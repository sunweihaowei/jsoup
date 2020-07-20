public class Segregation1 {
    public static void main(String[] args) {
        /*A a=new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());*/
    }
}
/*
//接口
interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}
//实现类B
class B implements improve.Interface1 {

    public void operation1() {
        System.out.println("B 实现 operation1");
    }

    public void operation2() {
        System.out.println("B 实现 operation2");
    }

    public void operation3() {
        System.out.println("B 实现 operation3");
    }

    public void operation4() {
        System.out.println("B 实现 operation4");
    }

    public void operation5() {
        System.out.println("B 实现 operation5");
    }
}
class D implements improve.Interface1 {

    public void operation1() {
        System.out.println("D 实现 operation1");
    }

    public void operation2() {
        System.out.println("D 实现 operation2");
    }

    public void operation3() {
        System.out.println("D 实现 operation3");
    }

    public void operation4() {
        System.out.println("D 实现 operation4");
    }

    public void operation5() {
        System.out.println("D 实现 operation5");
    }
}
class A{//A 类通过接口Interface1 依赖使用B类，但是只会使用到1,2,3,方法
    public void depend1(improve.Interface1 i){
        i.operation1();
    }
    public void depend2(improve.Interface1 i){
        i.operation2();
    }
    public void depend3(improve.Interface1 i){
        i.operation3();
    }
}
class C{//C 类通过接口Interface1 依赖使用D类，但是只会使用到1,4,5,方法
    public void depend1(improve.Interface1 i){
        i.operation1();
    }
    public void depend4(improve.Interface1 i){
        i.operation1();
    }
    public void depend5(improve.Interface1 i){
        i.operation1();
    }
}*/
