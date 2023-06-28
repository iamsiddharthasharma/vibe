//package com.project.SocialMediaBackend.Services.impl;
//
//import com.project.SocialMediaBackend.Services.FileService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//@Service
//public class FileServiceImplCopy implements FileService {
//    @Override
//    public String uploadImage(String path, MultipartFile file) throws IOException {
//
//        //file name
//        String name = file.getOriginalFilename();
//        //full path
//        String filePath=path+ File.separator+ name;
//        //create folder if not present
//        File f = new File(path);
//        if(!f.exists()){
//            f.mkdir();
//        }
//        //file copy
//
//        Files.copy(file.getInputStream(), Paths.get(filePath));
//        return name;
//    }
//}
