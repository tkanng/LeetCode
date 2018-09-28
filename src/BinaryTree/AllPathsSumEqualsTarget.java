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

    int result = 0;

    public int pathSum3(TreeNode root, int sum) {
        if (root == null) return 0;
        result = 0;
        tranverse(root, sum);
        return result;
    }

    void tranverse(TreeNode root, int sum) {
        result += pathCount(root, sum);
        if (root.left != null) {
            tranverse(root.left, sum);
        }
        if (root.right != null) {
            tranverse(root.right, sum);
        }
    }

    public int pathCount(TreeNode root, int remain) {
        // 包含root路径所有节点的val和等于remain,的路径条数
        if (root == null) return 0;
        int count = 0;
        if (root.val == remain) count = 1;
        count += pathCount(root.left, remain - root.val);
        count += pathCount(root.right, remain - root.val);
        return count;
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