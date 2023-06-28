package com.project.SocialMediaBackend.Services;

import com.project.SocialMediaBackend.DTO.UserRequestDto;
import com.project.SocialMediaBackend.Models.UserModel;
import com.project.SocialMediaBackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserRequestDto dto) throws Exception{
        UserModel user = new UserModel();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("username")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
            } else if (ex.getMessage().contains("email")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
            } else {
                throw ex;
            }
        }
    }
}