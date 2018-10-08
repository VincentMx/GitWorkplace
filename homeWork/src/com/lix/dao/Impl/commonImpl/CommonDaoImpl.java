package com.lix.dao.Impl.commonImpl;

import com.lix.dao.common.CommonDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : lix
 * @desc : 序列化参数获取
 * @time : 15:432018/9/20
 * @modify by :
 */
@Component("commonDao")
public class CommonDaoImpl implements CommonDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getNextVal(String name) {
        String sql = " select NEXTVAL('" + name + "')  ";
        Map<String, Object> map =  jdbcTemplate.queryForMap(sql);
        return map.get("NEXTVAL('" + name + "')").toString();
    }

    @Override
    public String getCurrVal(String name) {
        String sql = " select CURRVAL('" + name + "')  ";
        Map<String, Object> map =  jdbcTemplate.queryForMap(sql);
        return map.get("CURRVAL('" + name + "')").toString();
    }

    @Override
    public String setVal(String name, int num) {
        String sql = " select SETVAL('" + name + "' , "+ num +")  ";
        String a = "";
        try{
            jdbcTemplate.execute(sql);
            a = "1";
        }catch (Exception e){

            e.printStackTrace();
            a = "0";
        }
        return a;
    }
}
