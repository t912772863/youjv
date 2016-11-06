package com.gongxiangcloud.youjv.common.business;

import com.gongxiangcloud.youjv.common.utils.ReadPropertiesUtil;
import redis.clients.jedis.Jedis;

import java.net.URL;

/**
 * redis相关操作
 * Created by tianxiong on 16/10/18.
 */
public class RedisFactory {
    public static Jedis jedis;
    static {
        try{
            URL fileUrl = RedisFactory.class.getClassLoader().getResource("business.properties");
            ReadPropertiesUtil readPropertiesUtil = new ReadPropertiesUtil(fileUrl.getPath());

            String redisAddress = readPropertiesUtil.readValue("redis_address");
            String redisPort = readPropertiesUtil.readValue("redis_port");

            RedisFactory.jedis = new Jedis(redisAddress,Integer.parseInt(redisPort));
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("初始化数据异常");
        }
    }

}
