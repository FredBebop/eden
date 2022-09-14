package com.bebop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: eden
 * @package: com.bebop.configuration
 * @className: WebConfig
 * @author: fredbebop
 * @description: Web配置类
 * @date: 2022/8/27 14:19
 * @version: 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");
    }
}
