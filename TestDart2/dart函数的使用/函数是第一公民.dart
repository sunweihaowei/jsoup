main(){
  test(bar);
  print("--------------------------------------");
  //匿名函数
  test((){
    print("匿名函数被调用了");
    return 10;
  });
  print("--------------------------------------");
  //箭头函数
  test(()=>print("箭头函数被调用了"));
}
//函数可以作为另一个函数的参数
void test(Function foo){
  foo();
  var result=foo();
  foo();
}
void bar(){
  print("bar函数被调用");
}