package com.lix.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : lix
 * @desc :
 * @time : 9:002017/11/27
 * @modify by :
 */
public class BeanUtils {
    private static String[] getNullPropertyName(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : propertyDescriptors){
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyNames.add(pd.getName());
            }else {
                String strValue = convertValue(srcValue);
                if (StringUtils.isEmpty(strValue)){
                    emptyNames.add(pd.getName());
                }
            }

        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    private static String convertValue(Object obj){
        Class<?> clazz = obj.getClass();
        String type = clazz.getName();
        if("java.lang.String".equals(type)){
            return  obj.toString();
        }else if("java.tuil.Date".equals(type)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return sdf.format(obj);
        }else if("java.math.BigDecimal".equals(type)){
            return  obj.toString();
        }else if("java.lang.Integer".equals(type)){
            if("0".equals(obj.toString())){
                return "";
            }
            return obj.toString();
        }else if("java.math.Float".equals(type)){
            return String.valueOf(obj);
        }else if("java.math.Double".equals(type)){
            return String.valueOf(obj);
        }
            return "";
    }

    public static void copyPropertityIgnoreNull(Object source,Object target){
        org.springframework.beans.BeanUtils.copyProperties(source,target,getNullPropertyName(source));
    }

}
