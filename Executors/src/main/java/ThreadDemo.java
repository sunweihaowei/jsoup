public class ThreadDemo {
        public static void main(String[] args) {
            // t1 t2同时共享同一变量trainCount
            ThreadTrain threadTrain = new ThreadTrain();
            Thread t1 = new Thread(threadTrain, "窗口1");
            Thread t2 = new Thread(threadTrain, "窗口2");
            t1.start();
            t2.start();
        }
    }

    // 售票窗口
    class ThreadTrain implements Runnable{
        // 总共有100张火车票
        private int trainCount = 100;
        public void run() {
            while (trainCount > 0){
                try {
                    // 休眠50毫秒
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 出售火车票
                sale1();
            }
        }

        // 卖票方法
        public void sale(){
            synchronized (this){
                if (trainCount>0){
                    System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1)+"张票");
                    trainCount--;
                }
            }
        }
        // 卖票方法 同步函数
        public synchronized void sale1(){
            if(trainCount > 0){
                System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1)+"张票");
                trainCount--;
            }
        }
    }

