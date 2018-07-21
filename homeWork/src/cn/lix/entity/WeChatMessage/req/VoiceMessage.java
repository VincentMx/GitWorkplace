package cn.lix.entity.WeChatMessage.req;

/**
 * @author : lix
 * @desc :语音消息
 * @time : 0:302018/7/13
 * @modify by :
 */
public class VoiceMessage extends BaseMessage{


    // 媒体 ID
     private String MediaId;
    // 语音格式
     private String Format;


    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
