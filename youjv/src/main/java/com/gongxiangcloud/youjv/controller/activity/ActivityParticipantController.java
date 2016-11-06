package com.gongxiangcloud.youjv.controller.activity;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.service.activity.IActivityParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianxiong on 16/10/14.
 */
@Controller
@RequestMapping("activity_participant")
public class ActivityParticipantController extends BaseController {
    @Autowired
    private IActivityParticipantService activityParticipantService;

    /**
     * 审核活动报名接口
     * @param activityParticipantId 参与事件id,唯一标识
     * @param type 审核结果 PASS:通过   DENY:不通过
     * @return
     */
    @RequestMapping("check_participant")
    @ResponseBody
    public String checkParticipant(Long activityParticipantId,String type){
        boolean b = activityParticipantService.checkParticipant(activityParticipantId, type);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }


    /**
     * 活动签到接口
     * @param activityId
     * @param createUid
     * @param participantUid
     * @return
     */
    @RequestMapping("sign")
    @ResponseBody
    public String sign(Long activityId,Long createUid,Long participantUid){
        //// TODO: 16/10/14 签到逻辑待定

        return GsonUtil.toJson(successData.setData(true),ResponseData.class);
    }

    /**
     * 用户报名/取消报名接口
     * @param uid  用户标识
     * @param activityId 活动标识
     * @param type 类型: APPLY:报名   CANCEL:取消报名
     * @return
     */
    @RequestMapping("participant")
    @ResponseBody
    public String participant(Long uid,Long activityId,String type){
        return GsonUtil.toJson(successData.setData(true),ResponseData.class);
    }

}
