package com.zengcy.sp1.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zengcy.sp1.annotation.MyLog;
import com.zengcy.sp1.mapper.ComponentMapper;
import com.zengcy.sp1.dto.Result;
import com.zengcy.sp1.dto.TestReqDto;
import com.zengcy.sp1.entity.ComponentEntity;
import com.zengcy.sp1.feign.FeignClient1;

/**
 * @author zengcy 2023-05-29
 */
@RestController
@RequestMapping("/test1")
public class Tset1Controller {

    @Resource
    private FeignClient1 feignClient1;

    @Autowired
    private ComponentMapper componentMapper;

    @MyLog(description = "测试注解描述一")
    @PostMapping("/hello1")
    public Result<String> hello(@Valid @RequestBody TestReqDto name) {
        Result<String> hello = feignClient1.hello(name);
        ComponentEntity list = componentMapper.findList();
        System.out.println(list.getComponentId() + list.getComponentGroupId() + list.getComponentUrn());
        return Result.success(hello.getData());
    }

}
