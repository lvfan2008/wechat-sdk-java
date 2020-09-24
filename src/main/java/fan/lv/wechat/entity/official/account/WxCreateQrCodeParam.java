package fan.lv.wechat.entity.official.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxCreateQrCodeParam {

    /**
     * 二维码类型，QR_SCENE为临时的整型参数值
     */
    public static final String QR_SCENE = "QR_SCENE";

    /**
     * 二维码类型，QR_STR_SCENE为临时的字符串参数值
     */
    public static final String QR_STR_SCENE = "QR_STR_SCENE";

    /**
     * 二维码类型，QR_LIMIT_SCENE为永久的整型参数值
     */
    public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";

    /**
     * 二维码类型，QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    public static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";

    /**
     * 临时二维码可用，该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     */
    @JsonProperty("expire_seconds")
    Integer expireSeconds;

    /**
     * 二维码类型:
     * QR_SCENE为临时的整型参数值，
     * QR_STR_SCENE为临时的字符串参数值，
     * QR_LIMIT_SCENE为永久的整型参数值，
     * QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    @JsonProperty("action_name")
    String actionName;

    /**
     * 二维码详细信息
     */
    @JsonProperty("action_info")
    ActionInfo actionInfo;

    /**
     * @param expireSeconds 临时二维码可用，该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒
     * @param actionName    二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，
     *                      QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param sceneStr      场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     */
    public WxCreateQrCodeParam(Integer expireSeconds, String actionName, Integer sceneId, String sceneStr) {
        this.expireSeconds = actionName.equals(QR_SCENE) || actionName.equals(QR_STR_SCENE) ? expireSeconds : null;
        this.actionName = actionName;
        this.actionInfo = new ActionInfo(
                actionName.equals(QR_SCENE) || actionName.equals(QR_LIMIT_SCENE) ? sceneId : null,
                actionName.equals(QR_STR_SCENE) || actionName.equals(QR_LIMIT_STR_SCENE) ? sceneStr : null);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ActionInfo {

        /**
         * 场景信息
         */
        Scene scene;

        public ActionInfo(Integer sceneId, String sceneStr) {
            this.scene = new Scene(sceneId, sceneStr);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Scene {
        /**
         * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
         */
        @JsonProperty("scene_id")
        Integer sceneId;

        /**
         * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
         */
        @JsonProperty("scene_str")
        String sceneStr;
    }
}
