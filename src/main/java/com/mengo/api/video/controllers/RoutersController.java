package com.mengo.api.video.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 控制返回页面
 */
@Controller
public class RoutersController {

    /*
    登录页面
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }
    /*
    登录后的主界面
     */
    @GetMapping("/admin")
    public String main(){
        return "main";
    }


    @GetMapping("test")
    public String test(){
        return "test";
    }
}
