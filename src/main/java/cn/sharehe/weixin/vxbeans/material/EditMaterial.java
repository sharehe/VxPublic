package cn.sharehe.weixin.vxbeans.material;

/**
 * 修改素材实体类
 * @Author: wugui
 * @Date 2018-7-19 11:33
 */
public class EditMaterial extends ItemImgAndTextMaterial {
    private String media_id;  // 	要修改的图文消息的id
    private String index;       // 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
