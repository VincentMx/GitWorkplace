package cn.lix.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据接口类型
 * @author lix
 */
public class Constants {

    /**
     * 登录
     */
    public static final String Login = "login";

    /***
     * 暂存所有用户登录信息
     */
    public static Map<String,Object> xtYhInfo = new HashMap<String,Object>();

    /**
     *操作日志类型： 0: 登录，1 ：查询， 2 ：新增， 3：修改，4：删除。
     */
    public static String OPERATORLOGLOGIN = "0";
    public static String OPERATORLOGSELECT = "1";
    public static String OPERATORLOGADD= "2";
    public static String OPERATORLOGUPDATE = "3";
    public static String OPERATORLOGDELETE = "4";

    /***
     * 操作成功 1 失败： 0
     */
    public static String OPERATE_SUCCESS = "1";
    public static String OPERATE_FAIL = "0";

    /***
     * 系统登录日志有效状态 -- 有效
      */
    public static final String XTRZDL_YX = "1";

    /***
     * 系统用户登录状态-- 无效
     */
    public static final String XTRZDL_WX = "0";

    /***
     * 本系统标识
     */
    public static final String XTLX_BXT = "LXDHTGLXT";



    /**
     * 系统角色的有效状态-有效
     */
    public static final String XtJsYxzt_YX = "1";

    /**
     * 系统角色的有效状态-无效
     */
    public static final String XtJsYxzt_WX = "0";


    /**
     * 系统用户的有效状态-有效
     */
    public static final String XtYhYxzt_YX = "1";

    /**
     * 系统用户的有效状态-无效
     */
    public static final String XtYhYxzt_WX = "0";

    /***
     * 系统操作日志-有效
     */
    public static final String XtRzCz_YX = "1";

    /***
     * 系统操作日志-无效
     */
    public static final String XtRzCz_WX = "0";


    /***
     * 系统用户身份状态 -- 正常
     */
    public static final String XtYh_YX = "1";

    /***
     * 系统用户身份状态 -- 注销
     */
    public static final String XtYh_ZX = "0";

    /***
     * 系统用户身份状态 -- 待审核
     */
    public  static final String XtYh_DSH = "2";
    /***
     * 系统用户身份状态 -- 审核未通过
     */
    public  static final String XtYh_SHWTG = "3";

    /***
     * 系统参数类型 -- 有效
     */
    public static final String XtCsLx_YX = "1";

    /***
     * 系统参数类型 -- 无效
     */
    public static final String XtCsLx_WX = "0";

    /***
     * 系统参数 -- 有效
     */
    public static final String XtCs_YX = "1";

    /***
     * 系统参数 -- 无效
     */
    public static final String XtCs_WX = "0";


    /**
     * 在线用户
     */
    public static final String ZXYH = "SYS_ZXYH";


    /***
     * 系统单位有效状态 -- 有效
     */
    public static final String XtDw_YX = "1";


    /***
     * 系统单位有效状态 -- 无效
     */
    public static  final String XtDw_WX = "0";




}
