import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithSumK {
    // 题目地址：
    // https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k/0
    // 利用前缀数组和，求解等于某一个值的最大子数组长度！
    // 前缀数组！！！
    public static void main(String[] args) {
        //code3
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            int len = sc.nextInt();
            int k = sc.nextInt();
            int maxLen = 0;
            int[] nums = new int[len];
            int[] prefixSums = new int[len];
            for (int j = 0; j < len; ++j) {
                nums[j] = sc.nextInt();
                if (j == 0) prefixSums[0] = nums[j];
                else prefixSums[j] = nums[j] + prefixSums[j - 1];
            }
            if (len == 0) {
                System.out.println(0);
                continue;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);//处理prefixSums[i]等于情况
            for (int i = 0; i < len; ++i) {
                if (map.containsKey(prefixSums[i] - k)) {
                    // 以nums[i]结尾的,最大子数组,且该子数组和为k
                    maxLen = Math.max(maxLen, i - map.get(prefixSums[i] - k));
                }
                // map里面只保存了某一前缀和最先出现的位置。
                // 如果要求，最短的子数组和，可以保存某一前缀和最后出现的位置！！！
                if (!map.containsKey(prefixSums[i])) {
                    map.put(prefixSums[i], i);
                }
            }
            System.out.println(maxLen);
        }

    }

}
