package cn.sharehe.weixin.vxbeans.msg;

import cn.sharehe.weixin.constant.VxMsgEnum;

/**
 * 发送音频文件
 * @Author: wugui
 * @Date 2018-7-18 09:37
 */
public class ToMp3Msg extends MessageBase {
    private String Title;  // 非必须  音乐标题
    private String Description;  // 非必须 音乐描述
    private String MusicURL;  // 非必须 音乐链接
    private String HQMusicUrl; // 非必须 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String ThumbMediaId; // 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
    public ToMp3Msg(){
        super.setMsgType(VxMsgEnum.MUSIC.val);
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

    public String getMusicURL() {
        return MusicURL;
    }

    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        super.toString();
        return "ToMp3Msg{" +
                "Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", MusicURL='" + MusicURL + '\'' +
                ", HQMusicUrl='" + HQMusicUrl + '\'' +
                ", ThumbMediaId='" + ThumbMediaId + '\'' +
                '}';
    }
}
