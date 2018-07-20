package cn.sharehe.weixin.vxbeans.msg;

/**
 * 接收语音消息
 * @Author: wugui
 * @Date 2018-7-18 10:04
 */
public class FromVoiceMsg extends FromMsgBase{
    private String MediaId; // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String Format;  // 语音格式，如amr，speex等
    private String Recognition;

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    @Override
    public String toString() {
        return super.toString() + "FromVoiceMsg{" +
                "MediaId='" + MediaId + '\'' +
                ", Format='" + Format + '\'' +
                ", Recognition='" + Recognition + '\'' +
                '}';
    }
}
