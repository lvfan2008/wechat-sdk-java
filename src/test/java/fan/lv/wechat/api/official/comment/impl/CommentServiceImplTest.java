package fan.lv.wechat.api.official.comment.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.comment.CommentService;
import fan.lv.wechat.entity.official.comment.WxListCommentParam;
import fan.lv.wechat.entity.official.comment.WxListCommentResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class CommentServiceImplTest extends TestCase {

    CommentService commentService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        commentService = new CommentServiceImpl(Util.getClient());
    }

    public void testOpenComment() {
        WxResult result = commentService.openComment(123, 0);
        assertEquals(88001, (int) result.getErrorCode());
    }

    public void testListComment() {
        WxListCommentParam param = new WxListCommentParam(123, 0, 0, 10, 0);
        WxListCommentResult result = commentService.listComment(param);
        assertEquals(88001, (int) result.getErrorCode());
    }

    public void testMarkComment() {
        WxResult result = commentService.markComment(123, 0, 3);
        assertEquals(88001, (int) result.getErrorCode());
    }

    public void testUnMarkComment() {
        WxResult result = commentService.unMarkComment(123, 0, 3);
        assertEquals(88001, (int) result.getErrorCode());
    }

    public void testDeleteComment() {
        WxResult result = commentService.deleteComment(123, 0, 3);
        assertEquals(88001, (int) result.getErrorCode());
    }

    public void testReplyComment() {
        WxResult result = commentService.replyComment(123, 0, 3, "test");
        assertEquals(88001, (int) result.getErrorCode());
    }

    public void testDeleteCommentReply() {
        WxResult result = commentService.deleteCommentReply(123, 0, 3);
        assertEquals(88001, (int) result.getErrorCode());
    }
}