package com.sunweihao.state;
//测试线程优先级，设置越高，就越很大概率执行，默认为5
public class TestPriority {
    public static void main(String[] args) {
        //默认主线程优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        MyPriority myPriority=new MyPriority();
        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);

        //先设置优先级，再启动
        t1.start();//默认为5

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(7);
        t5.start();

        t6.setPriority(9);
        t6.start();


    }
}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}