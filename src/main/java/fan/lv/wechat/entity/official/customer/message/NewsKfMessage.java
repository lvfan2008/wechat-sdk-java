package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class NewsKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "news";

    /**
     * 发送的图文消息
     */
    News news;

    /**
     * 构造图文消息
     *
     * @param articles 图文列表
     */
    public NewsKfMessage(List<Article> articles) {
        this.news = new News(articles);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class News {
        /**
         * 图文列表
         */
        List<Article> articles;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Article {
        /**
         * 图文消息标题
         */
        String title;


        /**
         * 图文消息描述
         */
        String description;

        /**
         * 图文消息被点击后跳转的链接
         */
        String url;

        /**
         * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
         */
        @JsonProperty("picurl")
        String picUrl;
    }
}
