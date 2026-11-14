package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.upload")
@Data
public class LocalUploadProperties {

    /**
     * 本地文件保存目录
     */
    private String path;

    /**
     * 文件对外访问地址前缀
     */
    private String url;

}
