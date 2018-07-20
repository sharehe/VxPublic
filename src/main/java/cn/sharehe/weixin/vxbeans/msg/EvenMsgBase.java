package cn.sharehe.weixin.vxbeans.msg;

/**
 * 接收事件消息的基类
 * 可作为 订阅与取消订阅的实体类
 * @Author: wugui
 * @Date 2018-7-18 10:25
 */
public class EvenMsgBase extends MessageBase {
    protected String Event;
    private String EventKey;
    private String Ticket;

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
