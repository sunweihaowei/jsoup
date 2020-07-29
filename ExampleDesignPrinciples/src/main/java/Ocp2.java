public class Ocp2 {
    public static void main(String[] args) {
        /*GraphicEditor graphicEditor=new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        //增加一个方法
        graphicEditor.drawShape(new Triangle());*/
        GraphicEditor2 graphicEditor2=new GraphicEditor2();
        graphicEditor2.drawShape(new Rectangle2());
        graphicEditor2.drawShape(new Circle2());
        graphicEditor2.drawShape(new Triangle2());
        graphicEditor2.drawShape(new OtherDraw());
    }
}

//这是一个用于绘图的类
class GraphicEditor2{
    //接收Shape对象，然后根据type,来绘制不同的图形
    public void drawShape(Shape2 s){
        s.draw();
    }
}

//Shape类，基类
abstract class Shape2 {
    int m_type;
    public abstract void draw();//抽象方法
}

class Rectangle2 extends Shape2{
   Rectangle2(){
       //super表示调用父类的属性，方法
       super.m_type=1;//对父类赋值
   }

    public void draw() {
        System.out.println("矩形");
    }
}

class Circle2 extends Shape2{
    Circle2(){
        super.m_type=2;
    }

    public void draw() {
        System.out.println("圆形");
    }
}
class Triangle2 extends Shape2{
    Triangle2(){
        super.m_type=3;
    }

    public void draw() {
        System.out.println("三角形");
    }
}
//用开闭原则后，再增加一个方法，画其他图形
class OtherDraw extends Shape2{
    OtherDraw(){
        super.m_type=3;
    }

    public void draw() {
        System.out.println("其他图形");
    }
}