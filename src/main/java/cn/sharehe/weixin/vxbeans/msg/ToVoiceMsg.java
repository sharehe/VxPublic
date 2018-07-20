package cn.sharehe.weixin.vxbeans.msg;

import cn.sharehe.weixin.constant.VxMsgEnum;

/**
 * 被动回复语音消息
 * @Author: wugui
 * @Date 2018-7-17 17:56
 */
public class ToVoiceMsg extends MessageBase {
    private ToBitch Voice; //通过素材管理中的接口上传多媒体文件，得到的id。
    public ToVoiceMsg(){
        super.setMsgType(VxMsgEnum.VOICE.val);
        Voice = new ToBitch();
    }
    public String getMediaId() {
        return Voice.getMediaId();
    }

    public void setMediaId(String mediaId) {
        Voice.setMediaId(mediaId);
    }
}
