package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.dao.user.IUserInfoDao;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxiong on 16/10/7.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao userDao;


    public boolean insertUserInfo(UserInfo userInfo) {
        userDao.insert(userInfo);
        return true;
    }

    public boolean deleteUserInfoById(Long id) {
        userDao.deleteById(id);
        return true;
    }

    public boolean updateUserInfoByUid(Long id, UserInfo userInfo) {
        userInfo.setUid(id);
        userDao.updateById(userInfo);
        return true;
    }

    public UserInfo queryUserInfoByUid(Long uid) {
        return userDao.queryById(uid);
    }

    public List<UserInfo> queryUserInfoByUidList(List<Long> uidList) {
        List<UserInfo> userInfoList = userDao.queryByUidList(uidList);
        if(userInfoList == null){
            return new ArrayList<UserInfo>();
        }
        return userInfoList;
    }
}
