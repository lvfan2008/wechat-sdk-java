package fan.lv.wechat.util;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lv_fan2008
 */
@Slf4j
public class XmlUtilTest extends TestCase {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class XmlData {
        @XStreamAlias("a")
        String dataA;
        @XStreamAlias("b")
        String dataB;
    }

    public void testToXml() {
        XmlData xmlData = new XmlData("a_data", null);
        String xml = XmlUtil.toXml(xmlData);
        log.debug("xml: {}", xml);
        assertTrue(xml.contains("<a>") && !xml.contains("<b>"));
        xmlData = new XmlData("a_data", "b_data");
        xml = XmlUtil.toXml(xmlData);
        log.debug("xml: {}", xml);
        assertTrue(xml.contains("<b>"));
    }

    public void testParseXml() {
        String xml = "<xml>\n" +
                "  <a>a_data</a>\n" +
                "</xml>";
        XmlData xmlData = XmlUtil.parseXml(xml, XmlData.class);
        assertNull(xmlData.getDataB());

        xml = "<xml>\n" +
                "  <a>a_data</a>\n" +
                "  <b>b_data</b>\n" +
                "</xml>";
        xmlData = XmlUtil.parseXml(xml, XmlData.class);
        assertEquals(xmlData.getDataB(), "b_data");
    }
}