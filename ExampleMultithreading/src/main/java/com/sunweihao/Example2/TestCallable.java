package com.sunweihao.Example2;
import com.sunweihao.example.TestThread2;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;
    //线程构造方法
    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
        //hhh
    }
    @Override
    public Boolean call() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1=new TestCallable("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3620297292,2452146774&fm=26&gp=0.jpg","苍井空老师");
        TestCallable t2=new TestCallable("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3620297292,2452146774&fm=26&gp=0.jpg","颇多野老师");
        TestCallable t3=new TestCallable("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3620297292,2452146774&fm=26&gp=0.jpg","孙伟豪老师");
        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);//创建三条线程
        //提交执行
        Future<Boolean> r1=ser.submit(t1);
        Future<Boolean> r2=ser.submit(t2);
        Future<Boolean> r3=ser.submit(t3);
        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();
    }
}
class WebDownloader{
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