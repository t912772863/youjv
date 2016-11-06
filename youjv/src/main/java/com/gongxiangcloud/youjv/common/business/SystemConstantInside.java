package com.gongxiangcloud.youjv.common.business;

/**
 * 项目中一些内部定义的常量,
 * Created by tianxiong on 16/10/13.
 */
public class SystemConstantInside {


    /**------系统中数据库中数据的统一状态常量----------------------------------------------------------------------------*/

    /**
     * 所有表中的数据状态(正常)
     */
    public static final int DATA_STATUS_NORMAL = 1;

    /**
     * 所有表中的数据状态(删除)
     */
    public static final int DATA_STATUS_DELETE = -1;

    /**------------------------------------------------------------------------------------------------------------*/

    /**
     * 活动审请: 待审核
     */
    public static final int PARTICIPANT_STATUS_WAIT = 1;
    /**
     * 活动审请: 通过
     */
    public static final int PARTICIPANT_STATUS_PASS = 2;
    /**
     * 活动审请: 拒绝
     */
    public static final int PARTICIPANT_STATUS_DENY = 3;


    /**------------------------------------------------------------------------------------------------------------*/
    /**
     * 新增标签的默认色值
     */
    public static final String LABEL_COLOR_DEFAULT = "#946DE5";


    /**------------------------------------------------------------------------------------------------------------*/
    /**
     * 申请提现中
     */
    public static final int APPLY_CASH_WAIT = 1;
    /**
     * 申请提现成功
     */
    public static final int APPLY_CASH_SUCCESS = 2;
    /**
     * 提现失败
     */
    public static final int APPLY_CASH_FAILD = 3;

    /**------------------------------------------------------------------------------------------------------------*/

    /**
     * 活动已取消
     */
    public static final int ACTIVITY_STATUS_CANCEL = -1;
    /**
     * 活动报名中
     */
    public static final int ACTIVITY_STATUS_JOINING = 1;
    /**
     * 报名结束
     */
    public static final int ACTIVITY_STATUS_JOINED = 2;
    /**
     * 名单已确认
     */
    public static final int ACTIVITY_STATUS_COMMIT = 3;
    /**
     * 活动进行中
     */
    public static final int ACTIVITY_STATUS_DOING = 4;
    /**
     * 活动已结束
     */
    public static final int ACTIVITY_STATUS_OVER = 5;
    /**
     * 活动未成行
     */
    public static final int ACTIVITY_STATUS_UNDID = 6;
}
