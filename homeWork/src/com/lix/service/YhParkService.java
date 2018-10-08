package com.lix.service;

import com.lix.entity.*;
import com.lix.entity.vo.CwxxVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 20:292018/5/3
 * @modify by :
 */
public interface YhParkService {

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
    List<Map<String,Object>> findAllInfo(ClXx clXx, ParkXx parkXx, ParkSf parkSf, ParkCl parkCl);
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
      *@method: 根据参数获取停车位信息
      *@author: lix
      *@desc： 
      *@Date: 21:18 2018/6/7
      *@param: 
      *@return:   
      *
      */
    CwxxVO findCwByParam(CwxxVO cwxxVO);

    /**
      *@method: 获取停车位车辆关联信息
      *@author: lix
      *@desc： 
      *@Date: 21:19 2018/6/7
      *@param: 
      *@return:   
      *
      */
    ParkCl findpARKcLByParam(ParkCl parkCl);

    /**
      *@method: 收费信息
      *@author: lix
      *@desc： 
      *@Date: 21:19 2018/6/7
      *@param: 
      *@return:   
      *
      */
    ParkSf findParkSfByParam(ParkSf parkSf);

    
    /**
      *@method: 车辆信息
      *@author: lix
      *@desc： 
      *@Date: 21:24 2018/6/7
      *@param: 
      *@return:   
      *
      */
    ClXx  findClxxByParam(ClXx clXx);



    /**
      *@method: 添加公司
      *@author: lix
      *@desc： 
      *@Date: 18:51 2018/7/29
      *@param: 
      *@return:   
      *
      */
   void saveOrUpdateParkCompany(ParkCompany parkCompany) throws Exception;

   /**
     *@method: 审批停车公司
     *@author: lix
     *@desc： 
     *@Date: 18:52 2018/7/29
     *@param: 
     *@return:   
     *
     */
   void spParkCompany(Xt_yh xt_yh , ParkCompanyDsp parkCompanyDsp , String spflag );


   /**
     *@method: 分页查询停车公司
     *@author: lix
     *@desc： 
     *@Date: 18:33 2018/8/7
     *@param: 
     *@return:   
     *
     */
    Page findAllParkCompany(Page page, ParkCompany parkCompany);


    /**
      *@method: 分页查询待审批停车公司信息
      *@author: lix
      *@desc： 
      *@Date: 18:56 2018/8/7
      *@param: 
      *@return:   
      *
      */
    Page findAllParkCompanyDsp(Page page, ParkCompanyDsp parkCompanyDsp);

    /**
      *@method: 添加或者修改停车公司信息
      *@author: lix
      *@desc： 
      *@Date: 18:56 2018/8/7
      *@param: 
      *@return:   
      *
      */
    void saveOrUpdateParkCompanyDsp(Xt_yh xt_yh , ParkCompanyDsp parkCompanyDsp , HttpServletRequest request) throws Exception;
    /**
      *@method: 根据主键查询
      *@author: lix
      *@desc： 
      *@Date: 18:56 2018/8/7
      *@param: 
      *@return:   
      *
      */
    ParkCompanyDsp findParkCompanyDspBySkey(String skey) throws Exception;
    
    /**
      *@method: 删除待审批信息
      *@author: lix
      *@desc： 
      *@Date: 18:57 2018/8/7
      *@param: 
      *@return:   
      *
      */
    void deleteParkCompanyDsp(String skey , HttpServletRequest request ,Xt_yh xt_yh) throws Exception;


    /**
     *@method: 删除车位公司信息
     *@author: lix
     *@desc：
     *@Date: 18:57 2018/8/7
     *@param:
     *@return:
     *
     */
    void deleteParkCompany(String skey , HttpServletRequest request ,Xt_yh xt_yh) throws Exception;

    /**
      *@method: 查询所有停车公司
      *@author: lix
      *@desc： 
      *@Date: 19:05 2018/8/7
      *@param: 
      *@return:   
      *
      */
    List<ParkCompany> findAllParkCompany(ParkCompany parkCompany);
    
    /**
      *@method: 查询所有待审批停车公司
      *@author: lix
      *@desc： 
      *@Date: 19:09 2018/8/7
      *@param: 
      *@return:   
      *
      */
    List<ParkCompanyDsp> findAllParkCompanyDsp(ParkCompanyDsp parkCompanyDsp);


    /**
      *@method: 根据主键查找车位公司
      *@author: lix
      *@desc： 
      *@Date: 8:45 2018/8/23
      *@param: 
      *@return:   
      *
      */
    ParkCompany findParkCompanyById(ParkCompany  parkCompany);
    
    
    /**
      *@method: 添加关联信息
      *@author: lix
      *@desc： 
      *@Date: 17:16 2018/8/24
      *@param: 
      *@return:   
      *
      */
    void save(ParkCompanyGl parkCompanyGl , Xt_yh xt_yh);
    
    /**
      *@method: 删除关联信息
      *@author: lix
      *@desc： 
      *@Date: 17:16 2018/8/24
      *@param: 
      *@return:   
      *
      */
    void delete(ParkCompanyGl parkCompanyGl , Xt_yh xt_yh);
    
    /**
      *@method: 修改关联信息
      *@author: lix
      *@desc： 
      *@Date: 17:16 2018/8/24
      *@param: 
      *@return:   
      *
      */
    void update(ParkCompanyGl parkCompanyGl , Xt_yh xt_yh);
    
    /**
      *@method: 查询关联关系
      *@author: lix
      *@desc： 
      *@Date: 17:17 2018/8/24
      *@param: 
      *@return:   
      *
      */
    List<ParkCompanyGl> findAllParkGlByParam(ParkCompanyGl parkCompanyGl , ParkCompany parkCompany ,ParkXx parkXx);

    /**
      *@method: 根据公司添加车位信息
      *@author: lix
      *@desc：
      *@Date: 17:21 2018/8/24
      *@param:
      *@return:
      *
      */
    void save(String pcskey , ParkXx parkXx , Xt_yh xt_yh , HttpServletRequest request) throws Exception;

    
    /**
      *@method: 获取停车公司车位
      *@author: lix
      *@desc： 
      *@Date: 15:42 2018/8/25
      *@param: 
      *@return:   
      *
      */
    List<ParkXx> findParkListByPcskey(ParkCompany parkCompany);
    
}
