import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPathSumEqualTarget {


    // 寻找是否有从root到叶子节点的和为target
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // path必须从root开始，到叶子节点
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 保证root 一定不为null
        FindPath2(root, target, res, new ArrayList<Integer>());
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return res;
    }

    // 寻找从根节点到叶子节点和为target的路径
    public static void FindPath2(TreeNode root, int remain,
                                 ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmpList) {
        if (root == null) return;
        tmpList.add(root.val);
        if (root.left == null && root.right == null && remain == root.val) res.add(new ArrayList<>(tmpList));
        FindPath2(root.left, remain - root.val, res, tmpList); // 传remain参数，不要传sum！
        FindPath2(root.right, remain - root.val, res, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }


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
