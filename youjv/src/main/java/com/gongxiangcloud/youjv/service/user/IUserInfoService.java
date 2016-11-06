package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.entity.user.UserInfo;

import java.util.List;

/**
 * Created by tianxiong on 16/10/7.
 */
public interface IUserInfoService {

    /**
     * 新增一个
     * @param userInfo
     * @return
     */
    public boolean insertUserInfo(UserInfo userInfo);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteUserInfoById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param userInfo
     * @return
     */
    public boolean updateUserInfoByUid(Long id, UserInfo userInfo);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public UserInfo queryUserInfoByUid(Long id);


    /**
     * 根据UID批量查询
     * @param uidList
     * @return
     */
    public List<UserInfo> queryUserInfoByUidList(List<Long> uidList);
}
