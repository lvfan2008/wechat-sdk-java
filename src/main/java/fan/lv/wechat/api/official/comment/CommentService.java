package fan.lv.wechat.api.official.comment;

import fan.lv.wechat.entity.comment.WxListCommentParam;
import fan.lv.wechat.entity.comment.WxListCommentResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 评论数据管理
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Comments_management/Image_Comments_Management_Interface.html" target="_blank">微信官方接口文档</a>
 */
public interface CommentService {
    /**
     * 打开已群发文章评论
     *
     * @param msgDataId 群发返回的msg_data_id
     * @param index     多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @return 请求结果
     */
    WxResult openComment(Integer msgDataId, Integer index);

    /**
     * 查看指定文章的评论数据
     *
     * @param wxListCommentParam 查看评论参数
     * @return 评论列表
     */
    WxListCommentResult listComment(WxListCommentParam wxListCommentParam);

    /**
     * 将评论标记精选
     *
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 请求结果
     */
    WxResult markComment(Integer msgDataId, Integer index, Integer userCommentId);

    /**
     * 将评论取消精选
     *
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 请求结果
     */
    WxResult unMarkComment(Integer msgDataId, Integer index, Integer userCommentId);

    /**
     * 删除评论
     *
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 请求结果
     */
    WxResult deleteComment(Integer msgDataId, Integer index, Integer userCommentId);

    /**
     * 删除评论
     *
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @param content       回复评论
     * @return 请求结果
     */
    WxResult replyComment(Integer msgDataId, Integer index, Integer userCommentId, String content);

    /**
     * 删除评论回复
     *
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 请求结果
     */
    WxResult deleteCommentReply(Integer msgDataId, Integer index, Integer userCommentId);
}
