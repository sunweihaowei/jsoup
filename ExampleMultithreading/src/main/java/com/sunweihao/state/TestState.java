package com.sunweihao.state;

/**
 * 线程的五个状态
 * NEW ,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATED
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("//////");
            }
        });
        //观察状态
        Thread.State state=thread.getState();
        System.out.println(state);//
        //观察启动后
        thread.start();//启动线程
        state = thread.getState();
        System.out.println(state);//输出状态
        while (state != Thread.State.TERMINATED) {//只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state=thread.getState();
            System.out.println(state);
        }
        //死亡线程就不能启动了，所以下面报错
//        thread.start();
    }



}
