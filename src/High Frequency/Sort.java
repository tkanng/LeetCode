import java.util.Arrays;
import java.util.Stack;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {9, 1, 2};
//        quickSort1(arr, 0, arr.length-1);
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort1(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pos = divide(nums, lo, hi);
            quickSort1(nums, lo, pos - 1);
            quickSort1(nums, pos + 1, hi);
        }
    }

    public static int divide(int[] nums, int lo, int hi) {
        int val = nums[lo];
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

    static class Range {

        int lo = 0;
        int hi = 0;

        Range(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }
    }


    public static void quickSort2(int[] nums, int lo, int hi) {
        Stack<Range> stack = new Stack<>();
        if (lo < hi) {
            stack.push(new Range(lo, hi));
        }
        while (!stack.isEmpty()) {
            Range r = stack.pop();
            int tmp = divide(nums, r.lo, r.hi);
            if (tmp - 1 > lo) {
                stack.push(new Range(r.lo, tmp - 1));
            }
            if (tmp + 1 < hi) {
                stack.push(new Range(tmp + 1, r.hi));
            }
        }
    }

    public static void MergeSort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}




