package cn.sharehe.weixin.vxbeans.msg;

/**
 * 接收文本消息
 * @Author: wugui
 * @Date 2018-7-18 10:02
 */
public class FromTextMsg extends FromMsgBase{
    private String Content; //文本消息内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return super.toString() + "FromTextMsg{" +
                "Content='" + Content + '\'' +
                '}';
    }
}
