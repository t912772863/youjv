package com.gongxiangcloud.youjv.service.trade;

import com.gongxiangcloud.youjv.core.entity.trade.WithdrawCash;

/**
 * 提现记录业务层(平台给用户转帐)
 * Created by tianxiong on 16/10/9.
 */
public interface IWithdrawCashService {
    /**
     * 新增一个
     * @param withdrawCash
     * @return
     */
    public boolean insertWithdrawCash(WithdrawCash withdrawCash);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteWithdrawCashById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param withdrawCash
     * @return
     */
    public boolean updateWithdrawCashById(Long id,WithdrawCash withdrawCash);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public WithdrawCash queryWithdrawCashById(Long id);
}
