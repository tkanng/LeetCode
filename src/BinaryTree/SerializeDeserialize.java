import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {
    // 可以结合KMP做一些，骚东西

    public String Serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            return "#!";
        }
        res += root.val + "!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }

    public TreeNode Deserialize(String str) {
        Queue<String> queue = new LinkedList<String>();
        String[] strings = str.split("!");
        queue.addAll(Arrays.asList(strings));
        return DeserializeCore(queue);
    }

    public TreeNode DeserializeCore(Queue<String> strings) {
        if (strings.isEmpty()) return null;
        String s = strings.poll();
        if (s.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = DeserializeCore(strings);
        root.right = DeserializeCore(strings);
        return root;
    }


}
