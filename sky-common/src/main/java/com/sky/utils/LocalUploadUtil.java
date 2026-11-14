package com.sky.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 本地文件上传工具类
 */
@Data
@AllArgsConstructor
@Slf4j
public class LocalUploadUtil {

    /**
     * 本地文件保存目录
     */
    private String path;

    /**
     * 文件对外访问地址前缀
     */
    private String url;

    /**
     * 文件上传到本地磁盘
     *
     * @param bytes      文件字节数组
     * @param objectName 保存的文件名
     * @return 文件访问路径
     */
    public String upload(byte[] bytes, String objectName) throws IOException {
        // 创建保存目录
        Path dir = Paths.get(path);
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        // 写入文件
        Path filePath = dir.resolve(objectName);
        Files.write(filePath, bytes);

        String fileUrl = url + objectName;
        log.info("文件上传到:{}", fileUrl);
        return fileUrl;
    }
}
