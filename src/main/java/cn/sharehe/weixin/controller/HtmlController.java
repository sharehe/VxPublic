package cn.sharehe.weixin.controller;

import cn.sharehe.weixin.constant.VxConfigEnum;
import cn.sharehe.weixin.utils.HttpInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: wugui
 * @Date 2018-7-20 17:46
 */
@Controller
@RequestMapping("/html")
public class HtmlController {
    @RequestMapping("/one")
    public ModelAndView one(String code, String state){
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ VxConfigEnum.APPID.val +"&secret="+ VxConfigEnum.APPSECRET.val +"&code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = JSON.parseObject(HttpInterface.doGet(url));
        System.out.println(jsonObject.getString("openid"));
        ModelAndView view = new ModelAndView("index");
        view.addObject("openid",jsonObject.getString("openid"));
        return view;
    }
}
