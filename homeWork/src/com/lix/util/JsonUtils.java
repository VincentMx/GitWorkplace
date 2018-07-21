package com.lix.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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



    /**
     *
     * @author liufp
     *
     *   方法描述：
     *      json转换成map
     * @param
     * @return
     */
    public static Map<String, Object> parseJSON2Map(String jsonStr){

        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析

        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k);
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                @SuppressWarnings("unchecked")
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }



    /**
     *
     * @author liufp
     *
     *   方法描述：
     *     对象转换成json
     * @param obj
     * @return
     */
    public static String object2json(Object obj) {
        StringBuilder json = new StringBuilder();
        if (obj == null) {
            json.append("\"\"");
        } else if (obj instanceof String || obj instanceof Integer || obj instanceof Float
                || obj instanceof Boolean || obj instanceof Short || obj instanceof Double
                || obj instanceof Long || obj instanceof BigDecimal
                || obj instanceof BigInteger || obj instanceof Byte) {
            json.append("\"").append(string2json(obj.toString())).append("\"");
        } else if (obj instanceof Object[]) {
            json.append(array2json((Object[]) obj));
        } else if (obj instanceof List) {
            json.append(list2json((List<?>) obj));
        } else if (obj instanceof Map) {
            json.append(map2json((Map<?, ?>) obj));
        } else if (obj instanceof Set) {
            json.append(set2json((Set<?>) obj));
        } else {
            json.append(bean2json(obj));
        }
        return json.toString();
    }

    /**
     *
     * @author liufp
     *
     *   方法描述：
     *     bean转换成json
     * @param bean
     * @return
     */
    public static String bean2json(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo
                    (bean.getClass(), Object.class).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                try {
                    String name = object2json(props[i].getName());
                    String value = object2json(props[i].getReadMethod().invoke(bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     *
     * @author liufp
     *
     *   方法描述：
     *      list转换成json
     * @param list
     * @return
     */
    public static String list2json(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     *
     * @author liufp
     *
     *   方法描述：
     *    array转换成json
     * @param array
     * @return
     */
    public static String array2json(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     *
     * @author liufp
     *
     *   方法描述：
     *     map转换成json
     * @param map
     * @return
     */
    public static String map2json(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(object2json(key));
                json.append(":");
                json.append(object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }


    /**
     *
     * @author liufp
     *
     *   方法描述：
     *    set转换成json
     * @param set
     * @return
     */
    public static String set2json(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for (Object obj : set) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     *
     * @author liufp
     *
     *   方法描述：
     *     String转换成json
     * @param s
     * @return
     */
    public static String string2json(String s) {
        if (null == s){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F') {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    } else {
                        sb.append(ch);
                    }
            }
        }
        return sb.toString();
    }

    /**
     *
     * @author chenp
     *
     *   方法描述：
     *     map转换成json(主要针对json转map时产生转义字符\所写)
     * @param map
     * @return
     */
    public static String map2json2(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(object2json(key));
                json.append(":");
                json.append(object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        String theString = json.toString().replace("\\/", "/");//对斜线的转义
        return theString;
    }

}
