package cn.lix.entity.WeChatMessage.resp;

/**
 * @author : lix
 * @desc :图片消息实体类
 * @time : 1:102018/7/13
 * @modify by :
 */
public class ImageMessage extends BaseMessage{


    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
