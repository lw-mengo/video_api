package com.mengo.api.video;

import com.mengo.api.video.Contanst.WebContanst;
import com.mengo.api.video.utils.bean.SubjectInfo;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mytest {

    @Test
    public void testNet() {
        Document document;
        {
            try {
                document = Jsoup.connect(WebContanst.BASE_URL + WebContanst.SUBJECTS)
                        .timeout(5000).get();
                Elements elements = document.select("#subjects > li");
//                Elements titles = elements.select("h4 > a");
//                Elements users = elements.select("p.control-group > span > a");
//                Elements tags = elements.select("span:contains(TAG)");Elements titles = elements.select("h4 > a");
//                Elements users = elements.select("p.control-group > span > a");
//                Elements tags = elements.select("span:contains(TAG)");
//                for (int i=0;i<elements.size();i++){
//                    System.out.println("作品名称::::"+titles.get(i).text());
//                    System.out.println("上传作者::::"+users.get(i).text());
//                    System.out.println("标签属性::::"+tags.get(i).text());
//                }
                List<SubjectInfo> subjectInfoList = new ArrayList<>();
                for (Element e : elements
                ) {
                    SubjectInfo subjectInfo = new SubjectInfo();
                    subjectInfo.setTitle(e.select("h4 > a").text());
                    subjectInfo.setAuthor(e.select("p.control-group > span > a").text());
                    subjectInfo.setBrand(e.select("span:contains(品牌)").text());
                    subjectInfo.setImageUrl(e.select("img.media-object").attr("data-normal"));
                    subjectInfo.setScript(e.select("span:contains(剧本)").text());
                    subjectInfo.setReleaseData(e.select("span:contains(发售)").text());
                    subjectInfo.setTags(e.select("span:contains(TAG)").text());
                    subjectInfo.setTopicUrl(e.select("span:contains(介绍) > a").first().attr("href"));
                    subjectInfoList.add(subjectInfo);
//                    System.out.println("作品名称::::" + e.select("h4 > a").text());
//                    System.out.println("上传作者::::" + e.select("p.control-group > span > a").text());
//                    System.out.println("封面链接::::" + e.select("img.media-object").attr("data-normal"));
//                    System.out.println("标签属性::::" + e.select("span:contains(TAG)").text());
//                    System.out.println("品牌::::" + e.select("span:contains(品牌)").text());
//                    System.out.println("发售日期::::" + e.select("span:contains(发售)").text());
//                    System.out.println("剧本::::" + e.select("span:contains(剧本)").text());
//                    System.out.println("介绍::::" + e.select("span:contains(介绍) > a").first().attr("href"));

                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "ok");
                jsonObject.put("result", subjectInfoList);
                System.out.println(jsonObject.toString());

//                Element el = elements.select("span:contains(发售)").first();
//                System.out.println(el.text());

            } catch (IOException e) {
                System.out.println("连接超时");
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testContext() {
        String url = WebContanst.BASE_URL + "/topics/9437/page/2";

        try {
            Document document = Jsoup.connect(url).timeout(5000).get();
            Elements elements = document.select("div#topic-content > p");
            String temp = "";
            for (Element e:elements
                 ) {
                temp += e.text()+"\n";
            }
            System.out.println(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
