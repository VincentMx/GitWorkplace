package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtYhDao;
import com.lix.entity.XtYhDsp;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.service.XtYhDspService;
import com.lix.service.XtYhService;
import com.lix.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 23:472017/11/29
 * @modify by :
 */
@Service("xtYhService")
public class XtYhServiceImpl implements XtYhService {

    @Resource
    private XtYhDao xtYhDao;

    @Resource
    private XtYhDspService xtYhDspService;


    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveYhInfo(Xt_yh xt_yh,HttpServletRequest request,Xt_yh xt_yh2) throws Exception {
        if (StringUtils.isEmpty(xt_yh.getSkey())){
            xt_yh.setSkey(UuidUtils.get32UUID());
            xt_yh.setFlag(Constants.XtYhYxzt_YX);
            xtYhDao.saveYhInfo(xt_yh);
            operateUtils.addUserOperateLog(xt_yh2.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加用户信息","saveYhInfo,主键："+xt_yh.getSkey(),request);
        }else {
            Xt_yh xt_yh1 = xtYhDao.findYhInfoById(xt_yh.getSkey());
            BeanUtils.copyPropertityIgnoreNull(xt_yh,xt_yh1);
            xtYhDao.updateXtYhInfo(xt_yh1);
            operateUtils.addUserOperateLog(xt_yh2.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改用户信息","saveYhInfo,主键："+xt_yh.getSkey(),request);
        }
    }

    @Override
    public List<Xt_yh> findAllXtYh(Xt_yh xt_yh) {
        return xtYhDao.findAllXtYh(xt_yh);
    }

    @Override
    public void updateXtYhInfo(Xt_yh xt_yh) {
        Xt_yh xt_yh1 = xtYhDao.findYhInfoById(xt_yh.getSkey());
        BeanUtils.copyPropertityIgnoreNull(xt_yh,xt_yh1);
        xtYhDao.updateXtYhInfo(xt_yh1);
    }

    @Override
    public Xt_yh findYhInfoById(String skey) {
        return xtYhDao.findYhInfoById(skey);
    }

    @Override
    public Xt_yh findXtYhByPara(Xt_yh xt_yh) {
        if (xt_yh == null){
            return  null;
        }else {
            return xtYhDao.findXtYhByPara(xt_yh);
        }
    }

    @Override
    public void deleteXtYh(String skey,HttpServletRequest request,Xt_yh xt_yh1) throws Exception {
        if(!StringUtils.isEmpty(skey)){
            Xt_yh xt_yh = xtYhDao.findYhInfoById(skey);
            if(xt_yh != null){
                xtYhDao.deleteXtYh(xt_yh);
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除用户信息","deleteXtYh,主键："+xt_yh.getSkey(),request);
            }else{
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_FAIL,"","删除用户信息","deleteXtYh,主键："+xt_yh.getSkey(),request);
                throw new Exception("未找到该条记录");
            }
        }else{
            throw new Exception(" skey 不能为空  ");
        }
    }

    @Override
    public Page getAllXtYh(Page page, XtYhVO xtYhVO, HttpServletRequest request) {
        return xtYhDao.getAllXtYh(page,xtYhVO);
    }

    @Override
    public void removeXtYh(String skey, HttpServletRequest request,Xt_yh xt_yh1) throws Exception {
        if(!StringUtils.isEmpty(skey)){
            Xt_yh xt_yh = xtYhDao.findYhInfoById(skey);
            if(xt_yh != null){
                 xt_yh.setFlag(Constants.XtYh_ZX);
                 xtYhDao.updateXtYhInfo(xt_yh);
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","注销用户信息","removeXtYh,主键："+xt_yh.getSkey(),request);
            }else{
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_FAIL,"","注销用户信息","removeXtYh,主键："+xt_yh.getSkey(),request);
                throw new Exception("未找到该条记录");
            }
        }else{
            throw new Exception(" skey 不能为空  ");
        }
    }

    @Override
    public String getXtYhCount(Xt_yh xt_yh) {
        String sql = "SELECT  count(0) FROM xt_yh t WHERE  t.flag = '1'";
        Map<String,Object> numbers = jdbcTemplate.queryForMap(sql);
        return numbers.get("count(0)").toString();
    }

