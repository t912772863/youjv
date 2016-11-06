package com.gongxiangcloud.youjv.core.dao.activity;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class ActivityInfoDaoImpl extends BaseDao implements IActivityInfoDao {
    public void insert(ActivityInfo activityInfo) {
        this.getHibernateTemplate().save(activityInfo);
    }

    public void deleteById(Long id) {
        // 定义查询语句,通过Query来创建查询
        String hql = "update ActivityInfo a set a.status = -1 where a.id = :id";

        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();


    }

    public void updateById(ActivityInfo activityInfo) {
        ActivityInfo activityInfoOld = queryById(activityInfo.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(activityInfoOld,activityInfo));
    }

    public ActivityInfo queryById(Long id) {
        return this.getHibernateTemplate().get(ActivityInfo.class,id);
    }
}
