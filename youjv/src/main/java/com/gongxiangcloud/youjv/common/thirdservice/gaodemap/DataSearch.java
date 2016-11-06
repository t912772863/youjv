package com.gongxiangcloud.youjv.common.thirdservice.gaodemap;

import com.alibaba.fastjson.JSON;
import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.SystemConstantThird;
import com.gongxiangcloud.youjv.common.utils.ReadPropertiesUtil;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 高德云图,检索相关的API
 * Created by tianxiong on 16/10/17.
 */
public class DataSearch {
    private static String key;
    private static String tableId;

    static {
        try{
            URL fileUrl = Data.class.getClassLoader().getResource("business.properties");
            ReadPropertiesUtil readPropertiesUtil = new ReadPropertiesUtil(fileUrl.getPath());

            DataSearch.key = readPropertiesUtil.readValue("map_key");
            DataSearch.tableId = readPropertiesUtil.readValue("map_tableid");
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("初始化数据异常");
        }
    }

    /**
     * 周边条件检索
     * @param keywords 关键字
     * @param center 中心坐标
     * @param radius 半径范围
     * @param filter 过滤条件
     * @param sortrule 排序规则
     * @param limit 每页记录数
     * @param page  当前页码
     * @return
     */
    public static String around(String keywords,String center,int radius,String filter,String sortrule,int limit,int page){
        HttpClient client = new HttpClient();
        //使用POST方法
        PostMethod method = new PostMethod(SystemConstantThird.MAP_DATASEARCH_AROUND);


        method.addParameter("key", DataSearch.key);
        method.addParameter("tableid", DataSearch.tableId);
        method.addParameter("keywords", keywords);
        method.addParameter("center", center);
        method.addParameter("radius", radius+"");
        method.addParameter("filter", filter);
        method.addParameter("sortrule", sortrule);
        method.addParameter("limit", limit+"");
        method.addParameter("page", page+"");

        String datas;
        try {
            client.executeMethod(method);
            String resultBody = method.getResponseBodyAsString();
            JSONObject json= JSONObject.fromObject(resultBody);
            if(!SystemConstantThird.MAP_OPTION_SUCCESS.equals(json.get("status").toString())){
                throw new BusinessException("查询失败");
            }
            datas = json.get("datas").toString();
        } catch (IOException e) {
            e.printStackTrace();
            method.releaseConnection();
            throw new RuntimeException("同步活动到云图失败");
        }

        return datas;
    }
}
