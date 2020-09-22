package fan.lv.wechat.entity.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
public class WxTagFilterParam {

    /**
     * 用于设定图文消息的接收者
     */
    Filter filter;

    /**
     * 消息类型：群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    @JsonProperty("msgtype")
    String msgType;

    /**
     * 图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     */
    @JsonProperty("send_ignore_reprint")
    Integer sendIgnoreReprint = 0;

    /**
     * 用于设定即将发送的图文消息
     */
    @JsonProperty("mpnews")
    MpNews mpNews;

    /**
     * 文本消息
     */
    Text text;

    /**
     * 声音消息
     */
    Voice voice;

    /**
     * 视频消息
     */
    @JsonProperty("mpvideo")
    MpVideo mpVideo;


    /**
     * 卡券消息
     */
    @JsonProperty("wxcard")
    WxCard wxCard;

    /**
     * 图片消息
     */
    Images images;


    /**
     * 快速创建图文消息参数
     *
     * @param isToAll 否向全部用户发送
     * @param tagId   群发到的标签的tag_id
     * @param mediaId 群发的消息的media_id
     * @return 图文消息参数
     */
    public static WxTagFilterParam mpNews(Boolean isToAll, Integer tagId, String mediaId) {
        WxTagFilterParam wxTagFilterParam = new WxTagFilterParam();
        wxTagFilterParam.setFilter(new Filter(isToAll, tagId));
        wxTagFilterParam.setMpNews(new MpNews(mediaId));
        wxTagFilterParam.setMsgType("msgtype");
        return wxTagFilterParam;
    }

    /**
     * 快速创建文本消息参数
     *
     * @param isToAll 否向全部用户发送
     * @param tagId   群发到的标签的tag_id
     * @param content 文本消息
     * @return 文本消息参数
     */
    public static WxTagFilterParam text(Boolean isToAll, Integer tagId, String content) {
        WxTagFilterParam wxTagFilterParam = new WxTagFilterParam();
        wxTagFilterParam.setFilter(new Filter(isToAll, tagId));
        wxTagFilterParam.setText(new Text(content));
        wxTagFilterParam.setMsgType("text");
        return wxTagFilterParam;
    }

    /**
     * 快速创建声音消息参数
     *
     * @param isToAll 否向全部用户发送
     * @param tagId   群发到的标签的tag_id
     * @param mediaId 群发的消息的media_id
     * @return 声音消息参数
     */
    public static WxTagFilterParam voice(Boolean isToAll, Integer tagId, String mediaId) {
        WxTagFilterParam wxTagFilterParam = new WxTagFilterParam();
        wxTagFilterParam.setFilter(new Filter(isToAll, tagId));
        wxTagFilterParam.setVoice(new Voice(mediaId));
        wxTagFilterParam.setMsgType("voice");
        return wxTagFilterParam;
    }

    /**
     * 快速创建视频消息参数
     *
     * @param isToAll 否向全部用户发送
     * @param tagId   群发到的标签的tag_id
     * @param mediaId 群发的消息的media_id
     * @return 视频消息参数
     */
    public static WxTagFilterParam mpVideo(Boolean isToAll, Integer tagId, String mediaId) {
        WxTagFilterParam wxTagFilterParam = new WxTagFilterParam();
        wxTagFilterParam.setFilter(new Filter(isToAll, tagId));
        wxTagFilterParam.setMpVideo(new MpVideo(mediaId));
        wxTagFilterParam.setMsgType("mpvideo");
        return wxTagFilterParam;
    }

    /**
     * 快速创建卡券消息参数
     *
     * @param isToAll 否向全部用户发送
     * @param tagId   群发到的标签的tag_id
     * @param cardId  卡券Id
     * @return 卡券消息参数
     */
    public static WxTagFilterParam wxCard(Boolean isToAll, Integer tagId, String cardId) {
        WxTagFilterParam wxTagFilterParam = new WxTagFilterParam();
        wxTagFilterParam.setFilter(new Filter(isToAll, tagId));
        wxTagFilterParam.setWxCard(new WxCard(cardId));
        wxTagFilterParam.setMsgType("wxcard");
        return wxTagFilterParam;
    }


    /**
     * 快速创建图片消息参数
     *
     * @param isToAll            否向全部用户发送
     * @param tagId              群发到的标签的tag_id
     * @param mediaIds           图片媒体Id列表
     * @param recommend          推荐语
     * @param needOpenComment    是否打开评论，0不打开，1打开
     * @param onlyFansCanComment 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
     * @return 图片消息参数
     */
    public static WxTagFilterParam images(Boolean isToAll, Integer tagId, List<String> mediaIds, String recommend,
                                          Integer needOpenComment, Integer onlyFansCanComment) {
        WxTagFilterParam wxTagFilterParam = new WxTagFilterParam();
        wxTagFilterParam.setFilter(new Filter(isToAll, tagId));
        wxTagFilterParam.setImages(new Images(mediaIds, recommend, needOpenComment, onlyFansCanComment));
        wxTagFilterParam.setMsgType("image");
        return wxTagFilterParam;
    }


    /**
     * 用于设定图文消息的接收者
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Filter {
        /**
         * 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
         */
        @JsonProperty("is_to_all")
        Boolean isToAll;

        /**
         * 群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
         */
        @JsonProperty("tag_id")
        Integer tagId;
    }

    /**
     * 用于设定即将发送的图文消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MpNews {
        /**
         * 用于群发的消息的media_id,注意此处media_id需通过素材管理->新增素材来得到
         */
        @JsonProperty("media_id")
        String mediaId;
    }


    /**
     * 文本消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Text {
        /**
         * 文本消息内容
         */
        String content;
    }

    /**
     * 声音消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Voice {
        /**
         * 声音媒体Id
         */
        @JsonProperty("media_id")
        String mediaId;
    }

    /**
     * 视频消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MpVideo {
        /**
         * 视频媒体Id
         */
        @JsonProperty("media_id")
        String mediaId;
    }

    /**
     * 卡券消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxCard {
        /**
         * 卡券Id
         */
        @JsonProperty("card_id")
        String cardId;
    }


    /**
     * 图片消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Images {
        /**
         * 图片媒体Id列表
         */
        @JsonProperty("media_ids")
        List<String> mediaIds;

        /**
         * 推荐语，不填则默认为“分享图片”
         */
        String recommend;

        /**
         * Uint32 是否打开评论，0不打开，1打开
         */
        @JsonProperty("need_open_comment")
        Integer needOpenComment = 0;

        /**
         * Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
         */
        @JsonProperty("only_fans_can_comment")
        Integer onlyFansCanComment = 0;
    }

}
