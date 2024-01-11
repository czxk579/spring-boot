package com.example.demo15.aop;
import com.example.demo15.annotation.NoJsonResult;
import com.example.demo15.controller.TestController;
import com.example.demo15.entity.JSONResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


//@RestControllerAdvice(basePackageClasses = TestController.class)  // 未生效
// 全局限定 JSON 格式作用范围为 com.example.demo15.controller 这个包
@RestControllerAdvice(basePackages = "com.example.demo15.controller")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !(
                // 过滤掉已经加上jsonResult返回值的方法和加上 NoJsonResult 注解的方法
                returnType.getParameterType().equals(JSONResult.class) || returnType.hasMethodAnnotation(NoJsonResult.class)
                )
                // 作用范围限制在 TestController.class 类的所有方法
                && returnType.getContainingClass().equals(TestController.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //String类型需要特殊处理
        if (returnType.getParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new JSONResult<>().success(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new JSONResult<>().success(body);
    }
}
