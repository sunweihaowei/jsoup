package com.jg.jsoup.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
//历史的今天
//这里是怎么简单的破解反爬虫
public class JsoupDemo8 {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
        File input = new File("/tmp/input.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        Elements links = doc.select("a[href]"); // a with href
        Elements pngs = doc.select("img[src$=.png]");
        // img with src ending .png

        Element masthead = doc.select("div.masthead").first();
        // div with class=masthead

        Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
        System.out.println(doc);
    }

}

