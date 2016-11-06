package com.gongxiangcloud.youjv.core.entity.user;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户在共享云平台的帐户表(APP中我的钱包)
 * Created by tianxiong on 16/10/9.
 */
//@Entity
//@Table(name = "user_gongxiangcloud_account", schema = "sns", catalog = "")
public class UserGongxiangcloudAccount {
    /** 用户唯一标识*/
    private long uid;
    /** 用户在我方平台已确认的金额,也就是可以提现的金额(单位:分)*/
    private int confirmedMoney;
    /** 未确认的金额*/
    private int unconfirmedMoney;

    @Basic
    @Column(name = "UID", nullable = false)
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "CONFIRMED_MONEY", nullable = false)
    public int getConfirmedMoney() {
        return confirmedMoney;
    }

    public void setConfirmedMoney(int confirmedMoney) {
        this.confirmedMoney = confirmedMoney;
    }

    @Basic
    @Column(name = "UNCONFIRMED_MONEY", nullable = false)
    public int getUnconfirmedMoney() {
        return unconfirmedMoney;
    }

    public void setUnconfirmedMoney(int unconfirmedMoney) {
        this.unconfirmedMoney = unconfirmedMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGongxiangcloudAccount that = (UserGongxiangcloudAccount) o;

        if (uid != that.uid) return false;
        if (confirmedMoney != that.confirmedMoney) return false;
        if (unconfirmedMoney != that.unconfirmedMoney) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + confirmedMoney;
        result = 31 * result + unconfirmedMoney;
        return result;
    }
}
