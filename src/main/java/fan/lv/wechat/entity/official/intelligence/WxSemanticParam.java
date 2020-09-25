package fan.lv.wechat.entity.official.intelligence;

import lombok.Data;

/**
 * 语义理解请求参数
 *
 * @author lv_fan2008
 */
@Data
public class WxSemanticParam {
    /**
     * 输入文本串
     */
    String query;

    /**
     * 需要使用的服务类型，多个用“，”隔开，不能为空
     */
    String category;

    /**
     * 纬度坐标，与经度同时传入；与城市二选一传入
     */
    Double latitude;

    /**
     * 经度坐标，与纬度同时传入；与城市二选一传入
     */
    Double longitude;

    /**
     * 城市名称，与经纬度二选一传入
     */
    String city;

    /**
     * 区域名称，在城市存在的情况下可省；与经纬度二选一传入
     */
    String region;

    /**
     * 公众号唯一标识，用于区分公众号开发者
     */
    String appid;

    /**
     * 用户唯一id（非开发者id），用户区分公众号下的不同用户（建议填入用户openid），如果为空，则无法使用上下文理解功能。
     * appid和uid同时存在的情况下，才可以使用上下文理解功能。
     */
    String uid;

}
