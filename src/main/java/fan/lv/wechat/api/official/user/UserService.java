package fan.lv.wechat.api.official.user;

import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.entity.user.WxCreateTagResult;
import fan.lv.wechat.entity.user.WxGetTagUserResult;
import fan.lv.wechat.entity.user.WxGetTagsResult;

/**
 * @author lv_fan2008
 */
public interface UserService {

    /**
     * 创建标签,一个公众号，最多可以创建100个标签。
     *
     * @param name 标签名称
     * @return 创建标签结果
     */
    WxCreateTagResult createTag(String name);

    /**
     * 获取公众号已创建的标签
     *
     * @return 标签列表
     */
    WxGetTagsResult getTags();

    /**
     * 编辑标签
     *
     * @param id   标签id，由微信分配
     * @param name 标签名
     * @return 返回结果
     */
    WxResult updateTag(Integer id, String name);

    /**
     * 删除标签
     *
     * @param id 标签id，由微信分配
     * @return 删除结果
     */
    WxResult deleteTag(Integer id);

    /**
     * 获取标签下粉丝列表
     *
     * @param tagId      标签Id
     * @param nextOpenId 第一个拉取的OPENID，不填（null）默认从头开始拉取
     * @return 粉丝列表
     */
    WxGetTagUserResult getTagUser(Integer tagId, String nextOpenId);
}
