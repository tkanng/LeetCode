
import java.util.*;

public class S41TOS50 {


    public static void main(String[] args) {

        firstMissingPositive(new int[]{3, 4, -1, 1});
    }

    //S41  奇技淫巧！！！ 每次迭代中
    public static int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length) i++;
            else if (A[A[i] - 1] != A[i]) swap(A, i, A[i] - 1);  // 一直换，直到不满足条件or交换到和是的位置
            else i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1) i++;
        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    //S42  https://blog.csdn.net/wzy_1988/article/details/17752809
    // 找到每个 volume[i] = [min(left[i], right[i]) - A[i]] * 1  1 是宽度
    public int trap(int[] A) {
        // special case
        if (A == null || A.length == 0) {
            return 0;
        }

        int i, max, volume, left[] = new int[A.length], right[] = new int[A.length];

        // from left to right
        for (left[0] = A[0], i = 1, max = A[0]; i < A.length; i++) {
            if (A[i] < max) {
                left[i] = max;
            } else {
                left[i] = A[i];
                max = A[i];
            }
        }

        // from right to left
        for (right[A.length - 1] = A[A.length - 1], i = A.length - 2, max = A[A.length - 1]; i >= 0; i--) {
            if (A[i] < max) {
                right[i] = max;
            } else {
                right[i] = A[i];
                max = A[i];
            }
        }

        // trapped water
        for (volume = 0, i = 1; i <= A.length - 2; i++) {
            int tmp = Math.min(left[i], right[i]) - A[i];
            if (tmp > 0) {
                volume += tmp;
            }
        }

        return volume;
    }
}



