package com.lix.util;

import com.boyang.core.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:502017/12/28
 * @modify by :
 */
public class jdbcUtilDao {


    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        jdbcUtilDao.jdbcTemplate = jdbcTemplate;
    }

     /**
       *@method: 根据参数和sql语句查询信息
       *@author: lix
       *@desc：
       *@Date: 14:56 2017/12/28
       *@param:
       *@return:
       *
       */
    public <R>  List<R> queryPara(String sql, Class<R> clazz,Object[] args){
        List<R> result = jdbcTemplate.query(sql,args,new UserRowMapper(clazz));
        return  result == null ? new ArrayList<R>() : result;
    }





}
