package cn.sharehe.weixin.account;

import cn.sharehe.weixin.utils.MyRandom;
import cn.sharehe.weixin.vxbeans.account.CountAc;
import cn.sharehe.weixin.vxbeans.account.CountAcInfo;
import cn.sharehe.weixin.vxbeans.account.CountAcScene;
import cn.sharehe.weixin.vxinterface.AccountInterface;

/**
 * @Author: wugui
 * @Date 2018-7-20 10:10
 */
public class AccountTest {
    public void addTemTicket(){
        CountAc countAc = new CountAc();
        countAc.setExpire_seconds("3600");
        countAc.setAction_name("QR_SCENE");
        CountAcInfo countAcInfo = new CountAcInfo();
        CountAcScene countAcScene = new CountAcScene();
        countAcScene.setScene_id(MyRandom.getLong());
        countAcInfo.setScene(countAcScene);
        countAc.setAction_info(countAcInfo);
        System.out.println(AccountInterface.qryTicket(countAc));
    }
    public boolean downTemTicket(){
        return AccountInterface.downCode("gQF47zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAybWVMbDVGYUxjZWoxazBEaGhyMTgAAgTwWFFbAwQQDgAA",
                "F:/桌面/erwei1.jpg");
    }
    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        System.out.println(accountTest.downTemTicket());
//        accountTest.addTemTicket();
    }
}
