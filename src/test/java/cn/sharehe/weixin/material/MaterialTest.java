package cn.sharehe.weixin.material;

import cn.sharehe.weixin.vxbeans.material.QryMaterial;
import cn.sharehe.weixin.constant.VxFileEnum;
import cn.sharehe.weixin.vxinterface.MaterialInterface;

/**
 * @Author: wugui
 * @Date 2018-7-19 11:42
 */
public class MaterialTest {
    public void qryList(){
        QryMaterial material = new QryMaterial();
        material.setType(VxFileEnum.IMAGE.val);
        material.setOffset("0");
        material.setCount("20");
        System.out.println(MaterialInterface.qryMaterialList(material));
    }
    public void del(){
        System.out.println(MaterialInterface.delMeterial("bVZEItHFxs2Yk_rCw5unZG8elZAB-s8P-1SMZBk3BQM"));
    }
    public void add(){
        System.out.println(MaterialInterface.addTemMaterial("F:/桌面/util.jpg",VxFileEnum.IMAGE.val));
    }
    public void qryCount(){
        System.out.println(MaterialInterface.qryMaterialCount());
    }
    public static void main(String[] args) {
        MaterialTest test = new MaterialTest();
//        test.qryList();
//        test.del();
        test.add();
//        test.qryCount();
    }
}
