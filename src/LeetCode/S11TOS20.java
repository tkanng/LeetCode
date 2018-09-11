import java.util.*;

public class S11TOS20 {

    public static void main(String[] args) {

        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}, 0));
    }

    // S11 Brute Force
    public int maxArea(int[] height) {
        int x = 0;
        int y = 1;
        int len = height.length;
        if (len < 2) return 0;
        int ans = 0;
        for (; x < len - 1; ++x) {
            for (; y < len; ++y) {
                ans = Math.max(ans, (y - x) * Math.min(height[x], height[y]));
            }
        }
        return ans;
    }

    // S11 双指针法与证明：https://leetcode.com/problems/container-with-most-water/discuss/6099/yet-another-way-to-see-what-happens-in-the-on-algorithm/174248


    // S15  3 sum
    public static List<List<Integer>> threeSum1(int[] nums, int x) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(); // 初始化操作！
        HashSet<String> stringHashSet = new HashSet<>();

        if (nums.length < 3) return ans;
        int j, k, delta;
        for (int i = 0; i < nums.length - 2; ++i) {
            j = i + 1;
            k = nums.length - 1;
            delta = x - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == delta) {
                    stringHashSet.add(nums[i] + "_" + nums[j] + "_" + nums[k]);
                    ++j;
                    --k;
                } else if (nums[j] + nums[k] > delta) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        for (String s : stringHashSet) {
            ans.add(Arrays.asList(Integer.parseInt(s.split("_")[0]), Integer.parseInt(s.split("_")[1]), Integer.parseInt(s.split("_")[2])));
        }
        return ans;
    }


    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                // 这里的条件限制目的：找到有序序列中值为num[i]的第一个序号。如：-1-100111,那么只有下标为：0,2,4才会进入这个循环
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }

        }
        return res;
    }


}
