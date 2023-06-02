package com.zengcy.sp1.controller;

import javax.validation.Valid;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zengcy.sp1.dto.Result;
import com.zengcy.sp1.dto.TestReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author zengcy 2023-05-24
 */
@Api
@RestController
@RequestMapping("/user")
@RefreshScope
public class TestController {
    /**
     * hello world.
     *
     * @return hello
     */
    @ApiOperation("Add User")
    @PostMapping("/hello")
    @ApiImplicitParam(name = "name", type = "body", dataTypeClass = TestReqDto.class, required = true)
    public Result<String> hello(@Valid @RequestBody TestReqDto name) {
        return Result.success("nihao" + name.getName());
    }
}
