/*
* @Description: 日志管理
* @Author: show.chen
* @Date: 2023/5/21 3:03 PM
*/


1、日志的组成元素
    详细的日志元素见项目根目录的 日志的组成.png
    日志的输出内容中一共有7种元素，具体如下：
        1）时间日期：精确到毫秒
        2）日志级别：ERROR, WARN, INFO, DEBUG or TRACE
        3）进程ID
        4）分隔符：--- 标识实际日志的开始
        5）线程名：方括号括起来（可能会截断控制台输出）
        6）Logger名：通常使用源代码的类名
        7）日志内容

2、开启DEBUG日志
    可以通过两种方式切换至DEBUG级别：
    第一种：在运行命令后加入--debug标志，如：$ java -jar myapp.jar --debug
    第二种：在配置文件application.properties中配置debug=true


3、日志配置
    3.1 多彩输出
        如果终端支持ANSI，设置彩色输出会让日志更具可读性。
        通过在application.properties中设置spring.output.ansi.enabled参数来支持，该参数有三个选项：
            NEVER：禁用ANSI-colored输出
            DETECT：会检查终端是否支持ANSI，是的话就采用彩色输出（spring boot2 默认项）
            ALWAYS：总是使用ANSI-colored格式输出，若终端不支持的时候，会有很多干扰信息，不推荐使用

    3.2 文件输出
        logging.file.name=run.log
        logging.file.path=./
        其中，
            logging.file.name 设置文件名
            logging.file.path 设置文件路径

    3.3 文件滚动
        logging.logback.rollingpolicy.file-name-pattern：用于创建日志档案的文件名模式。
        logging.logback.rollingpolicy.clean-history-on-start：应用程序启动时是否对进行日志归档清理，默认为false，不清理
        logging.logback.rollingpolicy.max-history：要保留的最大归档日志文件数量，默认为7个
        logging.logback.rollingpolicy.max-file-size：归档前日志文件的最大尺寸，默认为10MB
        logging.logback.rollingpolicy.total-size-cap：日志档案在被删除前的最大容量，默认为0B

    3.4 级别控制
        配置格式：logging.level.*=LEVEL
            logging.level：日志级别控制前缀，*为包名或Logger名
            LEVEL：选项TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF
        如：
            logging.level.com.didispace=DEBUG：com.didispace包下所有class以DEBUG级别输出
            logging.level.root=WARN：root日志以WARN级别输出

4、自定义输出格式
    在Spring Boot中可以通过在application.properties配置如下参数控制输出格式：
        logging.pattern.console：定义输出到控制台的样式（不支持JDK Logger）
        logging.pattern.file：定义输出到文件的样式（不支持JDK Logger）

