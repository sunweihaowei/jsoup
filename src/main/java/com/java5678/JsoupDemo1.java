package com.java5678;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupDemo1 {
    public static void main(String[] args) {
        String html = "html" +
                "<head>:I am test</head><body>" +
                "<div>hello</div>" +
                "<body>" +
                "/html";
        Document parse = Jsoup.parse(html);
        System.out.println("全部parse===>"+parse);

        System.out.println("头文===>"+parse.head());
        System.out.println();
        System.out.println("解析实体===>"+parse.body());
        System.out.println();
        System.out.println("解析文本===>"+parse.text());
        System.out.println();
    }

}

