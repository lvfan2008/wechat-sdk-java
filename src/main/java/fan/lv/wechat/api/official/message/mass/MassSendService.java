package fan.lv.wechat.api.official.message.mass;

import fan.lv.wechat.entity.message.mass.Articles;
import fan.lv.wechat.entity.message.mass.WxUploadArticlesResult;
import fan.lv.wechat.entity.message.mass.WxUploadMediaResult;

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
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     *
     * @param articles 图文消息
     * @return 上传结果
     */
    WxUploadArticlesResult uploadNews(Articles articles);
}
