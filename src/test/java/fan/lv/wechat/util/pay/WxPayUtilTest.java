package fan.lv.wechat.util.pay;

import junit.framework.TestCase;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class WxPayUtilTest extends TestCase {

    public void testXmlToMap() throws Exception {
        String xml = "<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "  <CreateTime>1351776360</CreateTime>\n" +
                "  <MsgType><![CDATA[link]]></MsgType>\n" +
                "  <Title><![CDATA[公众平台官网链接]]></Title>\n" +
                "  <Description><![CDATA[公众平台官网链接]]></Description>\n" +
                "  <Url><![CDATA[url]]></Url>\n" +
                "  <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";
        Map<String, String> map = WxPayUtil.xmlToMap(xml);
        assertEquals("位置信息1", map.get("Label.A1"));
    }
}