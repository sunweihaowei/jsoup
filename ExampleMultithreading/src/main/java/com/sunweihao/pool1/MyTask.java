package com.sunweihao.pool1;

/**
 * 需求：任务类
 * 自定义线程练习，这是任务类，需求：
 * 包括人物编号，每一个任务执行时间为0.2s,
 */
public class MyTask implements Runnable{
    private int id;
    //由于run方法是重写口中的方法，因此id这个属性初始化可以利用构造方法完成

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        //获取线程名称
        String name = Thread.currentThread().getName();
        //打印即将执行任务
        System.out.println("线程："+"即将执行的任务");
        //休眠200
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印完成任务线程
        System.out.println("线程："+name+"执行完成");
    }
}
