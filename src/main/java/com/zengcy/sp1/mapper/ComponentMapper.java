package com.zengcy.sp1.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.zengcy.sp1.entity.ComponentEntity;

/**
 * @author zengcy 2023-05-29
 */
@Mapper
public interface ComponentMapper {

    ComponentEntity findList();

}
