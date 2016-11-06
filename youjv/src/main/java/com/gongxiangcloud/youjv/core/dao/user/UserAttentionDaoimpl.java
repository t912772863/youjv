package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.user.UserAttention;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/10.
 */
@Repository
public class UserAttentionDaoimpl extends BaseDao implements IUserAttentionDao {


    public void insert(UserAttention userAttention) {
        this.getHibernateTemplate().save(userAttention);
    }

    public void deleteByUidAndFollowUid(Long uid, Long followUid) {
        String hql = "delete from UserAttention a where a.uid = :uid and a.followUid = :followUid";
        this.getSession().createQuery(hql)//
            .setParameter("uid",uid)//
            .setParameter("followUid",followUid)//
            .executeUpdate();

    }
}
