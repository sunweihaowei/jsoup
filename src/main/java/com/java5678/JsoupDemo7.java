package com.java5678;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.rmi.runtime.Log;

import java.io.IOException;

//这里是怎么简单的破解反爬虫
public class JsoupDemo7 {
    //适合使用image，不适合style
    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("https://wenku.baidu.com/view/d898f5ed2cc58bd63086bd1f.html")
//                .get();
//        System.out.println(document);
//        document.select
        new Thread(){


            private String url;

            @Override
            public void run() {
                super.run();
                try {
//                    Document document = Jsoup.connect("http://www.hydcd.com/cy/fkccy/index.htm").get();
                    Document document = Jsoup.connect("http://www.hydcd.com/cy/fkccy/index2.htm").get();//这里是把路径传过去
                    System.out.println("document..."+document);//打印全部html的值
                    Elements select = document.select("td.style1");
                    System.out.println("select..."+select);
                    for (int i = 0; i < select.size(); i++) {
                        Elements td = select.get(i).select("td");//抓了t标签
                        System.out.println("td====》"+td);
                        //<td width="170" height="210">
                        // <p>第53关</p>
                        // <p> <img border="0" src="images/CF92239-51.png" alt="八面来风"></p>

                        // <p><br><br>疯狂猜成语答案是:八面来风</p></td>
                        Elements p = td.get(i).select("p").select("p").select("img");
                        /**
                         * 这里是打印出p标签，即为我们想要的内容
                         */
                        System.out.println("p--->"+"\n"+p);
                        for (Element element : p) {
                            String src = element.attr("src");//猜图图片
                            String alt = element.attr("alt");//答案
//                            Log.d(TAG+"：src",src);//这里是打印出图片地址
                            /**
                             * 这里是打印我们想要p标签的图片的尾部
                             */
                            System.out.println("src----->"+src);
                            /**
                             * 这里是打印出p标签中的答案
                             */
                            System.out.println("alt----->"+alt);


                            url = "http://www.hydcd.com/cy/fkccy/"+src;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}

