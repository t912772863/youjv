package com.gongxiangcloud.youjv.service.label;

import com.gongxiangcloud.youjv.core.dao.label.IActivityLabelRelationDao;
import com.gongxiangcloud.youjv.core.entity.label.ActivityLabelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/17.
 */

@Service
public class ActivityLabelRelationServiceImpl implements IActivityLabelRelationService {
    @Autowired
    private IActivityLabelRelationDao activityLabelRelationDao;

    public boolean insertActivityLabelRelation(ActivityLabelRelation activityLabelRelation) {
        activityLabelRelationDao.insert(activityLabelRelation);
        return true;
    }
}
