package cn.sharehe.weixin.vxbeans.msg;

/**
 * @Author: wugui
 * @Date 2018-7-18 10:01
 */
public class FromMsgBase extends MessageBase {
    protected String MsgId;  // 消息id，64位整型

    protected String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    @Override
    public String toString() {

        return super.toString() + "FromMsgBase{" +
                "MsgId='" + MsgId + '\'' +
                '}';
    }
}
