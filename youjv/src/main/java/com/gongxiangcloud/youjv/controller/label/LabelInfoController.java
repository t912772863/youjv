package com.gongxiangcloud.youjv.controller.label;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import com.gongxiangcloud.youjv.common.utils.GsonUtil;
import com.gongxiangcloud.youjv.controller.common.BaseController;
import com.gongxiangcloud.youjv.core.entity.label.LabelInfo;
import com.gongxiangcloud.youjv.service.label.ILabelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 标签相关的控制层
 * Created by tianxiong on 16/10/14.
 */
@Controller
@RequestMapping("label_info")
public class LabelInfoController extends BaseController{
    @Autowired
    private ILabelInfoService labelInfoService;

    /**
     * 新增一个标签
     * @param labelInfo
     * @return
     */
    @RequestMapping("insert_label_info")
    @ResponseBody
    public String insertLabelInfo(LabelInfo labelInfo){
        labelInfoService.insertLabelIfNeed(labelInfo);
        return GsonUtil.toJson(successData.setData(null),ResponseData.class);
    }

    /**
     * 查询标签(不同的引导)
     * @param level
     * @param type
     * @return
     */
    @RequestMapping("query_label")
    @ResponseBody
    public String queryLabel(Integer level,String type){
        if(level == null){
            level = 2;
        }
        List<LabelInfo> labelInfoList = labelInfoService.queryLabel(level,type);

        return GsonUtil.toJson(successData.setData(labelInfoList), ResponseData.class);
    }

}
