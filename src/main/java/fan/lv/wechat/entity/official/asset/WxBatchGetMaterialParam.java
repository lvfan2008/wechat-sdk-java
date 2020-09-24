package fan.lv.wechat.entity.official.asset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxBatchGetMaterialParam {
    /**
     * 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     */
    String type;

    /**
     * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     */
    Integer offset;

    /**
     * 返回素材的数量，取值在1到20之间
     */
    Integer count;
}
