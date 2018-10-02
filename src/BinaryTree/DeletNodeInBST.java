public class DeletNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] treeNodes = new TreeNode[2];
        find(root, key, treeNodes);
        TreeNode target = treeNodes[0];
        TreeNode parent = treeNodes[1];

        if (target == null)
            return root;
        // 找到target节点
        if (target == root) {
            // target为当前树的根节点！树只有一个节点
            if (target.left == null && target.right == null)
                return null;
            // target 有左孩子,无右孩子
            if (target.left != null && target.right == null) {
                return root.left;
            }
            // target 有右孩子，无左孩子
            if (target.left == null && target.right != null) {
                return root.right;
            }
            // target既有左孩子，又有右孩子
            TreeNode tmp = findLargestNodeInLeftTree(target);
            int val = tmp.val;
            deleteNode(root, val);
            target.val = val;
            return root;
        } else {
            // target 不是当前树的根节点
            // target 为叶子节点
            if (target.left == null && target.right == null) {
                if (parent.left == target) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return root;
            }
            // target 有左孩子,无右孩子
            if (target.left != null && target.right == null) {
                if (parent.left == target) {
                    parent.left = target.left;
                } else {
                    parent.right = target.left;
                }
                return root;
            }
            // target 有右孩子，无左孩子
            if (target.left == null && target.right != null) {
                if (parent.left == target) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
                return root;
            }
            // target既有左孩子，又有右孩子
            TreeNode tmp = findLargestNodeInLeftTree(target);
            int val = tmp.val;
            deleteNode(root, val);
            target.val = val;
            return root;
        }

    }

    public TreeNode findLargestNodeInLeftTree(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    public void find(TreeNode root, int key, TreeNode[] treeNodes) {
        if (root == null)
            return;
        if (root.val == key) {
            treeNodes[0] = root; // parent 为null
        } else {
            if (root.left != null) findCore(root.left, key, root, treeNodes);
            if (root.right != null) findCore(root.right, key, root, treeNodes);
        }
    }

    public void findCore(TreeNode root, int key, TreeNode father, TreeNode[] treeNodes) {
        if (root == null)
            return;
        if (root.val == key) {
            treeNodes[0] = root;
            treeNodes[1] = father;
            return;
        }
        if (root.left != null)
            findCore(root.left, key, root, treeNodes);
        if (root.right != null)
            findCore(root.right, key, root, treeNodes);
    }
}
