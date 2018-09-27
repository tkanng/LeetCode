public class DiameterOfBinaryTree {

    /*
    // 下面的方法有很多重复的计算！
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        // 注意这里的diameter的定义i，是指两个节点之间边的个数
        return Math.max(height(root.left) + height(root.right), Math.max(leftMax, rightMax));
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
*/


    // Diameter = MAX(Diameter, leftDepth + rightDepth)
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

}
