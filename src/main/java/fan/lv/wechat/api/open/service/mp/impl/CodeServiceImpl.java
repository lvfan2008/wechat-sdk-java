package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.CodeService;
import fan.lv.wechat.entity.open.mp.code.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class CodeServiceImpl implements CodeService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public CodeServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult uploadCode(String templateId, String extJson, String userVersion, String userDesc) {
        return client.postJson("/wxa/commit",
                SimpleMap.of("template_id", templateId,
                        "ext_json", extJson,
                        "user_version", userVersion,
                        "user_desc", userDesc),
                WxResult.class);
    }

    @Override
    public WxGetPageListResult getPageList() {
        return client.get("/wxa/get_page", WxGetPageListResult.class);
    }

    @Override
    public WxResult getTesterQrCode(String path) {
        return client.get("/wxa/get_qrcode",
                SimpleMap.of("path", path),
                WxResult.class);
    }

    @Override
    public WxSubmitCodeResult submitCode(WxSubmitCodeParam param) {
        return client.postJson("/wxa/commit",
                param,
                WxSubmitCodeResult.class);
    }

    @Override
    public WxGetAuditStatusResult getAuditStatus(Integer auditId) {
        return client.postJson("/wxa/get_auditstatus",
                SimpleMap.of("auditid", auditId),
                WxGetAuditStatusResult.class);
    }

    @Override
    public WxGetAuditStatusResult getLatestAuditStatus() {
        return client.get("/wxa/get_latest_auditstatus", WxGetAuditStatusResult.class);
    }

    @Override
    public WxResult undoCodeAudit() {
        return client.get("/wxa/undocodeaudit", WxResult.class);
    }

    @Override
    public WxResult release() {
        return client.postJson("/wxa/release", SimpleMap.of(), WxResult.class);
    }

    @Override
    public WxResult revertCodeRelease() {
        return client.get("/wxa/revertcoderelease", WxResult.class);
    }

    @Override
    public WxResult grayRelease(Integer grayPercentage) {
        return client.postJson("/wxa/grayrelease",
                SimpleMap.of("gray_percentage", grayPercentage),
                WxResult.class);
    }

    @Override
    public WxGetGrayReleasePlanResult getGrayReleasePlan() {
        return client.get("/wxa/getgrayreleaseplan", WxGetGrayReleasePlanResult.class);
    }

    @Override
    public WxResult revertGrayRelease() {
        return client.get("/wxa/revertgrayrelease", WxResult.class);
    }

    @Override
    public WxResult changeVisitStatus(String action) {
        return client.postJson("/wxa/change_visitstatus",
                SimpleMap.of("action", action),
                WxResult.class);
    }

    @Override
    public WxGetWeappSupportVersionResult getWeappSupportVersion() {
        return client.postJson("/cgi-bin/wxopen/getweappsupportversion",
                SimpleMap.of(),
                WxGetWeappSupportVersionResult.class);
    }

    @Override
    public WxResult setWeappSupportVersion(String version) {
        return client.postJson("/cgi-bin/wxopen/setweappsupportversion",
                SimpleMap.of("version", version),
                WxResult.class);
    }

    @Override
    public WxQueryQuotaResult queryQuota() {
        return client.get("wxa/queryquota", WxQueryQuotaResult.class);
    }

    @Override
    public WxResult speedupAudit(Integer auditId) {
        return client.postJson("/wxa/speedupaudit?",
                SimpleMap.of("auditid", auditId),
                WxResult.class);
    }
}
