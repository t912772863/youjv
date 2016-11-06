package com.gongxiangcloud.youjv.core.entity.user;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

/**
 * 用户关注关系表
 * Created by tianxiong on 16/10/9.
 */

// 没有主键的表映射会报错?

//@Entity
//@Table(name = "user_attention", schema = "sns", catalog = "")
public class UserAttention {
    private long uid;
    private long followUid;
    private Date createTime;

    @Basic
    @Column(name = "UID", nullable = false)
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "FOLLOW_UID", nullable = false)
    public long getFollowUid() {
        return followUid;
    }

    public void setFollowUid(long followUid) {
        this.followUid = followUid;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAttention that = (UserAttention) o;

        if (uid != that.uid) return false;
        if (followUid != that.followUid) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (int) (followUid ^ (followUid >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
