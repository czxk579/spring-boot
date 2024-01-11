package com.example.demo131.dto;
import com.example.demo131.annotation.ValidString;
import com.example.demo131.common.ValidGroup;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotNull(groups = {ValidGroup.class},message = "ID不能为空")
    private Long id;

    @NotBlank(message = "名字为必填项")
    private String username;

    @Email(message = "邮箱格式不正确")
    private String email;

    @ValidString(value = {"男","女"},message = "性别只能是男或者女")
    private String sex;


}
