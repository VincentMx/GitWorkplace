package com.lix.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author : lix
 * @desc :
 * @time : 15:042017/11/28
 * @modify by :
 */
public class JsonDate implements JsonValueProcessor {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH;MM;ss");

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value,jsonConfig);
    }

    @Override
    public Object processObjectValue(String s, Object value, JsonConfig jsonConfig) {
        return process(value,jsonConfig);
    }

    private Object process(Object value, JsonConfig jsonConfig){
        Object dateValue = value;
        if((dateValue instanceof  java.sql.Date)){
            dateValue = new java.util.Date(((java.sql.Date)dateValue).getTime());
        }
        if ((dateValue instanceof  java.util.Date)){
            return  this.dateFormat.format(dateValue);
        }
       return dateValue;
    }
}
