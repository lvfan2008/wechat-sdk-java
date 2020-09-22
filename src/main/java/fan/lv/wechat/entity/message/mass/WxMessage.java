package fan.lv.wechat.entity.message.mass;

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
     * @param mediaId 群发的消息的media_id
     */
    public void mpNews(String mediaId) {
        setMpNews(new MpNews(mediaId));
        setMsgType("msgtype");
    }

    /**
     * 快速创建文本消息参数
     *
     * @param content 文本消息
     */
    public void text(String content) {
        setText(new Text(content));
        setMsgType("text");
    }

    /**
     * 快速创建声音消息参数
     *
     * @param mediaId 群发的消息的media_id
     */
    public void voice(String mediaId) {
        setVoice(new Voice(mediaId));
        setMsgType("voice");
    }

    /**
     * 快速创建视频消息参数
     *
     * @param mediaId 群发的消息的media_id
     */
    public void mpVideo(String mediaId) {
        setMpVideo(new MpVideo(mediaId));
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
        setImages(new Images(mediaIds, recommend, needOpenComment, onlyFansCanComment));
        setMsgType("image");
    }
}
