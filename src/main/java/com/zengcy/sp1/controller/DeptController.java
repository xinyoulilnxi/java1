package com.zengcy.sp1.controller;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.zengcy.sp1.properties.UserProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zengcy 2023-05-31
 */
@RestController
@Slf4j
public class DeptController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private UserProperties userProperties;

    @GetMapping(value = "/dept/nacos")
    public String getPayment() {
        return "<h2>c语言中文网提醒您，服务访问成功！</h2>服务名：spring-cloud-alibaba-provider<br /> 端口号： " + serverPort + "<br /> 传入的参数：" + userProperties.getId();
    }
}
