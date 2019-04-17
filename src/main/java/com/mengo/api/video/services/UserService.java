package com.mengo.api.video.services;

import com.mengo.api.video.dao.UserDao;
import com.mengo.api.video.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByName(String name) {
        return userDao.findByUsername(name);
    }
}
