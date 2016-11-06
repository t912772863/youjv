package com.gongxiangcloud.youjv.core.entity.user;

import javax.persistence.*;
import java.util.Date;

/**
 * 个人帐户的收支记录表(收入和支出的流水)
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "user_income_expenses", schema = "sns", catalog = "")
public class UserIncomeExpenses {
    /** 自增ID*/
    private long id;
    /** 帐户: 收支发生过程中,与我的钱包交互的帐户信息*/
    private String account;
    /** 金额:(单位:分)*/
    private int amount;
    /** 创建时间:(记录发生的时间)*/
    private Date createTime;
    /** 针对该记录产生的描述,由系统生成统一格式:如(提现到微信)*/
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
    @Column(name = "ACCOUNT", nullable = false, length = 50)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
    @Column(name = "CREATE_TIME", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "REMARK", nullable = false, length = 50)
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

        UserIncomeExpenses that = (UserIncomeExpenses) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
