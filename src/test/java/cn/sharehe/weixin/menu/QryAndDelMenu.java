package cn.sharehe.weixin.menu;

import cn.sharehe.weixin.vxinterface.MenuInterface;

/**
 * @Author: wugui
 * @Date 2018-7-17 16:43
 */
public class QryAndDelMenu {
    public void qry(){
        System.out.println(MenuInterface.qryMenu());
    }
    public void del(){
        System.out.println(MenuInterface.delMenu());
    }

    public static void main(String[] args) {
        QryAndDelMenu qryAndDelMenu = new QryAndDelMenu();
        qryAndDelMenu.qry();
    }
}
