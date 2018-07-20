package cn.sharehe.weixin.service.imp;
import cn.sharehe.weixin.service.IMessageService;
import cn.sharehe.weixin.vxbeans.msg.*;
import org.springframework.stereotype.Service;
/**
 * @Author: wugui
 * @Date 2018-7-18 14:49
 */
@Service
public class MessageServiceImp implements IMessageService {
    @Override
    public MessageBase textHandle(FromTextMsg textMsg) {
        ToTextMsg textMsg1 = new ToTextMsg();
        init(textMsg1,textMsg);
        textMsg1.setContent("文本消息");
        return textMsg1;
    }

    @Override
    public MessageBase imageHandle(FromImgMsg imgMsg) {
        ToImgMsg imgMsg1 = new ToImgMsg();
        init(imgMsg1,imgMsg);
        imgMsg1.setMediaId(imgMsg.getMediaId());
        return imgMsg1;
    }

    @Override
    public MessageBase voiceHandle(FromVoiceMsg voiceMsg) {
        System.out.println(voiceMsg);
        ToVoiceMsg textMsg = new ToVoiceMsg();
        init(textMsg,voiceMsg);
        textMsg.setMediaId(voiceMsg.getMediaId());
        return textMsg;
    }

    @Override
    public MessageBase videoHandle(FromMp4ShortMsg mp4ShortMsg) {
        ToMp4Msg textMsg = new ToMp4Msg();
        init(textMsg,mp4ShortMsg);
        textMsg.setMediaId(mp4ShortMsg.getMediaId());
        textMsg.setTitle("我是小乌龟");
        textMsg.setDescription("一个超级聪明的乌龟");
        return textMsg;
    }

    @Override
    public MessageBase shortvideoHandler(FromMp4ShortMsg mp4ShortMsg) {
        ToTextMsg textMsg = new ToTextMsg();
        init(textMsg,mp4ShortMsg);
        textMsg.setContent("小视频消息");
        return textMsg;
    }

    @Override
    public MessageBase locationHandler(FromLocationMsg locationMsg) {
        ToTextMsg textMsg = new ToTextMsg();
        init(textMsg,locationMsg);
        textMsg.setContent("位置消息" +"\n" + locationMsg);
        return textMsg;
    }

    @Override
    public MessageBase linkHandler(FromLinkMsg locationMsg) {
        ToTextMsg textMsg = new ToTextMsg();
        init(textMsg,locationMsg);
        textMsg.setContent("链接消息");
        return textMsg;
    }
    private void init(MessageBase base, MessageBase textMsg){
        base.setToUserName(textMsg.getFromUserName());
        base.setFromUserName(textMsg.getToUserName());
    }
}
