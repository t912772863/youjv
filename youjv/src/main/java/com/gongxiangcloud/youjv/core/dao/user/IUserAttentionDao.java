package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.core.entity.user.UserAttention;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IUserAttentionDao {
    /**
     * 新增一条数据
     * @param userAttention
     */
    public void insert(UserAttention userAttention);

    /**
     * 根据关注者ID和被关注者ID删除一条数据
     * @param uid
     * @param followUid
     */
    public void deleteByUidAndFollowUid(Long uid,Long followUid);
}
