main(){
  //1.列表List:[];
  var names=["abd","abc","abb","aba","aba","aba","aba","aba","aba"];
  names.add("new");

  //2.集合set：{}；
  var movies={"孙伟豪","哈哈哈","苍井空"};
  //元素去重

  var list = Set.from(names).toList();

  //3.映射Map
  var info={
    "name":"why",
    "age":18
  };
  print(names);
  print(movies);
  print(info);
  print(list);
  //4.dart是没有关键字来定义接口的，默认class就是接口
}