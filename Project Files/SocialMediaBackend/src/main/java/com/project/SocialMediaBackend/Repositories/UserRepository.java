package com.project.SocialMediaBackend.Repositories;

import com.project.SocialMediaBackend.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
}
