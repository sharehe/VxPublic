package cn.sharehe.weixin.vxbeans.material;

import java.util.List;

/**
 * 上传永久图文素材的外部实体类
 * @Author: wugui
 * @Date 2018-7-19 11:01
 */
public class ImgAndTextMaterial {
    List<ItemImgAndTextMaterial> articles;

    public List<ItemImgAndTextMaterial> getArticles() {
        return articles;
    }

    public void setArticles(List<ItemImgAndTextMaterial> articles) {
        this.articles = articles;
    }
}
