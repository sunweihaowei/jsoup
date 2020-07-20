//这里是得到相同字符的长度
public class StringLength {
    //封装Package
    String s = "abclfdlsjfabc0";
    public void aa(){
        int count=0;
        while(s.indexOf("abc")>=0)
        {
            count++;
            s=s.replaceFirst("abc",""); //将统抄计过的abc替换为空 然后继续循百环
        }
        System.out.println(count);
    }
    public static void main(String args[]){
        StringLength te = new StringLength();
        te.aa();
    }
}
