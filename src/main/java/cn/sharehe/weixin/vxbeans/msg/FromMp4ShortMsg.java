package cn.sharehe.weixin.vxbeans.msg;

/**
 * 接收到视频消息或者小视频消息
 * @Author: wugui
 * @Date 2018-7-18 10:08
 */
public class FromMp4ShortMsg extends FromMsgBase {
    private String MediaId;     // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String ThumbMediaId; //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        return super.toString() + "FromMp4ShortMsg{" +
                "MediaId='" + MediaId + '\'' +
                ", ThumbMediaId='" + ThumbMediaId + '\'' +
                '}';
    }
}
