package com.lix.manager;

import cn.lix.constants.Constants;
import cn.lix.constants.SystemErrorCode;
import cn.lix.controller.base.BaseController;
import com.lix.entity.ParkCompany;
import com.lix.entity.ParkXx;
import com.lix.service.XtYhDspService;
import com.lix.service.XtYhService;
import com.lix.service.YhParkService;
import com.lix.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc : 停车类接口
 * @time : 18:372018/7/16
 * @modify by :
 */
@Component
public class ParkManager extends BaseController {


    private static Logger logger = Logger.getLogger(ParkManager.class);


    @Autowired
    private XtYhDspService xtYhDspService;


    @Autowired
    private XtYhService xtYhService;


    @Autowired
    private YhParkService parkService;


    //分页获取车位列表
    public Map<String , Object> getParkList(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }

    //获取车位详情
    public Map<String , Object> getParkDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车价格计划
    public Map<String , Object> getParkPriceDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取可用停车位数量
    public Map<String , Object> getParkNum(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //生成停车位预定订单
    public Map<String , Object> getParkOrder(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车位图片列表
    public Map<String , Object> getParkPicture(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车订单列表
    public Map<String , Object> getParkOrderList(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车订单详情
    public Map<String , Object> getParkOrderDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //取消订单
    public Map<String , Object> getParkRefundOrder(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取取消订单列表
    public Map<String , Object> getParkRefoundOrderList(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取取消订单详情
    public Map<String , Object> getParkRefoundOrderDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }

    //添加停车公司信息
    public Map<String , Object> addParkCompany(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }

    /**
      *@method: 修改停车公司信息
      *@author: lix
      *@desc： 
      *@Date: 19:16 2018/7/29
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> updateParkCompany(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }

    /**
      *@method: 查询停车公司信息
      *@author: lix
      *@desc： 
      *@Date: 8:51 2018/8/23
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> getParkCompanyInfo(Map<String,Object> bodyMap){
        logger.info("********************************* 获取停车公司信息  START**********************");

        Map<String , Object> retMap = new HashMap<String, Object>();
        ParkCompany parkCompany = new ParkCompany();
        List<ParkXx> parkXxList = new ArrayList<ParkXx>();
        parkCompany.setSkey(bodyMap.get("pcskey").toString());
        try{
            ParkCompany parkCompany1 = parkService.findParkCompanyById(parkCompany);
            if (parkCompany1 != null){

                parkXxList = parkService.findParkListByPcskey(parkCompany1);
                if(parkXxList != null){
                    retMap.put("parkCompany",parkCompany1);
                    retMap.put("parkxxList",parkXxList);
                    retMap.put(SystemErrorCode.retcode, Constants.success);
                    retMap.put(SystemErrorCode.retshow, Constants.success_msg);
                }else{
                    logger.info("*********************************未获取到该停车公司车位信息**********************");
                    retMap.put("parkCompany",parkCompany1);
                    retMap.put("parkxxList",parkXxList);
                    retMap.put(SystemErrorCode.retcode, Constants.success);
                    retMap.put(SystemErrorCode.retshow, Constants.success_msg);
                }
            }else {
                logger.info("*********************************获取停车公司失败**********************");

                retMap.put(SystemErrorCode.retcode, Constants.error);
                retMap.put(SystemErrorCode.retshow, "未查询到停车公司");
            }
        }catch (Exception e){
            logger.error("查询停车公司详细信息异常 ： " + e.getMessage());
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, e.getMessage());
        }
        logger.info("*********************************获取停车公司信息  END**********************");


        return retMap;
    }

    /**
      *@method: 获取停车公司车位列表信息
      *@author: lix
      *@desc： 
      *@Date: 12:32 2018/8/25
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> getParkCompanyCwList(Map<String,Object> bodyMap){
        logger.info("********************************* 获取停车公司信息  START**********************");

        Map<String , Object> retMap = new HashMap<String, Object>();
        ParkCompany parkCompany = new ParkCompany();
        List<ParkXx> parkXxList = new ArrayList<ParkXx>();
        parkCompany.setSkey(bodyMap.get("pcskey").toString());
        try{
            ParkCompany parkCompany1 = parkService.findParkCompanyById(parkCompany);
            if (parkCompany1 != null){

                parkXxList = parkService.findParkListByPcskey(parkCompany1);
                if(parkXxList != null){
                    retMap.put("parkxxList",parkXxList);
                    retMap.put(SystemErrorCode.retcode, Constants.success);
                    retMap.put(SystemErrorCode.retshow, Constants.success_msg);
                }else{
                    logger.info("*********************************未获取到该停车公司车位信息**********************");

                    retMap.put(SystemErrorCode.retcode, Constants.error);
                    retMap.put(SystemErrorCode.retshow, "未查询到停车公司车位信息");
                }

            }else {
                logger.info("*********************************获取停车公司失败**********************");

                retMap.put(SystemErrorCode.retcode, Constants.error);
                retMap.put(SystemErrorCode.retshow, "未查询到停车公司");
            }
        }catch (Exception e){
            logger.error("查询停车公司车位详细信息异常 ： " + e.getMessage());
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, e.getMessage());
        }
        logger.info("*********************************获取停车公司信息  END**********************");


        return retMap;
    }



    //获取停车公司列表信息
    public Map<String , Object> getParkCompanyList(Map<String,Object> bodyMap){
        logger.info("*********************************获取停车公司列表  START**********************");

        Map<String , Object> retMap = new HashMap<String, Object>();
        List<ParkCompany> parkCompanyList = new ArrayList<ParkCompany>();
        ParkCompany parkCompany = new ParkCompany();
        parkCompany.setPcName((String)bodyMap.get("pcname"));

        try{
            parkCompanyList = parkService.findAllParkCompany(parkCompany);
            if (parkCompanyList != null){

                retMap.put("parkCompanyList",parkCompanyList);
                retMap.put(SystemErrorCode.retcode, Constants.success);
                retMap.put(SystemErrorCode.retshow, Constants.success_msg);
            }else {
                logger.info("*********************************获取停车公司列表失败**********************");

                retMap.put(SystemErrorCode.retcode, Constants.error);
                retMap.put(SystemErrorCode.retshow, "未查询到停车公司列表");
            }
        }catch (Exception e){
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, e.getMessage());
        }
        logger.info("*********************************获取停车公司列表  END**********************");


        return retMap;
    }


}
