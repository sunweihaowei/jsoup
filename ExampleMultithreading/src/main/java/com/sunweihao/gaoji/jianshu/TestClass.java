package com.sunweihao.gaoji.jianshu;

import sun.rmi.runtime.Log;

public class TestClass {

    static void msg(String msg){
//        Log.i("IMListView", "msg: "+msg);
        System.out.println("msg:"+msg);
    }

    public static void main(String[] args) {
        SyncPerson person = new SyncPerson();
        new Thread(new Producer(person, "厂家")).start();
        new Thread(new Consumer(person, "客人")).start();
    }

    public interface Person {
        void consume(String personName) throws InterruptedException;
        void produce(String personName) throws InterruptedException;
    }

    public static class Consumer implements Runnable {

        private Person person;
        private String personName;

        public Consumer(Person person, String personName) {
            this.person = person;
            this.personName = personName;
        }

        @Override
        public void run() {
            try {
                person.consume(personName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Producer implements Runnable {

        private Person person;
        private String personName;

        public Producer(Person person, String personName) {
            this.person = person;
            this.personName = personName;
        }

        @Override
        public void run() {

            try {
                person.produce(personName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class SyncPerson implements Person{

        private static final String[] lock = {"true"};
        private int bytCount = 0;

        public void produce(String personName) throws InterruptedException {

            synchronized (lock) {
                while (true) {

                    if (bytCount == 5) {
                        lock.notifyAll();
                        msg(personName + "已经生产了足够多的螺丝，等待被消费。。。");
                        Thread.sleep(1000);
                        lock.wait();
                    }
                    bytCount++;
                    msg(personName + "生产了" + bytCount + "只螺丝");
                    Thread.sleep(1000);
                }
            }
        }

        public void consume(String personName) throws InterruptedException {

            synchronized (lock) {
                while (true) {

                    if (bytCount == 0) {
                        //先通知另一个方法开始执行
                        lock.notifyAll();
                        msg(personName + "已将螺丝消费完，需要再生产。。。");
                        Thread.sleep(1000);
                        lock.wait();//自己等待

                    }
                    bytCount--;
                    msg(personName + "消费了" + (5 - bytCount) + "只螺丝");
                    Thread.sleep(1000);
                }
            }
        }
    }
}

