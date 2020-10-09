package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.security.WxMediaCheckAsyncResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface SecurityService {
    /**
     * 校验一张图片是否含有违法违规内容
     * 应用场景举例：
     * <p>
     * 图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     * 敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。
     * 频率限制：单个 appId 调用上限为 2000 次/分钟，200,000 次/天（图片大小限制：1M） 服务市场： 通过服务市场使用可以有更多的能力，
     *
     * @param filePath 要检测的图片文件，格式支持PNG、JPEG、JPG、GIF，图片尺寸不超过 750px x 1334px
     * @return 检验结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/sec-check/security.imgSecCheck.html" target="_blank">微信官方文档</a>
     */
    WxResult imgSecCheck(String filePath);

    /**
     * 异步校验图片/音频是否含有违法违规内容
     * 应用场景举例：
     * <p>
     * 语音风险识别：社交类用户发表的语音内容检测；
     * 图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     * 敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。
     * 频率限制：单个 appId 调用上限为 2000 次/分钟，200,000 次/天；文件大小限制：单个文件大小不超过10M
     *
     * @param mediaUrl  要检测的多媒体url
     * @param mediaType 1:音频;2:图片
     * @return 返回任务Id结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/sec-check/security.mediaCheckAsync.html" target="_blank">微信官方文档</a>
     */
    WxMediaCheckAsyncResult mediaCheckAsync(String mediaUrl, Integer mediaType);

    /**
     * 检查一段文本是否含有违法违规内容
     * 应用场景举例：
     * <p>
     * 用户个人资料违规文字检测；
     * 媒体新闻类用户发表文章，评论内容检测；
     * 游戏类用户编辑上传的素材(如答题类小游戏用户上传的问题及答案)检测等。
     * 频率限制：单个 appId 调用上限为 4000 次/分钟，2,000,000 次/天* *服务市场：**通过服务市场使用可以有更多的能力，
     *
     * @param content 要检测的文本内容，长度不超过 500KB
     * @return 检验结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/sec-check/security.msgSecCheck.html" target="_blank">微信官方文档</a>
     */
    WxResult msgSecCheck(String content);
}
