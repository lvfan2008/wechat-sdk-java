package fan.lv.wechat.api.mp;

import fan.lv.wechat.entity.mp.nearbypoi.WxAddNearByPoiParam;
import fan.lv.wechat.entity.mp.nearbypoi.WxAddNearByPoiResult;
import fan.lv.wechat.entity.mp.nearbypoi.WxNearByPoiListResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 附近小程序服务
 *
 * @author lv_fan2008
 */
public interface NearByPoiService {
    /**
     * 添加地点
     *
     * @param poiParam 添加地点参数
     * @return 添加结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.add.html" target="_blank">微信官方文档</a>
     */
    WxAddNearByPoiResult addNearByPoi(WxAddNearByPoiParam poiParam);

    /**
     * 删除地点
     *
     * @param poiId 附近地点 ID
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.delete.html" target="_blank">微信官方文档</a>
     */
    WxResult delete(String poiId);

    /**
     * 查看地点列表
     *
     * @param page     起始页id（从1开始计数）
     * @param pageRows 每页展示个数（最多1000个）
     * @return 地点列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.getList.html" target="_blank">微信官方文档</a>
     */
    WxNearByPoiListResult getList(Integer page, Integer pageRows);

    /**
     * 展示/取消展示附近小程序
     *
     * @param poiId   附近地点 ID
     * @param status 是否展示：0 不展示 1 展示
     * @return 地点列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.setShowStatus.html" target="_blank">微信官方文档</a>
     */
    WxResult setShowStatus(String poiId, Integer status);
}
