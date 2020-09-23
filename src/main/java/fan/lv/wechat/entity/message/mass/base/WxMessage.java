package fan.lv.wechat.entity.message.mass.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 根据标签进行群发参数
 *
 * @author lv_fan2008
 */
@Data
public class WxMessage {

    /**
     * 消息类型：群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    @JsonProperty("msgtype")
    String msgType;

    /**
     * 用于设定即将发送的图文消息
     */
    @JsonProperty("mpnews")
    WxMpNews wxMpNews;

    /**
     * 文本消息
     */
    WxText wxText;

    /**
     * 声音消息
     */
    WxVoice wxVoice;

    /**
     * 视频消息
     */
    @JsonProperty("mpvideo")
    WxMpVideo wxMpVideo;


    /**
     * 卡券消息
     */
    @JsonProperty("wxcard")
    WxCard wxCard;

    /**
     * 图片消息
     */
    WxImages wxImages;


    /**
     * 快速创建图文消息参数
     *
     * @param mediaId 群发的消息的media_id
     */
    public void mpNews(String mediaId) {
        setWxMpNews(new WxMpNews(mediaId));
        setMsgType("msgtype");
    }

    /**
     * 快速创建文本消息参数
     *
     * @param content 文本消息
     */
    public void text(String content) {
        setWxText(new WxText(content));
        setMsgType("text");
    }

    /**
     * 快速创建声音消息参数
     *
     * @param mediaId 群发的消息的media_id
     */
    public void voice(String mediaId) {
        setWxVoice(new WxVoice(mediaId));
        setMsgType("voice");
    }

    /**
     * 快速创建视频消息参数
     *
     * @param mediaId 群发的消息的media_id
     */
    public void mpVideo(String mediaId) {
        setWxMpVideo(new WxMpVideo(mediaId));
        setMsgType("mpvideo");
    }

    /**
     * 快速创建卡券消息参数
     *
     * @param cardId 卡券Id
     */
    public void wxCard(String cardId) {
        setWxCard(new WxCard(cardId));
        setMsgType("wxcard");
    }


    /**
     * 快速创建图片消息参数
     *
     * @param mediaIds           图片媒体Id列表
     * @param recommend          推荐语
     * @param needOpenComment    是否打开评论，0不打开，1打开
     * @param onlyFansCanComment 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
     */
    public void images(List<String> mediaIds, String recommend,
                       Integer needOpenComment, Integer onlyFansCanComment) {
        setWxImages(new WxImages(mediaIds, recommend, needOpenComment, onlyFansCanComment));
        setMsgType("image");
    }
}
