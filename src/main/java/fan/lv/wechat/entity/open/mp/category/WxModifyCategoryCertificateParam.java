package fan.lv.wechat.entity.open.mp.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 修改类目资质信息参数
 *
 * @author lv_fan2008
 */
public class WxModifyCategoryCertificateParam {

    /**
     * 一级类目 ID
     */
    Integer first;

    /**
     * 二级类目 ID
     */
    Integer second;

    /**
     * 资质信息列表
     */
    @JsonProperty("certicates")
    List<Certificate> certificates;


    @Data
    public static class Certificate {
        /**
         * 资质名称
         */
        String key;

        /**
         * 资质图片
         */
        String value;

    }
}

