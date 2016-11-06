package com.gongxiangcloud.youjv.core.entity.trade;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户申请提现表
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "apply_withdraw_cash", schema = "sns", catalog = "")
public class ApplyWithdrawCash {
    /** 自增ID*/
    private long id;
    /** 用户ID*/
    private long uid;
    /** 申请提现的金额(单位:分)*/
    private int amount;
    /** 申请提现的状态: 1申请提现中; 2提现成功; 3提现失败*/
    private int applyStatus;
    /** 创建时间(申请提现的时间)*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
    /** 数据状态: -1删除; 1正常*/
    private int status;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UID", nullable = false)
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "AMOUNT", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "APPLY_STATUS", nullable = false)
    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
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
    @Column(name = "STATUS", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyWithdrawCash that = (ApplyWithdrawCash) o;

        if (id != that.id) return false;
        if (uid != that.uid) return false;
        if (amount != that.amount) return false;
        if (applyStatus != that.applyStatus) return false;
        if (status != that.status) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (uid ^ (uid >>> 32));
        result = 31 * result + amount;
        result = 31 * result + applyStatus;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
