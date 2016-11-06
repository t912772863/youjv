package com.gongxiangcloud.youjv.core.dao.label;

import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.label.ActivityLabelRelation;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/17.
 */
@Repository
public class ActivityLabelRelationImpl extends BaseDao implements IActivityLabelRelationDao {
    public void insert(ActivityLabelRelation activityLabelRelation) {
        this.getHibernateTemplate().save(activityLabelRelation);
    }
}
