public class SortColor {

    // 1-pass
    //-------------  SOLUTION 2: 1 SCAN ----------------//
    // 3-way partition used in quick sort
    public void sortColors(int[] nums) {
        int lt = 0, i = 0, gt = nums.length - 1;
        // 以1作为三向快速排序的v, 可以确定这种划分方法只会有一次
        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, gt--);
            } else { // nums[i] == 1
                i++;
            }
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    // 2-pass
    //-------------  SOLUTION 1: 2 SCANs ----------------//
    // counting sort
    public void sortColors2(int[] A) {
        // count
        int[] counts = new int[3];
        for (int i : A) {
            counts[i]++;
        }
        // fill
        for (int i = 0; i < A.length; i++) {
            if (i < counts[0]) {
                A[i] = 0;
            } else if (i < counts[0] + counts[1]) {
                A[i] = 1;
            } else {
                A[i] = 2;
            }
        }
    }
}
