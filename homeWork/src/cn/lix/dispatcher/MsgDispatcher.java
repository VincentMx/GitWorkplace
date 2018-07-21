package cn.lix.dispatcher;

import com.lix.util.WeChat.MessageUtil;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @author : lix
 * @desc :消息业务处理分发器
 * @time : 0:432018/7/13
 * @modify by :
 */
public class MsgDispatcher {

    private Logger log = Logger.getLogger(MsgDispatcher.class);

    public static String processMessage(Map<String, String> map) {
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
        System.out.println("==============这是文本消息！");
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
        System.out.println("==============这是图片消息！");
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
        System.out.println("==============这是链接消息！");
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
        System.out.println("==============这是位置消息！");
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
        System.out.println("==============这是视频消息！");
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
        System.out.println("==============这是语音消息！");
        } return null;
    }
}