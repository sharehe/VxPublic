package cn.sharehe.weixin.vxbeans.msg;

/**
 * 接收图片消息
 * @Author: wugui
 * @Date 2018-7-18 10:03
 */
public class FromImgMsg extends FromMsgBase {
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
