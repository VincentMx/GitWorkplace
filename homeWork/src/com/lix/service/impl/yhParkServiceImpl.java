package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.YhParkDao;
import com.lix.entity.*;
import com.lix.entity.vo.CwxxVO;
import com.lix.service.YhParkService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 20:302018/5/3
 * @modify by :
 */
@Component("yhParkService")
public class yhParkServiceImpl implements YhParkService {


    @Resource
    private YhParkDao yhParkDao;


    @Resource
    private JdbcTemplate jdbcTemplate;



    @Override
    public void save(ClXx clXx) {
          if(clXx.getClCph() != null && !"".equals(clXx.getClCph())){
              clXx.setSkey(UuidUtils.get32UUID());
              yhParkDao.save(clXx);
          }
    }

    @Override
    public void save(ParkXx parkXx) {
        if(parkXx != null){
            parkXx.setSkey(UuidUtils.get32UUID());
            yhParkDao.save(parkXx);
        }

    }

    @Override
    public void save(ParkCl parkCl) {

        if(parkCl != null){
            parkCl.setSkey(UuidUtils.get32UUID());
            yhParkDao.save(parkCl);
        }

    }

    @Override
    public void save(ParkSf parkSf) {
        if(parkSf != null){
            parkSf.setSkey(UuidUtils.get32UUID());
            yhParkDao.save(parkSf);
        }
    }

    @Override
    public void save(ClXx clXx, ParkCl parkCl, ParkSf parkSf) {

    }

    @Override
    public List<ClXx> findAllCl(ClXx clXx) {
        return yhParkDao.findAllCl(clXx);
    }

    @Override
    public Page findAllClxx(Page page, ClXx clXx) {
        return yhParkDao.findAllClxx(page,clXx);
    }

    @Override
    public List<ParkXx> findAllPark(ParkXx parkXx) {
        return yhParkDao.findAllPark(parkXx);
    }

    @Override
    public Page findAllParkxx(Page page, CwxxVO cwxxVO) {

        return yhParkDao.findAllParkxx(page,cwxxVO);
    }

    @Override
    public List<ParkSf> findAllParkSf(ParkSf parkSf) {
        return yhParkDao.findAllParkSf(parkSf);
    }

    @Override
    public Page findAllParkSf(Page page, ParkSf parkSf) {
        return yhParkDao.findAllParkSf(page , parkSf);
    }

    @Override
    public List<ParkCl> findAllParkCl(ParkCl parkCl) {
        return yhParkDao.findAllParkCl(parkCl);
    }

    @Override
    public Page findAllParkCl(Page page, ParkCl parkCl) {
        return yhParkDao.findAllParkCl(page , parkCl);
    }

    @Override
    public List<Map<String, Object>> findAllInfo(ClXx clXx, ParkXx parkXx, ParkSf parkSf, ParkCl parkCl) {
        return null;
    }

