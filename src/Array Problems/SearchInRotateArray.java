public class SearchInRotateArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int minIndex = minIdx(nums);
        if (nums[minIndex] == target)
            return minIndex;
        if (minIndex == 0) {
            return Bisearch(nums, 1, nums.length - 1, target);
        } else if (minIndex == nums.length - 1) {
            return Bisearch(nums, 0, nums.length - 2, target);
        } else {
            if (target >= nums[0]) {
                return Bisearch(nums, 0, minIndex - 1, target);
            } else {
                return Bisearch(nums, minIndex + 1, nums.length - 1, target);
            }

        }


    }

    public static int Bisearch(int[] nums, int lo, int hi, int target) {
        if (lo >= nums.length || hi >= nums.length)
            return -1;

        if (lo == hi) {
            if (nums[lo] == target)
                return lo;
            return -1;
        }
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] > target) return Bisearch(nums, lo, mid - 1, target);
        else return Bisearch(nums, mid + 1, hi, target);
    }

    /*
        public static int minIdx(int[] nums) {
            if (nums.length == 1) return 0;
            if (nums[0] < nums[nums.length - 1])
                // 对于递增序列
                return 0;
            if (nums[nums.length - 1] < nums[nums.length - 2])
                return nums.length - 1; // 最小元素是最后一个元素的情况

            int lo = 0;
            int hi = nums.length - 1;
            int mid = (lo + hi) / 2;
            while (lo < hi) {
                mid = lo + (hi - lo) / 2; // 防止溢出
                if (mid == lo) {
                    return nums[lo] < nums[hi] ? lo : hi;
                }
                if (nums[lo] >= nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            return lo;
        }
    */
    public static int minIdx(int[] nums) {
        // 也适用于含有重复元素的数组
        if (nums == null || nums.length == 0)
            return -1;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return lo;
    }



}
