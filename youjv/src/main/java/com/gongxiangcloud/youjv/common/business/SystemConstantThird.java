package com.gongxiangcloud.youjv.common.business;

/**
 * 项目中的一些与第三方平台交互时,由第三方约定,我们要遵守的常量.
 * Created by tianxiong on 16/10/11.
 */
public class SystemConstantThird {

    /**------短信服务相关常量-----------------------------------------------------------------------------------------*/
    /**
     * 友聚APP注册短信,json模版
     */
    public static String MESSAGE_SIGNUP_MODEL = "{\"code\":\"$code\"}";

    /**
     * 云信服务,成功发送短信返回状态码
     */
    public static final String MESSAGE_SEND_SUCCESS = "100";

    /**
     * 云信平台,配置的注册消息模版的唯一标识
     */
    public static final String MESSAGE_SIGNUP_TEMPLATE = "389779";
    /**
     * 云信平台,忘记密码,发送短信的模版
     */
    public static final String MESSAGE_FORGET_TEMPLATE = "389949";


    /**------高德地图云图服务常量-----------------------------------------------------------------------------------------*/
    /**
     * 高德云图,创建表链接
     */
    public static final String MAP_TABEL_CREATE = "http://yuntuapi.amap.com/datamanage/table/create";
    /**
     * 创建单条数据
     */
    public static final String MAP_DATA_CREATE = "http://yuntuapi.amap.com/datamanage/data/create";
    /**
     * 批量上传数据
     */
    public static final String MAP_DATA_BATCHCREATE = "http://yuntuapi.amap.com/datamanage/data/batchcreate";
    /**
     * 单条更新
     */
    public static final String MAP_DATA_UPDATE = "http://yuntuapi.amap.com/datamanage/data/update";
    /**
     * 单条删除
     */
    public static final String MAP_DATA_DELETE = "http://yuntuapi.amap.com/datamanage/data/delete";

    /**
     * 云图相关的接口返回的status成功标识
     */
    public static final String MAP_OPTION_SUCCESS = "1";
    /**
     * 周边检索
     */
    public static final String MAP_DATASEARCH_AROUND = "http://yuntuapi.amap.com/datasearch/around";

}
