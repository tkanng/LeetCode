import java.util.Arrays;
import java.util.Stack;

public class CommonSort {

    public static void main(String[] args) {
        int[] arr = {9, 1, 2};
//        quickSort1(arr, 0, arr.length-1);
//        quickSort2(arr, 0, arr.length - 1);
        MergeSort2(arr);
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
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    //使用递归的归并排序需要深度为LogN的栈空间
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2; // 防止left+right 溢出
            mergeSort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
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

    // 归并排序非递归实现！！
    public static void MergeSort2(int[] arr) {
        //使用非递归的方式来实现归并排序
        int len = arr.length;
        int k = 1;

        while (k < len) {
            MergePass(arr, k, len);
            k *= 2;
        }
    }

    //MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
    private static void MergePass(int[] arr, int k, int n) {
        int i = 0;
        int j;

        //从前往后,将2个长度为k的子序列合并为1个
        while (i < n - 2 * k + 1) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }

        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if (i < n - k) {
            merge(arr, i, i + k - 1, n - 1);
        }
    }

    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for (; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }


}




