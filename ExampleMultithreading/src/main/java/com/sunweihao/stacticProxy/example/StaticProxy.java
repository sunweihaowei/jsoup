package com.sunweihao.stacticProxy.example;

/**
 *静态代理模式总结
 * 真实对象和代理对象同时实现同个接口:
 * 为什么呀：因为
 * 代理对象要代理真实对象
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
        new Thread(){
            @Override
            public void run() {
                System.out.println("我爱你");
            }
        }.start();
    }
}
interface Marry{
    void HappyMarry();
}
//真实角色，去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("结婚");
    }
}
//代理角色，帮助你结婚
class WeddingCompany implements Marry{
    private Marry target;//结婚的目标人

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        //结婚前
        before();
        this.target.HappyMarry();//这就是真实的对象
        after();
    }
    //结婚前
    private void before() {
        System.out.println("布置现场");
    }
    //结婚后
    private void after() {
        System.out.println("收尾款");
    }

}
