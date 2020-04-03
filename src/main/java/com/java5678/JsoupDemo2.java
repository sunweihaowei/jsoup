package com.java5678;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 片段
 */
public class JsoupDemo2 {
    public static void main(String[] args) {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
        System.out.println();
        System.out.println(doc);
    }
}
