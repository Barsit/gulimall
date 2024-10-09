package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnune;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @projectName:gulimall
 * @see:com.atguigu.gulimall.product.exception
 * @author:db
 * @createTime:2024/10/5 11:23
 * @version:1.0
 */
//集中处理所有异常
@Slf4j
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现异常:{}，异常类型:{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String , String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnune.ValidException.getCode(),BizCodeEnune.ValidException.getMsg()).put("data",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.error("错误：",throwable);
        return R.error(BizCodeEnune.UNKNOW_EXCEPTION.getCode(), BizCodeEnune.UNKNOW_EXCEPTION.getMsg());
    }
}
