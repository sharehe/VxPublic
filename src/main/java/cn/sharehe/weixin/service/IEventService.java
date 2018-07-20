package cn.sharehe.weixin.service;

import cn.sharehe.weixin.vxbeans.msg.*;

/**
 * 处理事件消息
 * @Author: wugui
 * @Date 2018-7-18 14:30
 */
public interface IEventService {
    /**
     * 订阅事件
     * @param evenMsgBase
     * @return
     */
    MessageBase subscribeHandle(EvenMsgBase evenMsgBase);

    /**
     * 取消订阅事件
     * @param evenMsgBase
     * @return
     */
    MessageBase unsubscribe(EvenMsgBase evenMsgBase);

    /**
     * 点击view事件
     * @param evenViewMsg
     * @return
     */
    MessageBase ViewHandle(EvenViewMsg evenViewMsg);
    /**
     * 点击事件
     * @param clickMsg
     * @return
     */
    MessageBase clickHandle(EvenMenuClickMsg clickMsg);

    /**
     * 扫描二维码事件
     * @param scanMsg
     * @return
     */
    MessageBase scanHandle(EvenScanMsg scanMsg);
}
