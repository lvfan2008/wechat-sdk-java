package fan.lv.wechat.api.mp.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.MpMessageService;
import fan.lv.wechat.entity.mp.message.BaseMpMessage;
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
        return client.get("/cgi-bin/media/get", ImmutableMap.of("media_id", mediaId), WxResult.class);
    }

    @Override
    public WxUploadTempMediaResult uploadTempMedia(String type, String filePath) {
        return client.uploadFile("/cgi-bin/media/upload", ImmutableMap.of("type", type),
                ImmutableMap.of(), ImmutableMap.of("media", filePath), WxUploadTempMediaResult.class);
    }

    @Override
    public WxResult send(String toUser, BaseMpMessage baseMpMessage) {
        baseMpMessage.setToUser(toUser);
        return client.postJson("/cgi-bin/message/custom/send", baseMpMessage, WxResult.class);
    }

    @Override
    public WxResult sendKfTypingState(String toUser, String command) {
        Map<String, String> map = ImmutableMap.of("touser", toUser, "command", command);
        return client.postJson("/cgi-bin/message/custom/typing", map, WxResult.class);
    }
}
