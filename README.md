# cloud2020
springcloud微服务   阿里巴巴

[视频链接](https://www.bilibili.com/video/BV18E411x7eT?p=95)

springcloud脑图在项目里面
# 一、简介
- 依托 Spring Cloud Alibaba
- 组件：
    - Nacos:服务注册与发现,配置,默认集成Ribbon的支持
    - Sentinel:服务限流降级
    - Seata:分布式事务
# 二、开发工具
- IntelliJ IDEA 2019.3.1 x64
- mysql  Ver 8.0.11
# 三、遇到的问题及解决的方法
- 碰到Mysql版本问题，我用的是mysql8版本
    - [nacos1.2不完美解决mysql8.0不兼容问题](https://blog.csdn.net/qq_35010942/article/details/104972110?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-4&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-4)
    - [解决seata不能使用mysql8版本的问题]( https://blog.csdn.net/qq_42915936/article/details/105206771 )
- 别的细心一点应该没有问题

以上都是可以测试成功的