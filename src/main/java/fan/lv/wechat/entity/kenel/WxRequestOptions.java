package fan.lv.wechat.entity.kenel;

import fan.lv.wechat.util.RequestOptions;
import lombok.Data;

/**
 * @author lixinguo
 */
@Data
public class WxRequestOptions {

    /**
     * 是否自动获取令牌
     */
    Boolean autoGetAccessToken = true;

    /**
     * Http请求选项
     */
    RequestOptions requestOptions = new RequestOptions();

    public  static WxRequestOptions def(){
        return new WxRequestOptions();
    }

    WxRequestOptions autoGetAccessToken(Boolean autoGetAccessToken){
        this.autoGetAccessToken = autoGetAccessToken;
        return this;
    }
}
