package com.mengo.api.video.controllers;

import com.mengo.api.video.services.BangumiNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiControllers {
    @Autowired
    private BangumiNewService bangumiNewService;

    @GetMapping("listAll")
    public String listAll(){
        return bangumiNewService.findAll();
    }

}
