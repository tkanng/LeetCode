public class MinSumOfSubarrayBiggerThanK {

    public static void main(String[] args) {
        System.out.println(new MinSumOfSubarrayBiggerThanK().minSum(new int[]{33,4,5,99}, 98));
    }

    public int minSum(int[] a, int k) {
        int[] prefixSums = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            if (i == 0) prefixSums[i] = a[i];
            else prefixSums[i] = prefixSums[i - 1] + a[i];
        }
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; ++i) {
            if (prefixSums[i] < k) continue;
            if (BiSearch.biSearch(prefixSums, prefixSums[i] - k)) return k;
            int idx = BiSearch.getLargestNumSmallerThanK(prefixSums, prefixSums[i] - k, 0, a.length - 1);
            if (idx < 0) res = Math.min(res, prefixSums[i]);
            else {
                res = Math.min(res, prefixSums[i] - prefixSums[idx]);
            }
        }
        return res;
    }

    /*

        public static boolean biSearch1(int[] arr, int k, int low, int high) {
        if (low == high)
            return arr[low] == k;
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (arr[mid] == k) return true;
        if (arr[mid] < k) return biSearch1(arr, k, mid + 1, high);
        else return biSearch1(arr, k, low, mid - 1);
    }

        public static int getLargestNumSmallerThanK(int[] nums, int k, int start, int end) {
        // 在prefixSum[i]大于target的时候，才选。
        // 在不存在k的数组中，寻找<k的最大数字的下标值。
        int low = start;
        int high = end;
        if (k > nums[high]) return high + 1;
        if (k < nums[0]) return -1; // 当前k小于数组的最小值
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        //  如果没有找到,那么low > high
        return high;
    }

     */


}
