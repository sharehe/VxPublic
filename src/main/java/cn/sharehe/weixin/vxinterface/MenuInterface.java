package cn.sharehe.weixin.vxinterface;

import cn.sharehe.weixin.vxbeans.menu.Menu;
import cn.sharehe.weixin.constant.VxConfigEnum;
import cn.sharehe.weixin.utils.HttpInterface;

/**
 * 编辑菜单接口
 * @Author: wugui
 * @Date 2018-7-17 15:20
 */
public class MenuInterface {
    /**
     * 更新全部菜单
     * @param menu
     * @return 返回接口返回值
     */
    public static String addMenu(Menu menu){
        if (menu == null || menu.getButton() == null)
            throw new NullPointerException("参数不可为空");
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/menu/create?access_token=" + GetToken.getToken();
        return HttpInterface.doPost(url,menu);
    }

    /**
     * 查询菜单结构
     * @return 返回菜单接口返回值
     */
    public static String qryMenu(){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/menu/get?access_token=" + GetToken.getToken();
        return HttpInterface.doGet(url);
    }

    /**
     * 删除全部菜单接口
     * @return 接口返回值
     */
    public static String delMenu(){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/menu/delete?access_token=" + GetToken.getToken();
        return HttpInterface.doGet(url);
    }
}
