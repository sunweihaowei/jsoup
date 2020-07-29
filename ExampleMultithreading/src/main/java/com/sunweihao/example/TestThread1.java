package com.sunweihao.example;
//总结：线程开启不一定立即执行，由cpu调度执行
public class TestThread1 extends Thread{
    @Override
    public void run() {
        //子线程执行
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看哲学"+i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1=new TestThread1();
        testThread1.start();//执行多的情况下，先执行main线程，再执行子线程，两者互换
//        testThread1.run();//这里是先执行子线程

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }
}
