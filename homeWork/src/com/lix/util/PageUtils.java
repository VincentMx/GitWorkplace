package com.lix.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc :解析page工具类
 * @time : 8:562017/11/27
 * @modify by :
 */
public class PageUtils {

    
    /**
      *@method: 获取easyui的page数据
      *@author: lix
      *@desc： 
      *@Date: 15:27 2017/11/28
      *@param: 
      *@return:
      *
      */
    public static String getEasyUIPageJsonData(Page page){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",page.getTotalCount());
        map.put("rows",page.getData());
        return JsonUtils.getJsonData(map);
    }

    /**
     *@method: 获取extjs的page数据
     *@author: lix
     *@desc：
     *@Date: 15:27 2017/11/28
     *@param:
     *@return:
     *
     */
    public static String getExtjsPageJsonData(Page page){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("totalCount",page.getTotalCount());
        map.put("results",page.getData());
        return JsonUtils.getJsonData(map);
    }
    
    /**
      *@method: 获取bootStrapTable数据
      *@author: lix
      *@desc： 
      *@Date: 8:58 2017/12/4
      *@param: page
      *@return:   
      *
      */
    public static Map<String,Object> getBootStrapTableJsonData(Page page){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalCount",page.getTotalCount());
        map.put("results",page.getData());
        return map;
    }
    
    
    
}
