package com.fundzforus.server.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileUploadUtil {

    @Autowired
    AWSImagesUpload awsImagesUpload;

    public String saveImages(int userId, String fileName, MultipartFile multipartFile,
                             String userType) {
        return awsImagesUpload.uploadFile(multipartFile, userId, fileName, userType, MediaType.IMAGES);
    }

    public String savePdfs(int userId, String fileName, MultipartFile multipartFile,
                           String userType) {
        return awsImagesUpload.uploadFile(multipartFile, userId, fileName, userType, MediaType.PDFS);
    }
}
