package com.mengo.api.video.controllers;

import com.mengo.api.video.services.BangumiNewService;
import com.mengo.api.video.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiControllers {
    @Autowired
    private BangumiNewService bangumiNewService;
    @Autowired
    private EpisodeService episodeService;

    /**
     * 列出所有的新番数据
     * @return返回json数据
     */
    @GetMapping("listAll")
    public String listAll(){
        return bangumiNewService.findAll();
    }

    /**
     * 返回指定番剧的所有剧集与对应视频链接
     * @param bid 番剧索引，用来查找
     * @return 返回json数据
     */
    @GetMapping(value = "listEpisode",produces = "text/html;charset=utf-8")
    public String listEpisode(String bid){
        return episodeService.findByBid(bid);
    }


}
