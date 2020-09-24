package fan.lv.wechat.entity.user.tag;

import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxUpdateTagParam {

    /**
     * 标签信息
     */
    WxCreateTagResult.ResultTag tag;

    /**
     * @param id   标签id，由微信分配
     * @param name 标签名
     */
    public WxUpdateTagParam(Integer id, String name) {
        tag = new WxCreateTagResult.ResultTag(id, name);
    }
}
