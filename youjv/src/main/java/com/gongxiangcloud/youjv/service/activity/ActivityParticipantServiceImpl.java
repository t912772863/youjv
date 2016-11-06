package com.gongxiangcloud.youjv.service.activity;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.SystemConstantInside;
import com.gongxiangcloud.youjv.common.business.SystemConstantOutside;
import com.gongxiangcloud.youjv.core.dao.activity.IActivityParticipantDao;
import com.gongxiangcloud.youjv.core.entity.activity.ActivityParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class ActivityParticipantServiceImpl implements IActivityParticipantService{
    @Autowired
    private IActivityParticipantDao activityParticipantDao;

    public boolean insertActivityParticipant(ActivityParticipant activityParticipant) {
        activityParticipantDao.insert(activityParticipant);
        return true;
    }

    public boolean deleteActivityParticipantById(Long id) {
        activityParticipantDao.deleteById(id);
        return true;
    }

    public boolean updateActivityParticipantById(Long id, ActivityParticipant activityParticipant) {
        activityParticipant.setId(id);
        activityParticipantDao.updateById(activityParticipant);
        return true;
    }

    public ActivityParticipant queryActivityParticipantById(Long id) {
        return activityParticipantDao.queryById(id);
    }

    public List<ActivityParticipant> queryActivityParticipantByActivityId(Long activityId) {
        List<ActivityParticipant> list = activityParticipantDao.queryByActivityId(activityId);
        if(list == null){
            list = new ArrayList<ActivityParticipant>();
        }
        return list;
    }

    public boolean checkParticipant(Long activityParticipantId, String type) {
        ActivityParticipant activityParticipant = activityParticipantDao.queryById(activityParticipantId);
        if(SystemConstantOutside.ACTIVITY_CHECK_PASS.equals(type)){
            activityParticipant.setParticipantStatus(SystemConstantInside.PARTICIPANT_STATUS_PASS);
        }else if(SystemConstantOutside.ACTIVITY_CHECK_DENY.equals(type)){
            activityParticipant.setParticipantStatus(SystemConstantInside.PARTICIPANT_STATUS_DENY);
        }else{
            throw new BusinessException("未知的审核类型");
        }
        activityParticipantDao.updateById(activityParticipant);
        return true;
    }
}
