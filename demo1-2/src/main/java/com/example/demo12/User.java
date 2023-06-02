/*
 * @Description:
 * @Author: chenzhixiang.czx@alibaba-inc.com
 * @Date: 2023/5/28 7:37 AM
 */
package com.example.demo12;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="用户实体")
public class User {

    @ApiModelProperty("用户编号")
    private Long id;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户年龄")
    private Integer age;

}
