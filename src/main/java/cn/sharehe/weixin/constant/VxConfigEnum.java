package cn.sharehe.weixin.constant;

/**
 * 微信控制的一些常量
 * @Author: wugui
 * @Date 2018-7-17 11:12
 */
public enum VxConfigEnum {
    APPID("wxc99b26be46e8a086"),//
    APPSECRET("c2680a6106b11c0bd8e8dfc1a4b90b1a"),  //
    ROOTURLS("https://api.weixin.qq.com/"),
    ROOTURL("http://api.weixin.qq.com/"),
    MYTOKEN("wugui");   // 验证token
    VxConfigEnum(String val){
        this.val = val;
    }
    public String val;
}
