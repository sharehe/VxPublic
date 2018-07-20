package cn.sharehe.weixin.vxbeans.menu;

import java.util.List;

/**
 * 一直菜单实体类
 * @Author: wugui
 * @Date 2018-7-17 15:12
 */
public class OneMenu {
    private String name;
    private List<TwoMenu> sub_button;
    private String type;
    private String key;
    private String url;
    private String media_id;
    private String appid;
    private String pagepath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TwoMenu> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<TwoMenu> sub_button) {
        this.sub_button = sub_button;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}
