package cn.sharehe.weixin.vxbeans.msg;

/**
 * 回复消息的坑
 * @Author: wugui
 * @Date 2018-7-19 15:21
 */
public class ToBitch {
    private String MediaId;  //通过素材管理中的接口上传多媒体文件，得到的id。
    private String Title;   // 非必须 视频消息的标题
    private String Description; // 非必须 视频消息的描述
    public ToBitch(String mediaId) {
        MediaId = mediaId;
    }
    public ToBitch() {
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
