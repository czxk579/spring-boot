/*
 * @Description:
 * @Author: chenzhixiang.czx@alibaba-inc.com
 * @Date: 2023/5/28 4:01 PM
 */
package com.example.demo14;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1-教师管理", "3-教学管理"})
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @ApiOperation(value = "xxx")
    @GetMapping("/xxx")
    public String xxx() {
        return "xxx";
    }

}
