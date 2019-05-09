package com.mengo.api.video.controllers;

import com.mengo.api.video.services.BangumiNewService;
import com.mengo.api.video.services.EpisodeService;
import com.mengo.api.video.utils.network.SubjectListInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     *
     * @return返回json数据
     */
    @GetMapping("listAll")
    public String listAll() {
        return bangumiNewService.findAll();
    }

    /**
     * 返回指定番剧的所有剧集与对应视频链接
     *
     * @param bid 番剧索引，用来查找
     * @return 返回json数据
     */
    @GetMapping(value = "listEpisode", produces = "text/html;charset=utf-8")
    public String listEpisode(String bid) {
        return episodeService.findByBid(bid);
    }


    /**
     * 首页数据api
     * @param pageNum 页码数，默认0，非必须
     * @return json数据
     */
    @GetMapping(value = "getSubject")
    public String getSubject(@RequestParam(value = "pageNum", required = false,defaultValue = "0") int pageNum) {
        return SubjectListInfo.getSubject(pageNum);
    }


}
