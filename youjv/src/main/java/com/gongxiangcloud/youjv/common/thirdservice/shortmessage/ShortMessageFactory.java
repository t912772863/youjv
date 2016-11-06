package com.gongxiangcloud.youjv.common.thirdservice.shortmessage;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.RedisFactory;
import com.gongxiangcloud.youjv.common.business.SystemConstantOutside;
import com.gongxiangcloud.youjv.common.business.SystemConstantThird;
import com.gongxiangcloud.youjv.common.utils.Md5Util;
import com.gongxiangcloud.youjv.common.utils.RandomCodeUtil;
import com.gongxiangcloud.youjv.common.utils.ReadPropertiesUtil;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;

/**
 *云信短信服务的一些方法封装
 * Created by tianxiong on 16/10/10.
 */
@Component
public class ShortMessageFactory {
    private static String username;
    private static String password;
    private static String url;

    /**
     * 初始化数据
     */
    static{
        try{
            // 得到项目中配置文件的绝对路径
            URL fileUrl = ShortMessageFactory.class.getClassLoader().getResource("business.properties");

            //读取配置文件
            ReadPropertiesUtil readPropertiesUtil = new ReadPropertiesUtil(fileUrl.getPath());
            ShortMessageFactory.username = readPropertiesUtil.readValue("username");
            ShortMessageFactory.password = readPropertiesUtil.readValue("password");
            ShortMessageFactory.url = readPropertiesUtil.readValue("url");

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("初始化数据异常");
        }

    }


    /**
     * 发送短信
     * 外部传过来的的场景,在这里在转换成为对应的三方平台的模版唯一标识
     * @param phone 接收短信的手机号
     * @param type 发送短信的业务场景类型
     */
    // http://api.sms.cn/sms/?ac=send&uid=用户账号&pwd=MD532位密码&mobile=号码&content={"key":"内容"}
    public static String sendMessage(String phone,String type){
        String template;
        if(SystemConstantOutside.MESSAGE_SIGNUP.equals(type)){
            template = SystemConstantThird.MESSAGE_SIGNUP_TEMPLATE;
        }else if(SystemConstantOutside.MESSAGE_FORGET.equals(type)){
            template = SystemConstantThird.MESSAGE_FORGET_TEMPLATE;
        }else {
            throw new BusinessException("发送短信时,参数不合法");
        }

        //创建一个请求
        HttpClient client = new HttpClient();
        //使用POST方法
        PostMethod method = new PostMethod(url);

        String code = RandomCodeUtil.randomNumber();
        //组装请求参数
        method.addParameter("ac","send");
        method.addParameter("uid",username);
        method.addParameter("pwd", Md5Util.encryption(password+username));
        method.addParameter("mobile",phone);
        method.addParameter("content","{\"code\":\""+ code +"\"}");
        method.addParameter("template",template);


        try {
            client.executeMethod(method);
            String resultBody = method.getResponseBodyAsString();
            JSONObject json= JSONObject.fromObject(resultBody);
            if(!SystemConstantThird.MESSAGE_SEND_SUCCESS.equals(json.get("stat").toString())){
                throw new BusinessException("短信发送失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            method.releaseConnection();
            throw new RuntimeException("发送短信出现异常");
        }

        //发送成功后,把这个手机号和验证码放入redis中,设置一个超时时间6分钟
        RedisFactory.jedis.setex(phone,360,code);
        return code;
    }

    public static void main(String[] args) throws Exception{

        // 得到当前工程的绝对路径
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath() ;
        System.out.println(courseFile);

        //在项目目录下查找某一个文件的绝对路径
        ShortMessageFactory s = new ShortMessageFactory();
        URL xmlpath = s.getClass().getClassLoader().getResource("business.properties");
        String path = xmlpath.getPath();
        System.out.println(path);
    }

}
