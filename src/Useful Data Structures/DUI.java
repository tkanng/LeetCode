import java.util.*;

public class DUI {

    public static void main(String[] args) {
        // 默认是最小堆，如果需要是最大堆，可以自己定义Comparator
        Queue<Integer> qi = new PriorityQueue<Integer>();
        qi.add(5);
        qi.add(2);
        qi.add(1);
        qi.add(10);
        qi.add(3);

        while (!qi.isEmpty()) {
            System.out.print(qi.poll() + ",");
        }
        System.out.println();
        System.out.println("-----------------------------");
        // 自定义的比较器，可以让我们自由定义比较的顺序 Comparator<Integer> cmp;
        Comparator cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
        q2.add(2);
        q2.add(8);
        q2.add(9);
        q2.add(1); // add方法其实，就是调用的offer方法。
        q2.offer(1); //将指定元素插入优先级队列中。

        System.out.println();
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + ",");
        }


        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2-o1;
            }
        });

        treeSet.add(0);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(111121);
        treeSet.add(9);
        treeSet.add(8);
        treeSet.add(6);
        HashMap<Character, Integer> map = new HashMap<>();
        System.out.println(treeSet.first());
    }




}
