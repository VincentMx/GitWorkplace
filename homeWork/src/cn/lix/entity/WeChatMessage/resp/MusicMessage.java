package cn.lix.entity.WeChatMessage.resp;

/**
 * @author : lix
 * @desc :
 * @time : 0:312018/7/13
 * @modify by :
 */
public class MusicMessage extends BaseMessage {

// 音乐
 private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
