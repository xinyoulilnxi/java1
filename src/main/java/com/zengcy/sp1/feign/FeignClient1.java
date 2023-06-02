package com.zengcy.sp1.feign;

import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.zengcy.sp1.dto.Result;
import com.zengcy.sp1.dto.TestReqDto;

/**
 * @author zengcy 2023-05-29
 */
@FeignClient(url = "http://localhost:8080", name = "test1")
public interface FeignClient1 {

    @PostMapping("/user/hello")
    Result<String> hello(@Valid @RequestBody TestReqDto req);


}
