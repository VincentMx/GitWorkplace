package cn.lix.dispatcher;

import cn.lix.entity.WeChatMessage.resp.*;
import com.alibaba.fastjson.JSON;
import com.lix.manager.TranslateManager;
import com.lix.util.WeChat.MessageUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author : lix
 * @desc :消息业务处理分发器
 * @time : 0:432018/7/13
 * @modify by :
 */
@Component
public class MsgDispatcher {

    private static Logger logger = Logger.getLogger(MsgDispatcher.class);




    public static String processMessage(Map<String, String> map) {
        String openId = map.get("FromUserName");
        String mPid = map.get("ToUserName");


        //将微信用户添加至数据库
//        WxYhCzUtil wxYhCzUtil = new WxYhCzUtil();
//        wxYhCzUtil.addWxYh(openId);


        //翻译的接口类
        TranslateManager translateManager = new TranslateManager();

        //文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(openId);
        textMessage.setFromUserName(mPid);
        textMessage.setCreateTime(new Date().getTime());


        //图片消息
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
        imageMessage.setToUserName(openId);
        imageMessage.setFromUserName(mPid);


        //声音消息
        VoiceMessage voiceMessage = new VoiceMessage();
        voiceMessage.setFromUserName(mPid);
        voiceMessage.setToUserName(openId);
        voiceMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Voice);


        //图文消息
        NewMessage newMessage = new NewMessage();
        newMessage.setFromUserName(mPid);
        newMessage.setToUserName(openId);
        newMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        newMessage.setCreateTime(new Date().getTime());


        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            Map<String , Object> objectMap = new HashMap<String , Object>();
            Map<String , Object> rtnMap = new HashMap<String , Object>();
            Map<String , Object> rtnMap2 = new HashMap<String , Object>();

            String result = null;
            String result2 = null;

            String Content = map.get("Content");
           logger.info("==============这是文本消息！");
           logger.info("==============您输入的消息是：" + Content);
           logger.info("==============您是：" + openId);

           logger.info("==============您输入的待翻译的消息长度是：" + Content.length());
            //判断长度
            if(Content.length() > 2 && "翻译".equals(Content.substring(0 , 2))){
                String DfyStr = Content.substring(2,Content.length());
               logger.info("==============您输入的待翻译的消息是：" + DfyStr);
                objectMap.put("queryStr",DfyStr);
                objectMap.put("id",openId);

                //调运翻译接口
                rtnMap =  translateManager.queryForBaiduTrans(objectMap);
                //英语翻译
                objectMap.put("to","en");
                rtnMap2 =  translateManager.queryForBaiduTrans(objectMap);

                if(!"0000".equals(rtnMap.get("retcode"))){
                   logger.info("==============您输入的消息翻译出错");
                }else {
                    result = JSON.toJSONString (rtnMap.get("words").toString());
                    result2 = JSON.toJSONString (rtnMap2.get("words").toString());

                   logger.info("==============您输入的待翻译的消息翻译出来后是：" + result);
                   logger.info("==============您输入的待翻译的消息翻译出来后是：" + result2);

                    textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setContent("哇哦、刚刚输入的 \n【" + DfyStr + "】\n 翻译成法语是:\n【"+ result +"】\n 翻译成英语是:\n【"+ result2 +"】\n感觉翻译的怎么样啊。");
                   logger.info("===============回复消息体是：" + JSON.toJSONString(textMessage));
                   logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.textMessageToXml(textMessage)));

                    return MessageUtil.textMessageToXml(textMessage);
                }
              }


            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setContent("哈哈、抓到你了、刚刚输入\n【" + Content + "】的家伙、你的微信ID是【" + openId + "】\n ,这下你跑不掉喽！ \n【小提示：内容前加上翻译两个字、可以免费帮你翻译哦】");
           logger.info("===============回复消息体是：" + JSON.toJSONString(textMessage));
           logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.textMessageToXml(textMessage)));

            return MessageUtil.textMessageToXml(textMessage);

        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
           logger.info("==============这是图片消息！");
           logger.info("==============您输入的图片地址为：" + map.get("PicUrl"));
            String medisId = map.get("MediaId");
            String picUrl = map.get("PicUrl");
            Image image = new Image();
            image.setMediaId(medisId);


            imageMessage.setCreateTime(new Date().getTime());
            imageMessage.setImage(image);
           logger.info("===============回复消息体是：" + JSON.toJSONString(imageMessage));
           logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.imageMessageToXml(imageMessage)));

            return MessageUtil.imageMessageToXml(imageMessage);
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息

           logger.info("==============这是链接消息！");
            String  Description = map.get("Description");
            String  Title = map.get("Title");
            String  url = map.get("Url");

           logger.info("==============连接描述是：【" + Description+"】");
           logger.info("==============连接标题是：【" + Title +"】");
           logger.info("==============连接描述是：【" + url +"】");
            List<Article> articleList = new ArrayList<Article>();
            Article article = new Article();
            article.setDescription(Description);
            article.setTitle(Title);
            article.setUrl(url);
            article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/Oa16vswQQP22cOSMBQ5icxDd8wMWaiaqMl8NgMrTbWssNhR5XrJQ15H7z4U7licldfOleCEuEQu5a3VB9DNWxicibmA/0");

            articleList.add(article);

            newMessage.setCreateTime(new Date().getTime());
            newMessage.setArticleCount(1);
            newMessage.setArticles(articleList);

           logger.info("===============回复消息体是：" + JSON.toJSONString(newMessage));
           logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.newsMessageToXml(newMessage)));

            return MessageUtil.newsMessageToXml(newMessage);

        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
          logger.info("==============这是位置消息！");
           String label = map.get("Label");
           String x = map.get("Location_X");
           String y = map.get("Location_Y");
           String Scale = map.get("Scale");

           textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
           textMessage.setContent("还发位置哪。。。 \n" +
                   "我知道你在：【" + label + "】\n" +
                   "还是个"+Scale+"级的地图上取的 \n" +
                   "你看你这坐标：x : 【" + x+ "】，y : 【"+ y +"】.\n" +
                   "乖乖看文章吧！！！");
           logger.info("==============位置是：【" + label+"】");
           logger.info("==============坐标x: " + x +", 坐标y: " + y );
           logger.info("==============这是个"+ Scale+"级的地图。");
           logger.info("===============回复消息体是：" + JSON.toJSONString(textMessage));
           logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.textMessageToXml(textMessage)));

            return MessageUtil.textMessageToXml(textMessage);
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
       logger.info("==============这是视频消息！");
        }
        if(map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息

           logger.info("==============这是语音消息！");
            String MediaId = map.get("MediaId");
            Voice voice = new Voice();
            voice.setMediaId("aB43q47vpNP49mMKy68ofKck3TpNQfc0pb2rPY2D16KMi_PTm0rsmK-o_5kjpbH4");
            voiceMessage.setVoice(voice);

           logger.info("===============回复消息体是：" + JSON.toJSONString(voiceMessage));
           logger.info("===============封装后消息体是：" + JSON.toJSONString(MessageUtil.voiceMessageToXml(voiceMessage)));

            return MessageUtil.voiceMessageToXml(voiceMessage);
        }
        return null;
    }



    public Map<String , Object> getTranslatedWord (Map<String , Object> map){
        Map<String , Object> rtnMap = new HashMap<String , Object>();



        return rtnMap;
    }
}
