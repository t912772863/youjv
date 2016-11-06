package com.gongxiangcloud.youjv.service.trade;

import com.gongxiangcloud.youjv.core.entity.trade.ApplyWithdrawCash;

/**
 * 用户申请提现表业务层
 * Created by tianxiong on 16/10/9.
 */
public interface IApplyWithdrawCashService {
    /**
     * 新增一个
     * @param applyWithdrawCash
     * @return
     */
    public boolean insertApplyWithdrawCash(ApplyWithdrawCash applyWithdrawCash);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteApplyWithdrawCashById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param applyWithdrawCash
     * @return
     */
    public boolean updateApplyWithdrawCashById(Long id,ApplyWithdrawCash applyWithdrawCash);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public ApplyWithdrawCash queryApplyWithdrawCashById(Long id);
}
