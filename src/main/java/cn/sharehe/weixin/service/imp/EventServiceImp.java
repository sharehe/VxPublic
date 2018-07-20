package cn.sharehe.weixin.service.imp;

import cn.sharehe.weixin.service.IEventService;
import cn.sharehe.weixin.vxbeans.msg.*;
import org.springframework.stereotype.Service;

/**
 * @Author: wugui
 * @Date 2018-7-18 14:50
 */
@Service
public class EventServiceImp implements IEventService {
    @Override
    public MessageBase subscribeHandle(EvenMsgBase evenMsgBase) {
        System.out.println("订阅");
        ToTextMsg textMsg = new ToTextMsg();
        init(textMsg,evenMsgBase);
        if (evenMsgBase.getTicket() == null)
            textMsg.setContent("个人订阅");
        else
            textMsg.setContent(evenMsgBase.getTicket() + "\n推荐订阅");
        return textMsg;
    }

    @Override
    public MessageBase unsubscribe(EvenMsgBase evenMsgBase) {
        ToTextMsg textMsg = new ToTextMsg();
        init(textMsg,evenMsgBase);
        textMsg.setContent("取消订阅");
        return textMsg;
    }

    @Override
    public MessageBase ViewHandle(EvenViewMsg evenViewMsg) {
        ToTextMsg textMsg = new ToTextMsg();
        init(textMsg,evenViewMsg);
        textMsg.setContent("点击view");
        return textMsg;
    }

    @Override
    public MessageBase clickHandle(EvenMenuClickMsg clickMsg) {
        if (clickMsg.getEventKey().equals("news")) {
            ToImgAndTextMsg imgAndTextMsg = new ToImgAndTextMsg();
            init(imgAndTextMsg,clickMsg);
            imgAndTextMsg.setArticleCount("3");
            ToNewsItem toNewsItem = new ToNewsItem();
            toNewsItem.setTitle("这是第一张");
            toNewsItem.setDescription("哎呀妈呀 我咋这么有才呢 你说是不是啊 嘻嘻");
            toNewsItem.setPicUrl("http://boho.image.alimmdn.com/loading.png?t=1520057811554");
            toNewsItem.setUrl("boenfu.cn");
            imgAndTextMsg.add(toNewsItem);
            toNewsItem = new ToNewsItem();
            toNewsItem.setTitle("这是第二张");
            toNewsItem.setDescription("哎呀妈呀 我咋这么有才呢 你说是不是啊 嘻嘻发达阿道夫");
            toNewsItem.setPicUrl("http://boho.image.alimmdn.com/index/171222.png?t=1518670741568");
            toNewsItem.setUrl("boenfu.cn");
            imgAndTextMsg.add(toNewsItem);
            toNewsItem = new ToNewsItem();
            toNewsItem.setTitle("这是第三张");
            toNewsItem.setDescription("哎呀妈呀 我咋这么有才呢 你说是不是啊 嘻嘻发达阿道夫");
            toNewsItem.setPicUrl("http://boho.image.alimmdn.com/blog/nodedy/2.jpg?t=1520738563710");
            toNewsItem.setUrl("boenfu.cn");
            imgAndTextMsg.add(toNewsItem);
            return imgAndTextMsg;
        }else {
            ToTextMsg textMsg = new ToTextMsg();
            init(textMsg,clickMsg);
            textMsg.setContent("点击事件");
            return textMsg;
        }
    }

    @Override
    public MessageBase scanHandle(EvenScanMsg scanMsg) {
        ToTextMsg toTextMsg = new ToTextMsg();
        init(toTextMsg,scanMsg);
        toTextMsg.setContent("用户扫描了生成的二维码" + scanMsg.getTicket());
        return toTextMsg;
    }

    private void init(MessageBase base, MessageBase textMsg){
        base.setToUserName(textMsg.getFromUserName());
        base.setFromUserName(textMsg.getToUserName());
    }
}
