import java.util.Arrays;

public class BiSearch {


    public static void main(String[] args) {

        int[] a = new int[]{2, 5, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0};

        Arrays.sort(a);
        System.out.println(biSearch2(a, 0, 0, a.length - 1));

        System.out.println(getFirstK(a, 6, 3, 3));

        System.out.println(getLastK(a, 6, 0, a.length - 1));


        System.out.println(getFirstEqualOrBigger(a, 5, 0, a.length - 1));
        System.out.println(getLargestNumSmallerThanK(a, 4, 0, a.length - 1));

        System.out.println(getLargestNumSmallerThanK(a, 6, 0, a.length - 1));

        int[] res = getFirstKRelatedInfo(a, 7, 0, a.length - 1);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(a));


    }

    public static boolean biSearch(int[] arr, int k) {
        return biSearch1(arr, k, 0, arr.length - 1);
    }

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

    public static int biSearch2(int[] arr, int k, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    //递归写法
    public static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
            // 下面的判断语句，说明array[mid] == k;
        } else if (mid - 1 >= start && array[mid - 1] == k) {
            // 如果mid==start，直接返回.mid > start, 且array[mid-1] == k，说明在[start, mid-1]中
            return getFirstK(array, k, start, mid - 1);
        } else {
            // mid == start 或者 array[mid-1] != k;
            return mid;
        }
    }

    //循环写法
    public static int getLastK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 <= end && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int getFirstEqualOrBigger(int[] array, int k, int start, int end) {
        int equalIdx = getFirstK(array, k, 0, array.length - 1);
        if (equalIdx >= 0)
            return equalIdx;
        return getFirstBiggerThanK(array, k, 0, array.length - 1);
    }


    public static int getFirstBiggerThanK(int[] array, int k, int start, int end) {
        // array升序排列
        int lo = start;
        int hi = end;
        if (array[end] <= k) return -1; // k 大于最大的值
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (array[mid] > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


    public static int getLargestNumSmallerThanK(int[] nums, int k, int start, int end) {
        // 在prefixSum[i]大于target的时候，才选。
        // 在不存在k的数组中，寻找<k的最大数字的下标值。
        int low = start;
        int high = end;
        if (k > nums[high]) return high; //
        if (k <= nums[start]) return -1; // 当前k小于数组的最小值
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        //  如果没有找到,那么low > high
        return high;
    }

    //递归写法
    public static int[] getFirstKRelatedInfo(int[] array, int k, int start, int end) {
        if (start > end) {
            int[] res = new int[4];
            res[0] = -1; // 在array中没有找到k
            res[1] = (start + end) / 2;
            res[2] = start;// 搜索k，start的最后结果
            res[3] = end; // end的最后结果
            return res;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstKRelatedInfo(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstKRelatedInfo(array, k, mid + 1, end);
            // 下面的判断语句，说明array[mid] == k;
        } else if (mid - 1 >= start && array[mid - 1] == k) {
            // 如果mid==start，直接返回.mid > start, 且array[mid-1] == k，说明在[start, mid-1]中
            return getFirstKRelatedInfo(array, k, start, mid - 1);
        } else {
            // mid == start 或者 array[mid-1] != k;
            int[] res = new int[4];
            res[0] = 0; // 在array中找到k
            res[1] = mid;
            res[2] = start; // start的最后结果
            res[3] = end; // end 的最后结果
            return res;
        }
    }

}
