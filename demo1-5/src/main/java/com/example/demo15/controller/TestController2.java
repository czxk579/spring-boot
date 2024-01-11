/*
 * @Description:
 * @Author: chenzhixiang.czx@alibaba-inc.com
 * @Date: 2023/11/12 21:18
 */
package com.example.demo15.controller;

import com.example.demo15.entity.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TestController2 {
    @GetMapping("/hello")
    public Boolean test() {
        log.info("test方法开始");
        return false;
    }

}
