package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.SoterService;
import fan.lv.wechat.entity.mp.soter.WxVerifySignatureResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class SoterServiceImpl implements SoterService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public SoterServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxVerifySignatureResult verifySignature(String openId, String resultJson, String resultSignature) {
        return client.postJson("/cgi-bin/soter/verify_signature",
                SimpleMap.of("openid", openId, "json_string", resultJson, "json_signature", resultSignature),
                WxVerifySignatureResult.class);
    }
}
