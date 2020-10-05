package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.QrCodeService;
import fan.lv.wechat.entity.mp.qrcode.WxGetMpCodeParam;
import fan.lv.wechat.entity.mp.qrcode.WxGetUnlimitedMpCodeParam;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public class QrCodeServiceImpl implements QrCodeService {

    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public QrCodeServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult createQrCode(String path, Integer width) {
        width = width == null ? 430 : width;
        return client.postJson("/cgi-bin/wxaapp/createwxaqrcode", SimpleMap.of("path", path, "width", width), WxResult.class);
    }

    @Override
    public WxResult get(WxGetMpCodeParam param) {
        return client.postJson("/wxa/getwxacode", param, WxResult.class);
    }

    @Override
    public WxResult getUnlimited(WxGetUnlimitedMpCodeParam param) {
        return client.postJson("/wxa/getwxacodeunlimit", param, WxResult.class);
    }
}
