package com.gongxiangcloud.youjv.service.trade;

import com.gongxiangcloud.youjv.core.dao.trade.IWithdrawCashDao;
import com.gongxiangcloud.youjv.core.entity.trade.WithdrawCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class WithdrawCashServiceImpl implements IWithdrawCashService {
    @Autowired
    private IWithdrawCashDao withdrawCashDao;

    public boolean insertWithdrawCash(WithdrawCash withdrawCash) {
        withdrawCashDao.insert(withdrawCash);
        return true;
    }

    public boolean deleteWithdrawCashById(Long id) {
        withdrawCashDao.deleteById(id);
        return true;
    }

    public boolean updateWithdrawCashById(Long id, WithdrawCash withdrawCash) {
        withdrawCash.setId(id);
        withdrawCashDao.updateById(withdrawCash);
        return true;
    }

    public WithdrawCash queryWithdrawCashById(Long id) {
        return withdrawCashDao.queryById(id);
    }
}
