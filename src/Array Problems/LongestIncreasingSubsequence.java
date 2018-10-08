// 最长递增子序列长度LIS

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /* 三种解法：
    1. 排序原始序列，然后利用LCS，求解原始序列与排序后的序列的最长公共子序列长度O(N^2)
    2. 利用dp求解，O(N^2)
    3. 利用二分查找求解原始问题！O(NlogN)
    */


    /* 1. dp求解：

    1.定义长度为n的dp数组，dp[i]表示为arr[i]结尾的最长递增子序列的长度。

    2.对于第一个数arr[0]来说dp[0]=1,依次求出以i结尾的最长递增子序列

    3.对于dp[i],求arr[i]结尾的最长递增子序列，在arr[0..i-1]中选出比arr[i]小且长度最长的

    dp[j] , dp[i] = Math.max( dp[j..k](arr[j..k]均小于arr[i]) , dp[i] );如果所有的 dp[0…i-1] 都比 dp[i] 大，则 dp[i]=1;
      */
    public static int lengthOfLIS1(int arr[]) {
        int len = 0;
        if (arr == null || arr.length == 0)
            return 0;
        int dp[] = new int[arr.length];
        dp[0] = 1;
        //dp[i] 表示到i为止是最长递增子序列的长度
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    //求dp[i]时遍历，dp[0...i-1],找出arr[j]<arr[i]小且dp[j]是最大的
                    //dp[i]=dp[j]+1;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            len = Math.max(dp[i], len);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS2(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }

    /*
   二分查找解决LIS问题：
   https://www.felix021.com/blog/read.php?1587
   https://segmentfault.com/a/1190000002641054
     */

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] B = new int[nums.length]; //B[i] 记录了长度为i+1的LIS的最小结尾数字.
        B[0] = nums[0];
        int maxLen = 1;

        for (int i = 1; i < nums.length; ++i) {
            System.out.println(Arrays.toString(B));
            if (nums[i] > B[maxLen - 1]) {
                // 如果大于B数组中的最大元素
                B[maxLen] = nums[i];
                maxLen++;
            } else {
                if (nums[i] <= B[0]) {
                    B[0] = nums[i];
                } else {
                    int replaceIdx = getEqualOrFirstBiggerThan(B, nums[i], 0, maxLen - 1);
                    B[replaceIdx] = nums[i];
                }

            }
        }

        return maxLen;
    }

    public int getEqualOrFirstBiggerThan(int[] nums, int k, int lo, int hi) {
        // nums是单调递增的，所以数组中不会存在相同的元素
        if (nums[lo] >= k) return lo;
        while (lo <= hi) {
            int mid = (hi + lo) >> 1;
            if (nums[mid] == k) return mid;
            else if (nums[mid] > k) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }


}


