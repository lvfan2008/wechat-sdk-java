package fan.lv.wechat.entity.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文本消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    /**
     * 文本消息内容
     */
    String content;
}
