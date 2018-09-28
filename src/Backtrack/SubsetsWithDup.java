import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) begin = 0;

            /*
            每遍历到一个元素，只考虑两个部分，一是不添加当前元素的结果集合，另一是添加当前元素的结合。最后将两个部分结合起来.
             如{1,2,2,2,3}
            [[]]
            [[]] 添加1 ===> [[], [1]]   (将添加了1的中间结果，添加到最后结果中)
            [[],[1]] 添加2 === > [[], [1], [2],[1,2]]
            [[], [1], [2],[1,2]] 添加2(为重复元素,为保证结果中不存在重复,向[2],[1,2]添加2,然后添加到最终结果中)  =====> [[], [1], [2],[1,2], [2,2], [1,2,2]]
            [[], [1], [2],[1,2], [2,2], [1,2,2]]   添加2 ===>[[], [1], [2],[1,2], [2,2], [1,2,2], [2,2,2],[1,2,2,2]]
             */

            int size = result.size();
            for (int j = begin; j < size; j++) {
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;  // 记录扩展解集合前的结果大小
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
