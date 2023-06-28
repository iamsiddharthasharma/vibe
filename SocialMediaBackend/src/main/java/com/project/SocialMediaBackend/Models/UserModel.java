package com.project.SocialMediaBackend.Models;

import com.project.SocialMediaBackend.Enum.Gender;
import jakarta.persistence.*;
import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

@Data
@Entity
@Table(name="user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fullName;
    @Column(unique = true)
    private String userName;

    private String phone;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "password_hash")
    private String password;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}
