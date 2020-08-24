package com.jg.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

//历史的今天
//
public class SocialWallPapering {
    @Test
    public void TestTodayInHistory() throws Exception{

        String url="http://www.socwall.com/wallpapers/page:1/";
        //1.根据地址连接
        Connection connect = Jsoup.connect(url);
        //2.模拟浏览器，Request Headers
        connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//        connect.header("Accept-Encoding","ggzip, deflate, br");
        connect.header("Accept-Language","zh-CN,zh;q=0.9");
        connect.header("Cache-Control","max-age=0");
//        connect.header("Connection","keep-alive");
        connect.header("Cookie"," __cfduid=de33048c4783bc3664c824ca24da9efe11598001137; __utmz=134752371.1598001142.1.1.utmcsr=douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/group/topic/3837982/; __gads=ID=399ee6c4ed7a2f6c:T=1598001140:S=ALNI_MYifB3DjAJ2R3OqvSap_FcUQfE0tA; sessionId=2q0hbva0ej8g34lr1acl63k3d1; __utma=134752371.1416040440.1598001142.1598001142.1598237155.2; __utmc=134752371; __utmt=1; __utmb=134752371.5.10.1598237155");
//        connect.header("Host","www.hydcd.com");
//        connect.header("Referer","http://today.911cha.com/");
        connect.header("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
        connect.ignoreHttpErrors(true);//忽略网络错误
        Connection.Response response = connect.method(Connection.Method.GET).execute();//执行请求，并返回值
        Document parse = response.parse();
//        Element table1 = parse.getElementById("table1");//根据id来抓数据
        //拿到里面的所有a标签
//        Elements a = table1.select("a");
        //将数据建立到List上去
        System.out.println(parse);
    }
}
