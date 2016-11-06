package com.gongxiangcloud.youjv.service.activity;

import com.gongxiangcloud.youjv.core.entity.activity.ActivityParticipant;

import java.util.List;

/**
 * 用户服名活动记录表
 * Created by tianxiong on 16/10/9.
 */
public interface IActivityParticipantService {
    /**
     * 新增一个
     * @param activityParticipant
     * @return
     */
    public boolean insertActivityParticipant(ActivityParticipant activityParticipant);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteActivityParticipantById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param activityInfo
     * @return
     */
    public boolean updateActivityParticipantById(Long id,ActivityParticipant activityInfo);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public ActivityParticipant queryActivityParticipantById(Long id);

    /**
     * 根据活动ID查询出所有的参与情况
     * @param activityId
     * @return
     */
    public List<ActivityParticipant> queryActivityParticipantByActivityId(Long activityId);

    /**
     * 审核报名活动
     * @param activityParticipantId
     * @param type
     * @return
     */
    public boolean checkParticipant(Long activityParticipantId,String type);

}
