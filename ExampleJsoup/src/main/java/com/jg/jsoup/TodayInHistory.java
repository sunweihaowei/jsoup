package com.jg.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//历史的今天
//
public class TodayInHistory {
    @Test
    public void TestTodayInHistory() throws Exception{

        String url="http://today.911cha.com/history_364.html";
        //1.根据地址连接
        Connection connect = Jsoup.connect(url);
        //2.模拟浏览器
        connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        connect.header("Accept-Encoding","gzip, deflate");
        connect.header("Accept-Language","zh-CN,zh;q=0.9");
        connect.header("Connection","keep-alive");
        connect.header("Cookie","Hm_lvt_2e69b379c7dbfdda15f852ee2e7139dc=1595474608; bdshare_firstime=1595474608426; Hm_lpvt_2e69b379c7dbfdda15f852ee2e7139dc=1595491705");
        connect.header("Host","today.911cha.com");
        connect.header("Referer","http://today.911cha.com/");
        connect.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
        connect.ignoreHttpErrors(true);//忽略网络错误
        Connection.Response response = connect.method(Connection.Method.GET).execute();
        Document document = response.parse();
        Elements select = document.select("p.f14 1200");
        Elements p = document.select("p");//选择p标签
        Elements a = p.select("a");//选择里面的啊标签
        List<Map<String,String>> mapList=new ArrayList<Map<String, String>>();
        Map<String,String> stringStringMap=new HashMap<String, String>();

        List<String> listYear=new ArrayList<String>();
        List<String> listTitle=new ArrayList<String>();
        List<String> listContent=new ArrayList<String>();
        System.out.println(0%3);
        System.out.println(1%3);
        System.out.println(2%3);
        for (int i = 0; i < a.size(); i++) {
            if (i%3==0){
                listYear.add(a.get(i).text());
            }
            if (i%3==2){
                listTitle.add(a.get(i).text());
                listContent.add(a.get(i).attr("href"));
            }
            /*if (i%3=2)*/
        }
        System.out.println(listYear);
        System.out.println(listTitle);
        System.out.println(listContent);
    }
}
