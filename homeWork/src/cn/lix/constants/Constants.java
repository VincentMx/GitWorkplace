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

    /***
     * 系统用户待审批 -- 待审批
     */
    public static final String XtYhDsp_SPZ = "00";


    /***
     * 系统用户待审批 -- 审批通过
     */
    public static final String XtYhDsp_SPTG = "01";


    /***
     * 系统用户待审批 -- 审批未通过
     */
    public static final String XtYhDsp_SPWTG = "02";


    /**
     * 系统消息提示
     */
    public static String success = "0000";

    public static String success_msg = "成功";

    public static String error = "9999";

    public static String error_msg = "请求失败，系统正在处理";





    public static String TR001 = "TR001"; //百度
    public static String TR002 = "TR002"; //有道


    public static String YH001 = "YH001"; //注册待审批用户
    public static String YH002 = "YH002"; //审批待审批用户
    public static String YH003 = "YH003"; //修改用户信息
    public static String YH004 = "YH004"; //删除系统用户
    public static String YH005 = "YH005"; //获取所有用户信息
    public static String YH006 = "YH006"; //获取待审批用户信息
    public static String YH007 = "YH007"; //获取系统用户信息
    public static String YH008 = "YH008"; //删除待审批用户
    public static String YH009 = "YH009"; //
    public static String YH010 = "YH010"; //
    public static String YH011 = "YH011"; //
    public static String YH012 = "YH012"; //
    public static String YH013 = "YH013"; //
    public static String YH014 = "YH014"; //
    public static String YH015 = "YH015"; //
    public static String YH016 = "YH016"; //
    public static String YH017 = "YH017"; //
    public static String YH018 = "YH018"; //
    public static String YH019 = "YH019"; //
    public static String YH020 = "YH020"; //


   // 停车相关接口
   public static String PK001 = "PK001"; //分页获取车位列表
   public static String PK002 = "PK002"; //获取车位详情
   public static String PK003 = "PK003"; //获取停车价格计划
   public static String PK004 = "PK004"; //获取可用停车位数量
   public static String PK005 = "PK005"; //生成停车位预定订单
   public static String PK006 = "PK006"; //获取停车位图片列表
   public static String PK007 = "PK007"; //获取停车订单列表
   public static String PK008 = "PK008"; //获取停车订单详情
   public static String PK009 = "PK009"; //取消订单
   public static String PK010 = "PK010"; //获取取消订单列表
   public static String PK011 = "PK011"; //获取取消订单详情
   public static String PK012 = "PK012"; //
   public static String PK013 = "PK013"; //
   public static String PK014 = "PK014"; //




}
