package com.project.SocialMediaBackend.Repositories;

import com.project.SocialMediaBackend.Models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel,Integer> {
}
