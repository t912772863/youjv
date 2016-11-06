package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.dao.user.IUserWxAccountDao;
import com.gongxiangcloud.youjv.core.entity.user.UserWxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class UserWxAccountServiceImpl implements IUserWxAccountService {
    @Autowired
    private IUserWxAccountDao userWxAccountDao;

    public boolean insertUserWxAccount(UserWxAccount userWxAccount) {
//        userWxAccountDao
        return false;
    }

//    public boolean deleteUserWxAccountById(Long id) {
//        return false;
//    }
//
//    public boolean updateUserWxAccountById(Long id, UserWxAccount userWxAccount) {
//        return false;
//    }
//
//    public UserWxAccount queryUserWxAccountById(Long id) {
//        return null;
//    }
}
