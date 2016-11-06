package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.entity.user.UserIncomeExpenses;

/**
 * 用户收支流水业务层
 * Created by tianxiong on 16/10/9.
 */
public interface IUserIncomeExpensesService {
    /**
     * 新增一个
     * @param userIncomeExpenses
     * @return
     */
    public boolean insertUserIncomeExpenses(UserIncomeExpenses userIncomeExpenses);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteUserIncomeExpensesById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param userIncomeExpenses
     * @return
     */
    public boolean updateUserIncomeExpensesById(Long id,UserIncomeExpenses userIncomeExpenses);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public UserIncomeExpenses queryUserIncomeExpensesById(Long id);
}
