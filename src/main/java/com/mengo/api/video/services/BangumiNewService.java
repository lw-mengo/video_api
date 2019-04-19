package com.mengo.api.video.services;

import com.google.gson.Gson;
import com.mengo.api.video.dao.BangumiNewDao;
import com.mengo.api.video.entity.BangumiNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangumiNewService {
    @Autowired
    private BangumiNewDao dao;

    public void save(BangumiNew bangumiNew) {
        dao.save(bangumiNew);
    }

    public String findAll() {
        List<BangumiNew> list = dao.findAll();
        Gson gson = new Gson();
        String result = gson.toJson(list);
        return result;
    }
}
