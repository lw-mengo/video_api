package com.mengo.api.video.services;

import com.google.gson.Gson;
import com.mengo.api.video.dao.EpisodeDao;
import com.mengo.api.video.entity.Episode;
import com.mengo.api.video.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    private static final Logger logger = LoggerFactory.getLogger(EpisodeService.class);
    @Autowired
    private EpisodeDao dao;

    /**
     * 为番剧增加一集视频信息
     * @param bid 番剧的唯一值
     * @param number 集数
     * @param video_url 对应集数的视频地址
     */
    public void save(String bid,String video_url,int number){
        Episode episode = new Episode();
        episode.setBid(bid);
        episode.setEpisode(number);
        episode.setVideo_url(video_url);
        dao.save(episode);
    }

    /**
     * 根据bid查到到番剧的所有剧集与对应的链接
     * @param bid 番剧唯一索引
     * @return 返回json数据
     */
    public String findByBid(String bid){
        List<Episode> list = dao.findByBid(bid);
        Gson gson = new Gson();
        String jsonData = gson.toJson(list);
//        logger.info(jsonData);
        return jsonData;
    }


}
