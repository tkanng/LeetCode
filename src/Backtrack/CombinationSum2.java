import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {


    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1, 1, 6}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }


    }

    public static List<List<Integer>> combinationSum2_1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        getResult(list, new ArrayList<Integer>(), nums, 0, 0, target);
        return list;
    }

    private static void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int start, int currSum, int target) {
        if (currSum > target) return; // 提前结束递归
        if (currSum == target)
            result.add(new ArrayList<Integer>(cur)); // 取得所有组合
        else {
            for (int i = start; i < candidates.length; ++i) {
                // 通过这个条件得到有重复元素的数组中的所有组合！！！
                if (i > start && candidates[i] == candidates[i - 1]) continue; // skip duplicates
                cur.add(candidates[i]);
                getResult(result, cur, candidates, i + 1, currSum + candidates[i], target); // 这里需要更新start！！如果不更新start,会存在一直递归的情况。
                cur.remove(cur.size() - 1);
            }
        }
    }
}
