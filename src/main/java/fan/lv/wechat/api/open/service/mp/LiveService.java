package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.live.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

/**
 * 直播服务
 *
 * @author lv_fan2018
 */
public interface LiveService {

    /**
     * 创建直播间
     *
     * @param param 创建直播间参数
     * @return 创建结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxCreateLiveRoomResult createLiveRoom(WxCreateLiveRoomParam param);

    /**
     * 获取直播间列表
     *
     * @param start 起始房间，0表示从第1个房间开始拉取
     * @param limit 每次拉取的房间数量，建议100以内
     * @return 直播间列表
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxGetLiveRoomListResult getLiveRoomList(Integer start, Integer limit);

    /**
     * 获取直播间回放
     *
     * @param roomId 直播间ID
     * @param start  起始房间，0表示从第1个房间开始拉取
     * @param limit  每次拉取的房间数量，建议100以内
     * @return 直播间回放信息
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxGetLiveReplayInfoResult getLiveReplayInfo(Integer roomId, Integer start, Integer limit);

    /**
     * 直播间导入商品
     *
     * @param ids    数组列表，可传入多个，里面填写 商品 ID
     * @param roomId 房间ID
     * @return 导入结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxResult importGoods(List<Integer> ids, Integer roomId);


    /**
     * 商品添加并提审
     * 调用此接口上传并提审需要直播的商品信息，审核通过后商品录入【小程序直播】商品库
     *
     * @param param 上传并提审需要直播的商品信息
     * @return 提审结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxAddLiveGoodsResult addLiveGoods(WxLiveGoodsParam param);

    /**
     * 撤回审核,调用此接口，可撤回直播商品的提审申请，消耗的提审次数不返还
     *
     * @param goodsId 商品ID
     * @param auditId 审核单ID
     * @return 撤销结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxResult resetAudit(Integer goodsId, Integer auditId);

    /**
     * 重新提交审核
     * 调用此接口可以对已撤回提审的商品再次发起提审申请
     *
     * @param goodsId 商品ID
     * @return 重新提交审核结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxReAuditResult reAudit(Integer goodsId);

    /**
     * 删除商品
     * 调用此接口，可删除【小程序直播】商品库中的商品，删除后直播间上架的该商品也将被同步删除，不可恢复
     *
     * @param goodsId 商品ID
     * @return 删除商品结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxResult deleteGoods(Integer goodsId);

    /**
     * 更新商品
     * 调用此接口可以更新商品信息，审核通过的商品仅允许更新价格类型与价格，
     * 审核中的商品不允许更新，未审核的商品允许更新所有字段， 只传入需要更新的字段
     *
     * @param param 商品信息
     * @return 更新商品结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxResult updateGoods(WxLiveGoodsParam param);

    /**
     * 获取商品状态，调用此接口可获取商品的信息与审核状态
     *
     * @param goodsIds 商品ID列表
     * @return 商品信息
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxGoodsAuditInfoResult getGoodsAuditInfo(List<Integer> goodsIds);


    /**
     * 获取商品列表
     *
     * @param offset 分页条数起点
     * @param limit  分页大小，默认30，不超过100
     * @param status 商品状态，0：未审核。1：审核中，2：审核通过，3：审核驳回
     * @return 商品列表
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/commodity-api.html" target="_blank">官方接口文档</a>
     */
    WxGoodsAuditInfoResult getGoodsList(Integer offset, Integer limit, Integer status);
}
