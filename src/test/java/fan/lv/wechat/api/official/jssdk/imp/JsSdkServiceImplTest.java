package fan.lv.wechat.api.official.jssdk.imp;

import fan.lv.wechat.api.kernel.impl.DefaultCacheImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.entity.official.jssdk.*;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

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


    public void testGetJsConfig() {
        String ticket = "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg";
        WxJsConfig jsConfig = new WxJsConfig();
        jsConfig.setTimestamp("1414587457");
        jsConfig.setNonceStr("Wm3WZYTPz0wzccnW");
        jsConfig = jsSdkService.getSignedJsConfig(jsConfig, "http://mp.weixin.qq.com?params=value", ticket);
        log.debug("jsConfig: {}", JsonUtil.toJson(jsConfig));
        assertEquals(jsConfig.getSignature(), "0f9de62fce790f9a083d5c99e95740ceb90c27ed");
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
        cardExt = jsSdkService.getSignedCartExt(cardExt, ticket, "test", "erer");
        log.debug("ticket：{} ，cardExt: {}", ticket, JsonUtil.toJson(cardExt));
        assertEquals(cardExt.getSignature(), "09a67f7495fac12ad38648a394d7625631d79241");
    }

    public void testSignatureChooseCard() {
        String ticket = "E0o2-at6NcC2OsJiQTlwlACMn0nyYImHWZLxlmjPNOeyOu5RnVgxOu8yCsfeTpFF9r9pxwms-3V_aPJVeDo6rw";
        WxChooseCard chooseCard = new WxChooseCard();
        chooseCard.setTimestamp("1601707897");
        chooseCard.setNonceStr("eb37246e-48c4-4bcf-aa67-c81b0bf5b67c");
        chooseCard.setCardType("GROUPON");
        chooseCard = jsSdkService.getSignedChooseCard(chooseCard, ticket, "location_id");
        log.debug("ticket：{} ，cardExt: {}", ticket, JsonUtil.toJson(chooseCard));
        assertEquals(chooseCard.getCardSign(), "987c4285e1514172bb71e0558441f52f90f6eb16");
    }
}