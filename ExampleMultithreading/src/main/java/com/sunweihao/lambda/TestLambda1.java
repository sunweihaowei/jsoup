package com.sunweihao.lambda;

public class TestLambda1 {


    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like sunweihao2");
        }
    }

    public static void main(String[] args) {
        ILike like=new Like();
        like.lambda();
        like=new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like sunweihao3");
            }
        }
        like=new Like3();
        like.lambda();

        //5.匿名内部类，没有类的名称，必须借助接口或者父类
        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like sunweihao4");
            }
        };
        like.lambda();
        //6.用lambda简化,这个好像好点击灯泡的感叹号jdk1.8
        like=()->{
            System.out.println("i like sunweihao5");
        };
        like.lambda();
    }
}
//1.定义一个函数类接口
interface ILike{
    void lambda();
}
//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like sunweihao");
    }
}
