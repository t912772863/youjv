package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.user.UserIncomeExpenses;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/10.
 */
@Repository
public class UserIncomeExpensesDaoImpl extends BaseDao implements IUserIncomeExpensesDao {
    public void insert(UserIncomeExpenses userIncomeExpenses) {
        this.getHibernateTemplate().save(userIncomeExpenses);
    }

    public void deleteById(Long id) {
        String hql = "update UserIncomeExpenses a set a.status = -1 where a.id = :id";
        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();
    }

    public void updateById(UserIncomeExpenses userIncomeExpenses) {
        UserIncomeExpenses userIncomeExpensesOld = queryById(userIncomeExpenses.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(userIncomeExpensesOld,userIncomeExpenses));
    }

    public UserIncomeExpenses queryById(Long id) {
        return this.getHibernateTemplate().get(UserIncomeExpenses.class,id);
    }
}
