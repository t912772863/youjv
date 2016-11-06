package com.gongxiangcloud.youjv.core.entity.other;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户反馈的信息
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "opinion_info", schema = "sns", catalog = "")
public class OpinionInfo {
    /** 自增ID*/
    private long id;
    /** 用户唯一标识(user_login表中的uid)*/
    private Long uid;
    /** 反馈类型: 1.产品建议.; 2,功能崩溃; 3.使用帮助; 4.其它*/
    private Integer type;
    /** 意见正文*/
    private String context;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
    /** 消息状态: -1,已删除; 1.新建消息(未处理); 2.已处理*/
    private Integer status;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UID", nullable = true)
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "TYPE", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CONTEXT", nullable = true, length = 255)
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "STATUS", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpinionInfo that = (OpinionInfo) o;

        if (id != that.id) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
