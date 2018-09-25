public class IsSymmmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || isSymmmetrical(pRoot.left, pRoot.right);
    }

    static boolean isSymmmetrical(TreeNode leftRoot, TreeNode rightRoot) {

        if (leftRoot == null || rightRoot == null)
            return leftRoot == rightRoot;
        boolean flag1;
        boolean flag2;

        if (leftRoot.val == rightRoot.val) {
            if (leftRoot.left != null && rightRoot.right != null)
                flag1 = isSymmmetrical(leftRoot.left, rightRoot.right);
            else {
                flag1 = (leftRoot.left == null) && (rightRoot.right == null);
            }
            if (leftRoot.right != null && rightRoot.left != null)
                flag2 = isSymmmetrical(leftRoot.right, rightRoot.left);
            else {
                flag2 = (leftRoot.right == null) && (rightRoot.left == null);
            }
            return flag1 && flag2;
        } else {
            return false;
        }


    }
}
