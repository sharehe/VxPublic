package cn.sharehe.weixin.menu;
import cn.sharehe.weixin.vxbeans.menu.Menu;
import cn.sharehe.weixin.vxbeans.menu.OneMenu;
import cn.sharehe.weixin.vxbeans.menu.TwoMenu;
import cn.sharehe.weixin.constant.VxMenuEnum;
import cn.sharehe.weixin.vxinterface.MenuInterface;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: wugui
 * @Date 2018-7-17 15:27
 */
public class AddMenu{
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<OneMenu> listOne = new ArrayList<>(3);
        List<TwoMenu> listTwo = new ArrayList<>(5);
        // 设置一级菜单
        OneMenu o = new OneMenu();
        o.setName("摄像头");
        listOne.add(o);
        // 二级
        TwoMenu t = new TwoMenu();
        t.setName("拍照");
        t.setType(VxMenuEnum.PIC_SYSPHOTO.val);
        t.setKey("key1");
        listTwo.add(t);

        t = new TwoMenu();
        t.setName("选择图片");
        t.setKey("key2");
        t.setType(VxMenuEnum.PIC_PHOTO_OR_ALBUM.val);
        listTwo.add(t);

        t = new TwoMenu();
        t.setName("微信相册");
        t.setKey("key3");
        t.setType(VxMenuEnum.PIC_WEIXIN.val);
        listTwo.add(t);

        t = new TwoMenu();
        t.setName("扫码");
        t.setKey(VxMenuEnum.SCANCODE_PUSH.val);
        t.setType(VxMenuEnum.SCANCODE_PUSH.val);
        listTwo.add(t);

        t = new TwoMenu();
        t.setName("扫码弹出");
        t.setKey(VxMenuEnum.SCANCODE_WAITMSG.val);
        t.setType(VxMenuEnum.SCANCODE_WAITMSG.val);
        listTwo.add(t);
        o.setSub_button(listTwo);
        // 一级
        o = new OneMenu();
        o.setName("位置");
        listTwo = new ArrayList<>(5);
        o.setSub_button(listTwo);
        listOne.add(o);
        // 二级
        t = new TwoMenu();
        t.setName("获取位置");
        t.setType(VxMenuEnum.LOCATION_SELECT.val);
        t.setKey(VxMenuEnum.LOCATION_SELECT.val);
        listTwo.add(t);

        // 一级
        o = new OneMenu();
        o.setName("点击");
        listTwo = new ArrayList<>(5);
        o.setSub_button(listTwo);
        listOne.add(o);

        // 二级
        t = new TwoMenu();
        listTwo.add(t);
        t.setName("获取图文消息");
        t.setType(VxMenuEnum.CLICK.val);
        t.setKey("news");

        t = new TwoMenu();
        listTwo.add(t);
        t.setName("网页");
        t.setType(VxMenuEnum.VIEW.val);
        t.setKey(VxMenuEnum.VIEW.val);
        t.setUrl("http://boenfu.cn");

        menu.setButton(listOne);
        System.out.println(MenuInterface.addMenu(menu));
    }
}
