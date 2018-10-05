import java.util.Arrays;

/**
 * 三向切分快速排序
 * 适合有较多重复元素的排序算法
 *
 * @author roc
 */
public class ThreeWayQuickSort {

    public static void main(String[] args) {
        int[] a = {9, 0, 6, 5, 8, 2, 1, 7, 4, 3};
        System.out.println(Arrays.toString(a));
        ThreeWayQuickSort.sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    //在lt之前的(lo~lt-1)都小于中间值
    //在gt之前的(gt+1~hi)都大于中间值
    //在lt~i-1的都等于中间值
    //在i~gt的都还不确定（最终i会大于gt，即不确定的将不复存在）
    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int v = a[lo], lt = lo, i = lo + 1, gt = hi;
        // 这里的v是一个pivot值！！！
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, i++, lt++);
            } else if (a[i] > v) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
