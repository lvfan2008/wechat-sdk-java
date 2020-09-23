package fan.lv.wechat.entity.message.mass.base;

import lombok.Data;

import java.util.List;

/**
 * 图文消息
 *
 * @author lv_fan2008
 */
@Data
public class WxArticles {
    /**
     * 图文消息，一个图文消息支持1到8条图文
     */
    List<WxNews> articles;
}
