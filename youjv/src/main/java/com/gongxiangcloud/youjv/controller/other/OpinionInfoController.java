package com.gongxiangcloud.youjv.controller.other;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.other.OpinionInfo;
import com.gongxiangcloud.youjv.service.other.IOpinionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianxiong on 16/10/14.
 */
@Controller
@RequestMapping("opinion_info")
public class OpinionInfoController extends BaseController {
    @Autowired
    private IOpinionInfoService opinionInfoService;

    /**
     * 新增反馈信息接口
     * @param opinionInfo
     * @return
     */
    @RequestMapping("insert_opinion_info")
    @ResponseBody
    public String insertOpinionInfo(OpinionInfo opinionInfo){
        boolean b = opinionInfoService.insertOpinionInfo(opinionInfo);
        return GsonUtil.toJson(successData.setData(b), ResponseData.class);
    }

}
