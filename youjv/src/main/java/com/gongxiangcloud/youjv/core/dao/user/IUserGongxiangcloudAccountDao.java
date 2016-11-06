package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IUserGongxiangcloudAccountDao {
    public UserGongxiangcloudAccount queryByUid(Long uid);

    public void updateByUid(UserGongxiangcloudAccount account);
}
