package fan.lv.wechat.api.official.jssdk.imp;

import fan.lv.wechat.api.kernel.impl.DefaultCacheImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.entity.official.jssdk.*;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author lv_fan2008
 */
@Slf4j
public class JsSdkServiceImplTest extends TestCase {

    JsSdkService jsSdkService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        jsSdkService = new JsSdkServiceImpl(Util.getProperty("app_id"),
                Util.getClient(),
                new DefaultCacheImpl()
        );
    }

    public void testGetTicket() {
        WxJsSdkTicketResult result = jsSdkService.getJsSdkTicket();
        assertTrue(result.success());
    }

    public void testSignature() {
        WxJsSdkTicketResult result = jsSdkService.getJsSdkTicket();
        assertTrue(result.success());
        String sign = jsSdkService.signatureJsSdk("Wm3WZYTPz0wzccnW", "1414587457",
                "http://mp.weixin.qq.com?params=value",
                "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg");
        log.debug("sign: {}", sign);
        assertEquals(sign, "0f9de62fce790f9a083d5c99e95740ceb90c27ed");
    }

    public void testGetJsConfig() {
        WxJsSdkTicketResult result = jsSdkService.getJsSdkTicket();
        assertTrue(result.success());

        WxJsConfig jsConfig = jsSdkService.getJsConfig(true,
                Arrays.asList("startRecord", "stopRecord", "onVoiceRecordEnd", "playVoice",
                        "pauseVoice", "stopVoice", "onVoicePlayEnd", "uploadVoice", "downloadVoice",
                        "chooseImage", "previewImage", "uploadImage"), "http://www.yunyicheng.cn/jssdk/index", result.getTicket());
        log.debug("jsConfig: {}", JsonUtil.toJson(jsConfig));
        assertNotNull(jsConfig);
    }

    public void testGetCardApiTicket() {
        WxCardApiTicketResult result = jsSdkService.getCardApiTicket();
        assertTrue(result.success());
    }

    public void testSignatureCartExt() {
        String ticket = "E0o2-at6NcC2OsJiQTlwlACMn0nyYImHWZLxlmjPNOeyOu5RnVgxOu8yCsfeTpFF9r9pxwms-3V_aPJVeDo6rw";
        WxCardExt cardExt = new WxCardExt();
        cardExt.setTimestamp("1601707897");
        cardExt.setNonceStr("eb37246e-48c4-4bcf-aa67-c81b0bf5b67c");
        cardExt = jsSdkService.signatureCartExt(cardExt, ticket, "test", "erer");
        log.debug("ticket：{} ，cardExt: {}", ticket, JsonUtil.toJson(cardExt));
        assertEquals(cardExt.getSignature(), "09a67f7495fac12ad38648a394d7625631d79241");
    }

    public void testSignatureChooseCard() {
        String ticket = "E0o2-at6NcC2OsJiQTlwlACMn0nyYImHWZLxlmjPNOeyOu5RnVgxOu8yCsfeTpFF9r9pxwms-3V_aPJVeDo6rw";
        WxChooseCard chooseCard = new WxChooseCard();
        chooseCard.setTimestamp("1601707897");
        chooseCard.setNonceStr("eb37246e-48c4-4bcf-aa67-c81b0bf5b67c");
        chooseCard.setCardType("GROUPON");
        chooseCard = jsSdkService.signatureChooseCard(chooseCard, ticket, "location_id");
        log.debug("ticket：{} ，cardExt: {}", ticket, JsonUtil.toJson(chooseCard));
        assertEquals(chooseCard.getCardSign(), "987c4285e1514172bb71e0558441f52f90f6eb16");
    }
}