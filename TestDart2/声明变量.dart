main(){
  //1.明确的声明
  String name="why";

  //2.类型推导（var/final/const)
  //类型推导的方式虽然没有明确的指定变量的类型，但是变量是有自己的明确类型的
  //2.1.var声明变量
  var age=20;
  age=30;

  //2.2 final 声明常量
  final height=1.1;
  //  height=2.0;这句会报错
  //2.3const声明常量
  const address="广州市";
//  address="sdf";
//2.4 final和const区别
//const必须赋值 常量值（编译期间需要有一个确定的值）
//final可以通过计算/函数获取一个值（运行期间来确定的值）
//const data1=DateTime.now();这个是错误的，要编译期间有确定值
final data2=DateTime.now();//这个是正确的，因为这个是运行时赋值
  //final用于多一些

//  final p1=new Person("name1");这里new 被省略了
  //p1,p2是不同的对象，在堆里面就有两个空间
  const p1=Person("why");
  const p2=Person("why");
  const p3=Person("hh");//这不是单例
  print(identical(p1, p2));//这里是比较是否相等
  print(identical(p3, p2));//这里是比较是否相等
  const p4=Person("why");


}
class Person {
  final String name;
  const Person(this.name);
}