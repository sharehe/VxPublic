package cn.sharehe.weixin.vxbeans.msg;

/**
 * 接收到地理位置消息
 * @Author: wugui
 * @Date 2018-7-18 10:10
 */
public class FromLocationMsg extends FromMsgBase{
    private String Location_X;// 地理位置维度
    private String Location_Y;// 地理位置经度
    private String Scale;// 地图缩放大小
    private String Label;// 地理位置信息

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    @Override
    public String toString() {
        return super.toString() + "FromLocationMsg{" +
                "Location_X='" + Location_X + '\'' +
                ", Location_Y='" + Location_Y + '\'' +
                ", Scale='" + Scale + '\'' +
                ", Label='" + Label + '\'' +
                '}';
    }
}
