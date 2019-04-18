package com.mengo.api.video.controllers;

import com.mengo.api.video.entity.User;
import com.mengo.api.video.services.UserService;
import com.mengo.api.video.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        User user = userService.findByName(username);
        logger.info(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return CommonResult.success();
            } else {
                return CommonResult.error();
            }
        } else {
            return CommonResult.error();
        }
    }
}
