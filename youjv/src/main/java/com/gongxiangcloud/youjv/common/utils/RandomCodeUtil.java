package com.gongxiangcloud.youjv.common.utils;

import java.util.Random;

/**
 * 随机码生成工具类
 * Created by tianxiong on 16/10/11.
 */
public class RandomCodeUtil {
    /**
     * 返回一个四位随机数
     * @return
     */
    public static String randomNumber(){
        return new Random().nextInt(8999)+1000+"";
    }

    public static void main(String[] args) {
        System.out.println(randomNumber());
    }

}
