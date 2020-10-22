package fan.lv.wechat.api.open.service.open.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.open.OpenFastRegisterMpService;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class OpenFastRegisterMpServiceImpl implements OpenFastRegisterMpService {

    Client client;

    public OpenFastRegisterMpServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult fastRegister(String name, String code, Integer codeType, String legalPersonaWechat, String legalPersonaName, String componentPhone) {
        return client.postJson("/cgi-bin/component/fastregisterweapp?action=create",
                SimpleMap.of("name", name, "code", code, "code_type", codeType,
                        "legal_persona_wechat", legalPersonaWechat, "legal_persona_name", legalPersonaName,
                        "component_phone", componentPhone
                ),
                WxResult.class);
    }

    @Override
    public WxResult queryFastRegisterState(String name, String legalPersonaWechat, String legalPersonaName) {
        return client.postJson("/cgi-bin/component/fastregisterweapp?action=search",
                SimpleMap.of("name", name, "legal_persona_wechat", legalPersonaWechat,
                        "legal_persona_name", legalPersonaName),
                WxResult.class);
    }
}
