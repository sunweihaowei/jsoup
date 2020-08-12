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
public class IdiomHistory {
    @Test
    public void TestTodayInHistory() throws Exception{

        String url="http://www.hydcd.com/cy/chengyugushi.htm";
        //1.根据地址连接
        Connection connect = Jsoup.connect(url);
        //2.模拟浏览器，Request Headers
        connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        connect.header("Accept-Encoding","gzip, deflate");
        connect.header("Accept-Language","zh-CN,zh;q=0.9");
        connect.header("Cache-Control","max-age=0");
        connect.header("Connection","keep-alive");
        connect.header("Cookie","BAIDU_SSP_lcr=https://www.baidu.com/link?url=b337pjuEyAjsI1IkBFZpba7pwEHwgdmsAooSinG7szmSxTZudTj2334P_i4M7swpSeEjflU7wTz3BJ2fW6oE7a&wd=&eqid=b55011160005f367000000065f2d1e8f; UM_distinctid=1713e12e2eb776-0e9249cdab00cd-4313f6f-1fa400-1713e12e2eca15; cy=%u6210%u8BED%u6545%u4E8B; CNZZDATA2240952=cnzz_eid%3D628645636-1585881677-%26ntime%3D1596789958");
        connect.header("Host","www.hydcd.com");
        connect.header("Referer","http://today.911cha.com/");
        connect.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
        connect.ignoreHttpErrors(true);//忽略网络错误
        Connection.Response response = connect.method(Connection.Method.GET).execute();//执行请求，并返回值
        Document parse = response.parse();
        Element table1 = parse.getElementById("table1");//根据id来抓数据
        //拿到里面的所有a标签
        Elements a = table1.select("a");
        //将数据建立到List上去
        System.out.println(a);
    }
}
