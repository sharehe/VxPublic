package cn.sharehe.weixin.vxbeans.msg;

import cn.sharehe.weixin.constant.VxMsgEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息实体类
 * @Author: wugui
 * @Date 2018-7-18 09:40
 */
public class ToImgAndTextMsg extends MessageBase {
    private String ArticleCount;  // 图文消息个数，限制为8条以内
    private List<ToNewsItem> Articles;  // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
    public ToImgAndTextMsg(){
        super.setMsgType(VxMsgEnum.NEWS.val);
        Articles = new ArrayList<>();
    }
    public void add(ToNewsItem toNewsItem){
        Articles.add(toNewsItem);
    }
    public List<ToNewsItem> getArticles() {
        return Articles;
    }

    public void setArticles(List<ToNewsItem> articles) {
        Articles = articles;
    }

    public String getArticleCount() {
        return ArticleCount;
    }


    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }


}
