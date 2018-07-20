package cn.sharehe.weixin.vxbeans.msg;

import java.util.Date;

/**
 * 消息对象父类
 * @Author: wugui
 * @Date 2018-7-17 17:50
 */
public class MessageBase {
    protected String ToUserName;  // 接收方
    protected String FromUserName; // 发送方
    protected String MsgType;    // 消息类型
    public String CreateTime;
    public MessageBase(){
        this.CreateTime = new Date().getTime()+"";
    }
    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    @Override
    public String toString() {
        return "MessageBase{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
