package com.gongxiangcloud.youjv.core.dao.user;


import com.gongxiangcloud.youjv.core.entity.user.UserInfo;

import java.util.List;

/**
 * Created by tianxiong on 16/10/7.
 */
public interface IUserInfoDao {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public UserInfo queryById(Long id);

    /**
     * 新增
     * @param user
     */
    public void insert(UserInfo user);

    /**
     * 根据ID删除
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新
     * @param userInfo
     */
    public void updateById(UserInfo userInfo);

    /**
     * 根据ID集合批量查询多个
     * @param uidList
     * @return
     */
    public List<UserInfo> queryByUidList(List<Long> uidList);

}
