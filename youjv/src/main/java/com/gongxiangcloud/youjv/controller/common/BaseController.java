package com.gongxiangcloud.youjv.controller.common;

import com.gongxiangcloud.youjv.common.business.ResponseData;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by tianxiong on 16/10/10.
 */
public class BaseController {
    @Value("#{settings['image_local_pre']}")
    protected String imageLocalPre;
    @Value("#{settings['image_tomcat_pre']}")
    protected String imageTomcatPre;


    /**
     * 成功返回数据的封装
     */
    protected ResponseData successData = ResponseData.SUCCESS_DATA;

    /**
     * 失败返回数据封装
     */
    protected ResponseData failedData = ResponseData.FAILED_DATA;
}
