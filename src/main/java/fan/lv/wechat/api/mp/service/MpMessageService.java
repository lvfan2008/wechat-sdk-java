package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.message.WxCreateActivityIdResult;
import fan.lv.wechat.entity.mp.message.WxUniformMessageParam;
import fan.lv.wechat.entity.mp.message.WxUpdatableMsgParam;
import fan.lv.wechat.entity.mp.message.base.BaseMpMessage;
import fan.lv.wechat.entity.mp.message.WxUploadTempMediaResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface MpMessageService {
    /**
     * 获取客服消息内的临时素材。即下载临时的多媒体文件。目前小程序仅支持下载图片文件。
     *
     * @param mediaId 媒体文件 ID
     * @return 如果调用成功，会直接返回图片二进制内容(WxResult.getContent)，如果请求失败，会返回 JSON 格式的数据。
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.getTempMedia.html" target="_blank">微信官方文档</a>
     */
    WxResult getTempMedia(String mediaId);

    /**
     * 把媒体文件上传到微信服务器。目前仅支持图片。用于发送客服消息或被动回复用户消息。
     *
     * @param type     只支持image
     * @param filePath 上传图片路径
     * @return 上传结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.uploadTempMedia.html" target="_blank">微信官方文档</a>
     */
    WxUploadTempMediaResult uploadTempMedia(String type, String filePath);

    /**
     * 发送客服消息给用户
     *
     * @param toUser           用户OpenId
     * @param baseMpMessage 客服消息，必须为BaseMpMessage的子类
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.send.html" target="_blank">微信官方文档</a>
     */
    WxResult send(String toUser, BaseMpMessage baseMpMessage);

    /**
     * 发送客服输入状态
     * 如果不满足发送客服消息的触发条件，则无法下发输入状态。
     * <p>
     * 下发输入状态，需要客服之前30秒内跟用户有过消息交互。
     * <p>
     * 在输入状态中（持续15s），不可重复下发输入态。
     * <p>
     * 在输入状态中，如果向用户下发消息，会同时取消输入状态。
     *
     * @param toUser  粉丝OpenId
     * @param command "Typing"：对用户下发“正在输入"状态 "CancelTyping"：取消对用户的”正在输入"状态
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.setTyping.html" target="_blank">微信官方接口文档</a>
     */
    WxResult sendKfTypingState(String toUser, String command);

    /**
     * 下发小程序和公众号统一的服务消息
     *
     * @param param 统一消息参数
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/uniform-message/uniformMessage.send.html" target="_blank">微信官方接口文档</a>
     */
    WxResult sendUniformMessage(WxUniformMessageParam param);

    /**
     * 创建被分享动态消息或私密消息的 activity_id。
     *
     * @param unionId 可以为null,为私密消息创建activity_id时，指定分享者为unionid用户。其余用户不能用此activity_id分享私密消息。
     * @return 返回活动Id
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.createActivityId.html" target="_blank">微信官方文档</a>
     */
    WxCreateActivityIdResult createActivityId(String unionId);

    /**
     * 修改被分享的动态消息
     *
     * @param param 修改被分享的动态消息参数
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.setUpdatableMsg.html" target="_blank">微信官方文档</a>
     */
    WxResult setUpdatableMsg(WxUpdatableMsgParam param);
}
