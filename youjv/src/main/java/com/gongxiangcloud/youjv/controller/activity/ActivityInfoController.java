package com.gongxiangcloud.youjv.controller.activity;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.dto.ActivityDetailDto;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityInfo;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import com.gongxiangcloud.youjv.service.activity.IActivityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 活动相关控制层
 * Created by tianxiong on 16/10/9.
 */
@Controller
@RequestMapping("activity_info")
public class ActivityInfoController extends BaseController{
    @Autowired
    private IActivityInfoService activityInfoService;

    /**
     * 新增活动接口
     * @param activityInfo
     * @return
     */
    @RequestMapping("insert_activity_info")
    @ResponseBody
    public String insertActivityInfo(ActivityInfo activityInfo,String labelIds){
        //// TODO: 16/10/17 标签ID如何存和修改待确定
        boolean b = activityInfoService.insertActivityInfo(activityInfo);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

    /**
     * 删除活动
     * @param id
     * @return
     */
//    @RequestMapping("/deleteActivityInfoById")
//    @ResponseBody
//    public String deleteActivityInfoById(Long id){
//        System.out.println("======");
//        activityInfoService.deleteActivityInfoById(id);
//        return "success";
//    }

    /**
     * 根据ID查询活动详情
     * @param id
     * @return
     */
    @RequestMapping("query_activity_detail_by_id")
    @ResponseBody
    public String queryActivityDetailById(Long id){
        ActivityDetailDto activityDetailDto = activityInfoService.queryActivityInfoDetailById(id);
        return GsonUtil.toJson(successData.setData(activityDetailDto), ResponseData.class);
    }

    /**
     * 查询附近的活动接口
     * @param nowLocation 当前的经纬度地址
     * @param radius 查询半经(单位:千米)
     * @param free 是否免费
     * @param timeSlot 活动开始时间段
     * @param haveFriend 是否有好友参加
     * @return
     */
    @RequestMapping("query_activity_nearby")
    @ResponseBody
    public String queryActivityNearby(String nowLocation,Integer radius,Boolean free, String timeSlot, Boolean haveFriend){
        List<ActivityInfo> list = activityInfoService.queryActivityNearby(nowLocation, radius, free, timeSlot, haveFriend);
        return GsonUtil.toJson(successData.setData(list), ResponseData.class);
    }

    /**
     * 查询某个用户创建的活动
     * @param uid
     * @return
     */
    @RequestMapping("query_activity_create")
    @ResponseBody
    public String queryActivityCreate(Long uid){
        //todo
        List<ActivityInfo> list = activityInfoService.queryActivityNearby(null, null, null, null, null);
        return GsonUtil.toJson(successData.setData(list), ResponseData.class);
    }

    /**
     * 查询某个用户参加的活动
     * @param uid
     * @return
     */
    @RequestMapping("query_activity_join")
    @ResponseBody
    public String queryActivityJoin(Long uid){
        // TODO
        List<ActivityInfo> list = activityInfoService.queryActivityNearby(null, null, null, null, null);
        return GsonUtil.toJson(successData.setData(list), ResponseData.class);
    }

    /**
     * 活动热度统计接口
     * @param activityId 活动ID
     * @param type 热度类型: READ,阅读次数;   SHARE,分享次数
     * @return
     */
    @RequestMapping("query_activity_join")
    @ResponseBody
    public String hotCount(Long activityId,String type){
        boolean b = activityInfoService.hotCount(activityId, type);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

    /**
     * 取消活动接口
     * @param activityId
     * @return
     */
    @RequestMapping("cancel_activity")
    @ResponseBody
    public String cancelActivity(Long activityId){
        boolean b = activityInfoService.cancelActivity(activityId);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

    /**
     * 上传活动详情的图片接口
     * @param image
     * @return
     */
    @RequestMapping("upload_activity_image")
    @ResponseBody
    public String uploadActivityImage(@RequestParam MultipartFile image){
        if(image == null){
            return GsonUtil.toJson(failedData.setMsg("上传图片参数错误"),ResponseData.class);
        }

        // 存储图片的物理路径
        String imagePath = this.imageLocalPre+"/images";
        // 拿到上传的图片的名字
        String imageName = image.getOriginalFilename();
        // 重新命名图片名,防止同名冲突
        String newName = new Date().getTime() + imageName.substring(imageName.lastIndexOf("."));
        // 新的图片的全名(包括路径)
        File file = new File(imagePath +"/"+ newName);
        // 存储图片
        try {
            image.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("上传图片失败");
        }
        return GsonUtil.toJson(successData.setData(this.imageTomcatPre + "/images" + newName),ResponseData.class);
    }

}
