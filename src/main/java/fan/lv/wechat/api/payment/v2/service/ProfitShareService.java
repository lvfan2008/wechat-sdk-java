package fan.lv.wechat.api.payment.v2.service;

import fan.lv.wechat.entity.pay.profitshare.*;

import java.util.List;
import java.util.Map;

/**
 * 分账服务
 *
 * @author lv_fan2008
 */
public interface ProfitShareService {
    /**
     * 请求单次分账
     * <p>
     * 单次分账请求按照传入的分账接收方账号和资金进行分账，同时会将订单剩余的待分账金额解冻给特约商户。故操作成功后，订单不能再进行分账，也不能进行分账完结。
     *
     * @param transactionId 微信支付订单号
     * @param outOrderNo    服务商系统内部的分账单号，在服务商系统内部唯一（单次分账、多次分账、完结分账应使用不同的商户分账单号），
     *                      同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
     * @param receivers     分账接收方列表，不超过50个json对象，不能设置出资子商户作为分账接受方
     * @param others        其他参数
     * @return 分账结果
     */
    WxProfitShareResult profitShare(String transactionId, String outOrderNo, List<WxReceiver> receivers,
                                    Map<String, String> others);

    /**
     * 请求多次分账
     * <p>
     * ● 微信订单支付成功后，服务商代子商户发起分账请求，将结算后的钱分到分账接收方。多次分账请求仅会按照传入的分账接收方进行分账，不会对剩余的金额进行任何操作。故操作成功后，在待分账金额不等于零时，订单依旧能够再次进行分账。
     * <p>
     * ● 多次分账，可以将本商户作为分账接收方直接传入，实现释放资金给本商户的功能
     * <p>
     * ● 对同一笔订单最多能发起20次多次分账请求
     *
     * @param transactionId 微信支付订单号
     * @param outOrderNo    商户分账单号
     * @param receivers     分账接收方列表，不超过50个json对象，不能设置出资子商户作为分账接受方
     * @param others        其他参数
     * @return 分账结果
     */
    WxProfitShareResult multiProfitShare(String transactionId, String outOrderNo, List<WxReceiver> receivers,
                                         Map<String, String> others);

    /**
     * 查询分账结果
     *
     * @param transactionId 微信支付订单号
     * @param outOrderNo    商户分账单号
     * @return 分账结果
     */
    WxQueryProfitShareResult queryProfitShare(String transactionId, String outOrderNo);

    /**
     * 添加分账接收方
     *
     * @param receiver 分账接收方
     * @return 添加结果
     */
    WxAddReceiversResult addReceivers(WxReceiverForAdd receiver);

    /**
     * 删除分账接收方
     *
     * @param receiver 分账接收方
     * @return 添加结果
     */
    WxDeleteReceiverResult deleteReceivers(WxReceiverForDelete receiver);


    /**
     * 完结分账
     *
     * @param transactionId 微信支付订单号
     * @param outOrderNo    分账单号
     * @param description   分账完结描述
     * @return 分账结果
     */
    WxProfitShareResult finishProfitShare(String transactionId, String outOrderNo, String description);


    /**
     * 分账回退
     *
     * @param orderId           微信分账单号
     * @param outOrderNo        商户分账单号
     * @param outReturnNo       商户回退单号
     * @param returnAccountType 回退方类型
     * @param returnAccount     回退方账号
     * @param returnAmount      回退金额
     * @param description       回退描述
     * @return 分账回退结果
     */
    WxReturnProfitShareResult returnProfitShare(String orderId, String outOrderNo, String outReturnNo,
                                                String returnAccountType, String returnAccount, Integer returnAmount,
                                                String description);

    /**
     * 回退结果查询
     *
     * @param orderId 微信分账单号
     * @param outOrderNo    商户分账单号
     * @param outReturnNo   商户回退单号
     * @return 回退结果
     */
    WxReturnProfitShareResult queryReturnProfitShare(String orderId, String outOrderNo, String outReturnNo);
}