    @Override
    public void update(ClXx clXx) {
        if(clXx.getSkey() != null && !"".equals(clXx.getSkey())){
            ClXx clXx1 = yhParkDao.findClxxById(clXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(clXx,clXx1);
            yhParkDao.update(clXx1);
        }
    }

    @Override
    public void update(ParkXx parkXx) {
        if(parkXx.getSkey() != null && !"".equals(parkXx.getSkey())){
            ParkXx parkXx1 = yhParkDao.findParkById(parkXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkXx,parkXx1);
            yhParkDao.update(parkXx1);
        }
    }

    @Override
    public void update(ParkCl parkCl) {
        if(parkCl.getSkey() != null && !"".equals(parkCl.getSkey())){
            ParkCl parkCl1 = yhParkDao.findParkClById(parkCl.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkCl,parkCl1);
            yhParkDao.update(parkCl1);
        }
    }

    @Override
    public void update(ParkSf parkSf) {
        if(parkSf.getSkey() != null && !"".equals(parkSf.getSkey())){
            ParkSf parkSf1 = yhParkDao.findParkSfById(parkSf.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkSf,parkSf1);
            yhParkDao.update(parkSf1);
        }
    }

    @Override
    public void update(ClXx clXx, ParkSf parkSf, ParkCl parkCl) {

    }

    @Override
    public void delete(ClXx clXx) {
        if(clXx.getSkey() != null && !"".equals(clXx.getSkey())){
            ClXx clXx1 = yhParkDao.findClxxById(clXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(clXx,clXx1);
            yhParkDao.delete(clXx1);
        }
    }

    @Override
    public void delete(ParkXx parkXx) {
        if(parkXx.getSkey() != null && !"".equals(parkXx.getSkey())){
            ParkXx parkXx1 = yhParkDao.findParkById(parkXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkXx,parkXx1);
            yhParkDao.delete(parkXx1);
        }
    }

    @Override
    public void delete(ParkCl parkCl) {
        if(parkCl.getSkey() != null && !"".equals(parkCl.getSkey())){
            ParkCl parkCl1 = yhParkDao.findParkClById(parkCl.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkCl,parkCl1);
            yhParkDao.delete(parkCl1);
        }
    }

    @Override
    public void delete(ParkSf parkSf) {
        if(parkSf.getSkey() != null && !"".equals(parkSf.getSkey())){
            ParkSf parkSf1 = yhParkDao.findParkSfById(parkSf.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkSf,parkSf1);
            yhParkDao.delete(parkSf1);
        }
    }

    @Override
    public void delete(ClXx clXx, ParkSf parkSf, ParkCl parkCl) {

    }

    @Override
    public CwxxVO findCwByParam(CwxxVO cwxxVO) {
        CwxxVO cwxxVO1 = new CwxxVO();
        if(cwxxVO != null) {
          ParkXx parkXx = yhParkDao.findParkById(cwxxVO.getSkey());
          BeanUtils.copyPropertityIgnoreNull(parkXx , cwxxVO1);
        }
        return cwxxVO1;
    }

    @Override
    public ParkCl findpARKcLByParam(ParkCl parkCl) {
        ParkCl parkCl1 = new ParkCl();
        if(parkCl != null){
            parkCl1 = yhParkDao.findParkClById(parkCl.getSkey());
        }
        return parkCl1;
    }

    @Override
    public ParkSf findParkSfByParam(ParkSf parkSf) {
        ParkSf parkSf1 = new ParkSf();
        if(parkSf != null){
            parkSf1 = yhParkDao.findParkSfById(parkSf.getSkey());
        }
        return parkSf1;
    }

    @Override
    public ClXx findClxxByParam(ClXx clXx) {
        ClXx  clXx1 = new ClXx();
        if(clXx != null){
            clXx1 = yhParkDao.findClxxById(clXx.getSkey());
        }
        return clXx1;
    }

    @Override
    public void saveOrUpdateParkCompany(ParkCompany parkCompany) throws Exception {
        if(StringUtils.isEmpty(parkCompany.getSkey())){
            if(parkCompany != null){
                parkCompany.setSkey(UuidUtils.get32UUID());
                yhParkDao.saveParkCompany(parkCompany);
            }else{
             throw new Exception(" 停车公司信息不能为空 ");
            }
        }else{
            ParkCompany parkCompany1  = yhParkDao.findParkCompanyById(parkCompany.getSkey());
           if(parkCompany1 == null){
               throw  new Exception(" 未获取到停车公司信息 ");
           }
            BeanUtils.copyPropertityIgnoreNull(parkCompany1 , parkCompany);
            yhParkDao.updateParkCompany(parkCompany);

        }
    }

    @Override
    public void spParkCompany(Xt_yh xt_yh, ParkCompanyDsp parkCompanyDsp, String spflag) {

    }

    @Override
    public Page findAllParkCompany(Page page, ParkCompany parkCompany) {
        return yhParkDao.getParkCompanyByPage(page , parkCompany);
    }

    @Override
    public Page findAllParkCompanyDsp(Page page, ParkCompanyDsp parkCompanyDsp) {
        return yhParkDao.getAllParkCompanyDsp(page , parkCompanyDsp);
    }

    @Override
    public void saveOrUpdateParkCompanyDsp(Xt_yh xt_yh, ParkCompanyDsp parkCompanyDsp , HttpServletRequest request) throws Exception {

        if(parkCompanyDsp.getSkey() != null || !"".equals(parkCompanyDsp.getSkey())){

            parkCompanyDsp.setSkey(UuidUtils.get32UUID());
            parkCompanyDsp.setFlag(Constants.parkCompany_CS);
            yhParkDao.add(parkCompanyDsp);
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","注册停车公司信息","saveOrUpdateParkCompanyDsp,主键："+parkCompanyDsp.getSkey(),request);

        }else{
            ParkCompanyDsp parkCompanyDsp1 = yhParkDao.findParkCompanyDspById(parkCompanyDsp.getSkey());
            if(parkCompanyDsp1 != null){
                BeanUtils.copyPropertityIgnoreNull(parkCompanyDsp1 , parkCompanyDsp);
                yhParkDao.update(parkCompanyDsp);
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改停车公司信息","saveOrUpdateParkCompanyDsp,主键："+parkCompanyDsp.getSkey(),request);

            }
        }
    }

    @Override
    public ParkCompanyDsp findParkCompanyDspBySkey(String skey) throws Exception {
        ParkCompanyDsp parkCompanyDsp = new ParkCompanyDsp();
        if(skey != null && !"".equals(skey) ){
               parkCompanyDsp = yhParkDao.findParkCompanyDspById(skey);
          }else{
              throw  new Exception("主键不能为空");
          }
        return parkCompanyDsp;
    }

    @Override
    public void deleteParkCompanyDsp(String skey ,HttpServletRequest request ,Xt_yh xt_yh) throws Exception {
        if(skey != null && !"".equals(skey) ){
         ParkCompanyDsp   parkCompanyDsp = yhParkDao.findParkCompanyDspById(skey);
             if(parkCompanyDsp != null){
                 yhParkDao.delete(parkCompanyDsp);
                 operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除停车公司信息","deleteParkCompanyDsp,主键："+parkCompanyDsp.getSkey(),request);
             }else{
                 throw new Exception("未获取到相关公司信息");
             }

        }else{
            throw  new Exception("主键不能为空");
        }
    }

    @Override
    public void deleteParkCompany(String skey, HttpServletRequest request, Xt_yh xt_yh) throws Exception {
        if(skey != null && !"".equals(skey) ){
            ParkCompany   parkCompany = yhParkDao.findParkCompanyById(skey);
            if(parkCompany != null){
                yhParkDao.deleteParkCompany(parkCompany);
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除停车公司信息","deleteParkCompany,主键："+parkCompany.getSkey(),request);
            }else{
                throw new Exception("未获取到相关公司信息");
            }

        }else{
            throw  new Exception("主键不能为空");
        }

    }

    @Override
    public List<ParkCompany> findAllParkCompany(ParkCompany parkCompany) {
        return yhParkDao.getAllParkCompany(parkCompany);
    }

    @Override
    public List<ParkCompanyDsp> findAllParkCompanyDsp(ParkCompanyDsp parkCompanyDsp) {
        return yhParkDao.getAllParkCompanyDsp(parkCompanyDsp);
    }

    @Override
    public ParkCompany findParkCompanyById(ParkCompany parkCompany) {
        Assert.hasText(parkCompany.getSkey() , "车位公司主键不能为空");
        ParkCompany parkCompany1 = new ParkCompany();
        parkCompany1 = yhParkDao.findParkCompanyById(parkCompany.getSkey());
        return parkCompany1;
    }

    @Override
    public void save(ParkCompanyGl parkCompanyGl, Xt_yh xt_yh) {
        yhParkDao.save(parkCompanyGl);
    }

    @Override
    public void delete(ParkCompanyGl parkCompanyGl, Xt_yh xt_yh) {

        yhParkDao.delete(parkCompanyGl);
    }

    @Override
    public void update(ParkCompanyGl parkCompanyGl, Xt_yh xt_yh) {

        yhParkDao.update(parkCompanyGl);
    }

    @Override
    public List<ParkCompanyGl> findAllParkGlByParam(ParkCompanyGl parkCompanyGl, ParkCompany parkCompany, ParkXx parkXx) {
        List<ParkCompanyGl> list = new ArrayList<ParkCompanyGl>();
        if(parkCompanyGl != null){
          list =   yhParkDao.findByParam(parkCompanyGl);
        }else{
            return null;
        }
        return list;
    }

    @Override
    public void save(String pcskey, ParkXx parkXx, Xt_yh xt_yh, HttpServletRequest request) throws Exception {
        ParkCompanyGl parkCompanyGl = new ParkCompanyGl();
        ParkCompany parkCompany = new ParkCompany();

        //判断公司主键
        if(pcskey == null || "".equals(pcskey) || "undefined".equals(pcskey) ){
            throw new Exception("公司主键不能为空");
        }
        //车位信息不能为空
        if(parkXx == null){
            throw  new Exception("车位信息不能为空");
        }

        //验证公司信息
        parkCompany = yhParkDao.findParkCompanyById(pcskey);
        if(parkCompany == null){
            throw  new Exception("无公司信息");
        }else if(!Constants.parkCompany_SPTG.equals(parkCompany.getFlag())){
            throw new Exception("公司状态异常");
        }

        try {

        //保存车位信息
        parkXx.setSkey(UuidUtils.get32UUID());
        parkXx.setPaPcskey(parkCompany.getSkey());
        yhParkDao.save(parkXx);

        //添加关联信息
        parkCompanyGl.setPaskey(parkXx.getSkey());
        parkCompanyGl.setPcskey(parkCompany.getSkey());
        parkCompanyGl.setSkey(UuidUtils.get32UUID());
        parkCompanyGl.setFlag(Constants.park_Company_gl_YX);
        yhParkDao.save(parkCompanyGl);

        }catch (Exception e){
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_FAIL,e.getMessage(),"添加车位及公司关联信息","save,主键："+parkCompanyGl.getSkey(),request);
            e.printStackTrace();
        }

        operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加车位及公司关联信息","save,主键："+parkCompanyGl.getSkey(),request);

    }

    //接口调用
    @Override
    public List<ParkXx> findParkListByPcskey(ParkCompany parkCompany) {

        List<ParkXx> parkXxList = new ArrayList<ParkXx>();
        List<ParkCompanyGl> parkCompanyGlList = yhParkDao.findByParam(parkCompany);
        if(parkCompanyGlList != null){
            for (ParkCompanyGl parkCompanyGl : parkCompanyGlList ){
                 ParkXx parkXx = new ParkXx();
                 parkXx = yhParkDao.findParkById(parkCompanyGl.getPaskey());
                 parkXxList.add(parkXx);
            }

        }else {
           return  parkXxList;
        }


        return parkXxList;
    }
}
