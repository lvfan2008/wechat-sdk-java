package fan.lv.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.*;
import fan.lv.wechat.util.pay.WxPayUtil;
import fan.lv.wechat.util.pay.WxPayXmlUtil;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author lv_fan2008
 */
public class XmlUtil {

    /**
     * 转换对象为xml
     *
     * @param object 需要转换的对象
     * @return xml
     */
    public static String toXml(Object object) {
        return toXml(object, "xml");
    }


    /**
     * Xml转换为对象
     *
     * @param xml xml字符串
     * @return 对象
     */
    public static <T> T parseXml(String xml, Class<T> resultType) {
        return parseXml(xml, resultType, "xml");
    }

    /**
     * 转换对象为xml
     *
     * @param object    需要转换的对象
     * @param rootAlias 根元祖名称
     * @return xml
     */
    public static String toXml(Object object, String rootAlias) {
        return getXmlStream(object.getClass(), rootAlias).toXML(object);
    }


    /**
     * Xml转换为对象
     *
     * @param xml       xml字符串
     * @param rootAlias 根元祖名称
     * @return 对象
     */
    public static <T> T parseXml(String xml, Class<T> resultType, String rootAlias) {
        return resultType.cast(getXmlStream(resultType, rootAlias).fromXML(xml));
    }

    /**
     * 获取XStream对象
     *
     * @param resultType 对象类型
     * @param rootAlias  根元祖名称
     * @return xStream
     */
    public static XStream getXmlStream(Class<?> resultType, String rootAlias) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder())) {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            try {
                                Class<?> cls = realClass(fieldName);
                            } catch (Exception e) {
                                return false;
                            }
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.denyPermission(NullPermission.NULL);
        xstream.alias(rootAlias, resultType);
        xstream.processAnnotations(resultType);
        return xstream;
    }

    /**
     * XML格式字符串转换为Map,不支持数组
     *
     * @param strXml XML字符串
     * @return XML数据转换后的Map
     * @throws Exception 异常
     */
    public static Map<String, String> xmlToMap(String strXml) throws Exception {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilder documentBuilder = WxPayXmlUtil.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXml.getBytes(StandardCharsets.UTF_8));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            nodeToMap(nodeList, new Stack<>(), data);
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            WxPayUtil.getLogger().warn("Invalid XML, can not convert to map. Error message: {}. XML content: {}", ex.getMessage(), strXml);
            throw ex;
        }

    }

    /**
     * 用点分开父节点名字，对应存入map
     *
     * @param nodeList 节点列表
     * @param data     保存Map
     */
    protected static void nodeToMap(NodeList nodeList, Stack<String> parentNames, Map<String, String> data) {
        for (int idx = 0; idx < nodeList.getLength(); ++idx) {
            Node node = nodeList.item(idx);
            if (node.hasChildNodes()) {
                parentNames.push(node.getNodeName());
                nodeToMap(node.getChildNodes(), parentNames, data);
                parentNames.pop();
            } else {
                if (node.getParentNode().getNodeType() == Node.ELEMENT_NODE && parentNames.size() > 0 &&
                        !StringUtils.isBlank(node.getNodeValue())) {
                    data.put(String.join(".", parentNames), node.getNodeValue());
                }
            }
        }
    }

    /**
     * 将Map转换为XML格式的字符串，Key含.会分隔为各层的tag值
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception 异常
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        return mapToXml(data, "xml");
    }

    /**
     * 将Map转换为XML格式的字符串，Key含.会分隔为各层的tag值
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception 异常
     */
    public static String mapToXml(Map<String, String> data, String rootTagName) throws Exception {
        org.w3c.dom.Document document = WxPayXmlUtil.newDocument();
        org.w3c.dom.Element root = document.createElement(rootTagName);
        document.appendChild(root);
        for (String key : data.keySet()) {
            String value = data.get(key);
            if (key == null || value == null || value.trim().length() == 0) {
                continue;
            }
            value = value.trim();
            appendKeyValue(key, value, document, root);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString();
        try {
            writer.close();
        } catch (Exception ignored) {
        }
        return output;
    }

    protected static void appendKeyValue(String key, String value, org.w3c.dom.Document document, org.w3c.dom.Element root) {
        String[] keys = key.split("\\.");
        org.w3c.dom.Element lastElement = getChildElement(keys[0], document, root);
        for (int i = 1; i < keys.length; i++) {
            lastElement = getChildElement(keys[i], document, lastElement);
        }
        lastElement.appendChild(document.createTextNode(value));
    }

    protected static org.w3c.dom.Element getChildElement(String key, org.w3c.dom.Document document, org.w3c.dom.Element parent) {
        NodeList list = parent.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(key)) {
                return (Element) node;
            }
        }
        org.w3c.dom.Element filed = document.createElement(key);
        parent.appendChild(filed);
        return filed;
    }
}
