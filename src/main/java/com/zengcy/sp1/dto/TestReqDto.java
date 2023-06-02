package com.zengcy.sp1.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author zengcy 2023-05-24
 */
@Data
public class TestReqDto {

    @NotNull(message = "姓名不能为空")
    private String name;

}
