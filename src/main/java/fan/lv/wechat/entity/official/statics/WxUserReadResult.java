package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取图文统计数据（getuserread）结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserReadResult extends WxResult {

    /**
     * 数据的日期，需在begin_date和end_date之间
     */
    @JsonProperty("ref_date")
    String refDate;

    /**
     * 在获取图文统计数据、图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。
     * 99999999.全部；0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他;6.看一看;7.搜一搜；
     */
    @JsonProperty("user_source")
    Integer userSource;


    /**
     * 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    @JsonProperty("int_page_read_user")
    Integer intPageReadUser;

    /**
     * 图文页的阅读次数
     */
    @JsonProperty("int_page_read_count")
    Integer intPageReadCount;

    /**
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    @JsonProperty("ori_page_read_user")
    Integer oriPageReadUser;

    /**
     * 原文页的阅读次数
     */
    @JsonProperty("ori_page_read_count")
    Integer oriPageReadCount;

    /**
     * 分享的人数
     */
    @JsonProperty("share_user")
    Integer shareUser;

    /**
     * 分享的次数
     */
    @JsonProperty("share_count")
    Integer shareCount;

    /**
     * 收藏的人数
     */
    @JsonProperty("add_to_fav_user")
    Integer addToFavUser;

    /**
     * 收藏的次数
     */
    @JsonProperty("add_to_fav_count")
    Integer addToFavCount;

}
