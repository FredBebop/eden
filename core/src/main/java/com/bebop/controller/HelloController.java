package com.bebop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: eden
 * @package: com.bebop.controller
 * @className: HelloController
 * @author: fredbebop
 * @description: 测试Controller
 * @date: 2022/9/13 15:25
 * @version: 1.0
 */
@RestController
@RequestMapping("/hello")
@Api(tags = "测试接口文档")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/test")
    @ApiOperation(value = "测试api", notes = "目前仅仅是作为测试")
    public String test() {
        logger.debug("日志测试");
        logger.info("日志测试");
        logger.warn("日志测试");
        logger.error("日志测试");
        return "打印日志";
    }
}
