package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.common.business.RedisFactory;
import com.gongxiangcloud.youjv.common.business.SystemConstantInside;
import com.gongxiangcloud.youjv.common.business.SystemConstantThird;
import com.gongxiangcloud.youjv.common.thirdservice.shortmessage.ShortMessageFactory;
import com.gongxiangcloud.youjv.core.dao.user.IUserLoginDao;
import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import com.gongxiangcloud.youjv.core.entity.user.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    private IUserLoginDao userLoginDao;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IUserGongxiangcloudAccountService userGongxiangcloudAccountService;


    public boolean insertUserLogin(UserLogin userLogin) {

        // 在user_login中插入数据
        userLogin.setCreateTime(new Date());
        userLogin.setStatus(SystemConstantInside.DATA_STATUS_NORMAL);
        userLoginDao.insert(userLogin);

        // 在user_info中插入数据
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(userLogin.getUid());
        userInfo.setCreateTime(new Date());
        userInfo.setDegrees(-1);
        userInfo.setStatus(SystemConstantInside.DATA_STATUS_NORMAL);
        userInfoService.insertUserInfo(userInfo);

        // 在用户的平台帐号里面插入一条记录
        UserGongxiangcloudAccount userGongxiangcloudAccount = new UserGongxiangcloudAccount();
        userGongxiangcloudAccount.setUid(userLogin.getUid());
        userGongxiangcloudAccountService.insertUserGongxiangcloudAccount(userGongxiangcloudAccount);

        return true;
    }

//    public boolean deleteUserLoginById(Long id) {
//        return false;
//    }
//

    /**
     * 增量更新,根据UID
     * @param uid
     * @param userLogin
     * @return
     */
    public boolean updateUserLoginByUid(Long uid, UserLogin userLogin) {
        userLogin.setUid(uid);
        userLoginDao.updateByUid(userLogin);

        return false;
    }


    /**
     * 根据UID查询用户登录信息
     * @param uid
     * @return
     */
    public UserLogin queryUserLoginByUid(Long uid) {

        return userLoginDao.queryByUid(uid);
    }

    /**
     * 手机号唯一性的验证
     * @param mobile
     * @return
     */
    public boolean mobileVerify(String mobile) {
        UserLogin userLogin = userLoginDao.queryByMobile(mobile);
        return userLogin==null?true:false;
    }

    /**
     * redis对数据做一个缓存
     * @param mobile 手机号
     * @param verifyCode 验证码
     * @return
     */
    public boolean checkVerifyCode(String mobile, String verifyCode) {
        //从redis中获取值与传过来的值对比
        String val = RedisFactory.jedis.get(mobile);

        return verifyCode.equals(val);
    }

    /**
     * 根据手机号和密码查询(登录用)
     * @param mobile
     * @param password
     * @return
     */
    public UserLogin queryUserLoginByMobileAndPassword(String mobile, String password) {
        UserLogin userLogin = userLoginDao.queryByMobileAndPassword(mobile,password);
        // 如果为空说明登录失败,直接返回null
        if(userLogin == null){
            return userLogin;
        }
        // 如果不为空把其它信息一起查出来放入对象中返回

        return userLogin;
    }

    /**
     *
     * @param mobile 手机号
     * @param type 不同的业务场景,在第三方短信平台有不同的短信模版
     * @return
     */
    public String sendMessage(String mobile, String type) {
        return ShortMessageFactory.sendMessage(mobile,type);
    }

    /**
     * 根据用户UID和用户密码来查询
     * @param uid
     * @param password
     * @return
     */
    public UserLogin queryUserLoginByUidAndPassword(Long uid, String password) {
        return userLoginDao.queryByUidAndPassword(uid,password);
    }
}
