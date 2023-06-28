package com.project.SocialMediaBackend.Controllers;

import com.project.SocialMediaBackend.DTO.UserRequestDto;
import com.project.SocialMediaBackend.Services.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.7:3000"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserRequestDto dto){
        try {
            userService.addUser(dto);
        } catch (Exception ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationEx = (ConstraintViolationException) ex.getCause();
                String constraintName = constraintViolationEx.getConstraintName();
                if (constraintName != null && constraintName.contains("userName")) {
                    return new ResponseEntity<>("Username already exists.", HttpStatus.BAD_REQUEST);
                } else if (constraintName != null && constraintName.contains("email")) {
                    return new ResponseEntity<>("Email already exists.", HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>("UserName Or Email Already Exists.", HttpStatus.BAD_REQUEST);
            }

        }
        return new ResponseEntity<>("User has been added.", HttpStatus.CREATED);
    }
}
