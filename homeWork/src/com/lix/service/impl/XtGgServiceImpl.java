package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtGgDao;
import com.lix.entity.XtGg;
import com.lix.entity.Xt_yh;
import com.lix.service.XtGgService;
import com.lix.service.XtYhService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:302018/9/27
 * @modify by :
 */
@Service("xtGgService")
public class XtGgServiceImpl implements XtGgService {


    @Resource
    private XtGgDao xtGgDao;

    @Resource
    private XtYhService xtYhService;


    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveOrUpdate(XtGg xtGg, Xt_yh xt_yh, HttpServletRequest request) throws Exception {

        if(xtGg.getSkey() == null){
            if(xtGg.getGgnr() == null){
                throw  new Exception("公告内容不能为空");
            }

            xtGg.setSkey(UuidUtils.get32UUID());
            xtGg.setFbsj(DateFormatUtils.format(new Date() , "yyyy-MM-dd HH:mm:ss"));
            xtGg.setFbyh(xt_yh.getId());
            xtGg.setFlag(Constants.XT_GG_CS); //初始状态

            try {
                xtGgDao.save(xtGg);
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD, Constants.OPERATE_SUCCESS, "", "添加公告", "saveOrUpdate,主键：" + xtGg.getSkey(), request);
            }catch (Exception e){
                e.printStackTrace();
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD, Constants.OPERATE_FAIL, "", "添加公告", "saveOrUpdate,主键：" + xtGg.getSkey(), request);

            }

        }else {

            XtGg xtGg1 = xtGgDao.findById(xtGg);
            if(xtGg1 == null){
                throw  new Exception("未获取到相关公告信息");
            }else {
                BeanUtils.copyPropertityIgnoreNull(xtGg , xtGg1);

                try {
                    xtGgDao.update(xtGg1);
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE, Constants.OPERATE_SUCCESS, "", "修改公告", "saveOrUpdate,主键：" + xtGg1.getSkey(), request);

                }catch (Exception e){
                    e.printStackTrace();
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE, Constants.OPERATE_FAIL, "", "修改公告", "saveOrUpdate,主键：" + xtGg1.getSkey(), request);

                }
            }

        }
    }

    @Override
    public void delete(XtGg xtGg, Xt_yh xt_yh, HttpServletRequest request) throws Exception {
      if(xtGg.getSkey() == null){
          throw  new Exception("公告主键不能为空");
      }else {
          XtGg xtGg1 = xtGgDao.findById(xtGg);
          if(xtGg1 == null){
              throw new Exception("获取公告信息失败");
          }else {
              try {
                  xtGgDao.delete(xtGg1);
                  operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE, Constants.OPERATE_SUCCESS, "", "删除公告", "delete,主键：" + xtGg.getSkey(), request);

              }catch (Exception e){
                  e.printStackTrace();
                  operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE, Constants.OPERATE_FAIL, "", "删除公告", "delete,主键：" + xtGg.getSkey(), request);

              }
          }
      }
    }

    @Override
    public List<XtGg> findAllXtGg(XtGg xtGg) {

        return xtGgDao.findAllXtGg(xtGg);
    }

    @Override
    public Page findXtGgWithPage(Page page, XtGg xtGg) {
        return xtGgDao.findWithPage(page,xtGg);
    }

    @Override
    public XtGg findById(String  skey) throws Exception {
        if(skey == null){
           throw new Exception("主键不能为空");
        }
        XtGg xtGg = new XtGg();
        xtGg.setSkey(skey);
        return xtGgDao.findById(xtGg);
    }

    @Override
    public boolean checkUserInfo(Xt_yh xt_yh, String token, HttpServletRequest request) throws Exception {
        boolean result = false;

        if(xt_yh == null){
            throw new Exception(" 操作用户获取失败 ");
        }
        if(StringUtils.isEmpty(token)){
            throw new Exception(" 用户口令获取失败 ");
        }
        Xt_yh xt_yh2 = new Xt_yh();
        xt_yh2.setPassword(token);
        xt_yh2.setId(xt_yh.getId());

        Xt_yh xt_yh1 = xtYhService.findXtYhByPara(xt_yh2);
        if(xt_yh1 == null){
            throw  new Exception(" 用户身份获取失败 ");
        }else {
            if(xt_yh.equals(xt_yh1)){
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean SpGgxx(String skey, Xt_yh xt_yh, HttpServletRequest request) throws Exception {
        boolean result = false;

        XtGg xtGg1 = new XtGg();
        if(skey == null){
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE, Constants.OPERATE_FAIL, "", "发布公告", "SpGgxx,主键：" + skey, request);
            throw new Exception(" 待发布公告为空 ");

        }else {
            if(xt_yh != null){

                xtGg1.setSkey(skey);
                XtGg xtGg = xtGgDao.findById(xtGg1);
                if(xtGg != null){
                    BeanUtils.copyPropertityIgnoreNull(xtGg , xtGg1);
                    xtGg1.setFlag(Constants.XT_GG_FB); //公告发布
                    xtGgDao.update(xtGg1);

                    result = true;
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE, Constants.OPERATE_SUCCESS, "", "发布公告", "SpGgxx,主键：" + xtGg.getSkey(), request);

                }else {
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE, Constants.OPERATE_FAIL, "", "发布公告", "SpGgxx,主键：" + xtGg.getSkey(), request);

                    throw new Exception(" 公告发布失败 ");
                }

            }else {
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE, Constants.OPERATE_FAIL, "", "发布公告", "SpGgxx,主键：" + skey, request);
                throw new Exception(" 操作用户获取失败 ");
            }
        }
        return result;
    }

    @Override
    public List<XtGg> findLimitXtGgxx(XtGg xtGg, int size) throws Exception {
        List<Object> args = new ArrayList<Object>();

        if(size == 0 || size < 0){
            throw new Exception(" 获取长度不能小于等于0 ");
        }
     return xtGgDao.fingLimitXtggxx(xtGg,size);
    }
}
