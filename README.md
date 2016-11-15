# site 介绍 #
它是基于Dubbo的分布式系统架构，快速简单的上手。
****

#### site框架所包含的系统
<pre>
    site-core：
        核心通用jar包；
        包含model，interface，util等工具类；

    site-job：
        WEB界面的定时任务系统；
        集成了Dubbo的Consumer消费端；
        包含SpringMVC、SpringJDBC、Mybatis、Quartz、Log4j2、H2内存数据库；

    site-logs：
        MongoDB日志查询系统，site架构中，支持将日志写入MongoDB，site-logs则是查询分析MongoDB当中日志；
        包含SpringMVC、Spring-data、Log4j2、MongoDB数据库；

    site-web：
        前置系统，即WEB项目；
        集成了Dubbo的Consumer消费端；
        包含SpringMVC、Apache Shiro、Sitemesh3、Log4j2；

    site-ws：
        底层服务系统，即Dubbo的Provider提供端；；
        包含SpringMVC、 Mybatis、Log4j2；
        附有Redis操作示例；
        支持多数据源，支持Oracle、MySQL、SQLite数据库；
        数据库表的主键生成机制；
</pre>

#### site示例启动
<pre>
    1. 数据库选择，默认开启SQLite数据库，若改用Oracle或MySQL，可在site-ws工程的<font color="blue">datasource.properties</font>数据源配置文件
        当中设置；
    2. 本地架设一个zookeeper并启动好，修改好site-ws、site-web、site-job工程当中的<font color="blue">dubbo.properties</font>配置文件，将里面的
       zookeeper地址改为本地框架的ip与商品；
    3. 启动site-ws工程；
    4. 分别启动site-web、site-job两个工程，注意各启动的工程之间商品不要冲突；
    5. 浏览器访问site-web、site-job两个工程查看示例效果；
</pre>
****
欢迎[交流讨论](https://github.com/wangxinforme/site/issues)

[胡桃夹子GitHub](https://github.com/wangxinforme "Vincent Git@OSC主页")

