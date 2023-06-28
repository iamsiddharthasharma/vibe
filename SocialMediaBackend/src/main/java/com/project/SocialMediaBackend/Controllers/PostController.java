package com.project.SocialMediaBackend.Controllers;


import com.project.SocialMediaBackend.Helper.FileUploadHelper;
import com.project.SocialMediaBackend.Models.PostModel;
import com.project.SocialMediaBackend.Repositories.PostRepository;
import com.project.SocialMediaBackend.Services.FileService;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.7:3000"})
@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostRepository repository;

    @Autowired
    FileUploadHelper helper;
    @PostMapping("/add-post-image")
    public ResponseEntity<String> addPostWithImage(@RequestParam("content")String content, @RequestParam("file")
                                                   MultipartFile file){

        String path = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString();
        PostModel post = new PostModel();
        post.setContent(content);
        String filename =file.getOriginalFilename();
        try {
            helper.uploadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("some error occured during saving",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        post.setImage(path);

        repository.save(post);
        return new ResponseEntity<>("post created.",HttpStatus.CREATED);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<PostModel>> getAllPosts(){
        List<PostModel> posts = repository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "createdAt"))).getContent();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }


}
