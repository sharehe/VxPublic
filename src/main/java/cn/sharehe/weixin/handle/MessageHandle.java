package cn.sharehe.weixin.handle;
import cn.sharehe.weixin.constant.VxEvenEnum;
import cn.sharehe.weixin.constant.VxMsgEnum;
import cn.sharehe.weixin.service.IEventService;
import cn.sharehe.weixin.service.IMessageService;
import cn.sharehe.weixin.utils.XmlOrBean;
import cn.sharehe.weixin.vxbeans.msg.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wugui
 * @Date 2018-7-18 14:26
 */
@Component
public class MessageHandle {
    @Autowired
    private IEventService iEventService;
    @Autowired
    private IMessageService iMessageService;
    /**
     * @param req
     * @return
     */
    public String handle(HttpServletRequest req){
        Object textMsg = XmlOrBean.xmlToBean(req);
        MessageBase messageBase = null;
        if (textMsg instanceof FromMsgBase){ // 接收普通消息
            if (textMsg instanceof FromTextMsg){
                messageBase = iMessageService.textHandle((FromTextMsg) textMsg);
            }else if (textMsg instanceof FromImgMsg){
                messageBase = iMessageService.imageHandle((FromImgMsg) textMsg);
            }else if (textMsg instanceof FromLocationMsg){
                messageBase = iMessageService.locationHandler((FromLocationMsg) textMsg);
            }else if (textMsg instanceof FromMp4ShortMsg){
                FromMp4ShortMsg mp4ShortMsg = (FromMp4ShortMsg) textMsg;
                if (mp4ShortMsg.getMsgType().equals(VxMsgEnum.VIDEO.val)){  // 视频
                    messageBase = iMessageService.videoHandle(mp4ShortMsg);
                }else { // 小视频
                    messageBase = iMessageService.shortvideoHandler(mp4ShortMsg);
                }
            }else if (textMsg instanceof FromVoiceMsg){
                messageBase = iMessageService.voiceHandle((FromVoiceMsg) textMsg);
            }else if (textMsg instanceof FromLinkMsg){
                messageBase = iMessageService.linkHandler((FromLinkMsg) textMsg);
            }
        }else if (textMsg instanceof EvenMsgBase){  // 事件消息
            if (textMsg instanceof EvenMenuClickMsg){
                messageBase = iEventService.clickHandle((EvenMenuClickMsg) textMsg);
            }else if (textMsg instanceof EvenScanMsg){
                messageBase = iEventService.scanHandle((EvenScanMsg) textMsg);
            }else if (textMsg instanceof EvenMsgBase){
                EvenMsgBase evenMsgBase = (EvenMsgBase) textMsg;
                if (evenMsgBase.getEvent().equals(VxEvenEnum.SUBSCRIBE.val)){
                    messageBase = iEventService.subscribeHandle(evenMsgBase);
                }else {
                    messageBase = iEventService.unsubscribe(evenMsgBase);
                }
            }
        }else {
            return "success";
        }
        return XmlOrBean.messageToXml(messageBase);
    }
}
