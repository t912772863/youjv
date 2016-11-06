package com.gongxiangcloud.youjv.core.entity.activity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tianxiong on 16/10/9.
 */
public class ActivityLabelRelationPK implements Serializable {
    private long activityId;
    private long labelId;

    @Column(name = "ACTIVITY_ID", nullable = false)
    @Id
    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    @Column(name = "LABEL_ID", nullable = false)
    @Id
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

        ActivityLabelRelationPK that = (ActivityLabelRelationPK) o;

        if (activityId != that.activityId) return false;
        if (labelId != that.labelId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (activityId ^ (activityId >>> 32));
        result = 31 * result + (int) (labelId ^ (labelId >>> 32));
        return result;
    }
}
