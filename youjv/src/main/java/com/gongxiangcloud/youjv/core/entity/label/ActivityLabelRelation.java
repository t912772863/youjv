package com.gongxiangcloud.youjv.core.entity.label;

import javax.persistence.*;

/**
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "activity_label_relation")
public class ActivityLabelRelation {
    private long id;
    private long activityId;
    private long labelId;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ACTIVITY_ID", nullable = false)
    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

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

        ActivityLabelRelation that = (ActivityLabelRelation) o;

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
