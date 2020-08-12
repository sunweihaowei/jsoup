package com.sunweihao.state;
//测试礼让线程
// 礼让不一定成功，要看CPU心情，
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield=new MyYield();
        new Thread(myYield,"a").start();//a线程开始执行
        new Thread(myYield,"b").start();//b线程开始执行
    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让，有礼让，但要看CPU心情，即有时可以，有时不可以
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}
