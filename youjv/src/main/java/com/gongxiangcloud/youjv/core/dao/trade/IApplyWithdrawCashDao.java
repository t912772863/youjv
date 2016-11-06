package com.gongxiangcloud.youjv.core.dao.trade;

import com.gongxiangcloud.youjv.core.entity.trade.ApplyWithdrawCash;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IApplyWithdrawCashDao {
    /**
     * 新增一条数据
     * @param applyWithdrawCash
     */
    public void insert(ApplyWithdrawCash applyWithdrawCash);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param applyWithdrawCash
     */
    public void updateById(ApplyWithdrawCash applyWithdrawCash);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public ApplyWithdrawCash queryById(Long id);
}
