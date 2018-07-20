package cn.sharehe.weixin.material;

import cn.sharehe.weixin.vxbeans.material.QryMaterial;
import cn.sharehe.weixin.constant.VxFileEnum;
import cn.sharehe.weixin.vxinterface.MaterialInterface;

/**
 * @Author: wugui
 * @Date 2018-7-19 09:42
 */
public class QryMaterialTest {
    public static void main(String[] args) {
        QryMaterial material = new QryMaterial();
        material.setCount("20");
        material.setOffset("0");
        material.setType(VxFileEnum.IMAGE.val);
        System.out.println(MaterialInterface.qryMaterialList(material));
    }
}
