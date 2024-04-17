package com.jingdianjichi.oss.controller;

//import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jingdianjichi.oss.entity.Result;
import com.jingdianjichi.oss.service.FileService;
//import com.jingdianjichi.oss.service.StorageService;
import com.jingdianjichi.oss.util.MinioUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:05 2024/3/24
 */
@RestController
@RefreshScope
public class FileController {
//    @Resource
//    private MinioUtil minioUtil;
//    @Resource
//    private StorageService minioStorageServiceImpl;
//    @Resource
//    private StorageService aliStorageServiceImpl;
    @Resource
    private FileService fileService;
    @Value(value = "${storage.service.type}")
    private String storageType;
    @RequestMapping("/testGetAllBuckets")
    public List<String> testGetAllBuckets() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        return allBucket;
    }
    @RequestMapping("/testNacos")
    public String testNacos() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        return storageType;
    }
    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile, String bucket, String objectName) throws Exception {
        String url = fileService.uploadFile(uploadFile, bucket, objectName);
        return Result.ok(url);
    }
}
