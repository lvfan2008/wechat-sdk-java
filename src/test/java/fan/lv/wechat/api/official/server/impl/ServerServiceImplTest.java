package fan.lv.wechat.api.official.server.impl;

import com.sun.corba.se.impl.protocol.giopmsgheaders.ReplyMessage;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.message.impl.MassSendServiceImpl;
import fan.lv.wechat.api.official.server.MessageCallback;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.entity.official.server.message.BaseMessage;
import fan.lv.wechat.entity.official.server.message.BaseReceiveMessage;
import fan.lv.wechat.entity.official.server.message.CommonTextMessage;
import fan.lv.wechat.entity.official.server.message.ReplyTextMessage;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class ServerServiceImplTest extends TestCase {
    ServerService serverService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String sEncodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
        String sToken = "spamtest";
        String sAppid = "wx2c2769f8efd9abc2";
        serverService = new ServerServiceImpl(sEncodingAesKey, sToken, sAppid);
    }

    public void testServ() {
        String sMsgSignature = "003fee52ecc56afb46c00b5c7721be87860ce785";
        String sTimestamp = "1410349438";
        String sNonce = "298025754";
        String sEncryptBase64 = "mfBCs65c67CeJw22u4VT2TD73q5H06+ocrAIxswCaeZ/d/Lw" +
                "0msSZFHY0teqgSYiI1zR2gD2DKrB3TIrmX/liNSDrGqS8jSI/" +
                "WPeKB5VPr7Ezr7gomZAyGCwJSgT1TRFWPfONGJMxuj2nk4faTu" +
                "spAuVIFQ6SHwZuJBZC7mcJp7Cgr9cUhATQWDbOPaE7ukZBTV2Yq" +
                "yzH+UI2AK+J1S47cE79k1RX8t0hcTz/O0hlK8DGXKnvYv88qKQcI" +
                "7z4iaajqHfRVZKBNyOODabs+It+ZfM3dWTeFcPgDbGtIEnpt/EDtu" +
                "uA/zMvtkaKdHdswPnVZQ+xdwbYr3ldGvfT8HlEYEgkgKaThxTFobVl" +
                "wzu2ZkXCjicbP3xdr15Iq48ObgzPpqYuZ3IEoyggZDKClquk0u0orMck4GTF/XyE8yGzc4=";

        String sPostData = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA["
                + sEncryptBase64
                + "]]></Encrypt></xml>";

        serverService.messageCallback((message) -> {
            return new ReplyTextMessage("receive: " + JsonUtil.toJson(message));
        }).serv(sMsgSignature, sTimestamp, sNonce, null, sPostData);
    }
}