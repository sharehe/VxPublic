package cn.sharehe.weixin.constant;

/**
 * 微信消息类型枚举
 * @Author: wugui
 * @Date 2018-7-18 09:44
 */
public enum VxMsgEnum {
    TEXT("text"),   // 文本
    IMAGE("image"), // 图片
    VOICE("voice"), // 音频
    VIDEO("video"), // 视频
    MUSIC("music"), // mp3
    NEWS("news"),   // 图文
    SHORTVIDEO("shortvideo"), // 小视频
    LOCATION("location"),   // 地理位置
    LINK("link"),   // 连接
    EVENT("event"); // 事件
    public String val;
    VxMsgEnum(String val) {
        this.val = val;
    }
}
