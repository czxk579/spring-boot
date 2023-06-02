/*
* @Description: JSR-303实现请求参数校验
* @Author: show.chen
* @Date: 2023/5/28 2:17 PM
*/

请求参数校验
1、在pom.xml中加入依赖，具体如下：
    <dependency>
        <groupId>org.jetbrains</groupId>
        <artifactId>annotations</artifactId>
        <version>RELEASE</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

2、在要校验的字段上添加上@NotNull注解，具体如下：（参考 User.java）
    @Data
    @ApiModel(description="用户实体")
    public class User {

        @ApiModelProperty("用户编号")
        private Long id;

        @NotNull
        @ApiModelProperty("用户姓名")
        private String name;

        @NotNull
        @ApiModelProperty("用户年龄")
        private Integer age;

    }

3、在需要校验的参数实体前添加@Valid注解，具体如下：（参考 UserController.java）
    @PostMapping("/")
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    public String postUser(@Valid @RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }




Maven 包：javax.validation.constraints:validation-api-2.0.1.Final
    注解	作用数据类型	说明
    @Null	任何类型	对象必须为空
    @NotNull	任何类型	对象不为空
    @NotBlank	字符串	对象不为空，字符串去掉前后空格后长度不为0
    @NotEmpty	字符串、集合、数组	对象不为空，且字符串长度不为0，集合、数组大小不为0
    @AssertTrue	布尔型	必须为true；null值有效，Boolean通过校验，boolean不可
    @AssertFalse	布尔型	必须为false；null 可通过校验
    @Min(number)	整型数	数值必须大于或等于指定的最小值
    @Max(number)	整型数	数值必须小于或等于指定的最大值
    @DecimalMin(decimal)	浮点型	数值必须大于或等于指定的最小值，内部使用BigDecimal定义数值对象；为 null 是校验通过；默认包含边界值
    @DecimalMax(decimal)	浮点型	数值必须小于或等于指定的最大值，内部使用BigDecimal定义数值对象；为 null 是校验通过；默认包含边界值
    @Positive	整型数	数值必须为正整数
    @PositiveOrZero	整型数	数值必须为正整数或0
    @Negative	整型数	数值必须为负整数
    @NegativeOrZero	整型数	数值必须为负整数或0
    @Digits	数值型或者字符串	作为数值其构成必须合法
    @Digits(integer=, fraction=)	数值型	数值必须符合指定的整数精度和小数精度
    @Size(min=, max=)	字符串、集合、数组	对象的大小在指定区间内；为 null 是校验通过
    @Past	Date或者Calendar对象	必须是一个过去的日期
    @PastOrPresent	Date或者Calendar对象	必须是一个过去或者当前的日期
    @Future	Date或者Calendar对象	必须是一个将来的日期
    @FutureOrPresent	Date或者Calendar对象	必须是一个将来或者当前的日期
    @Pattern	字符串	必须是规则正确的正则表达式
    @Email	字符串	必须是Email类型；可以通过指定regexp和flags来自定义email格式；为null时算作通过验证


Maven 包：org.hibernate.validator.constraints:hibernate-validator-6.0.18.Final
    注解	作用数据类型	说明
    @Length(min=, max=)	字符串	字符串的长度在指定区间内
    @Range(min=, max=)	数值型	数值必须在指定闭区间内
    @CreditCardNumber	字符串	必须是通过Luhn校验和测试的信用卡号码
    @URL	字符串	必须是URL地址
    @UniqueElements	集合类	校验集合中的值都是唯一的，null 视为有效成员



SpringBoot 的请求参数校验注解参考：
    https://blog.csdn.net/sinat_36645384/article/details/123672082
