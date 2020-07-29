package com.jg.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class JsoupText {

    public static void main(String[] args) {
        //1.抓取目标的url
        String targetUrl="https://zhipeng0908.gitee.io/";
        //2.获取connection
        Connection connection= Jsoup.connect(targetUrl);
        connection.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

    }
    @Test
    public void testJsoup1() throws Exception{
        /**
         * 一、爬取网页HTML
         */
        //1.抓取目标的url
        String targetUrl="https://zhipeng0908.gitee.io/";
        //2.获取connection
        Connection connection= Jsoup.connect(targetUrl);
        //3.模拟浏览器
        connection.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        connection.header("Accept-Encoding","gzip, deflate, br");
        connection.header("Accept-Language","zh-CN,zh;q=0.9");
        connection.header("Cache-Control","max-age=0");
        connection.header("Connection","keep-alive");
        connection.header("Cookie","Hm_lvt_ec661610f14acf2457496da3a87d804d=1595487810; Hm_lpvt_ec661610f14acf2457496da3a87d804d=1595487810");
        connection.header("Host","zhipeng0908.gitee.io");
        connection.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");

        connection.ignoreHttpErrors(true);//忽略错误
        //执行
        Connection.Response response = connection.method(Connection.Method.GET).execute();//发起请求
        String body = response.body();//得到请求体
        System.out.println(body);
    }

    /**
     * 解析数据，简单的获取标题
     * @throws Exception
     */
    @Test
    public void testTitle() throws Exception{
        //1.抓取目标的url
        String targetUrl="https://zhipeng0908.gitee.io/";
        //2.获取connection
        Connection connection= Jsoup.connect(targetUrl);
        //3.模拟浏览器,伪造请求头
        connection.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        connection.header("Accept-Encoding","gzip, deflate, br");
        connection.header("Accept-Language","zh-CN,zh;q=0.9");
        connection.header("Cache-Control","max-age=0");
        connection.header("Connection","keep-alive");
        connection.header("Cookie","Hm_lvt_ec661610f14acf2457496da3a87d804d=1595487810; Hm_lpvt_ec661610f14acf2457496da3a87d804d=1595487810");
        connection.header("Host","zhipeng0908.gitee.io");
        connection.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");

        connection.ignoreHttpErrors(true);//忽略错误
        //4.执行
        Connection.Response response = connection.method(Connection.Method.GET).execute();//发起请求
        //5.document表示爬取下来的整个界面
        Document document = response.parse();//解析
        //6.body()方法表示爬取得到的body标签,一般html的内柔都写在这里
        Element bodyElement = document.body();
        System.out.println(bodyElement.html());


    }
}
