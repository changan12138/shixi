package com.itheima.manger.exception;

import com.itheima.manger.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class Globalexcetion {
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error(e.getMessage());
        return  Result.error("出错了");
    }
}
