package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.api.mp.service.QrCodeService;
import fan.lv.wechat.entity.open.mp.qrcode.WxGetCheckFileNameAndContentResult;
import fan.lv.wechat.entity.open.mp.qrcode.WxQrCodeRuleListResult;
import fan.lv.wechat.entity.open.mp.qrcode.WxShortUrlResult;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

/**
 * 普通链接二维码和小程序码
 *
 * @author lv_fan2008
 */
public interface OpenQrCodeService extends QrCodeService {

    /**
     * 获取已设置的二维码规则
     *
     * @return 二维码规则
     */
    WxQrCodeRuleListResult getQrCodeRuleList();

    /**
     * 获取校验文件名称及内容
     *
     * @return 获取校验文件名称及内容结果
     */
    WxGetCheckFileNameAndContentResult getCheckFileNameAndContent();

    /**
     * 增加或修改二维码规则
     *
     * @param prefix        二维码规则
     * @param permitSubRule 是否独占符合二维码前缀匹配规则的所有子规 1 为不占用，2 为占用; 详见
     * @param path          小程序功能页面
     * @param openVersion   测试范围
     * @param debugUrl      测试链接，至多 5 个用于测试的二维码完整链接，此链接必须符合已填写的二维码规则。
     * @param isEdit        编辑标志位，0 表示新增二维码规则，1 表示修改已有二维码规则
     * @return 返回结果
     */
    WxResult addQrCodeRule(String prefix, Integer permitSubRule, String path, Integer openVersion,
                           List<String> debugUrl, Integer isEdit);

    /**
     * 发布已设置的二维码规则
     *
     * @param prefix 二维码规则
     * @return 发布结果
     */
    WxResult publishQrCodeRule(String prefix);

    /**
     * 删除已设置的二维码规则
     *
     * @param prefix 二维码规则
     * @return 删除结果
     */
    WxResult delQrCodeRule(String prefix);

    /**
     * 将二维码长链接转成短链接
     *
     * @param longUrl 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     * @return 返回结果
     */
    WxShortUrlResult getShortUrl(String longUrl);
}
