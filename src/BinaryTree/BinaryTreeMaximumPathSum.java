public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumWithNode(root);
        return maxSum;
    }

    // 必须包含root节点且向下扩展的路径中，节点的最大和
    public int maxSumWithNode(TreeNode root) {
        if (root == null) return 0;
        int maxWithLeft = maxSumWithNode(root.left);
        int maxWithRight = maxSumWithNode(root.right);
        // tmp是包含root节点,向下扩展的最大路路径和
        int tmp = root.val + Math.max(0, Math.max(maxWithLeft, maxWithRight)); // 0表示不选择子节点
        // 必须包含节点root节点的路径上，最大的节点和与maxSum比较
        // 如果maxWithLeft,maxWithRight小于0,节点和最大的路径，就不会包含对应节点
        maxSum = Math.max(maxSum, root.val + Math.max(0, maxWithLeft) + Math.max(0, maxWithRight));
        return tmp;

    }
}
