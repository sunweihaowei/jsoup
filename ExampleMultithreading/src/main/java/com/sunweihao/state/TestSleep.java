package com.sunweihao.state;

import com.sunweihao.example.TestThread4;
//模拟网络延迟：放大问题的发生性
public class TestSleep implements Runnable {
    //有十部电影
    private int ticketNums=10;
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->拍了第"+ticketNums--+"剧");
        }
    }
    public static void main(String[] args) {
        TestThread4 ticket=new TestThread4();
        new Thread(ticket,"颇多野老师").start();
        new Thread(ticket,"苍井空老湿").start();
        new Thread(ticket,"老司机").start();
    }
}
