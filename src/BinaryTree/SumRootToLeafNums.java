import java.util.ArrayList;

public class SumRootToLeafNums {

    static int res = 0;


    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);


        System.out.println(sumNumbers(root));

    }
    public static int sumNumbers(TreeNode root) {

        if (root == null) return res;

        ArrayList<Integer> paths = new ArrayList<>();
        tranverse(root, paths);

        return res;
    }


    public static void tranverse(TreeNode node, ArrayList<Integer> paths) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            int tmp = 0;
            paths.add(node.val);
            for (int i = 0; i < paths.size(); ++i) {
                tmp = tmp * 10 + paths.get(i);
            }
            res += tmp;
            paths.remove(paths.size()-1);
            return;
        }
        paths.add(node.val);
        tranverse(node.left, paths);
        tranverse(node.right, paths);
        paths.remove(paths.size() - 1);
    }

}
