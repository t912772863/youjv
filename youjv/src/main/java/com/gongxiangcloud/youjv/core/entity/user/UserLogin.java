package com.gongxiangcloud.youjv.core.entity.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录帐号表
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable{
    /** 用户id，自增，唯一标识*/
    private Long uid;
    /** 手机号码*/
    private String mobile;
    /** 用户名*/
    private String userName;
    /** 登录密码*/
    private String password;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
    /** 连续登录失败的次数.*/
    private int continuousLoginFailed;
    /** 数据状态: -1:删除, 1正常*/
    private int status;

    @Id
    @GeneratedValue
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getContinuousLoginFailed() {
        return continuousLoginFailed;
    }

    public void setContinuousLoginFailed(int continuousLoginFailed) {
        this.continuousLoginFailed = continuousLoginFailed;
    }

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

        UserLogin userLogin = (UserLogin) o;

        if (uid != userLogin.uid) return false;
        if (continuousLoginFailed != userLogin.continuousLoginFailed) return false;
        if (status != userLogin.status) return false;
        if (mobile != null ? !mobile.equals(userLogin.mobile) : userLogin.mobile != null) return false;
        if (userName != null ? !userName.equals(userLogin.userName) : userLogin.userName != null) return false;
        if (password != null ? !password.equals(userLogin.password) : userLogin.password != null) return false;
        if (createTime != null ? !createTime.equals(userLogin.createTime) : userLogin.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(userLogin.updateTime) : userLogin.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + continuousLoginFailed;
        result = 31 * result + status;
        return result;
    }
}
