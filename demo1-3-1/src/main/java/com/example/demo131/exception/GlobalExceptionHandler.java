package com.example.demo131.exception;
import com.example.demo131.entity.JSONResult;
import com.example.demo131.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //服务器异常处理
    @ExceptionHandler(value = Exception.class)
    public JSONResult<Object> defaultExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("系统错误！原因是：",e);
        return new JSONResult<Object>().fail(ErrorCode.ERR_SYSTEM.getCode(),
                ErrorCode.ERR_SYSTEM.getMessage());
    }
    //自定义异常处理
    @ExceptionHandler(value = CustomException.class)
    public JSONResult<Object> businessExceptionHandler(HttpServletRequest req,
                                                       CustomException e) {
        log.error("业务异常！原因是：",e);
        return new JSONResult<Object>().fail(e.getErrorCode(),
                e.getErrorCodeDes());
    }

   //空指针异常处理
    @ExceptionHandler(value =NullPointerException.class)
    public JSONResult<Object> exceptionHandler(HttpServletRequest req,
                                               NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return new JSONResult<Object>().fail(ErrorCode.NULL_POINTER_ERROR.getCode(),
                ErrorCode.NULL_POINTER_ERROR.getMessage());
    }
    //....当然这里还可以定义很多异常，如果数字转换异常等等

    //参数校验异常处理
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public JSONResult<Object> handleValidatedException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            return new JSONResult<Object>().fail(ErrorCode.PARAM_VALIDATION_ERROR.getCode(),
                    ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        }
        return new JSONResult<Object>().fail(ErrorCode.PARAM_VALIDATION_ERROR.getCode(),ErrorCode.PARAM_VALIDATION_ERROR.getCode());
    }
}
