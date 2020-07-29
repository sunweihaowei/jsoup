package com.sunweihao.example;
//总结：线程开启不一定立即执行，由cpu调度执行
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        //子线程执行
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看哲学"+i);
        }
    }

    public static void main(String[] args) {
        //创建对象，通过线程对象来开启我们的线程，代理



        new Thread(new TestThread3()).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }
}
