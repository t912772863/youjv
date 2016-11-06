package com.gongxiangcloud.youjv.service.label;

import com.gongxiangcloud.youjv.core.dao.label.IUserLabelRelationDao;
import com.gongxiangcloud.youjv.core.entity.label.UserLabelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/17.
 */
@Service
public class UserLabelRelationServiceImpl implements IUserLabelRelationService {
    @Autowired
    private IUserLabelRelationDao userLabelRelationDao;

    public boolean insertUserLabelRelation(UserLabelRelation userLabelRelation) {
        userLabelRelationDao.insert(userLabelRelation);
        return true;
    }
}
