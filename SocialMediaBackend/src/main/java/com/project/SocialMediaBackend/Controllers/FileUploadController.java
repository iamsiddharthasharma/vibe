// package com.project.SocialMediaBackend.Controllers;

// import com.project.SocialMediaBackend.Services.FileService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.IOException;

// @RestController
// @RequestMapping("/file")
// public class FileUploadController {
//    @Autowired
//    FileService fileService;
//    @Value("${project.image}")
//    private String path;

//    @PostMapping("/upload-file")
//    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){

//        if(file.isEmpty()){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must contain file");
//        }
//        if(!file.getContentType().equals("image/jpeg")){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must be an image lol");
//        }
//        String filename =null;
//        try {
//           filename = fileService.uploadImage(path,file);
//        } catch (IOException e) {
//                e.printStackTrace();
//                return new ResponseEntity<>("some error occured during saving",HttpStatus.INTERNAL_SERVER_ERROR);
//        }

//        return ResponseEntity.ok("working");
//    }
// }
