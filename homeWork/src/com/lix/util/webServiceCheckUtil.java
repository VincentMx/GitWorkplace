package com.lix.util;

import cn.lix.constants.Constants;
import cn.lix.constants.SystemErrorCode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 23:462018/7/4
 * @modify by :
 */
@Component
public class webServiceCheckUtil {
    public String rtnBack(String msg,Map<String, Object> headMap) {
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put(SystemErrorCode.retcode, Constants.error);
        bodyMap.put(SystemErrorCode.retshow, msg);
        rtnMap.put("msghead", headMap);
        rtnMap.put("msgrsp", bodyMap);
        String resStr = JsonUtils.map2json(rtnMap);
        return resStr;
    }

    public String rtnBack(String code,String msg,Map<String, Object> headMap) {
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put(SystemErrorCode.retcode, code);
        bodyMap.put(SystemErrorCode.retshow, msg);
        rtnMap.put("msghead", headMap);
        rtnMap.put("msgrsp", bodyMap);
        String resStr = JsonUtils.map2json(rtnMap);
        return resStr;
    }

}
