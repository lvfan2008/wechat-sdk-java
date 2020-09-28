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
        return getXmlStream(object.getClass()).toXML(object);
    }


    /**
     * Xml转换为对象
     *
     * @param xml xml字符串
     * @return 对象
     */
    public static Object parseXml(String xml, Class<?> resultType) {
        return getXmlStream(resultType).fromXML(xml);
    }

    /**
     * 获取XStream对象
     *
     * @param resultType 对象类型
     * @return xStream
     */
    public static XStream getXmlStream(Class<?> resultType) {
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
        xstream.alias("xml", resultType);
        xstream.processAnnotations(resultType);
        return xstream;
    }
}
