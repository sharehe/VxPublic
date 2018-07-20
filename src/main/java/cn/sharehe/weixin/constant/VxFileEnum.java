package cn.sharehe.weixin.constant;

/**
 * 微信素材 文件类型
 * @Author: wugui
 * @Date 2018-7-18 16:55
 */
public enum VxFileEnum {
    IMAGE("image"), // 图片素材
    VOICE("voice"), // 音频素材
    VIDEO("video"), // 视频素材
    THUMB("thumb"); // 缩约图素材
    public String val;
    VxFileEnum(String val){
        this.val = val;
    }
}
