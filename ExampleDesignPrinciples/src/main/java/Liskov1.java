public class Liskov1 {
    public static void main(String[] args) {
        A1 a=new A1();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("1-8="+a.func1(1,8));
        System.out.println("-----------------------");

        B1 b=new B1();
        System.out.println(b.func2(11,3));;
        System.out.println(b.func3(11,3));

    }
}
class Base{

}
class A1 extends Base {
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
class B1 extends Base{
    private A1 a1=new A1();
    public int func2(int a,int b){
        return this.a1.func1(a,b)+9;
    }
    public int func3(int a,int b){
        return this.a1.func1(a,b);
    }
}