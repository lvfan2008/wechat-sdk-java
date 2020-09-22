package fan.lv.wechat.api.official.message;

import fan.lv.wechat.entity.message.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 群发接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Batch_Sends_and_Originality_Checks.html" target="_blank">微信官方接口文档</a>
 */
public interface MassSendService {

    /**
     * 上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     *
     * @param picturePath 图片路径
     * @return 上传结果
     */
    WxUploadMediaResult uploadPicture(String picturePath);


    /**
     * 上传图文消息素材
     *
     * @param articles 图文消息
     * @return 上传结果
     */
    WxUploadArticlesResult uploadNews(Articles articles);

    /**
     * 根据标签群发消息
     *
     * @param wxMassSendByTagParam 群发参数
     * @return 群发结果
     */
    WxMassSendResult massSendAll(WxMassSendByTagParam wxMassSendByTagParam);

    /**
     * 根据OpenID列表群发
     *
     * @param wxMassSendByOpenIdParam 群发参数
     * @return 群发结果
     */
    WxMassSendResult massSendToUser(WxMassSendByOpenIdParam wxMassSendByOpenIdParam);

    /**
     * 删除群发
     *
     * @param wxDeleteMassSendParam 删除群发参数
     * @return 删除结果
     */
    WxResult deleteMassMessage(WxDeleteMassSendParam wxDeleteMassSendParam);

    /**
     * 群发预览接口
     * 开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，
     * 增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
     *
     * @param wxMassSendPreviewParam 群发参数
     * @return 群发结果
     */
    WxMassSendResult massSendPreview(WxMassSendPreviewParam wxMassSendPreviewParam);

    /**
     * 查询群发消息发送状态
     *
     * @param wxQueryMassSendParam 查询参数
     * @return 查询结果
     */
    WxQueryMassSendResult queryMassSendStatus(WxQueryMassSendParam wxQueryMassSendParam);

    /**
     * 控制群发速度
     *
     * @param wxMassSendSpeedParam 群发速度参数
     * @return 控制结果
     */
    WxMassSendSpeedResult setMassSendSpeed(WxMassSendSpeedParam wxMassSendSpeedParam);
}
