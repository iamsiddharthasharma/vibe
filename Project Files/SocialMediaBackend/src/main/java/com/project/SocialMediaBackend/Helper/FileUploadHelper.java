package com.project.SocialMediaBackend.Helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
//     public final String Upload_dir ="E:\\projects\\SocialMediaBackend\\src\\main\\resources\\static\\image";
public  String Upload_dir="";

    {
        try {
            Upload_dir = new ClassPathResource("static/image").getFile().getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean uploadFile(MultipartFile file){
        boolean f = false;

            try{
//                InputStream is=file.getInputStream();
//                byte data []=  new byte[is.available()];
//                is.read(data);
//
//                FileOutputStream fos = new FileOutputStream(Upload_dir+"\\"+file.getOriginalFilename());
//                fos.write(data);
//                fos.flush();
//                fos.close();

                Files.copy(file.getInputStream(), Path.of(Upload_dir + File.separator + file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

                f=true;
            }catch (Exception e){
                e.printStackTrace();
            }
        return f;
     }
}
