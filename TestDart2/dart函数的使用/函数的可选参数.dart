main(){
  sayHello("hh");
}
//必选参数：必须传
void sayHello(String name){
  print(name);
  sayHello2("name",1,1.88);
  sayHello3("name",age: 100,height: 1.88);
  sayHello3("name",height: 1.88);
}
//dart中是没有函数的重载
//可选参数：位置可选参数 - 命名可选参数
//位置可选参数：[int age,double height]
void sayHello2(String name,[int age,double height]){

}
//命名可选参数
void sayHello3(String name,{int age,double height}){
}
//可选参数有默认值
//位置可选参数：[int age,double height]
void sayHello21(String name,[int age=1,double height=2.00]){

}
//命名可选参数
void sayHello31(String name,{int age=1,double height=2.00}){
}