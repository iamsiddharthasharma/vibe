package com.project.SocialMediaBackend.DTO;

import com.project.SocialMediaBackend.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserRequestDto {
    private String fullName;

    private String userName;

    private String phone;

    private String email;

    private Gender gender;

    private String password;
}
