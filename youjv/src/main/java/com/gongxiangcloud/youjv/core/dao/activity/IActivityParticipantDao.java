package com.gongxiangcloud.youjv.core.dao.activity;

import com.gongxiangcloud.youjv.core.entity.activity.ActivityParticipant;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IActivityParticipantDao {
    /**
     * 新增一条数据
     * @param activityParticipant
     */
    public void insert(ActivityParticipant activityParticipant);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param activityParticipant
     */
    public void updateById(ActivityParticipant activityParticipant);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public ActivityParticipant queryById(Long id);

    /**
     * 根据活动ID查询某个活动的所有参与信息
     * @param activityId
     * @return
     */
    public List<ActivityParticipant> queryByActivityId(Long activityId);

}
