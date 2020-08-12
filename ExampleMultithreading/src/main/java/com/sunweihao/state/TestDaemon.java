package com.sunweihao.state;

import org.omg.PortableServer.THREAD_POLICY_ID;

//测试守护线程
//上帝保护你
public class TestDaemon {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();

        Thread thread=new Thread(god);
        thread.setDaemon(true);//默认是false，表示是用户线程，正常的线程都是用户线程……
        thread.start();
        //开启你的线程
        new Thread(you).start();
    }
}
//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}
//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着"+i);
        }
        System.out.println("-==========goodbye ! world!=========");
    }
}
