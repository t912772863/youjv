package com.gongxiangcloud.youjv.core.dao.trade;

import com.gongxiangcloud.youjv.core.entity.trade.WithdrawCash;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IWithdrawCashDao {
    /**
     * 新增一条数据
     * @param withdrawCash
     */
    public void insert(WithdrawCash withdrawCash);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param withdrawCash
     */
    public void updateById(WithdrawCash withdrawCash);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public WithdrawCash queryById(Long id);
}
