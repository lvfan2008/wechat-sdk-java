package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
public class WxSubmitCodeParam {
    /**
     * 审核项列表（选填，至多填写 5 项）
     */
    @JsonProperty("item_list")
    List<AuditItem> itemList;

    /**
     * 预览信息（小程序页面截图和操作录屏）
     */
    @JsonProperty("preview_info")
    PreviewInfo previewInfo;

    /**
     * 小程序版本说明和功能解释
     */
    @JsonProperty("version_desc")
    String versionDesc;

    /**
     * 反馈内容，至多 200 字
     */
    @JsonProperty("feedback_info")
    String feedbackInfo;

    /**
     * 用 | 分割的 media_id 列表，至多 5 张图片, 可以通过新增临时素材接口上传而得到
     */
    @JsonProperty("feedback_stuff")
    String feedbackStuff;

    /**
     * 用户生成内容场景（UGC）信息安全声明
     */
    @JsonProperty("ugc_declare")
    UgcDeclare ugcDeclare;

    @Data
    public static class AuditItem {
        /**
         * 小程序的页面
         */
        String address;

        /**
         * 小程序的标签，用空格分隔，标签至多 10 个，标签长度至多 20
         */
        String tag;

        /**
         * 一级类目名称
         */
        @JsonProperty("first_class")
        String firstClass;


        /**
         * 二级类目名称
         */
        @JsonProperty("first_class")
        String secondClass;

        /**
         * 三级类目名称
         */
        @JsonProperty("third_class")
        String thirdClass;


        /**
         * 一级类目的 ID 编号
         */
        @JsonProperty("first_id")
        Integer firstId;


        /**
         * 二级类目的 ID 编号
         */
        @JsonProperty("second_id")
        Integer secondId;


        /**
         * 三级类目的 ID 编号
         */
        @JsonProperty("third_id")
        Integer thirdId;

        /**
         * 小程序页面的标题,标题长度至多 32
         */
        String title;
    }

    @Data
    public static class PreviewInfo {
        /**
         * 录屏mediaid列表，可以通过提审素材上传接口获得
         */
        @JsonProperty("video_id_list")
        List<String> videoIdList;

        /**
         * 截屏mediaid列表，可以通过提审素材上传接口获得
         */
        @JsonProperty("pic_id_list")
        List<String> picIdList;
    }

    @Data
    public static class UgcDeclare {
        /**
         * UGC场景 0,不涉及用户生成内容, 1.用户资料,2.图片,3.视频,4.文本,5其他, 可多选,当scene填0时无需填写下列字段
         */
        List<Integer> scene;

        /**
         * 当scene选其他时的说明,不超时256字
         */
        @JsonProperty("other_scene_desc")
        String otherSceneDesc;

        /**
         * 内容安全机制 1.使用平台建议的内容安全API,2.使用其他的内容审核产品,3.通过人工审核把关,4.未做内容审核把关
         */
        List<Integer> method;

        /**
         * 是否有审核团队, 0.无,1.有,默认0
         */
        @JsonProperty("has_audit_team")
        Integer hasAuditTeam;

        /**
         * 说明当前对UGC内容的审核机制,不超过256字
         */
        @JsonProperty("audit_desc")
        String auditDesc;
    }
}
