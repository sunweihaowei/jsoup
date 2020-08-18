package com.jg.jsoup.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
//这里是怎么简单的破解反爬虫
public class JsoupDemo6 {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.veer.com/query/image/?phrase=%E7%8C%AB&page=1")
                .cookie("Cookie","bd_vid=6109032094438954091; bd_vid.sig=Hr_CyobbFwbFfIReajPbz7Rl-B4; logidUrl=https://www.veer.com/?utm_source=baidu&utm_medium=cpc&utm_campaign=%E5%93%81%E7%89%8C%E8%AF%8D&utm_content=veer-%E5%93%81%E7%89%8C%E8%AF%8D&utm_term=veer&chid=901&bd_vid=6109032094438954091; logidUrl.sig=UPjxm1kJJj1DIazh5eJLcbTIK1I; koa.sid=_7E7HSb6XV6Z0CkTXEBSmpwl1NTKhTY1; koa.sid.sig=VLXbIe9UQXcxU-4mvsnAsPhbPus; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221713dc1be3fa0d-0cb903c2b96eab-4313f6f-2073600-1713dc1be40468%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E4%BB%98%E8%B4%B9%E5%B9%BF%E5%91%8A%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22veer%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Fbaidu.php%22%2C%22%24latest_landing_page%22%3A%22https%3A%2F%2Fwww.veer.com%2F%3Futm_source%3Dbaidu%26utm_medium%3Dcpc%26utm_campaign%3D%25E5%2593%2581%25E7%2589%258C%25E8%25AF%258D%26utm_content%3Dveer-%25E5%2593%2581%25E7%2589%258C%25E8%25AF%258D%26utm_term%3Dveer%26chid%3D901%26bd_vid%3D6109032094438954091%22%2C%22%24latest_utm_source%22%3A%22baidu%22%2C%22%24latest_utm_medium%22%3A%22cpc%22%2C%22%24latest_utm_campaign%22%3A%22%E5%93%81%E7%89%8C%E8%AF%8D%22%2C%22%24latest_utm_content%22%3A%22veer-%E5%93%81%E7%89%8C%E8%AF%8D%22%2C%22%24latest_utm_term%22%3A%22veer%22%7D%2C%22%24device_id%22%3A%221713dc1be3fa0d-0cb903c2b96eab-4313f6f-2073600-1713dc1be40468%22%7D; _ga=GA1.2.1438481871.1585879040; _gid=GA1.2.1188023197.1585879040; Hm_lvt_f2de34005a64c75f44715498bcb136f9=1585879040; Hm_lpvt_f2de34005a64c75f44715498bcb136f9=1585882369; _fp_=eyJpcCI6IjExNi4yNC44My41IiwiZnAiOiJhNTA4MTYzNzlhNGJhMDdlODBjNWY4ZTAxNGEwNGVhNSIsImhzIjoiJDJhJDA4JEx1NHN6N21kQkhwNXN2OUlhamhqVU8vUjBlMW5iZG4wRW94Q0huWUdLZVY1dlhmV3JsQUZTIn0%3D")
                .get();
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

