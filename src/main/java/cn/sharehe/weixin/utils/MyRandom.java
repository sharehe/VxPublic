package cn.sharehe.weixin.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数生成工具类
 * @Author: wugui
 * @Date 2018-7-19 17:32
 */
public class MyRandom {
    /**
     * 获得长度为32位的uuid
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 获取指定长度的随机整形字符
     * @return
     */
    public static String getLong(int len){
        StringBuilder biu = new StringBuilder(len);
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            biu.append(random.nextInt(10));
        }
        return biu.toString();
    }

    /**
     * 获取32位长度的整形字符
     * @return
     */
    public static String getLong(){
        return getLong(32);
    }
}
