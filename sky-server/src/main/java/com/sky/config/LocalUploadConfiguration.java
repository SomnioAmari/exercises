package com.sky.config;

import com.sky.properties.LocalUploadProperties;
import com.sky.utils.LocalUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于创建本地文件上传工具类对象
 */
@Configuration
@Slf4j
public class LocalUploadConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LocalUploadUtil localUploadUtil(LocalUploadProperties localUploadProperties) {
        log.info("开始创建本地文件上传工具类对象：{}", localUploadProperties);
        return new LocalUploadUtil(localUploadProperties.getPath(), localUploadProperties.getUrl());
    }
}
