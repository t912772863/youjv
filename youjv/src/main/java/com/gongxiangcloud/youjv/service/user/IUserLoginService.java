package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.entity.user.UserLogin;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IUserLoginService {
    /**
     * 新增一个
     * @param userLogin
     * @return
     */
    public boolean insertUserLogin(UserLogin userLogin);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
//    public boolean deleteUserLoginById(Long id);

    /**
     * 根据ID更新
     * @param uid
     * @param userLogin
     * @return
     */
    public boolean updateUserLoginByUid(Long uid,UserLogin userLogin);

    /**
     * 根据ID查询
     * @param Uid
     * @return
     */
    public UserLogin queryUserLoginByUid(Long Uid);

    /**
     * 校验前端传过来的手机验证码是否正确
     * @param mobile 手机号
     * @param verifyCode 验证码
     * @return 通过返回true,否则返回false
     */
    public boolean checkVerifyCode(String mobile,String verifyCode);

    /**
     * 手机唯一性的校验
     * @param mobile
     * @return
     */
    public boolean mobileVerify(String mobile);

    /**
     * 用户帐号密码登录
     * @param mobile
     * @param password
     * @return
     */
    public UserLogin queryUserLoginByMobileAndPassword(String mobile,String password);

    /**
     * 给手机发送一个验证码
     * @param mobile 手机号
     * @param type 发送短信的业务场景(在第三方平台,不同的场景对应不同的模版)
     * @return 成功发送到手机上的那个验证码
     */
    public String sendMessage(String mobile,String type);

    /**
     * 根据用户ID和用户密码来查询
     * @param uid
     * @param password
     * @return
     */
    public UserLogin queryUserLoginByUidAndPassword(Long uid,String password);
}
