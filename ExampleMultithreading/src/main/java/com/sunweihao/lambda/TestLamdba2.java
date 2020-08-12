package com.sunweihao.lambda;

public class TestLamdba2 {
    //3.静态内部类
    static class Love1 implements ILove{
        @Override
        public void love(int a) {
            System.out.println("爱 苍井空"+a);
        }
    }
    public static void main(String[] args) {
        ILove love=null;
        love=new Love();
        love.love(1);
        love=new Love1();
        love.love(2);
        //4.局部内部类
        class Love2 implements ILove{
            @Override
            public void love(int a) {
                System.out.println("爱 苍井空"+a);
            }
        }
        love=new Love2();
        love.love(3);
        //5.匿名内部类
        love=new ILove() {
            @Override
            public void love(int a) {
                System.out.println("爱 苍井空"+a);
            }
        };
        love.love(4);
        //6.lambda
        love=(int a)->{
            System.out.println("爱 苍井空"+a);
        };
        love.love(5);
        //7.lambda
        love=a->{
            System.out.println("爱 苍井空"+a);
        };
        love.love(6);
        //8.多参数
        ILove2 iLove2=(a,b)->{
            System.out.println(a+b);
        };
        iLove2.love(3,"字符串4");
    }
}
//1.接口
interface ILove{
    void love(int a);
}
//8.接口
interface ILove2{
    void love(int a,String b);
}
//2.实现接口
class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("爱 苍井空"+a);
    }
}

