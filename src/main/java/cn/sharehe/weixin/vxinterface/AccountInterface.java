package cn.sharehe.weixin.vxinterface;

import cn.sharehe.weixin.constant.VxConfigEnum;
import cn.sharehe.weixin.utils.HttpInterface;
import cn.sharehe.weixin.vxbeans.account.CountAc;

/**
 * 账号管理接口
 * @Author: wugui
 * @Date 2018-7-19 17:39
 */
public class AccountInterface {
    /**
     * 获得ticket 这里有临时跟永久两个
     * @param countAc 根据参数生成永久或者临时的
     * @return
     */
    public static String qryTicket(CountAc countAc){
        String url = VxConfigEnum.ROOTURLS.val + "/cgi-bin/qrcode/create?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doPost(url,countAc);
        return rel;
    }
    /**
     * 下载二维码
     * @param ticket
     * @param path
     * @return 二维码是否保存成功
     */
    public static boolean downCode(String ticket,String path){
        String url ="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket;
        return HttpInterface.doDown(url,path);
    }
}
