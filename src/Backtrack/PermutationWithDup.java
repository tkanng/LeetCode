
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDup {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /*
    第二种方法！
    Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
    CommonSort the array "int[] nums" to make sure we can skip the same value.
    when a number has the same value with its previous, we can use this number only if his previous is used
     */

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //when a number has the same value with its previous,
            // we can use this number only if his previous is used
            /*
            ，只对第一个未被使用的进行递归，我们那么这一次结果会出现在第一个的递归函数结果中，而后面重复的会被略过。
            如果第一个重复元素前面的元素还没在当前结果中，那么我们不需要进行递归。想明白了这一点，代码其实很好修改。
            首先我们要对元素集合排序，从而让重复元素相邻，接下来就是一行代码对于重复元素和前面元素使用情况的判断即可。
             */
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
