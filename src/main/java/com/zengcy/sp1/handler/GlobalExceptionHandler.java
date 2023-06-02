package com.zengcy.sp1.handler;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.google.common.collect.Lists;
import com.zengcy.sp1.dto.Result;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zengcy 2023-05-24
 * 参数校验handler
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Object> exceptionHandler(MethodArgumentNotValidException e) {
        List<InvalidDto> invalids = Lists.newArrayList();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            InvalidDto invalid = new InvalidDto();
            if (Boolean.FALSE.equals(fieldError.getRejectedValue())) {
            } else {
                invalid.setPath(fieldError.getField());
            }
            invalid.setValue(fieldError.getRejectedValue());
            invalid.setReason(fieldError.getDefaultMessage());
            invalids.add(invalid);
        }

        log.error("参数校验异常：{}", invalids);
        return Result.fail(null, invalids.get(0).getReason());
    }

    @Data
    @Accessors(chain = true)
    public static class InvalidDto {

        private String path;

        private Object value;

        private String reason;

    }
}
