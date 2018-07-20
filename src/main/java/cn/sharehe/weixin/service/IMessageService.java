package cn.sharehe.weixin.service;

import cn.sharehe.weixin.vxbeans.msg.*;

/**
 * 处理普通消息
 * @Author: wugui
 * @Date 2018-7-18 14:29
 */
public interface IMessageService {
    /**
     * 文本消息
     * @param textMsg
     * @return
     */
    MessageBase textHandle(FromTextMsg textMsg);

    /**
     * 图片消息
     * @param imgMsg
     * @return
     */
    MessageBase imageHandle(FromImgMsg imgMsg);

    /**
     * 音频消息
     * @param voiceMsg
     * @return
     */
    MessageBase voiceHandle(FromVoiceMsg voiceMsg);

    /**
     * 视频消息
     * @param mp4ShortMsg
     * @return
     */
    MessageBase videoHandle(FromMp4ShortMsg mp4ShortMsg);

    /**
     * 小视频消息
     * @param mp4ShortMsg
     * @return
     */
    MessageBase shortvideoHandler(FromMp4ShortMsg mp4ShortMsg);

    /**
     * 位置信息
     * @param locationMsg
     * @return
     */
    MessageBase locationHandler(FromLocationMsg locationMsg);

    /**
     * 连接消息
     * @param locationMsg
     * @return
     */
    MessageBase linkHandler(FromLinkMsg locationMsg);
}
