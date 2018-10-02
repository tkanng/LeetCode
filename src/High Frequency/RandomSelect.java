import java.util.Arrays;
import java.util.Random;

public class RandomSelect {

    // 随机算法，查找无序数组中第K小的元素
    // 第k大 使用 divide2
    // 第k小 使用 divide1
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 11, 3213, 1231, 32, 84938, 439, 439, 4398};
        System.out.println(randomSelect(nums, 7));
        System.out.println(Arrays.toString(nums));
    }

    static int randomSelect(int[] nums, int K) {
        if (K > nums.length) return -1;
        return randomSelect(nums, 0, nums.length - 1, K);
    }

    static int randomSelect(int[] nums, int lo, int hi, int K) {
        int pos = divide1(nums, lo, hi);// 这里可能需要优化，随机操作一下！
        int eleCount = pos - lo + 1;
        if (eleCount == K)
            return nums[pos];
        if (eleCount > K) {
            return randomSelect(nums, lo, pos - 1, K);
        } else {
            return randomSelect(nums, pos + 1, hi, K - eleCount);
        }

    }


    // 返回nums[lo]应该插入的坐标
    // 升序
    static int divide1(int[] nums, int lo, int hi) {
        // 随机化操作！！
        Random random = new Random();
        int pivotIdx = lo + Math.abs(random.nextInt() % (hi - lo + 1));
        int val = nums[pivotIdx];
        nums[pivotIdx] = nums[lo];
        nums[lo] = val;

        while (lo < hi) {
            while (lo < hi && nums[hi] >= val) {
                hi--;
            }
            if (lo < hi) nums[lo] = nums[hi];

            while (lo < hi && nums[lo] <= val) {
                lo++;
            }
            if (lo < hi) nums[hi] = nums[lo];
        }
        nums[lo] = val;
        return lo;
    }

    // 降序
    static int divide2(int[] nums, int lo, int hi) {
        int val = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] <= val) {
                hi--;
            }
            if (lo < hi) nums[lo] = nums[hi];

            while (lo < hi && nums[lo] >= val) {
                lo++;
            }
            if (lo < hi) nums[hi] = nums[lo];
        }
        nums[lo] = val;
        return lo;
    }

}
