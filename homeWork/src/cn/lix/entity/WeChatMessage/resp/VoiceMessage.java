package cn.lix.entity.WeChatMessage.resp;

/**
 * @author : lix
 * @desc :语音消息
 * @time : 1:112018/7/13
 * @modify by :
 */
public class VoiceMessage  extends BaseMessage {

    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
