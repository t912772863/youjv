package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.dao.user.IUserGongxiangcloudAccountDao;
import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class UserGongxiagncloudAccountServiceImpl implements IUserGongxiangcloudAccountService {
    @Autowired
    private IUserGongxiangcloudAccountDao userGongxiangcloudAccountDao;

    public boolean insertUserGongxiangcloudAccount(UserGongxiangcloudAccount userGongxiangcloudAccount) {
        return false;
    }

    public boolean deleteUserGongxiangcloudAccountById(Long id) {
        return false;
    }

    public boolean updateUserGongxiangcloudAccountByUid(UserGongxiangcloudAccount userGongxiangcloudAccount) {
        userGongxiangcloudAccountDao.updateByUid(userGongxiangcloudAccount);
        return true;
    }

    public UserGongxiangcloudAccount queryUserGongxiagncloudAccountByUid(Long uid) {
        return userGongxiangcloudAccountDao.queryByUid(uid);
    }
}
