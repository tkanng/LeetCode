import java.util.Arrays;

public class BuketSortProblems {

    // https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int len = citations.length;
        int H = 0;
        for (int i = 0; i < len; ++i) {
            if (i == 0 || citations[i - 1] != citations[i]) {
                int paperNumEqualOrBiggerThanH = len - i;
                H = Math.max(Math.min(citations[i], paperNumEqualOrBiggerThanH), H);
            }
        }
        return H;
    }


    //Maximum Gap
    public int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max); // 算出桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= len) {
            if (hasNum[i++]) { // 找到 第一个 不为 空的 桶
                lastMax = maxs[i - 1];
                break;
            }
        }
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    } // 使用 long 类型 是 为了 防止 相乘 时 溢出

    public int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }


}
