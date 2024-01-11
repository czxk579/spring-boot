package com.example.demo15.controller;
import com.example.demo15.entity.JSONResult;
import com.example.demo15.error.ErrorCode;
import com.example.demo15.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestExceptionController {

    /**
     * 数学计算异常，全局异常捕获
     */
    @GetMapping("/exceptionTest")
    public JSONResult<String> exceptionTest(){
        System.out.println(1/0);
        return new JSONResult<String>().success("test");
    }

    /**
     * 自定义异常
     */
    @GetMapping("/exceptionTest2")
    public Boolean exceptionTest2(){
        throw new CustomException(ErrorCode.CUSTOM_ERR.getCode(),
                ErrorCode.CUSTOM_ERR.getMessage());
    }

    /**
     *空指针异常
     */
    @GetMapping("/exceptionTest3")
    public Boolean exceptionTest3(){
        //模拟空指针异常
        String str = null;
        str.length();
        return true;
    }

    @GetMapping("/exceptionTest5")
    public Boolean exceptionTest5(){
        return true;
    }


}
