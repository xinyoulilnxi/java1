package com.zengcy.sp1.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @author zengcy 2023-05-31
 */
@Data
@ConfigurationProperties(prefix = "user")
@Component
public class UserProperties {

    private Long id;
}
