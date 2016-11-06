package com.gongxiangcloud.youjv.core.entity.label;

import javax.persistence.*;

/**
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "user_label_relation")
public class UserLabelRelation {
    private long id;
    private long uid;
    private long labelId;

    @Id
    @GeneratedValue
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
    @Column(name = "LABEL_ID", nullable = false)
    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLabelRelation that = (UserLabelRelation) o;

        if (uid != that.uid) return false;
        if (labelId != that.labelId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (int) (labelId ^ (labelId >>> 32));
        return result;
    }
}
