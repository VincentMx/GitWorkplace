package cn.lix.entity.WeChatMessage.req;

/**
 * @author : lix
 * @desc : 文本消息
 * @time : 0:292018/7/13
 * @modify by :
 */
public class TextMessage  extends BaseMessage{

// 消息内容
private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
