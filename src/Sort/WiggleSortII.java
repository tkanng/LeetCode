import java.util.Arrays;
import java.util.Random;

public class WiggleSortII {

    // https://leetcode.com/problems/wiggle-sort-ii/description/

    // 1. 基本解法
    //  O(nlogn) time and O(n) space solution by sorting
    public void wiggleSort1(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    // 2. 利用随机选择算法，得到整个数组中最中间的那个数组，并同时划分数组，即前一半数字均小于等于median,后一半数字均大于等于median
    // 利用三向快速排序算法，把所有median的值集中到一起,
    // 时间复杂度O(N)
    public void wiggleSort2(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        // 得到median，并划分数组
        int median = kthSmallestNumber(nums, m);
        // 将所有等于median的值，聚集在一起！
        // 三向快速排序的变体！！！
        for (int i = 0, j = 0, k = n - 1; j <= k; ) {
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }
        // 重新为nums赋值！！
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }
        int l = 0, r = nums.length - 1;
        k--;
        while (l < r) {
            int m = getMiddle(nums, l, r);
            if (m < k) {
                l = m + 1;
            } else if (m > k) {
                r = m - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int getMiddle(int[] nums, int l, int r) {
        int i = l;

        for (int j = l + 1; j <= r; j++) {
            if (nums[j] < nums[l]) swap(nums, ++i, j);
        }
        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
