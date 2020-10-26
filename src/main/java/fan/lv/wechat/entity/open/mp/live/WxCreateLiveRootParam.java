package fan.lv.wechat.entity.open.mp.live;

import lombok.Data;

/**
 * 创建直播间参数
 *
 * @author lv_fan2018
 */
@Data
public class WxCreateLiveRootParam {
    /**
     * 直播间名字，最短3个汉字，最长17个汉字，1个汉字相当于2个字符
     */
    String name;

    /**
     * 填入mediaID（mediaID获取后，三天内有效）；直播间背景图，图片规则：建议像素800*640，大小不超过1M
     */
    String coverImg;

    /**
     * 直播计划开始时间，1.开播时间需要在当前时间的10分钟后；2.开始时间不能在 6 个月后；格式为时间戳
     */
    Integer startTime;

    /**
     * 直播计划结束时间，1.开播时间和结束时间间隔不得短于30分钟，不得超过24小时，格式为时间戳
     */
    Integer endTime;

    /**
     * 主播昵称，最短2个汉字，最长15个汉字，1个汉字相当于2个字符
     */
    String anchorName;

    /**
     * 主播微信号，需要通过“小程序直播”小程序的实名验证
     */
    String anchorWechat;

    /**
     * 填入mediaID（mediaID获取后，三天内有效）；直播间分享图，图片规则：建议像素1080*1920，大小不超过2M
     */
    String anchorImg;

    /**
     * 直播间类型，1: 推流，0：手机直播
     */
    Integer type;

    /**
     * 横屏、竖屏，1：横屏，0：竖屏；横屏：视频宽高比为16:9、4:3、1.85:1；竖屏：视频宽高比为9:16、2:3
     */
    Integer screenType;

    /**
     * 是否关闭点赞，0：开启，1：关闭；若关闭，直播开始后不允许开启
     */
    Integer closeLike;

    /**
     * 是否关闭货架，0：开启，1：关闭；若关闭，直播开始后不允许开启
     */
    Integer closeGoods;

    /**
     * 是否关闭评论，0：开启，1：关闭；若关闭，直播开始后不允许开启
     */
    Integer closeComment;
}
