package com.gongxiangcloud.youjv.controller.user;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.business.ResponseHandlerInterceptor;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.common.utils.Md5Util;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.user.UserLogin;
import com.gongxiangcloud.youjv.service.user.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;

/**
 * Created by tianxiong on 16/10/9.
 */

@Controller
@RequestMapping("/user_login")
public class UserLoginController extends BaseController{
    @Autowired
    private IUserLoginService userLoginService;

    /**
     * 发送验证码
     * @param mobile 手机号
     * @param type 业务场景类型
     * @return
     */
    @RequestMapping("send_message")
    @ResponseBody
    public String sendMessage(String mobile,String type){
        String code = userLoginService.sendMessage(mobile, type);
        return GsonUtil.toJson(successData.setData(code),ResponseData.class);
    }

    /**
     * 校验手机验证码是否正确
     * @param mobile
     * @param verifyCode
     * @return
     */
    @RequestMapping("check_verify_code")
    @ResponseBody
    public String checkVerifyCode(String mobile,String verifyCode){
        //// TODO: 16/10/11 业务层判断手机验证码是否有效
        boolean b = userLoginService.checkVerifyCode(mobile,verifyCode);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

    /**
     * 查看手机号在APP平台是否可用.(如果已存在则不可用)
     * @param mobile
     * @return
     */
    @RequestMapping("mobile_verify")
    @ResponseBody
    public String mobileVerify(String mobile){
        boolean result = userLoginService.mobileVerify(mobile);
        if(!result){
            return GsonUtil.toJson(failedData.setMsg("手机号已经被注册"),ResponseData.class);
        }
        return GsonUtil.toJson(successData.setData(result), ResponseData.class);
    }


    /**
     * 通过手机注册接口
     * @param mobile 手机号
     * @param password 注册密码
     * @param verifyCode 验证码
     * @return
     */
    @RequestMapping("insert_user_login")
    @ResponseBody
    public String insertUserLogin(String mobile,String password,String verifyCode){
        // 先看验证码对不对
        boolean b = userLoginService.checkVerifyCode(mobile,verifyCode);
        // 验证失败,直接返回操作失败
        if(!b){
            return GsonUtil.toJson(failedData.setMsg("验证码有误"), ResponseData.class);
        }
        UserLogin userLogin = new UserLogin();
        // 对密码进行md5加密
        userLogin.setMobile(mobile);
        userLogin.setPassword(Md5Util.encryption(password));
        b = userLoginService.insertUserLogin(userLogin);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

    /**
     * 用户帐号密码登录
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(String mobile, String password, HttpServletRequest request){
        password = Md5Util.encryption(password);
        UserLogin userLogin = userLoginService.queryUserLoginByMobileAndPassword(mobile,password);
        if(userLogin == null){
            return GsonUtil.toJson(failedData.setMsg("登录失败,手机号或者密码错误"),ResponseData.class);
        }
        // 登录成功则把相关信息放入到session中,调其它方法前先验证,用户状态
//        HttpSession session = request.getSession();
//        session.setAttribute("user",userLogin.getUid()+"");
//
//        ResponseHandlerInterceptor.loginUsers.put(userLogin.getUid()+"",userLogin);


        return GsonUtil.toJson(successData.setData(userLogin),ResponseData.class);
    }

    /**
     * 用户注销登录
     * @param uid
     * @return
     */
    @RequestMapping("logout")
    @ResponseBody
    public String logout(Long uid){
        //// TODO: 16/10/13
        return GsonUtil.toJson(successData.setData(true),ResponseData.class);
    }

    /**
     * 忘记密码,重置密码
     * @param uid
     * @param code
     * @param password
     * @return
     */
    @RequestMapping("forget_reset")
    @ResponseBody
    public String forgetReset(Long uid,String code,String password){
        UserLogin userLogin = userLoginService.queryUserLoginByUid(uid);

        //先看验证码对不对
        boolean b = userLoginService.checkVerifyCode(userLogin.getMobile(),code);
        if(!b){
            return GsonUtil.toJson(failedData.setMsg("短信验证码输入有误"),ResponseData.class);
        }

        //重置密码
        userLogin.setPassword(password);
        userLoginService.updateUserLoginByUid(uid,userLogin);

        return GsonUtil.toJson(successData.setData(true),ResponseData.class);

    }

    /**
     * 通过输入旧密码的方式,来修改密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping("update_password")
    @ResponseBody
    public String updatePassword(Long uid,String oldPassword,String newPassword){
        oldPassword = Md5Util.encryption(oldPassword);
        newPassword = Md5Util.encryption(newPassword);
        UserLogin userLogin = userLoginService.queryUserLoginByUidAndPassword(uid,oldPassword);
        if(userLogin == null){
            return GsonUtil.toJson(failedData.setMsg("输入的旧密码有误"),ResponseData.class);
        }
        userLogin.setPassword(newPassword);
        userLoginService.updateUserLoginByUid(uid,userLogin);
        return GsonUtil.toJson(successData.setData(true),ResponseData.class);
    }

    /**
     * 通过第三方平台登录的接口
     * @param type
     * @param openId
     * @return
     */
    @RequestMapping("third_login")
    @ResponseBody
    public String thirdLogin(String type,String openId){
        UserLogin userLogin = userLoginService.queryUserLoginByUid(1L);
        return GsonUtil.toJson(successData.setData(userLogin),ResponseData.class);
    }
}
