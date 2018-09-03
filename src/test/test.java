import java.util.*;

public class test {
//
//    public static void main(String[] args) {
//
//        System.out.println(InversePairs(new int[]{1,2,3,4,5,6,7,0}));
//    }
//
//    public int FindGreatestSumOfSubArray(int[] array) {
//
//        int[] f = new int[array.length];
//        int max = array[0];
//        for (int a : array) {
//            if (a < max) max = a;
//        }
//
//        for (int i = 0; i < array.length; ++i) {
//            if (i == 0)
//                f[i] = array[i];
//            else {
//                if (f[i - 1] < 0) {
//                    f[i] = array[i];
//                } else {
//                    f[i] = f[i - 1] + array[i];
//                }
//            }
//
//            if (f[i] > max) max = f[i];
//        }
//        return max;
//
//    }
//
//    public static int InversePairs(int[] array) {
//        return inversePairs(array, 0, array.length - 1);
//    }
//
//
//    public static int inversePairs(int[] array, int left, int right) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            int leftCount = inversePairs(array, left, mid);
//            int rightCount = inversePairs(array, mid + 1, right);
//            int mergeCount = 0;
//
//
//
//            int [] copy = new int[right -left +1];
//            for(int i=left;i<=right;++i){
//                copy[i-left] = array[i];
//            }
//
//            Arrays.sort(copy, 0,mid-left);
//            Arrays.sort(copy, 0,mid-left);
//            return 0;
//
////
////            Arrays.sort(leftTmp);
////            Arrays.sort(rightTmp);
////
////            int leftIdx = 0;
////            int rightIdx = 0;
////
////            while (leftIdx < leftTmp.length && rightIdx < rightTmp.length) {
////                if (leftTmp[leftIdx] > rightTmp[rightIdx]) {
////                    mergeCount += leftTmp.length - leftIdx + 1;
////                    ++leftIdx;
////                    ++rightIdx;
////                } else {
////                    ++leftIdx;
////                }
////            }
////            return (leftCount + rightCount + mergeCount);
////        }else {
////            return 0;
////        }
//
//    }


    public static void main(String[] args) {
//        test t = new test();
//        System.out.println(t.LastRemaining_Solution(9, 1));

        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(0);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;

        ListNode r = deleteDuplication(a);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }


    }


    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        if (text.isEmpty()) {
            for (char ch : pattern.toCharArray()) {
                if (ch != '*')
                    return false;
            }
            return true;
        }

        if (pattern.charAt(0) == '*') {
            return isMatch(text.substring(1), pattern) || isMatch(text, pattern.substring(1));
        }
        boolean first_match = (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '?');

        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }

    public static int inversPairNum(int[] arr, int left, int right) {
        if (left >= right)
            return 0;

        int mid = (left + right) / 2;
        int leftCount = inversPairNum(arr, left, mid); //包含mid
        int rightCount = inversPairNum(arr, mid + 1, right);

        int mergeCount = 0;


        int leftIdx = mid;
        int rightIdx = right;

        while (leftIdx >= left && rightIdx > mid) {
            if (arr[leftIdx] > arr[rightIdx]) {
                mergeCount += rightIdx - mid;
                leftIdx--;
            } else {
                rightIdx--;
            }
        }
        Arrays.sort(arr, left, right + 1);

        return leftCount + rightCount + mergeCount;
    }


    public static String LeftRotateString(String str, int n) {
        char[] chars = new char[str.length()];
        n = n % str.length();

        for (int i = 0; i < str.length(); ++i) {

            if (i - n < 0) {
                chars[i - n + str.length()] = str.charAt(i);
            } else {
                chars[i - n] = str.charAt(i);
            }
        }
        return String.valueOf(chars);

    }


    public static boolean isContinuous(int[] numbers) {
        if (numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int zeroCount = 0;
        int noZeroBeginIdx = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == 0) zeroCount++;
            else {
                noZeroBeginIdx = i;
                break;
            }
        }
        int zeroNeededNum = 0;
        if (noZeroBeginIdx < numbers.length - 1) {
            for (int i = noZeroBeginIdx + 1; i < numbers.length; ++i) {
                if (numbers[i] == numbers[i - 1]) return false;
                zeroNeededNum += (numbers[i] % 14) - (numbers[i - 1] % 14) - 1;
            }
        }
        return zeroNeededNum <= zeroCount;
    }

    public class Node {
        int location;

        Node(int location) {
            this.location = location;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int noCouter = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (noCouter == m - 1) {
                noCouter = 0;
                result = top;
            } else {
                noCouter += 1;
                queue.add(top);
            }
        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;

        ListNode current = pHead.next;
        boolean isRepeated = false;

        while (current != null && current.val == pHead.val) {
            isRepeated = true;
            current = current.next;
        }
        if (isRepeated)
            return deleteDuplication(current);
        else {
            // current 为下一个不重复的节点
            pHead.next = deleteDuplication(current);
            return pHead;
        }
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null)
                return null;

            TreeLinkNode root = pNode;
            while (root.next != null) {
                root = root.next;
            }

            Stack<TreeLinkNode> stack = new Stack<>();

            TreeLinkNode node = null;
            TreeLinkNode pre = null;
            HashMap<TreeLinkNode, Integer> map = new HashMap<>();
            stack.push(root);
            map.put(root, 0);

            while (!stack.isEmpty()) {
                node = stack.pop();
                map.put(node, map.get(node) + 1);
                if (map.get(node) == 2) {
                    if (pre == pNode) {
                        return node;
                    } else {
                        pre = node;
                    }

                    if (node.right != null) {
                        stack.push(node.right);
                        map.put(node.right, 0);
                    }
                } else {
                    stack.push(node);
                    if (node.left != null) {
                        stack.push(node.left);
                        map.put(node.left, 0);
                    }

                }

            }
            return null;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayList<Integer> oneLayer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> layerNo = new LinkedList<>();
        q.add(pRoot);
        layerNo.add(0);
        int currentLayerNo = 0;
        TreeNode currentNode = null;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        while (!q.isEmpty()) {
            currentLayerNo = layerNo.poll();
            currentNode = q.poll();
            if (!map.containsKey(currentLayerNo)) {
                map.put(currentLayerNo, new ArrayList<>());
            }
            map.get(currentLayerNo).add(currentNode.val);

            if(currentNode.left!=null){
                q.add(currentNode.left);
                layerNo.add(currentLayerNo+1);
            }
            if(currentNode.right!=null){
                q.add(currentNode.right);
                layerNo.add(currentLayerNo+1);
            }

        }



    }


    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || isSymmmetrical(pRoot.left, pRoot.right);
    }

    static boolean isSymmmetrical(TreeNode leftRoot, TreeNode rightRoot) {

        if (leftRoot == null || rightRoot == null)
            return leftRoot == rightRoot;
        boolean flag1;
        boolean flag2;

        if (leftRoot.val == rightRoot.val) {
            if (leftRoot.left != null && rightRoot.right != null)
                flag1 = isSymmmetrical(leftRoot.left, rightRoot.right);
            else {
                flag1 = (leftRoot.left == null) && (rightRoot.right == null);
            }
            if (leftRoot.right != null && rightRoot.left != null)
                flag2 = isSymmmetrical(leftRoot.right, rightRoot.left);
            else {
                flag2 = (leftRoot.right == null) && (rightRoot.left == null);
            }
            return flag1 && flag2;
        } else {
            return false;
        }


    }


}