package cn.sharehe.weixin.vxbeans.msg;

/**
 * 点击view按钮事件
 * @Author: wugui
 * @Date 2018-7-18 16:34
 */
public class EvenViewMsg extends EvenMsgBase {
    private String MenuID;

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }
}
