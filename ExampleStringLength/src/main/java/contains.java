public class contains {
    public static void main(String[] args) {

        String str = "abc";

        boolean status = str.contains("d");

        if(status){//默认为true
            System.out.println("包含");

        }else{
            System.out.println("不包含");
        }

    }
}
