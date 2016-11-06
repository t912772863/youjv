package com.gongxiangcloud.youjv.service.trade;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.SystemConstantInside;
import com.gongxiangcloud.youjv.core.dao.trade.IApplyWithdrawCashDao;
import com.gongxiangcloud.youjv.core.entity.trade.ApplyWithdrawCash;
import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;
import com.gongxiangcloud.youjv.service.user.IUserGongxiangcloudAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class ApplyWithdrawCashServiceImpl implements IApplyWithdrawCashService {
    @Autowired
    private IApplyWithdrawCashDao applyWithdrawCashDao;
    @Autowired
    private IUserGongxiangcloudAccountService gongxiangcloudAccountService;

    public boolean insertApplyWithdrawCash(ApplyWithdrawCash applyWithdrawCash) {
        //查询出帐户金额,如果可用金额小于要提现的金额返回失败
        UserGongxiangcloudAccount account = gongxiangcloudAccountService.queryUserGongxiagncloudAccountByUid(applyWithdrawCash.getUid());
        if(account.getConfirmedMoney() < applyWithdrawCash.getAmount()){
            throw new BusinessException("提现金额不能大于可用金额");
        }

        applyWithdrawCash.setCreateTime(new Date());
        applyWithdrawCash.setApplyStatus(SystemConstantInside.APPLY_CASH_WAIT);
        applyWithdrawCash.setStatus(SystemConstantInside.DATA_STATUS_NORMAL);
        applyWithdrawCashDao.insert(applyWithdrawCash);
        // 申请提现成功,要把这个帐号对应的可用金额减云这个数.
        account.setConfirmedMoney(account.getConfirmedMoney()-applyWithdrawCash.getAmount());
        gongxiangcloudAccountService.updateUserGongxiangcloudAccountByUid(account);

        return true;
    }

    public boolean deleteApplyWithdrawCashById(Long id) {
        applyWithdrawCashDao.deleteById(id);
        return true;
    }

    public boolean updateApplyWithdrawCashById(Long id, ApplyWithdrawCash applyWithdrawCash) {
        applyWithdrawCash.setId(id);
        applyWithdrawCashDao.updateById(applyWithdrawCash);
        return true;
    }

    public ApplyWithdrawCash queryApplyWithdrawCashById(Long id) {
        return applyWithdrawCashDao.queryById(id);
    }
}
