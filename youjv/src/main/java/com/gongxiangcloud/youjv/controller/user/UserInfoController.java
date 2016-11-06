package com.gongxiangcloud.youjv.controller.user;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import com.gongxiangcloud.youjv.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by tianxiong on 16/10/7.
 */
@Controller
@RequestMapping("/user_info")
public class UserInfoController extends BaseController {

    @Autowired
    private IUserInfoService userInfoService;



    /**
     * 根据UID查询用户的信息
     *
     * @param uid
     * @return
     */
    @RequestMapping("/query_user_info_by_uid")
    @ResponseBody
    public String queryUserById(Long uid) {
        UserInfo userInfo = userInfoService.queryUserInfoByUid(uid);
        return GsonUtil.toJson(successData.setData(userInfo), ResponseData.class);
    }

    /**
     * 根据UID更新用户个人信息
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("update_user_info_by_uid")
    @ResponseBody
    public String updateUserInfoByUid(UserInfo userInfo) {
        if (userInfo.getUid() == null) {
            return GsonUtil.toJson(failedData.setMsg("更新时,UID不能为空"), ResponseData.class);
        }
        boolean result = userInfoService.updateUserInfoByUid(userInfo.getUid(), userInfo);
        return GsonUtil.toJson(successData.setData(result), ResponseData.class);

    }

    /**
     * 上传用户的头像图片
     *
     * @param headImage 头像图片的多媒体文件
     * @return
     */
    @RequestMapping("update_head_image")
    @ResponseBody
    public String updateHeadImage(@RequestParam MultipartFile headImage, Long uid) {
        if(headImage == null || uid == null){
            return GsonUtil.toJson(failedData.setMsg("上传头像参数错误"),ResponseData.class);
        }

        // 存储图片的物理路径
        String imagePath = this.imageLocalPre+"/images";
        // 拿到上传的图片的名字
        String imageName = headImage.getOriginalFilename();
        // 重新命名图片名,防止同名冲突
        String newName = new Date().getTime() + imageName.substring(imageName.lastIndexOf("."));
        // 新的图片的全名(包括路径)
        File file = new File(imagePath +"/"+ newName);
        // 存储图片
        try {
            headImage.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("上传图片失败");
        }
        // 上传成功,把路径存入到数据库中
        UserInfo userInfo = userInfoService.queryUserInfoByUid(uid);
        userInfo.setHeadImage(this.imageTomcatPre + "/images" + newName);

        return GsonUtil.toJson(successData.setData(this.imageTomcatPre+"/"+newName),ResponseData.class);
    }


}
