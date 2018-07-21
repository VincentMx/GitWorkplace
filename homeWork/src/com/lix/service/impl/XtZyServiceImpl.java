package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtZyDao;
import com.lix.entity.XtZy;
import com.lix.entity.vo.XtZyVO;
import com.lix.service.XtZyService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 14:312017/11/27
 * @modify by :
 */
@Service("xtZyService")
public class XtZyServiceImpl implements XtZyService {

    @Resource
    private XtZyDao xtZyDao;

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveXtZy(XtZy xt_zy, HttpServletRequest request,String sfzh) throws Exception {
        if (StringUtils.isEmpty(xt_zy.getSkey())){
             xt_zy.setSkey(UuidUtils.get32UUID());
            xtZyDao.saveXtZy(xt_zy);
            operateUtils.addUserOperateLog(sfzh, Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加资源","saveXtZy,主键："+xt_zy.getSkey(),request);

        }else {
            try {
                XtZy xt_zy1 = findById(xt_zy);
                BeanUtils.copyPropertityIgnoreNull(xt_zy,xt_zy1);
                xtZyDao.updateXtZy(xt_zy1);
                operateUtils.addUserOperateLog(sfzh, Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改资源","updateXtZy,主键："+xt_zy.getSkey(),request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<XtZy> findAllXtZy(XtZy xt_zy) {
        return xtZyDao.findAllXtZy(xt_zy);
    }

    @Override
    public void updateXtZy(XtZy xt_zy) {
        XtZy xt_zy1 = null;
        try {
            xt_zy1 = findById(xt_zy);
            BeanUtils.copyPropertityIgnoreNull(xt_zy,xt_zy1);
            xtZyDao.updateXtZy(xt_zy1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public XtZy findById(XtZy xt_zy)throws Exception {
        if (StringUtils.isEmpty(xt_zy.getSkey())){
           throw new Exception("skey is not allow null");
        }
        return xtZyDao.findById(xt_zy);
    }

    @Override
    public List<XtZy> findByUserKey(String userKey) {
        return xtZyDao.findByUserKey(userKey);
    }

    @Override
    public void deleteXtZyInfo(String skey,HttpServletRequest request,String sfzh) {
        XtZy xtZy = new XtZy();
        xtZy.setSkey(skey);
        try {
            XtZy xtZy1 = findById(xtZy);
            if(xtZy1 != null){
                xtZyDao.deleteXtZyInfo(xtZy1);
                operateUtils.addUserOperateLog(sfzh, Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除资源","deleteXtZy,主键："+xtZy.getSkey(),request);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Page findXtZyByParam(Page page, XtZyVO xtZyVO) {
        return xtZyDao.findXtZyByParam(page,xtZyVO);
    }

    @Override
    public List<Map<String,Object>> getTree(String id) {
      JSONArray jsonArray2 = new JSONArray();
        String sql = "SELECT  a.skey,a.name,a.isparent,a.parentkey,a.url,b.skey as bskey,b.name as bname from xt_zy a left join xt_zy_cz b on a.skey = b.parentkey where 1 = 1 ";
        if(id == null || StringUtils.isEmpty(id)){
            sql += "  and a.isparent = '1' ";
        }else{
            sql += "  and a.parentkey = '" + id + "' ";
        }
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);


        return list;
    }

    @Override
    public List<XtZy> getXtZyList(String parentKey) {
        String sql = "from XtZy t  where t.parentkey = '" + parentKey +  "'";
        List<XtZy> list = xtZyDao.getXtZyList(sql);
        return list;
    }

    @Override
    public List<XtZy> getXtZyList(String parentKey, String unit) {
        String sql = "from XtZy t  where t.parentkey = '" + parentKey +  "'";
        List<XtZy> list = xtZyDao.getXtZyList(sql);
        return list;
    }
}
