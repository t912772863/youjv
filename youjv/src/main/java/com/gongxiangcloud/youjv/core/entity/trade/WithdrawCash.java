package com.gongxiangcloud.youjv.core.entity.trade;

import javax.persistence.*;
import java.util.Date;

/**
 * 返现记录表(平台向用户帐号打款)
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "withdraw_cash", schema = "sns", catalog = "")
public class WithdrawCash {
    /** 自增ID*/
    private long id;
    /** 申请提现记录的ID*/
    private long applyCashId;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
    /** 返现状态: 1返现中,;  2返现成功; 3返现失败;*/
    private int cashStatus;
    /** 数据状态: -1删除; 1正常*/
    private int status;
    /** 提现的时候,我方平台给用户转帐的订单号*/
    private String cashOrderId;
    /** 收款人ID:这个字符串与我方平台的用户帐号是一对一的关系.(如:微信平台为APPID+OPENID)*/
    private String receiverId;
    /** 收款人姓名*/
    private String receiverName;
    /** 转帐说明(如:提现)*/
    private String remark;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPLY_CASH_ID", nullable = false)
    public long getApplyCashId() {
        return applyCashId;
    }

    public void setApplyCashId(long applyCashId) {
        this.applyCashId = applyCashId;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "CASH_STATUS", nullable = false)
    public int getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(int cashStatus) {
        this.cashStatus = cashStatus;
    }

    @Basic
    @Column(name = "STATUS", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CASH_ORDER_ID", nullable = false, length = 50)
    public String getCashOrderId() {
        return cashOrderId;
    }

    public void setCashOrderId(String cashOrderId) {
        this.cashOrderId = cashOrderId;
    }

    @Basic
    @Column(name = "RECEIVER_ID", nullable = false, length = 50)
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "RECEIVER_NAME", nullable = false, length = 20)
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Basic
    @Column(name = "REMARK", nullable = false, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WithdrawCash that = (WithdrawCash) o;

        if (id != that.id) return false;
        if (applyCashId != that.applyCashId) return false;
        if (cashStatus != that.cashStatus) return false;
        if (status != that.status) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (cashOrderId != null ? !cashOrderId.equals(that.cashOrderId) : that.cashOrderId != null) return false;
        if (receiverId != null ? !receiverId.equals(that.receiverId) : that.receiverId != null) return false;
        if (receiverName != null ? !receiverName.equals(that.receiverName) : that.receiverName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (applyCashId ^ (applyCashId >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + cashStatus;
        result = 31 * result + status;
        result = 31 * result + (cashOrderId != null ? cashOrderId.hashCode() : 0);
        result = 31 * result + (receiverId != null ? receiverId.hashCode() : 0);
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