    @Override
    public String getXtYhDlCount(Xt_yh xt_yh) {
        String sql = "SELECT  count(0) FROM xt_rz_dl t WHERE  t.yxzt = '1' and t.unit_key like '" + SysUnitUtil.getRightDome(xt_yh.getUnit()) + "%'";
        Map<String,Object> numbers = jdbcTemplate.queryForMap(sql);
        return numbers.get("count(0)").toString();
    }

    @Override
    public String getXtYhCzCount(Xt_yh xt_yh) {
        String sql = "SELECT  count(0) FROM xt_rz_cz t WHERE  t.yxzt = '1' and t.unit_key like '" + SysUnitUtil.getRightDome(xt_yh.getUnit()) + "%'";
        Map<String,Object> numbers = jdbcTemplate.queryForMap(sql);
        return numbers.get("count(0)").toString();
    }

    @Override
    public String getYhSelfDlCount(Xt_yh xt_yh) {
        String sql = "SELECT  count(0) FROM xt_rz_dl t WHERE  t.yxzt = '1' and t.user_id = '" + xt_yh.getId() + "' and t.unit_key like '" + SysUnitUtil.getRightDome(xt_yh.getUnit()) + "%'";
        Map<String,Object> numbers = jdbcTemplate.queryForMap(sql);
        return numbers.get("count(0)").toString();
    }

    @Override
    public void SpYhInfo(String Skey, String flag, String bz , HttpServletRequest request , Xt_yh xt_yh) throws Exception {
        if(Skey != null && !"".equals(Skey) && !StringUtils.isEmpty(Skey) && !StringUtils.isEmpty(flag)){
            XtYhDsp xtYhDsp = xtYhDspService.getXtYhDspInfoById(Skey);
            Xt_yh xtYh = new Xt_yh();
            if(xtYhDsp != null){
                if(Constants.XtYhDsp_SPTG.equals(flag)){
                    BeanUtils.copyPropertityIgnoreNull(xtYhDsp,xtYh);
                    xtYh.setFlag(Constants.XtYh_YX);
                    xtYh.setBz(bz);
                    xtYhDao.saveYhInfo(xtYh);
                    //当把用户审核通过之后、则保存进系统用户表中、接着删除待审批表中的数据
                    xtYhDspService.deleteXtYhDspInfoById(Skey,xtYh.getId(),request);
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","审批用户信息","SpYhInfo,主键："+xtYh.getSkey(),request);

                }else if (Constants.XtYhDsp_SPWTG.equals(flag)){
                     xtYhDsp.setFlag(flag);
                     xtYhDsp.setSkey(Skey);
                     xtYhDspService.addXtYhDspInfo(xtYhDsp , request , xt_yh);
                     operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","审批用户信息","SpYhInfo,主键："+xtYhDsp.getSkey(),request);

                }


            }
        }
    }

    @Override
    public List<Map<String, Object>> getAllXtYh(String skey, String id) throws Exception {
        List<Map<String , Object>> xtyhList = new ArrayList<Map<String, Object>>();
        Xt_yh xt_yh = findYhInfoById(skey);
        if(xt_yh != null){
            //当用户信息不为空时、判断用户所传id是否匹配
            if(id.equals(xt_yh.getId())){
            //当用户id匹配时、开始判断用户所在单位
                StringBuffer sql = new StringBuffer(" select t.skey, t.id , t.name , t.sex, t.unit , t.phone  ,t.address , t.email , t.flag , t.bz , t.lastitime , t.lastip ,t. mobile, t.regtime  ");
                sql.append(" from xt_yh t  ");
                sql.append(" where 1 = 1  ");
                sql.append(" and t.unit like '" + SysUnitUtil.getRightDome(xt_yh.getUnit()) + "%'  ");
                sql.append(" and t.flag = '1'  ");
                sql.append("  order by t.regtime desc; ");

                xtyhList = jdbcTemplate.queryForList(sql.toString());


                 if(xtyhList == null){
                     xtyhList.add(new HashMap<>());
                 }
            }else{
            throw new Exception("用户信息匹配失败！");
            }
        }else{
            throw new Exception("未获取到用户信息");
        }
        return xtyhList;
    }

    @Override
    public Xt_yh fingById(String id, String unit) {
        return xtYhDao.findById(id , unit);
    }
}
