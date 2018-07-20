package cn.sharehe.weixin.vxinterface;

import cn.sharehe.weixin.vxbeans.material.EditMaterial;
import cn.sharehe.weixin.vxbeans.material.ImgAndTextMaterial;
import cn.sharehe.weixin.vxbeans.material.QryMaterial;
import cn.sharehe.weixin.constant.VxConfigEnum;
import cn.sharehe.weixin.utils.HttpInterface;

import java.io.*;

/**
 * 素材类型接口
 * @Author: wugui
 * @Date 2018-7-19 09:39
 */
public class MaterialInterface {
    /**
     * 获取素材列表
     * @param material
     * @return
     */
    public static String qryMaterialList(QryMaterial material){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/batchget_material?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doPost(url,material);
        return rel;
    }

    /**
     * 获取永久素材数量
     * @return
     */
    public static String qryMaterialCount(){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/get_materialcount?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doGet(url);
        return rel;
    }

    /**
     * 上传临时素材
     * @param path 文件路径
     * @param type 素材类型 详见VxFileEnum
     * @return
     */
    public static String addTemMaterial(String path,String type){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/media/upload?access_token=" + GetToken.getToken() + "&type=" + type;
        String rel = HttpInterface.doFlie(url,path);
        return rel;
    }

    /**
     * 上传非图文的永久素材
     * @param path 文件路径
     * @param type 素材类型 详见VxFileEnum
     * @return
     */
    public static String addMaterial(String path,String type){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/add_material?access_token=" + GetToken.getToken() + "&type=" + type;
        String rel = HttpInterface.doFlie(url,path);
        return rel;
    }

    /**
     * 上传图文永久素材
     * @param imgAndText
     * @return
     */
    public static String addNewsMaterial(ImgAndTextMaterial imgAndText){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/add_news?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doPost(url,imgAndText);
        return rel;
    }

    /**
     * 上传图文消息内的图片获取URL 用来在图文消息正文中填写url
     * @param path 图片路径 绝对
     * @return
     */
    public static String addNewsImgMeterial(String path){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/media/uploadimg?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doFlie(url,path);
        return rel;
    }

    /**
     * 修改素材图文消息
     * @param material
     * @return
     */
    public static String editNewsMeterial(EditMaterial material){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/update_news?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doPost(url,material);
        return url;
    }

    /**
     * 删除永久素材
     * @param media_id 素材id
     * @return
     */
    public static String delMeterial(String media_id){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/del_material?access_token=" + GetToken.getToken();
        String rel = HttpInterface.doPost(url,"{\"media_id\":\"" + media_id + "\"}");
        return rel;
    }

    /**
     * 下载临时素材
     * @param media_id id
     * @param path 保存文件的绝对路径包括文件名
     */
    public static boolean downTemMaterial(String media_id,String path){
        String url = VxConfigEnum.ROOTURL.val + "cgi-bin/media/get?access_token=" + GetToken.getToken() + "&media_id=" + media_id;
        return HttpInterface.doDown(url,path);
    }

    /**
     * 下载永久非视频与非图文的素材
     * @param meaia_id
     * @param path
     * @return
     */
    public static boolean downMaterial(String meaia_id,String path){
        String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/material/get_material?access_token=" + GetToken.getToken();
        return HttpInterface.doDown(url,path,"{\"media_id\":\"" + meaia_id + "\"}");
    }

}
