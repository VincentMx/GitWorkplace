package cn.lix.entity.WeChatMessage.resp;

/**
 * @author : lix
 * @desc :回复视频消息
 * @time : 1:112018/7/13
 * @modify by :
 */
public class VideoMessage extends BaseMessage {
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
