package com.jg.jsoup.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\javaLearning\\jsoup\\JsoupLearning.html");
        Document doc = Jsoup.parse(file, "UTF-8", "");
        System.out.println(doc);
    }

}

