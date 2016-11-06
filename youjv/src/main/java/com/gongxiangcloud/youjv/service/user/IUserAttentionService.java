package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.entity.user.UserAttention;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IUserAttentionService {
    /**
     * 新增一个
     * @param userAttention
     * @return
     */
    public boolean insertUserAttention(UserAttention userAttention);


    /**
     * 用户关注/取关
     * @param uid
     * @param followUid
     * @param attention true为关注, false为取关
     * @return
     */
    public boolean attention(Long uid, Long followUid, Boolean attention);

    /**
     * 查询好友接口
     * @param uid 用户ID
     * @param type 好友类型(相互关注,主动关注,被关注)
     * @return
     */
    public List<UserInfo> queryFriends(Long uid,String type);
}
