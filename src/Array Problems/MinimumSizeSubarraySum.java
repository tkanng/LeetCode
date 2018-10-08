public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                // 找到所有的区间，使得区间和>=s
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
