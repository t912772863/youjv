package com.gongxiangcloud.youjv.core.dao.other;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.other.OpinionInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class OpinionInfoDaoImpl extends BaseDao implements IOpinionInfoDao{
    public void insert(OpinionInfo opinionInfo) {
        this.getHibernateTemplate().save(opinionInfo);
    }

    public void deleteById(Long id) {
        String hql = "update OpinionInfo a set a.status = -1 where a.id = :id ";
        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();
    }

    public void updateById(OpinionInfo opinionInfo) {
        OpinionInfo opinionInfoOld = queryById(opinionInfo.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(opinionInfoOld,opinionInfo));
    }

    public OpinionInfo queryById(Long id) {
        return this.getHibernateTemplate().get(OpinionInfo.class,id);
    }
}
