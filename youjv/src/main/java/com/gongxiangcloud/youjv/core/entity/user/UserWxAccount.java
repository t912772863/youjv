package com.gongxiangcloud.youjv.core.entity.user;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户与微信支付相关的帐号信息
 * Created by tianxiong on 16/10/9.
 */
//@Entity
//@Table(name = "user_wx_account", schema = "sns", catalog = "")
public class UserWxAccount {
    /** 用户标识 */
    private long uid;
    /** 微信号与我方平台(appId)关联的唯一openId*/
    private String openId;
    /** 微信帐号*/
    private String wxNumber;
    /** 实名认证的名字*/
    private String realName;
    /** 数据状态: -1删除(解绑); 1正常*/
    private int status;

    @Basic
    @Column(name = "UID", nullable = false)
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "OPEN_ID", nullable = false, length = 50)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "WX_NUMBER", nullable = false, length = 50)
    public String getWxNumber() {
        return wxNumber;
    }

    public void setWxNumber(String wxNumber) {
        this.wxNumber = wxNumber;
    }

    @Basic
    @Column(name = "REAL_NAME", nullable = false, length = 10)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

        UserWxAccount that = (UserWxAccount) o;

        if (uid != that.uid) return false;
        if (status != that.status) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (wxNumber != null ? !wxNumber.equals(that.wxNumber) : that.wxNumber != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (wxNumber != null ? wxNumber.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
