package com.gongxiangcloud.youjv.core.entity.activity;

import javax.persistence.*;

/**
 * 活动参与者详情表
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "activity_participant", schema = "sns", catalog = "")
public class ActivityParticipant {
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

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACTIVITY_ID", nullable = false)
    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "PARTICIPANT_UID", nullable = false)
    public long getParticipantUid() {
        return participantUid;
    }

    public void setParticipantUid(long participantUid) {
        this.participantUid = participantUid;
    }

    @Basic
    @Column(name = "PARTICIPANT_STATUS", nullable = false)
    public int getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(int participantStatus) {
        this.participantStatus = participantStatus;
    }

    @Basic
    @Column(name = "SIGN_STATUS", nullable = false)
    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    @Basic
    @Column(name = "ORDER_ID", nullable = true)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityParticipant that = (ActivityParticipant) o;

        if (id != that.id) return false;
        if (activityId != that.activityId) return false;
        if (participantUid != that.participantUid) return false;
        if (participantStatus != that.participantStatus) return false;
        if (signStatus != that.signStatus) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (activityId ^ (activityId >>> 32));
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (int) (participantUid ^ (participantUid >>> 32));
        result = 31 * result + participantStatus;
        result = 31 * result + signStatus;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
