package cn.sharehe.weixin.handle;

import cn.sharehe.weixin.vxinterface.GetToken;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: wugui
 * @Date 2018-7-17 11:44
 */
@Component
public class ScheduleHandle {
    @Scheduled(fixedDelay = 1800*3000)  // 1.5 小时 1800*3000
    public void autoGetToken(){
        GetToken.setTokenNull();
    }

}
