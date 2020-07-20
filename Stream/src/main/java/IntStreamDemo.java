import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void main(String[] args) {

            // TODO Auto-generated method stub
            Singleton test = Singleton.getInstance();
            Singleton test1 = Singleton.getInstance();
            System.out.println(test.hashCode());
            System.out.println(test1.hashCode());

    }
    static class Singleton{


        private static volatile Singleton instance;
        private Singleton() {

        }

        //双重安全检查，解决线程安全问题，解决懒加载问题
        //即懒汉式加载（线程安全）
        public static synchronized Singleton getInstance() {

            if(instance==null) {
                synchronized(Singleton.class) {
                    if(instance==null) {
                        System.out.println("我只初始化了这一次哦");
                        instance=new Singleton();
                    }
                }

            }
            return instance;
        }
    }
}
