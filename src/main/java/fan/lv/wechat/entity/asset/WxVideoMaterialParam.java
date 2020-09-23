package fan.lv.wechat.entity.asset;

import lombok.Data;

/**
 * 视频素材参数
 *
 * @author lv_fan2008
 */
@Data
public class WxVideoMaterialParam {
    /**
     * 视频素材的标题
     */
    String title;

    /**
     * 视频素材的描述
     */
    String introduction;
}
