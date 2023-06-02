/*
* @Description: 使用Swagger2构建强大的API文档
* @Author: show.chen
* @Date: 2023/5/28 1:56 PM
*/

整合Swagger2
1、在pom.xml中加入依赖，具体如下：
        <!--springfox dependencies for api documentations in swagger -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>3.0.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>3.0.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>

2、application.properties中配置文档相关内容，比如：
    swagger.title=spring-boot-starter-swagger
    swagger.description=Starter for swagger 2.x
    swagger.version=1.4.0.RELEASE
    swagger.license=Apache License, Version 2.0
    swagger.licenseUrl=https://www.apache.org/licenses/LICENSE-2.0.html
    swagger.termsOfServiceUrl=https://github.com/dyc87112/spring-boot-starter-swagger
    swagger.contact.name=show.chen
    swagger.contact.url=http://blog.didispace.com
    swagger.contact.email=842930917@qq.com
    swagger.base-package=com.didispace
    swagger.base-path=/**
    spring.mvc.pathmatch.matching-strategy=ant-path-matcher

    各参数配置含义如下：
        swagger.title：标题
        swagger.description：描述
        swagger.version：版本
        swagger.license：许可证
        swagger.licenseUrl：许可证URL
        swagger.termsOfServiceUrl：服务条款URL
        swagger.contact.name：维护人
        swagger.contact.url：维护人URL
        swagger.contact.email：维护人email
        swagger.base-package：swagger扫描的基础包，默认：全扫描
        swagger.base-path：需要处理的基础URL规则，默认：/**

3、通过@Api，@ApiOperation注解来给API增加说明、通过@ApiImplicitParam、@ApiModel、@ApiModelProperty注解来给参数增加说明。
    参考项目的 User.java 和 UserController 文件

4、启动应用，访问：http://localhost:{port}/swagger-ui/index.html，如：
    http://localhost:8080/swagger-ui/index.html


出现 bug 参考：
    https://cloud.tencent.com/developer/ask/sof/106483919



