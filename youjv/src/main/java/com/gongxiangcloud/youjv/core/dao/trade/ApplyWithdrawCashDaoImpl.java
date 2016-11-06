package com.gongxiangcloud.youjv.core.dao.trade;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.trade.ApplyWithdrawCash;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class ApplyWithdrawCashDaoImpl extends BaseDao implements IApplyWithdrawCashDao {
    public void insert(ApplyWithdrawCash applyWithdrawCash) {
        this.getHibernateTemplate().save(applyWithdrawCash);
    }

    public void deleteById(Long id) {
        String hql = "update ApplyWithdrawCash a set a.status = -1 where a.id = :id ";
        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();
    }

    public void updateById(ApplyWithdrawCash applyWithdrawCash) {
        ApplyWithdrawCash applyWithdrawCashOld = queryById(applyWithdrawCash.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(applyWithdrawCashOld,applyWithdrawCash));
    }

    public ApplyWithdrawCash queryById(Long id) {
        return this.getHibernateTemplate().get(ApplyWithdrawCash.class,id);
    }
}
