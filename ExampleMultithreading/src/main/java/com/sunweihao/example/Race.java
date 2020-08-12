package com.sunweihao.example;

public class Race implements Runnable {
    private static String winner;
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")&&i%10==0&&i>0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag=gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--跑了"+i+"步");
        }
    }
    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner!=null) {
            return true;
        }
        {//否则
            if (steps>=100){//当达到100步
                winner=Thread.currentThread().getName();//得到并设置达到100步的名字
                System.out.println("winner is "+winner);//打印出胜利者
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
