package cn.lix.dispatcher;

import cn.lix.entity.WeChatMessage.resp.Article;
import cn.lix.entity.WeChatMessage.resp.ImageMessage;
import cn.lix.entity.WeChatMessage.resp.NewMessage;
import cn.lix.entity.WeChatMessage.resp.TextMessage;
import com.alibaba.fastjson.JSON;
import com.lix.util.WeChat.MessageUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :事件消息业务处理分发器
 * @time : 0:442018/7/13
 * @modify by :
 */
public class EventDispatcher {
    private static Logger logger = Logger.getLogger(EventDispatcher.class);



    public static String processEvent(Map<String, String> map) {

        //获取用户信息
        String openId = map.get("FromUserName");
        String mPid = map.get("ToUserName");


        //图片消息体
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setToUserName(openId);
        imageMessage.setFromUserName(mPid);


        //图文消息
        NewMessage newMessage = new NewMessage();
        newMessage.setFromUserName(mPid);
        newMessage.setToUserName(openId);
        newMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        newMessage.setCreateTime(new Date().getTime());

        //文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(openId);
        textMessage.setFromUserName(mPid);
        textMessage.setCreateTime(new Date().getTime());


        if(map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
            logger.info("==============这是关注事件！");
            List<Article> articleList = new ArrayList<Article>();
            Article article = new Article();
            article.setDescription("走了这么久、终于找到了啊、不容易哦");
            article.setTitle("欢迎您关注木子的微信公众号丫丫法语");
            article.setUrl("http://mp.weixin.qq.com/s?__biz=MzU3MDAyMzE1OQ==&mid=2247483797&idx=1&sn=7e9dc0b2b4052b7e55df2fc730df3910&chksm=fcf48c0dcb83051be8f7e379c6280554f64ac1da28b8ccc7745116c0b8b89b5ddf67d0ec5926&mpshare=1&scene=24&srcid=0904aN3eWlihLqOfdurWhocF#rd");
            article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/Oa16vswQQP22cOSMBQ5icxDd8wMWaiaqMl8NgMrTbWssNhR5XrJQ15H7z4U7licldfOleCEuEQu5a3VB9DNWxicibmA/0");

            articleList.add(article);

            newMessage.setCreateTime(new Date().getTime());
            newMessage.setArticleCount(1);
            newMessage.setArticles(articleList);

            logger.info("===============回复消息体是：" + JSON.toJSONString(newMessage));
            logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.newsMessageToXml(newMessage)));

            return MessageUtil.newsMessageToXml(newMessage);

        }
        if(map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件

           String Content = map.get("Content");
           logger.info("==============这是取消关注事件！");
           logger.info("==============您输入的消息是：" + Content);
           logger.info("==============您是：" + openId);

           textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
           textMessage.setContent("期待您的再次关注，谢谢！");
           logger.info("===============回复消息体是：" + JSON.toJSONString(textMessage));
           logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.textMessageToXml(textMessage)));
           return MessageUtil.textMessageToXml(textMessage);
        }
        if(map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件

        logger.info("==============这是扫描二维码事件！");
        }
        if(map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件

        logger.info("==============这是位置上报事件！");
        }
        if(map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件

        logger.info("==============这是自定义菜单点击事件！");
        }
        if(map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件

        logger.info("==============这是自定义菜单 View 事件！");
        }
        return null;
    }

}
