/*
 * @Description:
 * @Author: chenzhixiang.czx@alibaba-inc.com
 * @Date: 2023/5/28 3:57 PM
 */
package com.example.demo14;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"2-学生管理"})
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @ApiOperation(value = "获取学生清单", notes = "bbb", tags = "3-教学管理")
    @GetMapping("/list")
    public String bbb() {
        return "bbb";
    }

    @ApiOperation(value = "获取教某个学生的老师清单", notes = "ccc")
    @GetMapping("/his-teachers")
    public String ccc() {
        return "ccc";
    }

    @ApiOperation(value = "创建一个学生", notes = "aaa")
    @PostMapping("/aaa")
    public String aaa() {
        return "aaa";
    }

}
