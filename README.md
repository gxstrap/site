# site 介绍 #
它是基于Dubbo的分布式系统架构，快速简单的上手。
****

#### site框架所包含的系统
<pre>
    site-core：
        <code>核心通用jar包；</code>
        <code>包含model，interface，util等工具类；</code>

    site-job：
        <code>WEB界面的定时任务系统；</code>
        <code>集成了Dubbo的Consumer消费端；</code>
        <code>包含SpringMVC、SpringJDBC、Mybatis、Quartz、Log4j2、H2内存数据库；</code>

    site-logs：
        <code>MongoDB日志查询系统，site架构中，支持将日志写入MongoDB，site-logs则是查询分析MongoDB当中日志；</code>
        <code>包含SpringMVC、Spring-data、Log4j2、MongoDB数据库；</code>

    site-web：
        <code>前置系统，即WEB项目；</code>
        <code>集成了Dubbo的Consumer消费端；</code>
        <code>包含SpringMVC、Apache Shiro、Sitemesh3、Log4j2；</code>

    site-ws：
        <code>底层服务系统，即Dubbo的Provider提供端；；</code>
        <code>包含SpringMVC、 Mybatis、Log4j2；</code>
        <code>附有Redis操作示例；</code>
        <code>支持多数据源，支持Oracle、MySQL、SQLite数据库；</code>
        <code>数据库表的主键生成机制；</code>
</pre>

#### site示例启动
<pre>
    1. <code>数据库选择，默认开启SQLite数据库，若改用Oracle或MySQL，可在site-ws工程的<font color="blue">datasource.properties</font>数据源配置文件当中设置；</code>
    2. <code>本地架设一个zookeeper并启动好，修改好site-ws、site-web、site-job工程当中的<font color="blue">dubbo.properties</font>配置文件，将里面的zookeeper地址改为本地框架的ip与商品；</code>
    3. <code>启动site-ws工程；</code>
    4. <code>分别启动site-web、site-job两个工程，注意各启动的工程之间商品不要冲突；</code>
    5. <code>浏览器访问site-web、site-job两个工程查看示例效果；</code>
</pre>
****
欢迎[交流讨论](https://github.com/wangxinforme/site/issues)
[胡桃夹子GitHub](https://github.com/wangxinforme "Vincent Git@OSC主页")

