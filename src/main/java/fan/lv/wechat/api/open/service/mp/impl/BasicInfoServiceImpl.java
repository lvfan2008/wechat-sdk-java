package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.BasicInfoService;
import fan.lv.wechat.entity.open.mp.basicinfo.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

import java.util.List;

/**
 * @author lv_fan2008
 */
public class BasicInfoServiceImpl implements BasicInfoService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public BasicInfoServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxMpBasicInfoResult getMpBasicInfo() {
        return client.get("/cgi-bin/account/getaccountbasicinfo", WxMpBasicInfoResult.class);
    }

    @Override
    public WxModifyDomainResult modifyDomain(String action, List<String> requestDomain, List<String> wsRequestDomain, List<String> uploadDomain, List<String> downloadDomain) {
        return client.postJson("/wxa/modify_domain",
                SimpleMap.of("action", action,
                        "requestdomain", requestDomain,
                        "wsrequestdomain", wsRequestDomain,
                        "uploaddomain", uploadDomain,
                        "downloaddomain", downloadDomain),
                WxModifyDomainResult.class);
    }

    @Override
    public WxResult modifyWebViewDomain(String action, List<String> webViewDomain) {
        return client.postJson("/wxa/setwebviewdomain",
                SimpleMap.of("action", action,
                        "webviewdomain", webViewDomain),
                WxResult.class);
    }

    @Override
    public WxSetNicknameResult setNickname(WxSetNicknameParam param) {
        return client.postJson("/wxa/setnickname", param, WxSetNicknameResult.class);
    }

    @Override
    public WxVerifyNicknameResult verifyNickname(String nickname) {
        return client.postJson("/cgi-bin/wxverify/checkwxverifynickname",
                SimpleMap.of("nick_name", nickname),
                WxVerifyNicknameResult.class);
    }

    @Override
    public WxQueryNicknameAuditResult queryNicknameAudit(String auditId) {
        return client.postJson("/wxa/api_wxa_querynickname",
                SimpleMap.of("audit_id", auditId),
                WxQueryNicknameAuditResult.class);
    }

    @Override
    public WxResult modifyHeadImage(String headImgMediaId, Double x1, Double y1, Double x2, Double y2) {
        return client.postJson("/cgi-bin/account/modifyheadimage",
                SimpleMap.of("head_img_media_id", headImgMediaId,
                        "x1", x1.toString(),
                        "y1", y1.toString(),
                        "x2", x2.toString(),
                        "y2", y2.toString()),
                WxResult.class);
    }

    @Override
    public WxResult modifySignature(String signature) {
        return client.postJson("/cgi-bin/account/modifysignature",
                SimpleMap.of("signature", signature),
                WxResult.class);
    }

    @Override
    public WxGetSearchStatusResult getSearchStatus() {
        return client.get("/wxa/getwxasearchstatus", WxGetSearchStatusResult.class);
    }

    @Override
    public WxResult setSearchStatus(Integer status) {
        return client.postJson("/wxa/changewxasearchstatus",
                SimpleMap.of("status", status),
                WxResult.class);
    }
}
