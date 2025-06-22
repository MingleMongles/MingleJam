package com.minglemongles.minglejam.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.minglemongles.minglejam.*.query.repository", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
