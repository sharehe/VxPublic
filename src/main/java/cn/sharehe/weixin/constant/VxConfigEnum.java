package cn.sharehe.weixin.constant;

/**
 * @Author: wugui
 * @Date 2018-7-17 11:12
 */
public enum VxConfigEnum {
    // wxc99b26be46e8a086
    APPID("wxc99b26be46e8a086"),// wx1e30b24a6dec285e
    //c2680a6106b11c0bd8e8dfc1a4b90b1a
    APPSECRET("c2680a6106b11c0bd8e8dfc1a4b90b1a"),  //047248ba7ee006550f992a456897a08c
    ROOTURLS("https://api.weixin.qq.com/"),
    ROOTURL("http://api.weixin.qq.com/"),
    MYTOKEN("wugui");   // 验证token
    VxConfigEnum(String val){
        this.val = val;
    }
    public String val;
}
