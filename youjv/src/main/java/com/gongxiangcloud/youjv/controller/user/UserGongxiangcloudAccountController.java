package com.gongxiangcloud.youjv.controller.user;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;
import com.gongxiangcloud.youjv.service.user.IUserGongxiangcloudAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户在我方平台的帐户信息管理控制层
 * Created by tianxiong on 16/10/16.
 */
@Controller
@RequestMapping("gongxiangcloud_account")
public class UserGongxiangcloudAccountController extends BaseController{
    @Autowired
    private IUserGongxiangcloudAccountService gongxiangcloudAccountService;

    /**
     * 根据UID查询这个用户在我方平台 的帐号信息
     * @param uid
     * @return
     */
    @RequestMapping("query_gongxiangcloud_account_by_uid")
    @ResponseBody
    public String queryGongxiangcloudAccountByUid(Long uid){
        UserGongxiangcloudAccount gongxiangcloudAccount = gongxiangcloudAccountService.queryUserGongxiagncloudAccountByUid(uid);
        return GsonUtil.toJson(successData.setData(gongxiangcloudAccount), ResponseData.class);
    }

}
