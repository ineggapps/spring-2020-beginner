package com.demo3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 환경 설정을 위한 클래스
@ComponentScan(basePackages = { "com.demo3" })
public class SpringConfig {
}
