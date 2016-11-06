package com.gongxiangcloud.youjv.common.business;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.List;

/**
 * 针对请求的拦截器
 * Created by tianxiong on 16/10/10.
 */
public class ResponseHandlerInterceptor implements HandlerInterceptor{
    public static Hashtable<String,Object> loginUsers = new Hashtable<String, Object>();

    /**
     * 配置一些请求地址不被拦截
     */
    private List<String> uncheckUrls;

    public List<String> getUncheckUrls() {
        return uncheckUrls;
    }

    public void setUncheckUrls(List<String> uncheckUrls) {
        this.uncheckUrls = uncheckUrls;
    }

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;

        // 获取请求地址的第一层级
//        String requestUrl = httpServletRequest.getRequestURI();
//        requestUrl = requestUrl.substring(0,requestUrl.indexOf("/",1));
        // 免拦截,直接放行
//        if(uncheckUrls.contains(requestUrl)){
//            return true;
//        }
        // 先查看用户是否为登录状态
//        if (loginUsers.contains(httpServletRequest.getSession().getAttribute("user"))){
//            return true;
//        }

//        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("-------------->after the method");
        System.out.println(modelAndView);
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
