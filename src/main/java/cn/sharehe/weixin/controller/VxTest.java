package cn.sharehe.weixin.controller;

import cn.sharehe.weixin.handle.MessageHandle;
import cn.sharehe.weixin.utils.VxSigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: wugui
 * @Date 2018-7-17 14:35
 */
@RestController
@RequestMapping("/test")
public class VxTest {
    @Autowired
    private MessageHandle messageHandle;
    // 验证token是否一致
    @GetMapping(value = "/qryToken")
    public String qryToken(HttpServletRequest req){
        Enumeration pname = req.getParameterNames();
        while (pname.hasMoreElements())
            System.out.println(pname.nextElement());
        String signature = req.getParameter("signature");/// 微信加密签名
        String timestamp = req.getParameter("timestamp");/// 时间戳
        String nonce = req.getParameter("nonce"); /// 随机数
        String echostr = req.getParameter("echostr"); // 随机字符串
        if (VxSigUtil.checkSignature(signature,timestamp,nonce))
            return echostr;
        return "";
    }

    /**
     * 推送消息接口
     * @param req
     * @return
     */
    @PostMapping(value = "/qryToken")
    public String message(HttpServletRequest req){
        String a = messageHandle.handle(req);
        System.out.println(a);
        return a;
    }
}
