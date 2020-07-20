import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) throws Exception, ExecutionException {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();//单线程

        for(int i=0;i<10;i++){

            singleThreadExecutor.execute(new MyRunable());

        }



    }

}



class MyRunable implements Runnable{



    @Override

    public void run() {

        System.out.println(Thread.currentThread().getName());

    }



}