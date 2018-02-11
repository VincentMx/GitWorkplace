package com.lix.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 15:472017/11/27
 * @modify by :
 */
public class JsonUtils {

    public static String getJsonDataByPage(List<?> list){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",true);
        map.put("totalCount",list.size());
        map.put("results",list);
        JSONArray array = JSONArray.fromObject(map);
        return array.toString().substring(1,array.toString().length() - 1);

    }

    /***
     * 返回json数据
     * @param bean
     * @return
     */

    public static String getJsonData(Object bean){
        return JSONObject.fromObject(bean,getJsonConfig(null)).toString();
    }

    public static JsonConfig getJsonConfig(String dateFormat){
        JsonDate beanProcessor = new JsonDate();
        if (dateFormat != null){
            DateFormat df = new SimpleDateFormat(dateFormat);
            beanProcessor.setDateFormat(df);
        }
        JsonConfig  jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        jsonConfig.registerJsonValueProcessor(Date.class,beanProcessor);
        String defaultValue = null;
        if((StringUtils.hasText(defaultValue))&&(defaultValue.equals("null"))){
            jsonConfig.registerDefaultValueProcessor(Integer.class,new DefaultValueProcessor(){

                @Override
                public Object getDefaultValue(Class aClass) {
                    return null;
                }
            });
            jsonConfig.registerDefaultValueProcessor(Long.class, new DefaultValueProcessor() {
                @Override
                public Object getDefaultValue(Class aClass) {
                    return null;
                }
            });
            jsonConfig.registerDefaultValueProcessor(Float.class, new DefaultValueProcessor() {
                @Override
                public Object getDefaultValue(Class aClass) {
                    return null;
                }
            });
            jsonConfig.registerDefaultValueProcessor(Double.class, new DefaultValueProcessor() {
                @Override
                public Object getDefaultValue(Class aClass) {
                    return null;
                }
            });
            jsonConfig.registerDefaultValueProcessor(BigInteger.class, new DefaultValueProcessor() {
                @Override
                public Object getDefaultValue(Class aClass) {
                    return null;
                }
            });
            jsonConfig.registerDefaultValueProcessor(BigDecimal.class, new DefaultValueProcessor() {
                @Override
                public Object getDefaultValue(Class aClass) {
                    return null;
                }
            });
        }
        return jsonConfig;
    }

    public  static String PutListToJson(List<?> list){
        JSONArray array = JSONArray.fromObject(list);
        return array.toString();
    }

}
