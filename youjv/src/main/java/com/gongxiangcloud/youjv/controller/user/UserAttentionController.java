package com.gongxiangcloud.youjv.controller.user;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import com.gongxiangcloud.youjv.service.user.IUserAttentionService;
import com.gongxiangcloud.youjv.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxiong on 16/10/14.
 */
@Controller
@RequestMapping("user_attention")
public class UserAttentionController extends BaseController {
    @Autowired
    private IUserAttentionService userAttentionService;
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 用户关注/取关接口
     * @param uid
     * @param followUid
     * @param attenion
     * @return
     */
    @RequestMapping("attention")
    @ResponseBody
    public String attention(Long uid,Long followUid,Boolean attenion){
        boolean b = userAttentionService.attention(uid, followUid, attenion);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }


    /**
     * 查询好友列表接口
     * @param uid
     * @param type
     * @return
     */
    @RequestMapping("query_friends")
    @ResponseBody
    public String queryFriends(Long uid,String type){
        //// TODO: 16/10/16
        
        List<UserInfo> list = new ArrayList();
        list.add(userInfoService.queryUserInfoByUid(1L));

        return GsonUtil.toJson(successData.setData(list),ResponseData.class);

    }


}
