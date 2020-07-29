package com.sunweihao.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2Improve implements Runnable {
    private String url;
    private String name;
    public TestThread2Improve(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 testThread1=new TestThread2("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3620297292,2452146774&fm=26&gp=0.jpg","苍井空老师");
        TestThread2 testThread2=new TestThread2("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3620297292,2452146774&fm=26&gp=0.jpg","颇多野老师");
        TestThread2 testThread3=new TestThread2("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3620297292,2452146774&fm=26&gp=0.jpg","孙伟豪老师");
        new Thread(testThread1).start();
        new Thread(testThread2).start();
        new Thread(testThread3).start();
    }
}

class WebDownloader2{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download方法出现错误");
        }
    }
}