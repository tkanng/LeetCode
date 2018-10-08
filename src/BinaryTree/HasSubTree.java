public class HasSubTree {

    // 树的子结构
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) return false;

        if (root1.val == root2.val && tree1HasTree2(root1, root2)) return true;

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    public boolean tree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right);
        }
        return false;
    }
}
