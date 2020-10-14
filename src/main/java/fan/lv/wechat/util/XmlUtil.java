package fan.lv.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.*;

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
}
