import java.util.Arrays;
import java.util.Comparator;

public class Arrays2 {


    public static void main(String[] args) {

        Integer[] s = new Integer[]{34, 1, 8, 0};
        Arrays.sort(s, 0, s.length); //利用Arrays.sort对数组进行排序，可以指定范围。
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return j - i;
            }
        });

        System.out.println(Arrays.toString(s));
    }

}
