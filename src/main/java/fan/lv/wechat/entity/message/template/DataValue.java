package fan.lv.wechat.entity.message.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息正文，value为消息内容文本（200字以内），没有固定格式，可用\n换行，color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
 *
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataValue {
    /**
     * 数据值
     */
    String value;

    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    String color;

    public DataValue(String value) {
        this.value = value;
    }
}
