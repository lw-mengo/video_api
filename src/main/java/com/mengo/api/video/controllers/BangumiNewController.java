package com.mengo.api.video.controllers;

import com.mengo.api.video.entity.BangumiNew;
import com.mengo.api.video.services.BangumiNewService;
import com.mengo.api.video.utils.CommonResult;
import com.mengo.api.video.utils.FileSaveUtil;
import com.mengo.api.video.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BangumiNewController {

    @Autowired
    private BangumiNewService service;


    /**
     * 获取上传的新番信息与封面图
     *
     * @param name    新番名
     * @param content 简介内容
     * @param file    封面图
     * @return 返回状态码
     */
    @PostMapping("saveBangumi")
    @ResponseBody
    public String save(@RequestParam("name") String name, @RequestParam("content") String content, @RequestParam("file") MultipartFile file) {
        if (name == null || content == null || file == null) {
            return CommonResult.fail();
        } else {
            BangumiNew bangumiNew = new BangumiNew();
            bangumiNew.setName(name);
            bangumiNew.setContent(content);
            bangumiNew.setBid(UUIDUtil.getBid());
            FileSaveUtil.saveFile(file);
            bangumiNew.setImage_path(FileSaveUtil.getFilePath(file.getOriginalFilename()));
            service.save(bangumiNew);
            return CommonResult.success();
        }

    }
}
