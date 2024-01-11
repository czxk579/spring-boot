package com.example.demo15.controller;
import com.example.demo15.annotation.NoJsonResult;
import com.example.demo15.entity.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public JSONResult<String> test(){
        log.info("test方法开始");
        return new JSONResult<String>().success("test");
    }

    @GetMapping("/test2")
    public Boolean test2(){
        log.info("test2方法开始");
        return false;
    }

    @GetMapping("/test3")
    @NoJsonResult
    public String test3(){
        log.info("test3方法开始");
        return "test3";
    }

}
