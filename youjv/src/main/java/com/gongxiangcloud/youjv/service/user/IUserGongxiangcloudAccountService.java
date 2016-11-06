package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IUserGongxiangcloudAccountService {
    /**
     * 新增一个
     * @param userGongxiangcloudAccount
     * @return
     */
    public boolean insertUserGongxiangcloudAccount(UserGongxiangcloudAccount userGongxiangcloudAccount);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteUserGongxiangcloudAccountById(Long id);

    /**
     * 根据ID更新
     * @param userGongxiangcloudAccount
     * @return
     */
    public boolean updateUserGongxiangcloudAccountByUid(UserGongxiangcloudAccount userGongxiangcloudAccount);

    /**
     * 根据ID查询
     * @param uid
     * @return
     */
    public UserGongxiangcloudAccount queryUserGongxiagncloudAccountByUid(Long uid);
}
