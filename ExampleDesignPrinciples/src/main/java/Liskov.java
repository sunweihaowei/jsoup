public class Liskov {
    public static void main(String[] args) {
        A a=new A();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("1-8="+a.func1(1,8));
        System.out.println("-----------------------");

        B b=new B();
        System.out.println("11-3="+b.func1(11,3));
        System.out.println("1-8="+b.func1(1,8));
        System.out.println("11+3+9="+b.func1(11,3));
    }
}
class A {
    /**
     * 返回两个数的差
     * @param num1
     * @param num2
     * @return
     */
    public int func1(int num1,int num2){
        return num1-num2;
    }
}

/**
 * B继承A，并增加方法
 */
class B extends A{
    //不小心重写了父类的方法
    @Override
    public int func1(int num1, int num2) {
        return num1+num2;
    }
    public int func2(int a,int b){
        return func1(a,b)+9;
    }
}