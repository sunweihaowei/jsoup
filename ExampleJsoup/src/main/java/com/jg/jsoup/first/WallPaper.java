package com.jg.jsoup.first;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

//这里是怎么简单的破解反爬虫
public class WallPaper {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("https://wallhaven.cc/toplist?page=2");
        connect.header("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//        connect.header("accept-encoding"," gzip, deflate, br");
        connect.header("accept-language","zh-CN,zh;q=0.9");
        connect.header("cache-control","max-age=0");
        connect.header("cookie","__cfduid=d06396c48c6641d5a1e668b857b6230aa1598000932; _pk_ses.1.01b8=1; _pk_id.1.01b8=637a204ceafe8e65.1598000939.1.1598003756.1598000939.; XSRF-TOKEN=eyJpdiI6InRrNmtHNkQ0cUc1REFBcmlEVFwvKzlnPT0iLCJ2YWx1ZSI6IndjT09nb3VvKzJsT1ZRZHdEbkhsTUxCMFVQNW1qSzNKcG44bzFvQUJUaGNMelZKcWl6VWl6bVdQTCtPcldiMWUiLCJtYWMiOiJkNzk3NzMwMDA2ZjIzMzM1YjUyYTlkOGFmODczZDUyZjAwMjgxOTExZjU3OTVhZDVjYmUxYjBlMjY5YTQ0MTVkIn0%3D; wallhaven_session=eyJpdiI6IlRLcm10eGM5bXY1VXN0eUtvR3R0RXc9PSIsInZhbHVlIjoiSmRlK2Z0Uzh2bXNBMG9WNXZ3WTNHXC9nRVg0MzQ3U2VnRU9PVGpPNmd0bmlhYVhaWVFsUmJINytEbWZVTUx6aXgiLCJtYWMiOiJiYTY2YmUxNWU2ZWQxMjQzM2EzM2I2ZjgyZTY2ZTlhNDFmNDkwYmE5MWMyNDRiMjZlNTc4OTg0ZTZjMWJiODJjIn0%3D");
        connect.header("sec-fetch-dest","document");
        connect.header("sec-fetch-mode","navigate");
        connect.header("sec-fetch-site","same-origin");
        connect.header("sec-fetch-user","?1");
        connect.header("upgrade-insecure-requests","1");
        connect.header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
        connect.ignoreHttpErrors(true);
        Connection.Response response = connect.method(Connection.Method.GET).execute();
        Document document = response.parse();
//        String body = response.body();
        Elements select = document.select("div.egeli_pic_m");
        Elements a = select.select("a");
        System.out.println("我是不是成功了---->    "+document);
    }

}

