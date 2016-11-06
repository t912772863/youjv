package com.gongxiangcloud.youjv.common.dto;

import com.gongxiangcloud.youjv.core.entity.trade.OrderInfo;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;

/**
 * 每一条活动参与信息的数据传递封装
 * Created by tianxiong on 16/10/14.
 */
public class ActivityParticipantDto {
    /** 自增ID*/
    private long id;
    /** 活动ID*/
    private long activityId;
    /** 参与者留言*/
    private String remark;
    /** 参与者用户ID*/
    private long participantUid;
    /** 参与者参与的状态: 1待审核; 2已通过; 3已拒绝*/
    private int participantStatus;
    /** 签到状态: 1未签到; 2已签到*/
    private int signStatus;
    /** 支付订单ID(对于收费活动,参与者要先支付费用)*/
    private Long orderId;

    /**参与者信息*/
    private UserInfo participantUser;
    /**这笔活动的支付订单*/
    private OrderInfo orderInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getParticipantUid() {
        return participantUid;
    }

    public void setParticipantUid(long participantUid) {
        this.participantUid = participantUid;
    }

    public int getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(int participantStatus) {
        this.participantStatus = participantStatus;
    }

    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UserInfo getParticipantUser() {
        return participantUser;
    }

    public void setParticipantUser(UserInfo participantUser) {
        this.participantUser = participantUser;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
