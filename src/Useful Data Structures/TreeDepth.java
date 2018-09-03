import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if (root.left != null) leftHeight = height(root.left);
        if (root.right != null) rightHeight = height(root.right);

        if (leftHeight > rightHeight) return (leftHeight + 1);
        else return (rightHeight + 1);

    }


    public static int height2(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        if (root == null)
            return 0;
        nodeQueue.add(root);
        depthQueue.add(1);

        int tmpDepth = 0;
        TreeNode tmpNode;
        while (!nodeQueue.isEmpty()) {
            tmpNode = nodeQueue.poll();
            tmpDepth = depthQueue.poll();

            if (tmpNode.left != null) {
                nodeQueue.add(tmpNode.left);
                depthQueue.add(tmpDepth + 1);
            }
            if (tmpNode.right != null) {
                nodeQueue.add(tmpNode.right);
                depthQueue.add(tmpDepth + 1);
            }
        }
        return tmpDepth;
    }


    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean temp = false;

        for (int i = 0; i < array.length; ++i) {
            if (map.containsKey(array[i])) {
                temp = map.get(array[i]);
                map.put(array[i], !temp);
            } else {
                map.put(array[i], true);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(Integer i:map.keySet()){
            if(map.get(i) == true){
                result.add(i);
            }
        }
        num1[0] =result.get(0);
        num2[0] = result.get(1);

    }

}
