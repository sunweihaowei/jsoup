public class Ocp1 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor=new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        //增加一个方法
        graphicEditor.drawShape(new Triangle());
    }
}
//这是一个用于绘图的类
class GraphicEditor{
    //接收Shape对象，然后根据type,来绘制不同的图形
    public void drawShape(Shape s){
        if (s.m_type==1) {
            drawRectangle(s);
        }else if (s.m_type==2){
            drawCircle(s);
        }else if (s.m_type==3){
            drawTriangle(s);
        }
    }
    private void drawRectangle(Shape r) {
        System.out.println("矩形");
    }

    private void drawCircle(Shape r) {
        System.out.println("圆形");
    }
    //增加一个方法
    private void drawTriangle(Shape r) {
        System.out.println("三角形");
    }
}
//Shape类，基类
class Shape {
    int m_type;
}
class Rectangle extends Shape{
   Rectangle(){
       //super表示调用父类的属性，方法
       super.m_type=1;//对父类赋值
   }
}
class Circle extends Shape{
    Circle(){
        super.m_type=2;
    }
}
//增加一个方法，绘制三角形
class Triangle extends Shape{
    Triangle(){
        super.m_type=3;
    }
}