package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户小程序访问页面数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxVisitPageResult extends WxResult {

    /**
     * 日期，格式为 yyyymmdd
     */
    @JsonProperty("ref_date")
    String refDate;

    /**
     * 数据列表
     */
    List<VisitPage> list;


    @Data
    public static class VisitPage {

        /**
         * 页面路径
         */
        @JsonProperty("page_path")
        String pagePath;


        /**
         * 访问次数
         */
        @JsonProperty("page_visit_pv")
        Integer pageVisitPv;

        /**
         * 访问人数
         */
        @JsonProperty("page_visit_uv")
        Integer pageVisitUv;

        /**
         * 次均停留时长
         */
        @JsonProperty("page_staytime_pv")
        Double pageStaytimePv;

        /**
         * 进入页次数
         */
        @JsonProperty("entrypage_pv")
        Integer entryPagePv;

        /**
         * 退出页次数
         */
        @JsonProperty("exitpage_pv")
        Integer exitPagePv;

        /**
         * 转发次数
         */
        @JsonProperty("page_share_pv")
        Integer pageSharePv;

        /**
         * 转发人数
         */
        @JsonProperty("page_share_uv")
        Integer pageShareUv;
    }
}
