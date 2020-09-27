package fan.lv.wechat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import fan.lv.wechat.entity.official.server.message.BaseReceiveMessage;

import java.util.Collection;

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
        XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
        xstream.autodetectAnnotations(true);
        return xstream.toXML(object);
    }

    /**
     * Xml转换为对象
     *
     * @param xml        xml字符串
     * @param resultType 转为类型
     * @param <T>        类型模板
     * @return Xml对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseXml(String xml, Class<T> resultType) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
        xstream.autodetectAnnotations(true);
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(Collection.class);
        xstream.allowTypesByWildcard(new String[]{
                "fan.lv.wechat.*"
        });
        try {
            return (T) xstream.fromXML(xml, resultType.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Xml转换为对象
     *
     * @param xml xml字符串
     * @return 对象
     */
    public static Object parseXml(String xml,Object object) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(Collection.class);
        xstream.allowTypesByWildcard(new String[]{
                "fan.lv.wechat.*"
        });
        xstream.autodetectAnnotations(true);
        xstream.alias("xml", BaseReceiveMessage.class);
        return xstream.fromXML(xml,object);
    }
}
