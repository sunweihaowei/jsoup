main(){
  //1.定义字符串
  var str1='abc';
  var str2='abc';
  var str3="""
  abc
  cba
  nba
  """;
  print(str1+str2+str3);
  //2.字符串和表达式拼接
  var name="why";
  var age=19;
  var height=1.88;
  //强调：${变量},那么{}可以省略
  var message="my name is ${name},age is ${age},height is ${height}";
  var messageImprove="my name is $name,age is $age,height is $height";
  var message2="my name is ${name},type is ${name.runtimeType}";//最后面不可以省略
  print(message);
  print(message2);
  print(messageImprove);
}