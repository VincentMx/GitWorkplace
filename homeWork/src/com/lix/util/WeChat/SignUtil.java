package com.lix.util.WeChat;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author : lix
 * @desc :检验微信发送的消息
 * @time : 19:522018/7/12
 * @modify by :
 */
public class SignUtil {


    private org.apache.log4j.Logger logger = Logger.getLogger(SignUtil.class);

    private static String Token = "wslzlgdxlx";




    public static Boolean checkSignature(String signature, String timestamp, String nonce){
        String[] strs = new String[] {Token,timestamp,nonce};
        Arrays.sort(strs);
        StringBuffer content = new StringBuffer();
        for(int i = 0; i < strs.length; i ++){
            content.append(strs[i]);
        }

        MessageDigest md = null;
        String tmpStr = null;

        try{
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return signature!=null?tmpStr.toUpperCase().equals(tmpStr.toUpperCase()):false;



    }

    /** * 将字节数组转换为十六进制字符串 * @param byteArray * @return */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    /** * 将字节转换为十六进制字符串 * @param mByte * @return */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

    public static String byteArrayToStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        String str = new String(byteArray);
        return str;
    }

}
