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
    /**
     * 获得临时的
     */
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

    /**
     * 获得永久的
     */
    public void addTicket(){
        CountAc countAc = new CountAc();
        countAc.setAction_name("QR_LIMIT_STR_SCENE");
        CountAcInfo acInfo = new CountAcInfo();
        CountAcScene acScene = new CountAcScene();
        acScene.setScene_str(MyRandom.getUUID());
        acInfo.setScene(acScene);
        countAc.setAction_info(acInfo);
        System.out.println(AccountInterface.qryTicket(countAc));
    }
    public boolean downTemTicket(){
        return AccountInterface.downCode("gQGT8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyazUwVjVMYUxjZWoxMDAwMHcwN3AAAgSVkFFbAwQAAAAA",
                "F:/桌面/erwei1.jpg");
    }
    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        System.out.println(accountTest.downTemTicket());
//        accountTest.addTemTicket();
//        accountTest.addTicket();
    }
}
