public class ReconstructBinaryTree {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        if (pre.length != in.length)
            return null;
        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTreeCore(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
        if (pre_end - pre_start < 0 || in_end - in_start < 0 || pre_end > pre.length - 1 || in_end > in.length - 1)
            return null;
        if (pre_end == pre_start)
            return new TreeNode(pre[pre_start]);
        TreeNode root = new TreeNode(pre[pre_start]);
        int rootIdxOfIn = -1;
        for (int i = in_start; i <= in_end; ++i) {
            if (in[i] == root.val) {
                rootIdxOfIn = i;
                break;
            }
        }
        // don't find root.val in Array in
        if (rootIdxOfIn < 0) return null;
        root.left = reConstructBinaryTreeCore(pre, pre_start + 1, pre_start + rootIdxOfIn - in_start, in, in_start, rootIdxOfIn - 1);
        root.right = reConstructBinaryTreeCore(pre, pre_start + rootIdxOfIn - in_start + 1, pre_end, in, rootIdxOfIn + 1, in_end);
        return root;
    }


}
