package com.mengo.api.video;

import com.mengo.api.video.Contanst.WebContanst;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void testUUID() {
        UUID str = UUID.randomUUID();
        String[] s = str.toString().split("-");

        System.out.println(s[0]);

    }




}
