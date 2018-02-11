package com.lix.util;

/**
 * @author : lix
 * @desc :
 * @time : 10:362017/12/31
 * @modify by :
 */
public class SysUnitUtil {



    public static String getLimitUnitUtil(String unit){
        if (unit != null  && unit != ""){
            for (int i = 0; i < unit.length() ; i++) {
                if (unit.substring(unit.length()-1, unit.length()) == "0") {
                     unit = unit.substring(0,unit.length() - 1);
                }else {
                    break;
                }
            }
        }

        return  unit;
    }
    
    
    
    /**
      *@method: 获取单位代码等级
      *@author: lix
      *@desc： 
      *@Date: 17:29 2018/1/16
      *@param: 
      *@return:   
      *
      */
    public static String getRightDome(String unitKey){
        String rightDm = "";
        int[] gradeArr = new int[]{3,3,2,2,2};
        for (int i = 0; i <gradeArr.length; i++) {
            String str = unitKey.substring(unitKey.length()-gradeArr[i], unitKey.length());
            if ((str.length() == 2 && !"00".equals(str)) || (str.length() == 3 && !"000".equals(str))){
                rightDm = unitKey;
                break;
            }
            unitKey = unitKey.substring(0,unitKey.length() - gradeArr[i]);
        }
        return rightDm;
        
    }
}
