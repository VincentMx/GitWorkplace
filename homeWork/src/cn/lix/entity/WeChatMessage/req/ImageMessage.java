package cn.lix.entity.WeChatMessage.req;

/**
 * @author : lix
 * @desc :图片消息
 * @time : 0:292018/7/13
 * @modify by :
 */
public class ImageMessage extends BaseMessage{

    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
