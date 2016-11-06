package com.gongxiangcloud.youjv.core.dao.trade;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.trade.WithdrawCash;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class WithdrawCashDaoImpl extends BaseDao implements IWithdrawCashDao {
    public void insert(WithdrawCash withdrawCash) {
        this.getHibernateTemplate().save(withdrawCash);
    }

    public void deleteById(Long id) {
        String hql = "update WithdrawCash a set a.status = -1 where a.id = :id";
        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();

    }

    public void updateById(WithdrawCash withdrawCash) {
        WithdrawCash withdrawCashOld = queryById(withdrawCash.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(withdrawCashOld,withdrawCash));
    }

    public WithdrawCash queryById(Long id) {
        return this.getHibernateTemplate().get(WithdrawCash.class,id);
    }
}
