package com.gongxiangcloud.youjv.core.dao.activity;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityParticipant;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class ActivityParticipantDaoImpl extends BaseDao implements IActivityParticipantDao {
    public void insert(ActivityParticipant activityParticipant) {
        this.getHibernateTemplate().save(activityParticipant);
    }

    public void deleteById(Long id) {
        this.getHibernateTemplate().delete(queryById(id));
    }

    public void updateById(ActivityParticipant activityParticipant) {
        ActivityParticipant activityParticipantOld = queryById(activityParticipant.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(activityParticipantOld,activityParticipant));
    }

    public ActivityParticipant queryById(Long id) {
        return this.getHibernateTemplate().get(ActivityParticipant.class,id);
    }

    public List<ActivityParticipant> queryByActivityId(Long activityId) {
        String hql = "from ActivityParticipant a where a.activityId = :activityId";
        List<ActivityParticipant> list = this.getSession().createQuery(hql)//
            .setParameter("activityId",activityId)//
            .list();

        return list;
    }
}
