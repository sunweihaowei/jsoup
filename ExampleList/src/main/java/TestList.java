import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class TestList {

    void init(List<Integer> list) {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }//1到10
    }

    void remove(List<Integer> list) {
        for (int i = 0; i < 5; i++) {
            list.remove(i);
        }
    }

    void removeTwo(List<Integer> list) {
        for (int i : list) {
            if (i < 6) {
                list.remove(i);
            }
        }
    }

    void removeThree(List<Integer> list) {
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
            int i = iter.next();
            if (i < 6) {
                iter.remove();
            }
        }
    }

    public static void main(String[] args) {
        TestList testList = new TestList();
        List<Integer> list = new ArrayList<Integer>();

        // 第一种方法
        testList.init(list);
        testList.remove(list);
        System.out.println(list);

        // 第二种方法
       /* try {
            testList.init(list);
            testList.removeTwo(list);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // 第三种方法
        testList.init(list);
        testList.removeThree(list);
        System.out.println(list);
    }
}