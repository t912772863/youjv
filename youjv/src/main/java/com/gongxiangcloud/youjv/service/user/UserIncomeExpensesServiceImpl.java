package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.dao.user.IUserIncomeExpensesDao;
import com.gongxiangcloud.youjv.core.entity.user.UserIncomeExpenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class UserIncomeExpensesServiceImpl implements IUserIncomeExpensesService {
    @Autowired
    private IUserIncomeExpensesDao userIncomeExpensesDao;

    public boolean insertUserIncomeExpenses(UserIncomeExpenses userIncomeExpenses) {
        userIncomeExpensesDao.insert(userIncomeExpenses);

        return true;
    }

    public boolean deleteUserIncomeExpensesById(Long id) {
        userIncomeExpensesDao.deleteById(id);
        return true;
    }

    public boolean updateUserIncomeExpensesById(Long id, UserIncomeExpenses userIncomeExpenses) {
        userIncomeExpenses.setId(id);
        userIncomeExpensesDao.updateById(userIncomeExpenses);
        return true;
    }

    public UserIncomeExpenses queryUserIncomeExpensesById(Long id) {
        return userIncomeExpensesDao.queryById(id);
    }
}
