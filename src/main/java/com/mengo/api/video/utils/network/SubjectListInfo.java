package com.mengo.api.video.utils.network;

import com.mengo.api.video.Contanst.WebContanst;
import com.mengo.api.video.utils.bean.SubjectInfo;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取首页数据的工具类
 */
public class SubjectListInfo {

    /**
     * 获取首页数据与其他数据
     * @param pageNum  页数
     * @return 返回json
     */
    public static String getSubject(int pageNum) {
        Document document;
        List<SubjectInfo> subjectInfoList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        String url = "";
        if (pageNum<0||pageNum==0){
            url += WebContanst.BASE_URL+WebContanst.SUBJECTS;
        }else {
            url += WebContanst.BASE_URL+WebContanst.SUBJECTS+WebContanst.PAGE+pageNum;
        }
        try {
            document = Jsoup.connect(url)
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
                subjectInfo.setPainting(e.select("span:contains(原画)").text());
                subjectInfoList.add(subjectInfo);

            }
            jsonObject.put("status", "ok");
            jsonObject.put("result", subjectInfoList);
//                Element el = elements.select("span:contains(发售)").first();
//                System.out.println(el.text());
        } catch (IOException e) {
            jsonObject.put("status", "error");
            System.out.println("连接超时");
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
