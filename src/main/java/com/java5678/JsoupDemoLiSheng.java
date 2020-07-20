package com.java5678;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

//这里是怎么简单的破解反爬虫
public class JsoupDemoLiSheng {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("https://wenku.baidu.com/view/d898f5ed2cc58bd63086bd1f.html")
//                .get();
//        System.out.println(document);
//        document.select
        new Thread(){


            private String url;

            @Override
            public void run() {
                super.run();
                try {
                    Document document = Jsoup.connect("https://pvp.qq.com/web201605/herolist.shtml?ADUIN=1096187594&ADSESSION=1587103242&ADTAG=CLIENT.QQ.5615_.0&ADPUBNO=27006")
                            .cookie("cookie","RK=Bs4UDrGiW7; ptcz=cc062b51d9120e239af5e67d0e76949c7eac89695399abc888e56da0d78ded03; pgv_pvid=5756570202; pgv_pvi=1866266624; eas_sid=51s5Y8J771p1U7B890A1M5a3C7; ied_qq=o1096187594; pt2gguin=o1096187594; pgv_info=ssid=5756570202; tokenParams=%3FADUIN%3D1096187594%26ADSESSION%3D1587103242%26ADTAG%3DCLIENT.QQ.5615_.0%26ADPUBNO%3D27006; webwx_data_ticket=gSd2BbG1py/CpubhT20Cpiuc; pvpqqcomrouteLine=herolist_herolist")
                            .get();//这里是把路径传过去
                    System.out.println("document..."+document);//打印全部html的值
                    Elements select = document.select("div.herolist-box");
                    System.out.println("select..."+"\n"+select);
                    for (int i = 0; i < select.size(); i++) {
                        Elements img = select.get(i).select("li").select("a").select("img");//抓了t标签
                        System.out.println("img====》"+"\n"+img);
                        for (Element element : img) {
                            String src = element.attr("src");//猜图图片
                            String alt = element.attr("alt");//答案
//                            Log.d(TAG+"：src",src);//这里是打印出图片地址
                            /**
                             * 这里是打印我们想要p标签的图片的尾部
                             */
                            System.out.println("src----->"+src);
                            /**
                             * 这里是打印出p标签中的答案
                             */
                            System.out.println("alt----->"+alt);


                            url = "http://www.hydcd.com/cy/fkccy/"+src;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}

