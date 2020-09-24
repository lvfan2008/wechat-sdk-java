package fan.lv.wechat.entity.official.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 网络检测参数
 *
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
public class WxCheckParam {
    /**
     * 执行的检测动作，允许的值：dns（做域名解析）、ping（做ping检测）、all（dns和ping都做）
     */
    String action;

    /**
     * 指定平台从某个运营商进行检测，允许的值：CHINANET（电信出口）、UNICOM（联通出口）、CAP（腾讯自建出口）、DEFAULT（根据ip来选择运营商）
     */
    @JsonProperty("check_operator")
    String checkOperator;
}
