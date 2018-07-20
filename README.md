## VxPublic
springboot搭建微信公众号常用接口框架包括菜单创建 素材更新 消息处理 账号管理 更换微信APPID可直接使用

该项目为一个web项目主要功能在于将微信公众号消息处理做了统一处理等，可在该项目上进行进一步的开发，包括公众号后台管理等

## 开始使用

### 需要配置的微信公众号常量

在constant.VxConfigEnum枚举类中的枚举类型需要修改成自己的对应微信公众平台上的值

值得注意的是MYTOKEN属性，这个属性为测试号管理的token

### 获取access_token

vxinterface.GetToken中的getToken方法为获取access_token，该方法进行了同步操作，防止并发获取。系统获取token的策略为没一个半小时便把koten清空，下次需要token时在获取token，清空token的操作在handle.ScheduleHandle中

## 消息处理与回复

1. 你只需要关心service包中的两个服务类即可，根据消息类型分为普通消息（MessageService）与事件消息(EventService)的对应处理方法即可，其中事件消息目前只写了常用事件处理，可添加需要的事件

2. 微信公众号的消息处理流程为：用户->微信服务器->项目服务器->微信服务器->用户

3. 消息格式为微信服务器（xml)->项目服务器(object)->微信服务器（xml)

4. 程序内部数据流为controller.VxTest(xml)->handle.MessageHandle(xml)

   ->utils.XmlOrBean(object)->handle.MessageHandle(object)->service.[Message|Event]Service(object)->handle.MessageHandle(object)->utils.XmlOrBean(xml)->controller.VxTest(xml)

   ### 添加需要而没有的事件处理步骤

   1. 需要修改utils.XmlOrBean的mapToBean方法在TODO注释点增加else if即可，
   2. 根据返回的对象在handle.MessageHanle中添加对应的instance判断也可添加其他判断，
   3. 在service中添加对应的处理接口方法，与实现方法就可以了

## 接口使用

1. 注意 这里需要特别注意 由于在test测试我为了加快测试速度使用的main所以在里面测试并没有启动工程，则需要手动说的token则需要先在vxinterface.GetToken中去把Token获得并设置为Token的属性才可使用以下测试类
2. 添加菜单如何使用添加菜单接口可以参照test.*.menu.AddMenu测试类中的代码使用
3. 素材管理，可查看test.*.material.*中的实列使用
4. 账号管理， 可查看test.*.account.*中的实列使用
5. 注意  测试完成后，启动项目需要将Token属性设置为null

## 部分包说明

### vxbeans

该包下主要是vx接口与消息回复需要的实体类

account----------------为账号管理中的实体类

material----------------为素材管理下的实体类

menu--------------------为菜单管理的实体类

msg-----------------------为消息接收与回复的实体类，里面分为四类，消息基类以Base结尾，From开头的为接收普通消息的实体类，Even开头的为接收事件的实体类，To开头的为被动回复消息的实体类

### vxinterface

该包下为调用微信的接口实现类