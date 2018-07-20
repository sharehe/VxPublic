package cn.sharehe.weixin.vxbeans.msg;

import cn.sharehe.weixin.constant.VxMsgEnum;

/**
 * 发送视频消息实体
 * @Author: wugui
 * @Date 2018-7-18 09:35
 */
public class ToMp4Msg extends MessageBase {
    private ToBitch Video;  //通过素材管理中的接口上传多媒体文件，得到的id
    public ToMp4Msg(){
        super.setMsgType(VxMsgEnum.VIDEO.val);
        Video = new ToBitch();
    }
    public String getMediaId() {
        return Video.getMediaId();
    }
    public void setMediaId(String mediaId) {
        Video.setMediaId(mediaId);
    }
    public String getTitle() {
        return Video.getTitle();
    }

    public void setTitle(String title) {
        Video.setTitle(title);
    }

    public String getDescription() {
        return Video.getDescription();
    }

    public void setDescription(String description) {
        Video.setDescription(description);
    }
}
