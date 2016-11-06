package com.gongxiangcloud.youjv.controller.trade;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.trade.ApplyWithdrawCash;
import com.gongxiangcloud.youjv.service.trade.IApplyWithdrawCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianxiong on 16/10/16.
 */
@Controller
@RequestMapping("apply_withdraw_cash")
public class ApplyWithdrawCashController extends BaseController {
    @Autowired
    private IApplyWithdrawCashService applyWithdrawCashService;

    /**
     *   申请提现接口
     * @param applyWithdrawCash
     * @return
     */
    @RequestMapping("apply_withdraw_cash")
    @ResponseBody
    public String applyWithdrawCash(ApplyWithdrawCash applyWithdrawCash){
        boolean b = applyWithdrawCashService.insertApplyWithdrawCash(applyWithdrawCash);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

}
