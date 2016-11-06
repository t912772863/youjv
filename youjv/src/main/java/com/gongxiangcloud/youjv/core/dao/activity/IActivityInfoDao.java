package com.gongxiangcloud.youjv.core.dao.activity;

import com.gongxiangcloud.youjv.core.entity.activity.ActivityInfo;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IActivityInfoDao {
    /**
     * 新增一条数据
     * @param activityInfo
     */
    public void insert(ActivityInfo activityInfo);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param activityInfo
     */
    public void updateById(ActivityInfo activityInfo);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public ActivityInfo queryById(Long id);

}
