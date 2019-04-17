package com.mengo.api.video.dao;

import com.mengo.api.video.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String name);
}
