public class IfAndMethod {

    private static int i;

    public static void main(String[] args) {
        i = 10;
        while (i<15){
            if (!doStart()){//false
                System.out.println("run OK");
            }
            i++;
            System.out.println(i);
        }
    }

    private static boolean doStart() {      
        if (i<15){
            return false;
        }
        return true;
    }

}
