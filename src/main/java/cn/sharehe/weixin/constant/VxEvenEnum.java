package cn.sharehe.weixin.constant;

/**
 * 事件类型枚举
 * @Author: wugui
 * @Date 2018-7-18 10:17
 */
public enum VxEvenEnum {
    SUBSCRIBE("subscribe"), // 订阅事件
    UNSUBSCRIBE("unsubscribe"), //取消订阅事件
    SCAN("SCAN"), // 用户已关注时的事件推送
    LOCATION("LOCATION"), // 上报地理位置事件
    CLICK("CLICK"),  //  点击菜单拉取消息时的事件推送
    VIEW("VIEW"), //  点击菜单跳转链接时的事件推送
    SCANCODE_PUSH("scancode_push"), // 扫码推事件的事件推送
    SCANCODE_WAITMSG("scancode_waitmsg"),  // 扫码推事件且弹出“消息接收中”
    PIC_SYSPHOTO("pic_sysphoto"),  // 弹出系统拍照发图的事件推送
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album"), // 弹出拍照或者相册发图的事件推送
    PIC_WEIXIN("pic_weixin"), // 弹出微信相册发图器的事件推送
    LOCATION_SELECT("location_select"); // 弹出地理位置选择器的事件推送
    public String val;
    VxEvenEnum(String val){
        this.val = val;
    }
}
