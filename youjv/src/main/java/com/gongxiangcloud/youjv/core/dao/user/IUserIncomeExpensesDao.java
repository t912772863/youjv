package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.core.entity.user.UserIncomeExpenses;

/**
 * 用户收支记录流水表
 * Created by tianxiong on 16/10/9.
 */
public interface IUserIncomeExpensesDao {
    /**
     * 新增一条数据
     * @param userIncomeExpenses
     */
    public void insert(UserIncomeExpenses userIncomeExpenses);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param userIncomeExpenses
     */
    public void updateById(UserIncomeExpenses userIncomeExpenses);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public UserIncomeExpenses queryById(Long id);
}
