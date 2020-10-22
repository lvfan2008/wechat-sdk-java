package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.impl.QrCodeServiceImpl;
import fan.lv.wechat.api.open.service.mp.OpenQrCodeService;
import fan.lv.wechat.entity.open.mp.qrcode.WxGetCheckFileNameAndContentResult;
import fan.lv.wechat.entity.open.mp.qrcode.WxQrCodeRuleListResult;
import fan.lv.wechat.entity.open.mp.qrcode.WxShortUrlResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

import java.util.List;

/**
 * @author lv_fan2008
 */
public class OpenQrCodeServiceImpl extends QrCodeServiceImpl implements OpenQrCodeService {
    /**
     * @param client 请求客户端
     */
    public OpenQrCodeServiceImpl(Client client) {
        super(client);
    }

    @Override
    public WxQrCodeRuleListResult getQrCodeRuleList() {
        return client.get("/cgi-bin/wxopen/qrcodejumpget", WxQrCodeRuleListResult.class);
    }

    @Override
    public WxGetCheckFileNameAndContentResult getCheckFileNameAndContent() {
        return client.get("/cgi-bin/wxopen/qrcodejumpdownload", WxGetCheckFileNameAndContentResult.class);
    }

    @Override
    public WxResult addQrCodeRule(String prefix, Integer permitSubRule, String path, Integer openVersion, List<String> debugUrl, Integer isEdit) {
        return client.postJson("/cgi-bin/wxopen/qrcodejumpadd",
                SimpleMap.of("prefix", prefix, "permit_sub_rule", permitSubRule.toString(),
                        "path", path, "open_version", openVersion.toString(),
                        "debug_url", debugUrl, "is_edit", isEdit.toString()),
                WxResult.class);
    }

    @Override
    public WxResult publishQrCodeRule(String prefix) {
        return client.postJson("/cgi-bin/wxopen/qrcodejumppublish",
                SimpleMap.of("prefix", prefix),
                WxResult.class);
    }

    @Override
    public WxResult delQrCodeRule(String prefix) {
        return client.postJson("/cgi-bin/wxopen/qrcodejumpdelete",
                SimpleMap.of("prefix", prefix),
                WxResult.class);
    }

    @Override
    public WxShortUrlResult getShortUrl(String longUrl) {
        return client.postJson("/cgi-bin/shorturl",
                SimpleMap.of("action", "long2short", "long_url", longUrl),
                WxShortUrlResult.class);
    }
}
