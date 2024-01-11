package com.example.demo131.controller;
import com.example.demo131.common.ValidGroup;
import com.example.demo131.dto.UserDTO;
import com.example.demo131.entity.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TestController {

    @RequestMapping("/save")
    public JSONResult<String> save(@Validated @RequestBody UserDTO userDTO){
        return new JSONResult<String>().success("success");
    }

    @RequestMapping("/update")
    public JSONResult<String> update(@Validated(ValidGroup.class) @RequestBody UserDTO userDTO){
        return new JSONResult<String>().success("success");
    }


}
