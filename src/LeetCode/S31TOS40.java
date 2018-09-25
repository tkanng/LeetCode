import java.util.Arrays;

public class S31TOS40 {

    //S31
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            --i;
        }
        if (i == 0) {
            Arrays.sort(nums);
        } else {
            int tmp = nums[i - 1]; // 小的元素
            int j = nums.length - 1;
            while (nums[j] <= tmp) {
                --j;
            }
            nums[i - 1] = nums[j];
            nums[j] = tmp;
            Arrays.sort(nums, i, nums.length); //后面元素升序排列.
        }
    }


}
