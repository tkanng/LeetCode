/**
 * @author YangXuan
 * @Description : 描述
 * @email 364105996@qq.com
 * @date 2013-11-25 下午8:21:13
 */
public class MaxDistanceBetween2Nodes {

    /**
     * @Description : 节点实体
     */
    private class Node {
        Node left;
        Node right;
        int nValue;
        int nMaxLeft;
        int nMaxRight;

        Node(int data) {
            nValue = data;
        }
    }

    private Node root;
    private int maxDistance = 0;

    public MaxDistanceBetween2Nodes(Node root) {
        this.root = root;
    }

    /**
     * @return Node 返回类型
     * @Description: 将数据插入二叉树并使之有序
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.nValue) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    /**
     * @return void 返回类型
     * @Description: 将数组转换成二叉树
     */
    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            root = insert(root, data[i]);
        }
    }

    /**
     * @return void 返回类型
     * @Description: 打印有序二叉树
     */
    private void printTree(Node node) {

        if (node == null)
            return;
        printTree(node.left);
        System.out.print(node.nValue + "  ");
        printTree(node.right);
    }

    public void printTree() {
        printTree(root);
    }

    private void maxDistance(Node root) {
        // 遍历到叶子节点，返回
        if (root == null)
            return;

        // 如果左子树为空，那么该节点的左边最长距离为0
        if (root.left == null) {
            root.nMaxLeft = 0;
        }

        // 如果右子树为空，那么该节点的右边最长距离为0
        if (root.right == null) {
            root.nMaxRight = 0;
        }

        // 如果左子树不为空，递归寻找左子树最长距离
        if (root.left != null) {
            maxDistance(root.left);
        }

        // 如果右子树不为空，递归寻找右子树最长距离
        if (root.right != null) {
            maxDistance(root.right);
        }

        // 计算左子树最长节点距离
        if (root.left != null) {
            int nTempMax = 0;
            if (root.left.nMaxLeft > root.left.nMaxRight) {
                nTempMax = root.left.nMaxLeft;
            } else {
                nTempMax = root.left.nMaxRight;
            }
            root.nMaxLeft = nTempMax + 1;
        }

        // 计算右子树最长节点距离
        if (root.right != null) {
            int nTempMax = 0;
            if (root.right.nMaxLeft > root.right.nMaxRight) {
                nTempMax = root.right.nMaxLeft;
            } else {
                nTempMax = root.right.nMaxRight;
            }
            root.nMaxRight = nTempMax + 1;
        }

        // 更新最长距离
        if (root.nMaxLeft + root.nMaxRight > maxDistance) {
            maxDistance = root.nMaxLeft + root.nMaxRight;
        }
    }

    public void countMaxDistance() {
        maxDistance(root);
    }



    // TODO:用高度的思想去求解！！！
//情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
//情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
    //  //return MaxDistance of t
    //int MaxDistance(Tree * t)
    //{
    //    if (t == 0) return 0;
    //    int lheight = height(t->left)-1;//左子树高度-1
    //    int rheight = height(t->right)-1;
    //    int lDis = MaxDistance(t->left);
    //    int rDis = MaxDistance(t->right);
    //    return max(lheight + rheight + 2,max(lDis,rDis));//+2:根节点到左右孩子的边
    //}
    ////returns height of tree with root t
    //int height(Tree * t){
    //     if (t == 0)
    //          return 0;
    //    return 1 + max(height(t->left),height(t->right));
    //}


    public static void main(String[] args) {
        Node root = null;
        MaxDistanceBetween2Nodes a = new MaxDistanceBetween2Nodes(root);
        int[] data = {9, 6, 4, 8, 7, 3, 15, 13, 16, 18, 14, 15, 15, 16};
        a.buildTree(data);
        a.countMaxDistance();
        a.printTree();
        System.out.println();
        System.out.println("任意两个节点间的最大距离为 : " + a.maxDistance);
    }


}
