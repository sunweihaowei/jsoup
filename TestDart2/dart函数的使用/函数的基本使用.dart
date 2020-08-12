main(){
  print(sum(20, 30));
  print(sum2(20, 30));
}
int sum(int num1,int num2){
  return num1+num2;
}
//返回值类型是可以省略的,开发中不建议省略，阅读性差
//省略的写法
sum2(int num1,int num2){
  return num2+num1;
}