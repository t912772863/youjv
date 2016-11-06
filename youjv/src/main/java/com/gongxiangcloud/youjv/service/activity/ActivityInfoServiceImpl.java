package com.gongxiangcloud.youjv.service.activity;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.SystemConstantOutside;
import com.gongxiangcloud.youjv.common.dto.ActivityDetailDto;
import com.gongxiangcloud.youjv.common.dto.ActivityParticipantDto;
import com.gongxiangcloud.youjv.common.thirdservice.gaodemap.Data;
import com.gongxiangcloud.youjv.core.dao.activity.IActivityInfoDao;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityInfo;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityParticipant;
import com.gongxiangcloud.youjv.core.entity.trade.OrderInfo;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import com.gongxiangcloud.youjv.service.trade.IOrderInfoService;
import com.gongxiangcloud.youjv.service.user.IUserInfoService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tianxiong on 16/10/9.
 */
@Service
public class ActivityInfoServiceImpl implements IActivityInfoService {
    @Autowired
    private IActivityInfoDao activityInfoDao;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IActivityParticipantService activityParticipantService;
    @Autowired
    private IOrderInfoService orderInfoService;

    public boolean insertActivityInfo(ActivityInfo activityInfo) {
        // 插入前先同步到高德云图
        String mapDataId = Data.create(activityInfo.getName(),activityInfo.getHoldLocation(),activityInfo.getAddress());
        activityInfo.setMapDataId(mapDataId);
        activityInfoDao.insert(activityInfo);
        return true;
    }

    public boolean deleteActivityInfoById(Long id) {
        activityInfoDao.deleteById(id);
        return true;
    }

    public boolean updateActivityInfoById(Long id, ActivityInfo activityInfo) {
        return false;
    }

    public ActivityInfo queryActivityInfoById(Long id) {
        return activityInfoDao.queryById(id);
    }

    public ActivityDetailDto queryActivityInfoDetailById(Long id) {
        ActivityInfo activityInfo = activityInfoDao.queryById(id);
        if(activityInfo == null){
            return null;
        }
        ActivityDetailDto activityDetailDto = new ActivityDetailDto();

        //查询出活动基本信息

        //查询出活动创建者信息
        UserInfo createUser = userInfoService.queryUserInfoByUid(activityInfo.getCreateUid());

        //查询出活动参与者和参与情况信息
            //参与情况信息
        List<ActivityParticipant> activityParticipantList = activityParticipantService.queryActivityParticipantByActivityId(id);
            //提取所有参与者id,查询出所有参与者信息; 提取出所有订单id,查询订单
        List<Long> participantUidList = new ArrayList<Long>();
        List<Long> orderIdList = new ArrayList<Long>();
        for(ActivityParticipant a : activityParticipantList){
            participantUidList.add(a.getParticipantUid());
            orderIdList.add(a.getOrderId());
        }
            //查询出所有参与者信息
        List<UserInfo> paticipantUserList = userInfoService.queryUserInfoByUidList(participantUidList);
            //查询出所有订单信息
        List<OrderInfo> orderInfoList = orderInfoService.queryOrderInfoByIdList(orderIdList);


            // 转换成map,方便组装
        Map<Long,UserInfo> userInfoMap = new HashedMap();
        Map<Long,OrderInfo> orderInfoMap = new HashedMap();
        for(UserInfo u : paticipantUserList){
            userInfoMap.put(u.getUid(),u);
        }
        for(OrderInfo o : orderInfoList){
            orderInfoMap.put(o.getId(),o);
        }

            // 把参与者,订单和其对应的情况组装
        List<ActivityParticipantDto> participantDtoList = new ArrayList<ActivityParticipantDto>();
        for(ActivityParticipant a : activityParticipantList){
            ActivityParticipantDto activityParticipantDto = new ActivityParticipantDto();
            try {
                BeanUtils.copyProperties(activityParticipantDto,a);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException("bean属性转换时出现异常");
            }
            activityParticipantDto.setParticipantUser(userInfoMap.get(activityParticipantDto.getParticipantUid()));
            if(activityParticipantDto.getOrderId() != null){
                activityParticipantDto.setOrderInfo(orderInfoMap.get(activityParticipantDto.getOrderId()));
            }

            participantDtoList.add(activityParticipantDto);
        }

        try {
            BeanUtils.copyProperties(activityDetailDto,activityInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("bean属性转换时出现异常");
        }
        activityDetailDto.setCreateUser(createUser);
        activityDetailDto.setActivityParticipantDtoList(participantDtoList);
        return activityDetailDto;
    }

    public List<ActivityInfo> queryActivityNearby(String nowLocation, Integer radius, Boolean free, String timeSlot, Boolean haveFriend) {
        // // TODO: 16/10/14  ...好复杂的逻辑,还要调用谷歌地图,有时间再写吧
        List<ActivityInfo> list = new ArrayList<ActivityInfo>();
        ActivityInfo a = queryActivityInfoById(1L);
        list.add(a);
        return list;
    }

    public boolean hotCount(Long id, String type) {
        ActivityInfo activityInfo = activityInfoDao.queryById(id);
        if(SystemConstantOutside.ACTIVITY_HOT_READ.equals(type)){
            activityInfo.setReadTime(activityInfo.getReadTime()+1);
        }else if(SystemConstantOutside.ACTIVITY_HOT_SHARE.equals(type)){
            activityInfo.setShareTime(activityInfo.getShareTime()+1);
        }else{
            throw new BusinessException("未知热度类型");
        }

        activityInfoDao.updateById(activityInfo);
        return true;
    }

    public boolean cancelActivity(Long activityId) {
        //// TODO: 16/10/14
        // 查找活动,判断这个时间段是否可以取消

        // 可以取消,取消后的关联操作
            // 相关通知
            // 付费活动,相关订单的退款,等等

        return true;
    }
}
