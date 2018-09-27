public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumWithNode(root);
        return maxSum;
    }

    public int maxSumWithNode(TreeNode root) {
        // 必须包含node节点且向下扩展的节点最大和
        if (root == null) return 0;
        int maxWithLeft = maxSumWithNode(root.left);
        int maxWithRight = maxSumWithNode(root.right);
        int tmp = root.val + Math.max(0, Math.max(maxWithLeft, maxWithRight)); // 0表示不选择节点
        // 必须包含节点root节点的路径上，最大的节点和与maxSum比较
        // 如果maxWithLeft,maxWithRight小于0,节点和最大的路径，就不会包含对应节点
        maxSum = Math.max(maxSum, root.val + Math.max(0, maxWithLeft) + Math.max(0, maxWithRight));
        return tmp;

    }
}
