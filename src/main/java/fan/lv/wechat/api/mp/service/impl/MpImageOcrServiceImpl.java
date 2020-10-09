package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.Intelligence.impl.ImageOcrServiceImpl;

/**
 * @author lv_fan2008
 */
public class MpImageOcrServiceImpl extends ImageOcrServiceImpl {
    /**
     * @param client 请求客户端
     */
    public MpImageOcrServiceImpl(Client client) {
        super(client);
    }
}
