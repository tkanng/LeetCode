import java.util.HashMap;

public class AllPathsSumEqualsTarget {


    // 推荐做法中使用了前缀和数组！！！！！
    /*
    In a prefix sum array, sum(a,b) = sum(0, b) - sum(0, a-1) is the same as sum(0, a-1) = sum(0, b) - sum(a,b) where currSum = sum(0, b) and target is sum(a,b). a and b are indices in the array.
Note that currSum is the prefix sum, i.e. the sum of all node values (from its ancestors to that node).

     */


    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        helper(root, 0, sum, preSum);
        return count;
    }

    int count = 0;

    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum) + 1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }


    //递归做法（不推荐）
    //================寻找path（不一定从root开始，不一定终止与叶子节点）上的节点和为target=========
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }


}