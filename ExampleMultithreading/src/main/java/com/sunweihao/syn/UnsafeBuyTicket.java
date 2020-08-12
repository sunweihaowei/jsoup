package com.sunweihao.syn;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket=new BuyTicket();
        new Thread(buyTicket,"苍井空").start();
        new Thread(buyTicket,"波打野介意").start();
        new Thread(buyTicket,"吉泽明步").start();
    }
}
class BuyTicket implements Runnable{
    //票
    private int ticketNums=10;
    boolean flag=true;
    @Override
    public void run() {
        //买票
        while (flag) {
            buy();
        }
    }
    private void buy() {
        //判断是否有票
        if (ticketNums<=0) {
            flag=false;
            return;
        }
        //模拟延迟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
