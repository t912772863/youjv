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
 * 高德云图对应的数据服务
 * Created by tianxiong on 16/10/17.
 */
public class Data {
    private static String key;
    private static String tableId;

    static {
        try{
            URL fileUrl = Data.class.getClassLoader().getResource("business.properties");
            ReadPropertiesUtil readPropertiesUtil = new ReadPropertiesUtil(fileUrl.getPath());

            Data.key = readPropertiesUtil.readValue("map_key");
            Data.tableId = readPropertiesUtil.readValue("map_tableid");
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("初始化数据异常");
        }
    }

    /**
     *
     * @param name 标签名
     * @param location 经纬度坐标
     * @param address 详细地址
     * @return 成功创建的数据ID
     */
    public static String create(String name,String location,String address){
        HttpClient client = new HttpClient();
        //使用POST方法
        PostMethod method = new PostMethod(SystemConstantThird.MAP_DATA_CREATE);

        Map<String,String> data = new HashMap();
        data.put("_name",name);
        data.put("_location",location);
        data.put("_address",address);

        String mapStr = JSON.toJSONString(data);

        method.addParameter("key", Data.key);
        method.addParameter("tableid", Data.tableId);
        method.addParameter("data", mapStr);

        String backId;
        try {
            client.executeMethod(method);
            String resultBody = method.getResponseBodyAsString();
            JSONObject json= JSONObject.fromObject(resultBody);
            if(!SystemConstantThird.MAP_OPTION_SUCCESS.equals(json.get("status").toString())){
                throw new BusinessException("同步活动到云图失败");
            }
            backId = json.get("_id").toString();
        } catch (IOException e) {
            e.printStackTrace();
            method.releaseConnection();
            throw new RuntimeException("同步活动到云图失败");
        }

        return backId;
    }

    /**
     * 删除云图上的活动对应的数据
     * @param tableId
     * @return
     */
    public static boolean delete(String tableId){
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(SystemConstantThird.MAP_DATA_DELETE);
        method.addParameter("key",Data.key);
        method.addParameter("tableid",Data.tableId);
        method.addParameter("ids",tableId);
        try{
            client.executeMethod(method);
            String resultBody = method.getResponseBodyAsString();
            JSONObject json = JSONObject.fromObject(resultBody);
            if(!SystemConstantThird.MAP_OPTION_SUCCESS.equals(json.get("status").toString())){
                throw new BusinessException("删除云图上的数据出现异常");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("删除云图上的数据出现异常");
        }
        return true;
    }

    public static void main(String[] args) {
        Data.delete(13+"");
    }

}
