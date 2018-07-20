package cn.sharehe.weixin.utils;

import cn.sharehe.weixin.constant.VxEvenEnum;
import cn.sharehe.weixin.constant.VxMsgEnum;
import cn.sharehe.weixin.vxbeans.msg.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将xml转换为消息实体类
 * 将消息实体类装换为xml
 *
 * @Author: wugui
 * @Date 2018-7-18 10:38
 */
@SuppressWarnings("all")
public class XmlOrBean {
    /**
     * 公共方法将微信转化的xml消息转换为bean
     * @param req
     * @return
     */
    public static Object xmlToBean(HttpServletRequest req) {
        Document document = null;
        Map<String,String> map = new HashMap<>();
        try {
            // 从request中取得输入流
            InputStream inputStream = req.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList){
                // TODO 输出接收的参数名与对应值
                System.out.println(e.getName() + "----" + e.getText());
                map.put(e.getName(),e.getText());
            }
            // 释放资源
            inputStream.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapToBean(map);
    }

    /**
     * 将map装换为对应bean
     * @param map
     * @return
     */
    private static Object mapToBean(Map<String, String> map) {
        String type = map.get("MsgType");
        try {
            if (type.equals(VxMsgEnum.EVENT.val)) {
                String evenType = map.get("Event");
                if (evenType.equals(VxEvenEnum.CLICK.val)){
                    EvenMenuClickMsg clickMsg = new EvenMenuClickMsg();
                    mapToBean(clickMsg,map);
                    return clickMsg;
                }else if (evenType.equals(VxEvenEnum.SUBSCRIBE.val)){
                    EvenMsgBase evenMsgBase = new EvenMsgBase();
                    mapToBean(evenMsgBase,map);
                    return evenMsgBase;
                }else if (evenType.equals(VxEvenEnum.UNSUBSCRIBE.val)){
                    EvenMsgBase evenMsgBase = new EvenMsgBase();
                    mapToBean(evenMsgBase,map);
                    return evenMsgBase;
                }else if (evenType.equals(VxEvenEnum.VIEW.val)){
                    EvenViewMsg viewMsg = new EvenViewMsg();
                    mapToBean(viewMsg,map);
                    return viewMsg;
                }else if (evenType.equals(VxEvenEnum.SCAN.val)){
                    EvenScanMsg scanMsg = new EvenScanMsg();
                    mapToBean(scanMsg,map);
                    return scanMsg;
                }else if (evenType.equals(VxEvenEnum.LOCATION.val)){

                }else {
                    return null;         // TODO 缺少事件处理 可在这里增加对应处理事件
                }
            } else if (type.equals(VxMsgEnum.TEXT.val)) {
                FromTextMsg fromTextMsg = new FromTextMsg();
                mapToBean(fromTextMsg, map);
                return fromTextMsg;
            } else if (type.equals(VxMsgEnum.IMAGE.val)) {
                FromImgMsg imgMsg = new FromImgMsg();
                mapToBean(imgMsg,map);
                return imgMsg;
            } else if (type.equals(VxMsgEnum.VOICE.val)) {
                FromVoiceMsg voiceMsg = new FromVoiceMsg();
                mapToBean(voiceMsg,map);
                return voiceMsg;
            } else if (type.equals(VxMsgEnum.VIDEO.val)) {
                FromMp4ShortMsg mp4ShortMsg = new FromMp4ShortMsg();
                mapToBean(mp4ShortMsg,map);
                return mp4ShortMsg;
            } else if (type.equals(VxMsgEnum.SHORTVIDEO.val)) {
                FromMp4ShortMsg mp4ShortMsg = new FromMp4ShortMsg();
                mapToBean(mp4ShortMsg,map);
                return mp4ShortMsg;
            } else if (type.equals(VxMsgEnum.LOCATION.val)) {
                FromLocationMsg locationMsg = new FromLocationMsg();
                mapToBean(locationMsg,map);
                return locationMsg;
            } else if (type.equals(VxMsgEnum.LINK.val)) {
                FromLinkMsg linkMsg = new FromLinkMsg();
                mapToBean(linkMsg,map);
                return linkMsg;
            } else {

            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射 设置对象属性值
     * @param object
     * @param map
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void mapToBean(Object object, Map<String, String> map) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = object.getClass();
        Field f = null;
        for (Map.Entry entry : map.entrySet()) {
            try {
                f = clazz.getDeclaredField((String) entry.getKey());
            }catch (NoSuchFieldException e){
                Class c = clazz.getSuperclass();
                try {
                    f = c.getDeclaredField((String) entry.getKey());
                }catch (NoSuchFieldException e1){
                    try{
                        Class c1 = c.getSuperclass();
                        f = c1.getDeclaredField((String) entry.getKey());
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
            f.setAccessible(true);
            f.set(object, entry.getValue());
        }
    }

    /**
     * 扩展xstream使其支持CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;
                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write(text);
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * 将bean装换为xml
     * @param textMessage
     * @return
     */
    public static String messageToXml(MessageBase textMessage) {
        xstream.alias("xml", textMessage.getClass());
        xstream.alias("item", new ToNewsItem().getClass());
        return xstream.toXML(textMessage);
    }


    public static void main(String[] args) {
        ToTextMsg toTextMsg = new ToTextMsg();
        toTextMsg.setToUserName("touser");
        toTextMsg.setContent("发送的消息");
        MessageBase messageBase = toTextMsg;
        System.out.println(XmlOrBean.messageToXml(messageBase));
        Object a = new FromLinkMsg();
        System.out.println(a instanceof ToTextMsg);
    }
}
