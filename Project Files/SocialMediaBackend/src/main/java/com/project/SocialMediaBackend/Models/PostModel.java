package com.project.SocialMediaBackend.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Data
@Entity
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;

    private int likes;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    private String image;
    public PostModel() {
        this.createdAt = new Date();
    }
}
