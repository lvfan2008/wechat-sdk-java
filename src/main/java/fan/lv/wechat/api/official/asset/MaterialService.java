package fan.lv.wechat.api.official.asset;

import fan.lv.wechat.entity.asset.*;
import fan.lv.wechat.entity.message.mass.WxUploadMediaResult;
import fan.lv.wechat.entity.message.mass.base.WxArticles;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 素材管理
 *
 * @author lv_fan2008
 */
public interface MaterialService {

    /**
     * 新增临时素材
     *
     * @param type     媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param filePath 上传文件路径
     * @return 上传素材结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html" target="_blank">微信官方接口文档</a>
     */
    WxAddTemporaryMaterialResult addTemporaryMaterial(String type, String filePath);


    /**
     * 获取临时素材
     *
     * @param mediaId 媒体文件ID
     * @return 临时素材结果，如果为视频，则返回url，其他保存在原始流content属性
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html" target="_blank">微信官方接口文档</a>
     */
    WxGetTemporaryMaterialResult getTemporaryMaterial(String mediaId);

    /**
     * 新增永久图文素材
     *
     * @param articles 图文
     * @return 上传图文素材结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html" target="_blank">微信官方接口文档</a>
     */
    WxAddNewsResult addNews(WxArticles articles);


    /**
     * 上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     *
     * @param picturePath 图片路径
     * @return 上传结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html" target="_blank">微信官方接口文档</a>
     */
    WxUploadMediaResult uploadPicture(String picturePath);

    /**
     * 添加其他永久素材
     *
     * @param type                 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param filePath             媒体文件路径
     * @param wxVideoMaterialParam 视频素材参数，传视频时，不可为null
     * @return 添加结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html" target="_blank">微信官方接口文档</a>
     */
    WxAddOtherMaterialResult addOtherMaterial(String type, String filePath, WxVideoMaterialParam wxVideoMaterialParam);

    /**
     * 获取永久素材
     *
     * @param mediaId 媒体文件ID
     * @return 素材结果，如果为视频或图文，则返回Json，其他保存在WxGetMaterialResult的原始流content属性
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Getting_Permanent_Assets.html" target="_blank">微信官方接口文档</a>
     */
    WxGetMaterialResult getMaterial(String mediaId);

    /**
     * 删除永久素材
     *
     * @param mediaId 媒体文件ID
     * @return 删除结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Deleting_Permanent_Assets.html" target="_blank">微信官方接口文档</a>
     */
    WxResult deleteMaterial(String mediaId);

    /**
     * 修改永久图文素材
     *
     * @param wxUpdateNewsParam 图文素材
     * @return 修改结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Editing_Permanent_Rich_Media_Assets.html" target="_blank">微信官方接口文档</a>
     */
    WxResult updateNews(WxUpdateNewsParam wxUpdateNewsParam);

    /**
     * 获取永久素材数量
     *
     * @return 永久素材数量
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_the_total_of_all_materials.html" target="_blank">微信官方接口文档</a>
     */
    WxMaterialCountResult getMaterialCount();

    /**
     * 分类型获取永久素材的列表
     * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count 返回素材的数量，取值在1到20之间
     * @return 获取结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_materials_list.html" target="_blank">微信官方接口文档</a>
     */
    WxBatchGetMaterialResult batchGetMaterial(String type,Integer offset,Integer count);
}
