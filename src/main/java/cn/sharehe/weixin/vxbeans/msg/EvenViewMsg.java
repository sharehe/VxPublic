package cn.sharehe.weixin.vxbeans.msg;

/**
 * 点击view按钮事件
 * @Author: wugui
 * @Date 2018-7-18 16:34
 */
public class EvenViewMsg extends EvenMsgBase {
    private String MenuId;

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
