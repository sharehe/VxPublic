package cn.sharehe.weixin.constant;

/**
 * 微信菜单类型值的枚举
 * @Author: wugui
 * @Date 2018-7-17 15:30
 */
public enum VxMenuEnum {
    CLICK("click"),
    VIEW("view"),
    SCANCODE_PUSH("scancode_push"),
    SCANCODE_WAITMSG("scancode_waitmsg"),
    PIC_SYSPHOTO("pic_sysphoto"),
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
    PIC_WEIXIN("pic_weixin"),
    LOCATION_SELECT("location_select"),
    MEDIA_ID("media_id"),
    VIEW_LIMITED("view_limited");
    public String val;
    VxMenuEnum(String val){
        this.val = val;
    }
}
