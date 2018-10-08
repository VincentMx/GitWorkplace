package com.lix.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author : lix
 * @desc :
 * @time : 14:472018/8/22
 * @modify by :
 */
public class RandomUtil {


    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Long startTime = new Date().getTime();
        String msgString = getCharAndNumr(6) + "-" + getCharAndNumr(6) + "-" + getCharAndNumr(6) + "-" + getCharAndNumr(6);
//	        while (true) {
//	            String code = getCharAndNumr(6);
//	            set.add(code);
//	            if (set.size() >= 1000) {
//	                break;
//	            }
//	        }
        Long endTime = new Date().getTime();
        long time = (endTime - startTime);
        System.out.println(msgString);
        System.out.println("生成个数：" + set.size());
        System.out.println("生成耗时" + time + "毫秒，约" + (time / 1000) + "秒");//
//	        for (String string : set) {
//	            System.out.println(string);
//	        }
    }

    /**
     * java生成随机数字和字母组合
     *
     * @param length [生成随机数的长度]
     *
     */
    public static String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


}
