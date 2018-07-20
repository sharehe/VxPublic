package cn.sharehe.weixin.vxbeans.account;

/**
 * 获取二维码需要ticket实体类
 * @Author: wugui
 * @Date 2018-7-19 17:56
 */
public class CountAc {
    private String expire_seconds;  // 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
    private String action_name;     // 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
    private CountAcInfo action_info;    //

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public CountAcInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(CountAcInfo action_info) {
        this.action_info = action_info;
    }
}
