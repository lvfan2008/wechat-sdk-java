package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 语义理解接口协议结果
 *
 * @author lv_fan2008
 * @see <a href="https://open.weixin.qq.com/zh_CN/htmledition/res/assets/smart_lang_protocol.pdf" target="_blank">语义理解接口协议文档</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSemanticResult extends WxResult {
    /**
     * 输入文本串
     */
    String query;

    /**
     * 服务的全局类型id，详见协议文档中垂直服务协议定义
     */
    String type;

    /**
     * 语义理解后的结构化标识，各服务不同
     */
    Object semantic;

    /**
     * 部分类别的结果
     */
    List<Object> result;

    /**
     * 部分类别的结果html5展示，目前不支持
     */
    String answer;

    /**
     * 特殊回复说明
     */
    String text;

}
