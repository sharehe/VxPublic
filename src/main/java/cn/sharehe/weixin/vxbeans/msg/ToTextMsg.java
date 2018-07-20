package cn.sharehe.weixin.vxbeans.msg;

import cn.sharehe.weixin.constant.VxMsgEnum;

/**
 * 被动回复文本消息消息
 * @Author: wugui
 * @Date 2018-7-17 17:53
 */
public class ToTextMsg extends MessageBase {
    private String Content;        // 回复内容
    public ToTextMsg(){
        super.setMsgType(VxMsgEnum.TEXT.val);
    }
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
