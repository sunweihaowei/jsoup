package com.jg.jsoup.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.baidu.com").get();
        System.out.println(document.body());
        System.out.println();

        Document doc = Jsoup.connect("http://www.baidu.com")
                .data("query", "Java")//这里是传参数
                .userAgent("Mozilla")//这里是伪装浏览器
                .cookie("auth", "token")
                .timeout(3000)//访问时间
                .post();
        System.out.println(doc);
    }

}

