package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.core.entity.user.UserLogin;

/**
 * 用户登录帐号信息表
 * Created by tianxiong on 16/10/9.
 */
public interface IUserLoginDao {
    /**
     * 新增一条数据
     * @param userLogin
     */
    public void insert(UserLogin userLogin);

    /**
     * 根据ID删除数据
     * @param id
     */
//    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param userLogin
     */
    public void updateByUid(UserLogin userLogin);

    /**
     * 根据UID查询数据
     * @param Uid
     * @return
     */
    public UserLogin queryByUid(Long Uid);

    /**
     * 根据手机号查询
     * @param mobile
     * @return
     */
    public UserLogin queryByMobile(String mobile);

    /**
     * 根据用户名和密码查询(登录)
     * @param mobile
     * @param password
     * @return
     */
    public UserLogin queryByMobileAndPassword(String mobile,String password);

    /**
     * 根据用户ID和密码来查询
     * @param uid
     * @param password
     * @return
     */
    public UserLogin queryByUidAndPassword(Long uid,String password);
}
