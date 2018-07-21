package cn.lix.entity.WeChatMessage.req;

/**
 * @author : lix
 * @desc :视频/小视频消息
 * @time : 0:302018/7/13
 * @modify by :
 */
public class VideoMessage   extends BaseMessage{

    // 视频消息媒体 id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    // 视频消息缩略图的媒体 id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
