package com.gongxiangcloud.youjv.service.activity;

import com.gongxiangcloud.youjv.common.dto.ActivityDetailDto;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityInfo;

import java.util.List;

/**
 * 活动详情表业务层
 * Created by tianxiong on 16/10/9.
 */
public interface IActivityInfoService {
    /**
     * 新境
     * @param activityInfo
     * @return
     */
    public boolean insertActivityInfo(ActivityInfo activityInfo);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteActivityInfoById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param activityInfo
     * @return
     */
    public boolean updateActivityInfoById(Long id,ActivityInfo activityInfo);

    /**
     * 根据id查询 单表查询
     * @param id
     * @return
     */
    public ActivityInfo queryActivityInfoById(Long id);

    /**
     * 根据id查询详情(会查很多东西,非必要少用)
     * @param id
     * @return
     */
    public ActivityDetailDto queryActivityInfoDetailById(Long id);

    /**
     * 查询附近的活动接口
     * @param nowLocation 当前的经纬度地址
     * @param radius 查询半经(单位:千米)
     * @param free 是否免费
     * @param timeSlot 活动开始时间段
     * @param haveFriend 是否有好友参加
     * @return
     */
    public List<ActivityInfo> queryActivityNearby(String nowLocation,Integer radius,Boolean free, String timeSlot, Boolean haveFriend);

    /**
     * 活动热度统计接口
     * @param id 活动ID
     * @param type 热度类型
     * @return
     */
    public boolean hotCount(Long id,String type);

    /**
     * 取消某个活动
     * @param activityId
     * @return
     */
    public boolean cancelActivity(Long activityId);
}
