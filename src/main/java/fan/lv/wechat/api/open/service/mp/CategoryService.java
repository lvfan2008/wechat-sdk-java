package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.category.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 类目管理服务
 *
 * @author lv_fan2008
 */
public interface CategoryService {

    /**
     * 获取可以设置的所有类目
     *
     * @return 所有类目
     */
    WxGetAllCategoriesResult getAllCategories();

    /**
     * 获取已设置的所有类目
     *
     * @return 已设置的所有类目
     */
    WxGetSettledCategoriesResult getSettledCategories();

    /**
     * 添加类目
     *
     * @param param 添加类目参数
     * @return 添加类目结果
     */
    WxResult addCategory(WxAddCategoryParam param);

    /**
     * 删除类目
     *
     * @param first  一级类目 ID
     * @param second 二级类目 ID
     * @return 删除类目结果
     */
    WxResult delCategory(Integer first, Integer second);

    /**
     * 修改类目资质信息
     *
     * @param param 修改类目资质信息参数
     * @return 修改类目资质信息结果
     */
    WxResult modifyCategoryCertificate(WxModifyCategoryCertificateParam param);

    /**
     * 获取审核时可填写的类目信息
     *
     * @return 获取审核时可填写的类目信息结果
     */
    WxGetCanModifyCategoriesResult getCanModifyCategories();
}
