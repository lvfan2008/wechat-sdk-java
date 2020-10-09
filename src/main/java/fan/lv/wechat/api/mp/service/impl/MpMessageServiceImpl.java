package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.MpMessageService;
import fan.lv.wechat.entity.mp.message.WxCreateActivityIdResult;
import fan.lv.wechat.entity.mp.message.WxUniformMessageParam;
import fan.lv.wechat.entity.mp.message.WxUpdatableMsgParam;
import fan.lv.wechat.entity.mp.message.base.BaseMpMessage;
import fan.lv.wechat.entity.mp.message.WxUploadTempMediaResult;
import fan.lv.wechat.entity.result.WxResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class MpMessageServiceImpl implements MpMessageService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public MpMessageServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult getTempMedia(String mediaId) {
        return client.get("/cgi-bin/media/get", SimpleMap.of("media_id", mediaId), WxResult.class);
    }

    @Override
    public WxUploadTempMediaResult uploadTempMedia(String type, String filePath) {
        return client.uploadFile("/cgi-bin/media/upload", SimpleMap.of("type", type),
                SimpleMap.of(), SimpleMap.of("media", filePath), WxUploadTempMediaResult.class);
    }

    @Override
    public WxResult send(String toUser, BaseMpMessage baseMpMessage) {
        baseMpMessage.setToUser(toUser);
        return client.postJson("/cgi-bin/message/custom/send", baseMpMessage, WxResult.class);
    }

    @Override
    public WxResult sendKfTypingState(String toUser, String command) {
        Map<String, String> map = SimpleMap.of("touser", toUser, "command", command);
        return client.postJson("/cgi-bin/message/custom/typing", map, WxResult.class);
    }

    @Override
    public WxResult sendUniformMessage(WxUniformMessageParam param) {
        return client.postJson("/cgi-bin/message/wxopen/template/uniform_send", param, WxResult.class);
    }

    @Override
    public WxCreateActivityIdResult createActivityId(String unionId) {
        return client.get("/cgi-bin/message/wxopen/activityid/create",
                unionId == null ? SimpleMap.of() : SimpleMap.of("unionid", unionId),
                WxCreateActivityIdResult.class);
    }

    @Override
    public WxResult setUpdatableMsg(WxUpdatableMsgParam param) {
        return client.postJson("/cgi-bin/message/wxopen/updatablemsg/send", param, WxResult.class);
    }
}
