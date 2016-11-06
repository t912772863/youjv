package com.gongxiangcloud.youjv.common.utils;

import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import org.apache.commons.collections.map.HashedMap;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by tianxiong on 16/10/10.
 */
public class JavaBeanUtil {
    /**
     *
     * @param bean1 主Bean,也就是信息比较全的一个
     * @param bean2 副Bean,也就是只包含了要更新属性的Bean
     * @return 用bean2中的属性替换Bean1中的属性后的Bean
     */
    public static Object fuseBeans(Object bean1,Object bean2) {
        try {
            // 先得到第二个类中的属性不为空的值,以map存下来.
            Map<String,Object> bean2FiledValueMap = getJavaBeanFieldValue(bean2);
            // 把上面得到的值在第一个类中做一个替换
            Class c = bean1.getClass();
            Field[] fields = c.getDeclaredFields();
            Map<String,Field> bean1FieldMap = new HashedMap();
            for (Field field:fields) {
                bean1FieldMap.put(field.getName(),field);
            }

            for(String bean2FieldKey:bean2FiledValueMap.keySet()){
                Field field = bean1FieldMap.get(bean2FieldKey);
                if(field != null){
                    field.setAccessible(true);
                    field.set(bean1,bean2FiledValueMap.get(bean2FieldKey));
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("转换Bean出现异常");
        }

        return bean1;
    }

    /**
     * 把一个bean中的有值的属性,放入一个map中
     * @param bean
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String,Object> getJavaBeanFieldValue(Object bean) throws IllegalAccessException{
        // 先得到第二个类中的属性不为空的值,以map存下来.
        //得到类对象
        Class c1 = (Class)bean.getClass();
        // 得到类中的属性集合
        Field[] fields = c1.getDeclaredFields();
        // map
        Map<String,Object> bean1FieldValueMap = new HashedMap();

        //循环处理
        for(int i = 0 ; i < fields.length; i++){
            Field field = fields[i];
            // 设置属性为可以访问的
            field.setAccessible(true);
            // 得到属性名
            String name = field.getName();

            // 得到这个属性的值
            Object val = field.get(bean);
            // 得到这个值的类型
            Class fieldValueType =  field.getType();
            System.out.println(fieldValueType.toString());
            // 值类型转换为真实类型


            //值不为空则放入map中
            if(val!=null){
                bean1FieldValueMap.put(name,val);
            }
        }
        return bean1FieldValueMap;


    }


    public static void main(String[] args) throws IllegalAccessException {
        UserInfo u1 = new UserInfo();
        u1.setUid(1L);
        u1.setEmail("u1mail");
        u1.setAddress("u1address");

        UserInfo u2 = new UserInfo();
        u2.setUid(1L);
        u2.setEmail("u2mail");

        Object  obejct = fuseBeans(u1,u2);
    }



}
