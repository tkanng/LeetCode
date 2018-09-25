import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPathSumEqualTarget {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> paths = new ArrayList<>();
        // 保证root 一定不为null
        FindPath(root, target, res, paths);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return res;
    }

    public static void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<TreeNode> paths) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            // 判断paths中节点与当前节点val和，是否等于target
            int tmp = root.val;
            for (TreeNode node : paths) {
                tmp += node.val;
            }
            if (tmp == target) {
                ArrayList<Integer> oneResult = new ArrayList<>();
                for (TreeNode node : paths) {
                    oneResult.add(node.val);
                }
                oneResult.add(root.val);
                res.add(oneResult);
            }
            return;
        }
        paths.add(root);
        if (root.left != null) {
            FindPath(root.left, target, res, paths);
        }
        if (root.right != null) {
            FindPath(root.right, target, res, paths);
        }
        paths.remove(paths.size() - 1); // 深度遍历后，需要回退一格！
    }

}
