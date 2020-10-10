package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.mp.service.OperationService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.operation.*;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

import java.util.Date;

/**
 * @author lv_fan2008
 */
public class OperationServiceImplTest extends TestCase {
    OperationService operationService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        operationService = new OperationServiceImpl(Util.getMpClient());
    }

    public void testGetFeedback() {
        WxGetFeedbackResult result = operationService.getFeedback(1, 20, null);
        assertTrue(result.success());
    }

    public void testGetJsErrSearch() {
        String json = "{\n" +
                "  \"errmsg_keyword\":\"\",\n" +
                "  \"type\":1,\n" +
                "  \"client_version\": \"\",\n" +
                "  \"start_time\": 1587021734,\n" +
                "  \"end_time\": 1587626534,\n" +
                "  \"start\": 1,\n" +
                "  \"limit\": 1,\n" +
                "  \"sceneDesc\": \"测试数据\"\n" +
                "}";
        WxGetJsErrSearchParam param = JsonUtil.parseJson(json, WxGetJsErrSearchParam.class);
        WxGetJsErrSearchResult result = operationService.getJsErrSearch(param);
        assertTrue(result.success());
    }

    public void testGetPerformance() {
        String json = "{\n" +
                "  \"cost_time_type\": 2,\n" +
                "  \"default_start_time\": 1572339403,\n" +
                "  \"default_end_time\": 1574931403,\n" +
                "  \"device\": \"@_all\",\n" +
                "  \"networktype\": \"@_all\",\n" +
                "  \"scene\": \"@_all\",\n" +
                "  \"is_download_code\": \"@_all\"\n" +
                "}";
        WxGetPerformanceParam param = JsonUtil.parseJson(json, WxGetPerformanceParam.class);
        WxGetPerformanceResult result = operationService.getPerformance(param);
        assertTrue(result.success());
    }

    public void testGetSceneList() {
        WxGetSceneListResult result = operationService.getSceneList();
        assertTrue(result.success());
    }

    public void testGetVersionList() {
        WxGetVersionListResult result = operationService.getVersionList();
        assertTrue(result.success());
    }

    public void testTestGetPerformance() {
        long yesterday = System.currentTimeMillis() - 24 * 3600 * 1000;
        Date d = new Date(yesterday);
        String date = String.format("%tY%tm%td", d, d, d);
        WxRealtimeLogSearchParam param = new WxRealtimeLogSearchParam(date, (int) (yesterday / 1000),  (int)(yesterday / 1000 + 200));
        WxRealtimeLogSearchResult result = operationService.getRealtimeLogSearch(param);
        assertTrue(result.success());
    }
}