package com.sunweihao.gaoji.jianshu;

/**
 * wait和 notify 的学习
 * @author wm
 * @date 2019/9/18 15:15
 */
public class SimpleWN {
    final static Object object = new Object();

    public static class T1 extends  Thread{
        public void run() {
            synchronized (object){
                //执行
                System.out.println(System.currentTimeMillis()+":T1 start! ");
                System.out.println(System.currentTimeMillis()+":T1 wait for object");
                //等待
                try {
                    object.notify();
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //结束
                for (int i = 0; i < 10; i++) {
                    if (i>5){
                        return;
                    }
                    System.out.println(System.currentTimeMillis()+":T1 end! "+i);
                }

            }
        }
    }
    public static class T2 extends Thread{
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T2 start! notify one thread");
                object.notify();//object线程执行
                System.out.println(System.currentTimeMillis()+":T2 end! ");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T2 end! 2");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
