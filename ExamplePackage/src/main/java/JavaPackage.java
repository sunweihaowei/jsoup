//设计原则Design Principles

public class JavaPackage {
    public static void main(String[] args) {
        PersonModel model = new PersonModel();
        model.name = "sunweihao";
        model.age = 24;
        System.out.println(model.name);
        System.out.println(model.age);
        System.out.println("\n");
        System.out.println("我是封装的访问");
        PersonModel2 personModel2=new PersonModel2();
        personModel2.setAge(24);
        personModel2.setName("孙伟豪是的发送到发送到");
        System.out.println(personModel2.getName());
        System.out.println(personModel2.getAge());
    }
}

class PersonModel {
    String name;
    int age;
}

/**
 * 1.好处，可以在这里进行判断
 */
class PersonModel2 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>4||name.length()<2){
            System.out.println("你的名字输入有误");
            return;
        }else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>100||age<0){
            System.out.println("你的年龄输入有误");
            return;
        }else {
            this.age = age;
        }
    }
}