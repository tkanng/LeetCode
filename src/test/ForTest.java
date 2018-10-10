public class ForTest {


    public static void main(String[] args) {


    }

    // chars = new char [] {'0', ' ', '2'};
    void foo(char[] chars) {
        chars[1] = '1';  // chars变为{'0','1','2'}
    }

    void foo2(char[] chars) {
        chars = null; // chars不变
    }

    void foo3(Integer i) {
        i = 100;
    }


    public String Serialize(TreeNode root) {
        if (root == null)
            return "#,";
        String s = root.val + ",";
        s += Serialize(root.left);
        s += Serialize(root.right);
        return s;
    }
//
//    public TreeNode Deserialize(String str) {
//        Thread
//    }

}
