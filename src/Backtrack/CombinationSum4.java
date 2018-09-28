import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {


    // 做题中不要使用static变量啊啊啊啊！！！！

    int count = 0;

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{9}, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack3(nums, target);
        return count;
    }

    // 得到所有的排列！
    private void backtrack3(int[] nums, int remain) {
        if (remain == 0) {
            count++;
        } else if (remain < 0) {
            return;
        } else {
            for (int i = 0; i < nums.length && remain >= nums[i]; i++) {
                backtrack3(nums, remain - nums[i]);
            }
        }
    }
}
