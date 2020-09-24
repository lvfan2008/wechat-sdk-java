package fan.lv.wechat.api.official.comment.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.comment.CommentService;
import fan.lv.wechat.entity.official.comment.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public class CommentServiceImpl implements CommentService {
    /**
     * 请求客户端
     */
    protected Client client;

    public CommentServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult openComment(Integer msgDataId, Integer index) {
        return client.post("/cgi-bin/comment/open", new WxOpenCommentParam(msgDataId, index), WxResult.class);
    }

    @Override
    public WxListCommentResult listComment(WxListCommentParam wxListCommentParam) {
        return client.post("/cgi-bin/comment/list", wxListCommentParam, WxListCommentResult.class);
    }

    @Override
    public WxResult markComment(Integer msgDataId, Integer index, Integer userCommentId) {
        return client.post("/cgi-bin/comment/markelect", new WxCommentParam(msgDataId, index, userCommentId), WxResult.class);
    }

    @Override
    public WxResult unMarkComment(Integer msgDataId, Integer index, Integer userCommentId) {
        return client.post("/cgi-bin/comment/unmarkelect", new WxCommentParam(msgDataId, index, userCommentId), WxResult.class);
    }

    @Override
    public WxResult deleteComment(Integer msgDataId, Integer index, Integer userCommentId) {
        return client.post("/cgi-bin/comment/delete", new WxCommentParam(msgDataId, index, userCommentId), WxResult.class);
    }

    @Override
    public WxResult replyComment(Integer msgDataId, Integer index, Integer userCommentId, String content) {
        return client.post("/cgi-bin/comment/reply/add", new WxReplyCommentParam(msgDataId, index, userCommentId, content), WxResult.class);
    }

    @Override
    public WxResult deleteCommentReply(Integer msgDataId, Integer index, Integer userCommentId) {
        return client.post("/cgi-bin/comment/reply/delete", new WxCommentParam(msgDataId, index, userCommentId), WxResult.class);
    }
}
