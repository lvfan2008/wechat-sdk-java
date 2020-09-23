package fan.lv.wechat.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
public class WxCreateTagParam {

    /**
     * 标签信息
     */
    WxCreateTag tag;

    /**
     * @param name 标签名字
     */
    public WxCreateTagParam(String name) {
        tag = new WxCreateTag(name);
    }

    /**
     * @author lv_fan2008
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxCreateTag {
        /**
         * 标签名
         */
        String name;
    }
}
