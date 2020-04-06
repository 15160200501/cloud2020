package com.ming.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.ming.springcloud.dao"})
public class MybatisConfig {
}
