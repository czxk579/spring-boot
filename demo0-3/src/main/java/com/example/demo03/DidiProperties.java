/*
 * @Description:
 * @Author: chenzhixiang.czx@alibaba-inc.com
 * @Date: 2023/10/21 16:05
 */
package com.example.demo03;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.didispace")
public class DidiProperties {

    /**
     * 这是一个测试配置
     */
    private String from;

}
