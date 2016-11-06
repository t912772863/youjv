package com.gongxiangcloud.youjv.core.dao.label;

import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.label.UserLabelRelation;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/17.
 */
@Repository
public class UserLabelRelationDaoImpl extends BaseDao implements IUserLabelRelationDao {

    public void insert(UserLabelRelation userLabelRelation) {
        this.getHibernateTemplate().save(userLabelRelation);
    }
}
