package com.bebop.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: eden
 * @package: com.bebop.configuration
 * @className: MybatisConfig
 * @author: fredbebop
 * @description: TODO
 * @date: 2022/9/21 16:23
 * @version: 1.0
 */
@Configuration
@MapperScan("com.bebop.login.mapper")
public class MybatisConfig {
}
