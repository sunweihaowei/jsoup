package com.jg.jsoup.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
//这里是爬虫爬数据
public class JsoupDemo5 {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.veer.com/topic/761/").get();//这里是得到整个完整文献，即html
//        System.out.println(document);
        Element root = document.getElementById("root");//这里是根据id：root得到root那个地方的html
//        System.out.println(root);
        Elements section = root.getElementsByTag("section");//这里是通过标签得到section的html
        for (Element element : section) {
            Elements img = element.getElementsByTag("img");//这里是通过img标签的到img的html（这里是for，所以得到很多个）
            for (Element element1 : img) {//img遍历
                //attr这个方法可以取属性，也可以设置属性，这里我们选择取属性
                String src = element1.attr("src");//图片
                String alt = element1.attr("alt");//title
                System.out.println(alt+":"+src);
            }
        }
    }

}

