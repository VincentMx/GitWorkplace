package cn.lix.entity.WeChatMessage.resp;

/**
 * @author : lix
 * @desc :回复文本消息
 * @time : 0:322018/7/13
 * @modify by :
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
     private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
