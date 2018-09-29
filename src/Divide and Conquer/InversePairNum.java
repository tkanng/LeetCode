import java.util.Arrays;

public class InversePairNum {
    //
    // 正序数相关问题,计算数组的小和：
    // https://www.nowcoder.com/questionTerminal/8397609ba7054da382c4599d42e494f3



    // 逆序对
    public static int inversPairNum(int[] arr, int left, int right) {
        // 返回[left....right]的逆序对数，同时将arr[left]....arr[right]排好序了。
        if (left >= right)
            return 0;
        int mid = (left + right) / 2;
        int leftCount = inversPairNum(arr, left, mid); //包含mid
        int rightCount = inversPairNum(arr, mid + 1, right);
        int mergeCount = 0;
        int leftIdx = mid;
        int rightIdx = right;
        while (leftIdx >= left && rightIdx > mid) {
            if (arr[leftIdx] > arr[rightIdx]) {
                mergeCount += rightIdx - mid;
                leftIdx--;
            } else {
                rightIdx--;
            }
        }
        // 记得排序！
        Arrays.sort(arr, left, right + 1);
        return leftCount + rightCount + mergeCount;
    }
}
