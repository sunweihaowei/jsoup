package com.jg.jsoup.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

//这里是怎么简单的破解反爬虫
public class JsoupWallPaper {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
        new Thread(){


            private String url;

            @Override
            public void run() {
                super.run();
                try {
                    //86
                    Document document = Jsoup.connect("https://sj.enterdesk.com/2.html")

                            .get();//这里是把路径传过去
                    Elements select = document.select("div.egeli_pic_m");
                    Elements a = select.select("a");
                    for (int i = 86; i < a.size(); i+=2) {
                        System.out.println(a.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}

