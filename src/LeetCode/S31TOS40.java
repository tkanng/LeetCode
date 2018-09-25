import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    //S39


    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        ArrayList<Integer> chosenNums = new ArrayList<>();
        reachTarget(candidates, target, 0, chosenNums, 0);
        return res;
    }


    public void reachTarget(int[] candidates, int target, int currentSum, ArrayList<Integer> chosenNums, int start) {
        if (currentSum > target) return;
        if (start >= candidates.length) {
            return;
        }
        if (start == candidates.length - 1) {
            // 最后一个元素
            int tmp = currentSum + candidates[start];
            if (tmp > target) return;
            if (tmp == target) {
                //增加一个解
                LinkedList<Integer> oneResult = new LinkedList<>();
                oneResult.addAll(chosenNums);
                oneResult.add(candidates[start]);
                res.add(oneResult);
                return;
            }
            if (tmp < target) {
                // 继续递归
                chosenNums.add(candidates[start]);
                int size = chosenNums.size();
                reachTarget(candidates, target, tmp, chosenNums, start);
                chosenNums.remove(size - 1);
            }
        } else if (start < candidates.length - 1) {
            //不是最后一个元素,两个选择：选择当前元素，不选择当前元素。
            int tmp1 = currentSum + candidates[start];
            if (tmp1 == target) {
                LinkedList<Integer> oneResult = new LinkedList<>();
                oneResult.addAll(chosenNums);
                oneResult.add(candidates[start]);
                res.add(oneResult);
            } else if (tmp1 < target) {
                chosenNums.add(candidates[start]);
                int size = chosenNums.size();
                reachTarget(candidates, target, tmp1, chosenNums, start);
                chosenNums.remove(size - 1);
            }
            reachTarget(candidates, target, currentSum, chosenNums, start + 1);
        }
    }


}
