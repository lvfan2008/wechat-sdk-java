package fan.lv.wechat.api.payment.service;

import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.entity.pay.redpack.WxGetRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxMpSendRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxSendRedPackResult;

import java.util.Map;

/**
 * 现金红包服务
 *
 * @author lv_fan2008
 */
public interface RedPackService {

    /**
     * 发放红包接口
     *
     * @param mchBillNo   商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z） 接口根据商户订单号支持重入，如出现超时可再调用。
     * @param sendName    红包发送者名称
     * @param reOpenId    接受红包的用户openid openid为用户在wxappid下的唯一标识（获取openid参见微信公众平台开发者文档：网页授权获取用户基本信息）
     * @param totalAmount 付款金额，单位分
     * @param totalNum    红包发放总人数 total_num=1
     * @param wishing     红包祝福语
     * @param clientIp    调用接口的机器Ip地址
     * @param actName     活动名称
     * @param remark      备注信息
     * @param others      其他参数
     * @return 发放红包结果
     */
    WxSendRedPackResult sendRedPack(String mchBillNo, String sendName, String reOpenId,
                                    Integer totalAmount, Integer totalNum, String wishing,
                                    String clientIp, String actName, String remark,
                                    Map<String, String> others);

    /**
     * 发放裂变红包
     *
     * @param mchBillNo   商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z） 接口根据商户订单号支持重入，如出现超时可再调用。
     * @param sendName    红包发送者名称
     * @param reOpenId    接受红包的用户openid openid为用户在wxappid下的唯一标识（获取openid参见微信公众平台开发者文档：网页授权获取用户基本信息）
     * @param totalAmount 付款金额，单位分
     * @param totalNum    红包发放总人数 total_num=1
     * @param wishing     红包祝福语
     * @param amtType     红包金额设置方式 ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额
     * @param clientIp    调用接口的机器Ip地址
     * @param actName     活动名称
     * @param remark      备注信息
     * @param others      其他参数
     * @return 发放红包结果
     */
    WxSendRedPackResult sendGroupRedPack(String mchBillNo, String sendName, String reOpenId,
                                         Integer totalAmount, Integer totalNum, String wishing,
                                         String amtType, String clientIp, String actName, String remark,
                                         Map<String, String> others);

    /**
     * 查询红包记录
     *
     * @param mchBillNo 商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z） 接口根据商户订单号支持重入，如出现超时可再调用。
     * @param billType  MCHT:通过商户订单号获取红包信息。
     * @return 红包记录
     */
    WxGetRedPackResult getRedPack(String mchBillNo, String billType);


    /**
     * 小程序发放红包接口
     *
     * @param mchBillNo   商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z） 接口根据商户订单号支持重入，如出现超时可再调用。
     * @param sendName    红包发送者名称
     * @param reOpenId    接受红包的用户openid openid为用户在wxappid下的唯一标识（获取openid参见微信公众平台开发者文档：网页授权获取用户基本信息）
     * @param totalAmount 付款金额，单位分
     * @param totalNum    红包发放总人数 total_num=1
     * @param wishing     红包祝福语
     * @param clientIp    调用接口的机器Ip地址
     * @param actName     活动名称
     * @param remark      备注信息
     * @param notifyWay   通过JSAPI方式领取红包,小程序红包固定传MINI_PROGRAM_JSAPI
     * @param others      其他参数
     * @return 发放红包结果
     */
    WxMpSendRedPackResult sendMpRedPack(String mchBillNo, String sendName, String reOpenId,
                                        Integer totalAmount, Integer totalNum, String wishing,
                                        String clientIp, String actName, String remark, String notifyWay,
                                        Map<String, String> others);
}
