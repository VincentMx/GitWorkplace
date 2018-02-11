package com.lix.util;

import cn.lix.constants.Constants;
import com.lix.entity.XtRzCz;
import com.lix.entity.Xt_yh;
import com.lix.service.XtRzCzService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static cn.lix.constants.Constants.XtRzCz_YX;

/**
 * @author : lix
 * @desc :
 * @time : 21:562017/12/19
 * @modify by :
 */
@Component
public class operateUtils  {

    private static final Logger log = Logger.getLogger(operateUtils.class.getName());

    private static XtRzCzService userXtRzCz;

    @Resource
    private XtRzCzService xtRzCzService;

    @PostConstruct
    public void init(){
        userXtRzCz = this.xtRzCzService;
    }

    /***
     * @desc: 用户添加日志操作
     * @date:2017-12-18
     * @param operate_type 操作类型
     * @param operate_result 操作结果
     * @param error_code 错误代码
     * @param operate_name 操作功能名称
     * @param operate_contidion 处登录之外，记录用户登陆数据
     * @param request
     */
    public static void addUserOperateLog(String sfzh,String operate_type, String operate_result, String error_code, String operate_name, String operate_contidion, HttpServletRequest request) throws Exception {
        //Xt_yh xt_yh = (Xt_yh) request.getSession().getAttribute("xtYh");
        Xt_yh xt_yh = new Xt_yh();
        try{
            xt_yh = (Xt_yh) Constants.xtYhInfo.get(sfzh);
            if(xt_yh == null || StringUtils.isEmpty(xt_yh.getId())){
               log.error("operateUtils[addUserOperateLog]：用户：【"+xt_yh.getId()+"】登陆信息不存在");
               throw  new Exception("operateUtils[addUserOperateLog]：用户：【"+xt_yh.getId()+"】登陆信息不存在");
           }
        }catch (Exception e){
            log.error("operateUtils[addUserOperateLog]：用户：【"+xt_yh.getId()+"】登陆失败");
            throw  new Exception("operateUtils[addUserOperateLog]：用户：【"+xt_yh.getId()+"】登陆失败");
        }

        XtRzCz xtRzCz = new XtRzCz();
        xtRzCz.setRegId(Constants.XTLX_BXT);
        xtRzCz.setUserId(xt_yh.getId());
        xtRzCz.setSkey(UuidUtils.get32UUID());
        xtRzCz.setYxzt(Constants.XtRzCz_YX);
        xtRzCz.setUserName(xt_yh.getName());
        xtRzCz.setUnitKey(xt_yh.getUnit());
        xtRzCz.setUnitName(xt_yh.getUnit());
        xtRzCz.setOperateTime(DateUtils.getCurrDateTime());
        xtRzCz.setOperateType(operate_type);
        xtRzCz.setOperateResult(operate_result);
        xtRzCz.setErrorCode(error_code);
        xtRzCz.setOperateName(operate_name);
        xtRzCz.setOperateCondition(operate_contidion+",操作ip:"+ GetCilentInfoUtils.getRemoteIp(null,request));
        try {
            userXtRzCz.addXtCzRz(xtRzCz);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统在保存日志时发生错误："+ e.getMessage());
        }
    }




}
