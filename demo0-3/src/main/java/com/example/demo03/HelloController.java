/*
 * @Description:
 * @Author: chenzhixiang.czx@alibaba-inc.com
 * @Date: 2023/10/21 16:05
 */
package com.example.demo03;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class HelloController {

    @Autowired
    private DidiProperties didiProperties;

    @RequestMapping("/hello")
    public String index() {
        log.info(didiProperties.getFrom());
        return "Hello World";
    }

}