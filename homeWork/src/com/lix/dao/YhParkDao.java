package com.lix.dao;

import com.lix.entity.ClXx;
import com.lix.entity.ParkCl;
import com.lix.entity.ParkSf;
import com.lix.entity.ParkXx;
import com.lix.entity.vo.CwxxVO;
import com.lix.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :用户停车数据库操作类
 * @time : 23:172018/5/2
 * @modify by :
 */
public interface YhParkDao {

    /**
      *@method: 添加车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:26 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void save(ClXx clXx);
    /**
      *@method: 添加停车位信息
      *@author: lix
      *@desc： 
      *@Date: 23:27 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void save(ParkXx parkXx);
    /**
      *@method: 添加停车位-车辆映射关系
      *@author: lix
      *@desc： 
      *@Date: 23:27 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void save(ParkCl parkCl);
    /**
      *@method: 添加停车收费信息
      *@author: lix
      *@desc： 
      *@Date: 23:27 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void save(ParkSf parkSf);
    /**
      *@method: 添加综合信息
      *@author: lix
      *@desc： 
      *@Date: 23:28 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void save(ClXx clXx, ParkCl parkCl, ParkSf parkSf);
    /**
      *@method: 获取所有车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:28 2018/5/2
      *@param: 
      *@return:   
      *
      */
    List<ClXx> findAllCl(ClXx clXx);
    /**
      *@method: 分页查询车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:34 2018/5/2
      *@param: 
      *@return:   
      *
      */
    Page findAllClxx(Page page, ClXx clXx);
    /**
      *@method: 获取所有停车场信息
      *@author: lix
      *@desc： 
      *@Date: 23:28 2018/5/2
      *@param: 
      *@return:   
      *
      */
    List<ParkXx> findAllPark(ParkXx parkXx);
    /**
      *@method: 分页查询停车场信息
      *@author: lix
      *@desc： 
      *@Date: 23:35 2018/5/2
      *@param: 
      *@return:   
      *
      */
    Page findAllParkxx(Page page, CwxxVO cwxxVO);
    /**
      *@method: 获取所有停车场收费下信息
      *@author: lix
      *@desc： 
      *@Date: 23:28 2018/5/2
      *@param: 
      *@return:   
      *
      */
    List<ParkSf> findAllParkSf(ParkSf parkSf);
    /**
      *@method: 分页查询停车收费信息
      *@author: lix
      *@desc： 
      *@Date: 23:35 2018/5/2
      *@param: 
      *@return:   
      *
      */
    Page findAllParkSf(Page page,ParkSf parkSf);
    /**
      *@method: 获取所有停车场关联信息
      *@author: lix
      *@desc： 
      *@Date: 23:29 2018/5/2
      *@param: 
      *@return:   
      *
      */
    List<ParkCl> findAllParkCl(ParkCl parkCl);
    /**
      *@method: 分页查询停车场-车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:36 2018/5/2
      *@param: 
      *@return:   
      *
      */
    Page findAllParkCl(Page page, ParkCl parkCl);
    /**
      *@method: 获取所有综合信息
      *@author: lix
      *@desc： 
      *@Date: 23:29 2018/5/2
      *@param: 
      *@return:   
      *
      */
    List<Map<String,Object>> findAllInfo(ClXx clXx,ParkXx parkXx, ParkSf parkSf,ParkCl parkCl);
    /**
      *@method: 修改车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:29 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void update(ClXx clXx);
    /**
      *@method: 修改停车场信息
      *@author: lix
      *@desc： 
      *@Date: 23:30 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void update(ParkXx parkXx);
    /**
      *@method: 修改停车场=-车辆映射关系
      *@author: lix
      *@desc： 
      *@Date: 23:30 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void update(ParkCl  parkCl);
    /**
      *@method: 修改所有停车场--收费信息
      *@author: lix
      *@desc： 
      *@Date: 23:30 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void update(ParkSf parkSf);
    /**
      *@method: 修改综合信息
      *@author: lix
      *@desc： 
      *@Date: 23:30 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void update(ClXx clXx,ParkSf parkSf,ParkCl parkCl);
    /**
      *@method: 删除车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:31 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void delete(ClXx clXx);
    /**
      *@method: 删除停车场信息
      *@author: lix
      *@desc： 
      *@Date: 23:31 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void delete(ParkXx parkXx);
    /**
      *@method: 删除停车张-车辆信息
      *@author: lix
      *@desc： 
      *@Date: 23:31 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void delete(ParkCl  parkCl);
    /**
      *@method: 删除停车场-收费信息
      *@author: lix
      *@desc： 
      *@Date: 23:31 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void delete(ParkSf parkSf);
    /**
      *@method: 删除综合信息
      *@author: lix
      *@desc： 
      *@Date: 23:32 2018/5/2
      *@param: 
      *@return:   
      *
      */
    void delete(ClXx clXx,ParkSf parkSf,ParkCl parkCl);


    /**
      *@method: 根据id查询
      *@author: lix
      *@desc： 
      *@Date: 21:19 2018/6/5
      *@param: 
      *@return:   
      *
      */
    ClXx findClxxById(String skey);

    /**
      *@method: 根据id获取信息
      *@author: lix
      *@desc： 
      *@Date: 21:20 2018/6/5
      *@param: 
      *@return:   
      *
      */
    ParkXx findParkById(String skey);

    /**
      *@method: 根据id获取信息
      *@author: lix
      *@desc： 
      *@Date: 21:20 2018/6/5
      *@param: 
      *@return:   
      *
      */
    ParkSf findParkSfById(String skey);

    /**
      *@method: 获取信息
      *@author: lix
      *@desc： 
      *@Date: 21:20 2018/6/5
      *@param: 
      *@return:   
      *
      */
    ParkCl findParkClById(String skey);
}
