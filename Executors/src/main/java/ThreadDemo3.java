public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        // t1 t2同时共享同一变量trainCount
        ThreadTrain threadTrain=new ThreadTrain();
        Thread t1 = new Thread(threadTrain, "窗口1");
        Thread t2 = new Thread(threadTrain, "窗口2");
        t1.start();
        Thread.sleep(40);
        threadTrain.flg = false;
        t2.start();
    }
    static class ThreadTrain implements Runnable{
        // 总共有100张火车票
        private int trainCount = 100;
        public boolean flg = true;
        public void run() {
            if(flg){
                while (trainCount > 0) {
                    try {
                        // 休眠50秒
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 执行同步代码块 this锁
                    sale1();
                }
            }else {
                // 执行同步函数
                while (trainCount > 0){
                    try {
                        // 休眠50秒
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 执行同步函数
                    sale();
                }
            }
        }

        // 卖票方法 同步函数
        public synchronized void sale(){
            if(trainCount > 0){
                System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1)+"张票");
                trainCount--;
            }
        }

        // 卖票方法
        public void sale1(){
            // 同步代码块 synchronized 包裹需要线程安全的问题。this锁
            synchronized (this){
                if(trainCount > 0){
                    System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1)+"张票");
                    trainCount--;
                }
            }
        }
    }
}

// 售票窗口
