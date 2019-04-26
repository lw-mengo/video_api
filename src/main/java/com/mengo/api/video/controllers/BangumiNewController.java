package com.mengo.api.video.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mengo.api.video.entity.BangumiNew;
import com.mengo.api.video.services.BangumiNewService;
import com.mengo.api.video.services.EpisodeService;
import com.mengo.api.video.utils.CommonResult;
import com.mengo.api.video.utils.FileSaveUtil;
import com.mengo.api.video.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.List;

@Controller
public class BangumiNewController {

    @Autowired
    private BangumiNewService service;
    @Autowired
    private EpisodeService episodeService;

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

    /**
     * 返回给后台所有的新番数据，使用pageHelper分页
     * @param model 返回给thymeleaf页面的数据
     * @return 显示list.html
     */
    @GetMapping("listAll")
    public String listAll(Model model){
       String str =  service.findAll();
        Type type = new TypeToken<List<BangumiNew>>(){}.getType();
        List<BangumiNew> arrayList = new Gson().fromJson(str,type);
       // JsonObject object = new JsonParser().parse(str).getAsJsonObject();
        model.addAttribute("dataList",arrayList);
       return "list";
    }

    /**
     * 点击list页面增加按钮跳转到add页面
     * @param bid 传递过来的bid来标记番剧
     * @return 返回add页面
     */
    @GetMapping("addEpisode")
    public String add(String bid,Model model){
        model.addAttribute("bid",bid);//将bid返回给页面，并标记为不可编辑
        return "add";
    }

    /**
     * 增加集数页面的action操作 存入数据库
     * @param video_url 视频地址
     * @param num 集数
     * @param bid 番剧唯一索引
     * @return 返回状态值
     */
    @PostMapping("save_episode")
    @ResponseBody
    public String save(String bid,String video_url,int num){
        episodeService.save(bid,video_url,num);
        return CommonResult.success();
    }



}
