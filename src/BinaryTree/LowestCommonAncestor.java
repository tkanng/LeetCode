
import java.util.ArrayList;
import java.util.Stack;


// Definition of TreeNode:


//Version : Divide & Conquer

public class LowestCommonAncestor {
    //DFS:
    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null

    // 如果是多叉树的话，需要在divide阶段对root的每个子节点做调用
    // Conquer阶段，对Divide阶段得到的结果做处理,
    // 如果root子节点中找到了两个不是null的结果，返回root
    // 如果只有一个子节点调用结果不是null，返回该节点
    // 如果子节点调用结果全是null,返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || root == node1 || root == node2){
            return root;
        }
        //Divide:
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        //Conquer:
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
}

