package com.mengo.api.video.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutersController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("test")
    public String test(){
        return "test";
    }
}
