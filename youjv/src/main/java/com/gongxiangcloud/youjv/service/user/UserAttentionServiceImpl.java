package com.gongxiangcloud.youjv.service.user;

import com.gongxiangcloud.youjv.core.dao.user.IUserAttentionDao;
import com.gongxiangcloud.youjv.core.entity.user.UserAttention;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class UserAttentionServiceImpl implements IUserAttentionService {
    @Autowired
    private IUserAttentionDao userAttentionDao;

    public boolean insertUserAttention(UserAttention userAttention) {
        userAttentionDao.insert(userAttention);
        return true;
    }



    public boolean attention(Long uid, Long followUid, Boolean attention) {
        if(attention){
            //关注
            UserAttention userAttention = new UserAttention();
            userAttention.setCreateTime(new Date());
            userAttention.setUid(uid);
            userAttention.setFollowUid(followUid);
            userAttentionDao.insert(userAttention);
        }else{
            //取关
            userAttentionDao.deleteByUidAndFollowUid(uid, followUid);
        }

        return true;
    }

    public List<UserInfo> queryFriends(Long uid, String type) {
//        List<UserAttention> attentionList = userAttentionDao.

        return null;
    }
}
