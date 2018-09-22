//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = Math.abs(sc.nextInt());
//        int[] nums = new int[n];
//        int min = 0;
//        int max = 0;
//        int ap = 0;
//        int am = 0;
//        for (int i = 0; i < n; ++i) {
//            nums[i] = sc.nextInt();
//        }
//        // 可以排序一下！
//        //Arrays.sort(nums);
//        if (n == 2) {
//            if (nums[1] - nums[0] > k) {
//                System.out.println(Math.abs(nums[1] - nums[0] - 2 * k));
//            } else {
//                System.out.println(Math.abs(nums[1] - nums[0]));
//            }
//        } else if (n > 2) {
//            if (nums[1] > nums[0] && nums[1] - nums[0] > k) {
//                max = Math.max(nums[0] + k, nums[1] - k);
//                min = Math.min(nums[0] + k, nums[1] - k);
//            } else if (nums[1] > nums[0]) {
//                max = nums[1] + k;
//                min = nums[0] + k;
//            } else {
//                max = nums[0] + k;
//                min = nums[1] + k;
//            }
//            for (int i = 2; i < n; ++i) {
//                ap = Math.max(Math.abs(nums[i] + k - max), Math.abs(nums[i] + k - min));
//                am = Math.max(Math.abs(nums[i] - k - max), Math.abs(nums[i] - k - min));
//                if (ap < am) {
//                    if (nums[i] + k > max) {
//                        max = nums[i] + k;
//                    }
//                    if (nums[i] + k < min) {
//                        min = nums[i] + k;
//                    }
//                } else {
//                    if (nums[i] - k > max) {
//                        max = nums[i] - k;
//                    }
//                    if (nums[i] - k < min) {
//                        min = nums[i] - k;
//                    }
//                }
//            }
//        }
//        System.out.println(max - min);
//    }
//}


//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int []  scores = new int[n];
//        int [] doors = new int[n];
//        for(int i=0;i<n;i++){
//            scores[i] = sc.nextInt();
//            doors[i] = sc.nextInt()-1;
//        }
//        if(n==0) {
//            System.out.println(0);
//            return;
//        }
//        int max =scores[0];
//        int maxIdx =0;
//        for(int i=0;i<n;++i){
//            if(scores[i] >max){
//                max = scores[i];
//                maxIdx = i;
//            }
//        }
//        int idx = maxIdx;
//        int ret = max;
//        while(scores[doors[idx]] >=0){
//            ret += scores[doors[idx]];
//            idx = doors[doors[idx]];
//        }
//        System.out.println(ret);
//
//
//    }
//}

//import javax.xml.ws.BindingType;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//    }
//
//    class IndexNode {
//        TreeNode node;
//        int layerNo;
//
//        IndexNode(TreeNode node, int layerNo) {
//            this.node = node;
//            this.layerNo = layerNo;
//        }
//    }
//
//    class TreeNode {
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//
//        public TreeNode(int val) {
//            this.val = val;
//
//        }
//
//    }
//
//    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        Queue<IndexNode> q = new LinkedList<>();
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (pRoot == null)
//            return res;
//        q.add(new IndexNode(pRoot, 0));
//        IndexNode tmp = null;
//        int preLayer = -1;
//        ArrayList<Integer> oneResult = new ArrayList<>();
//        while (!q.isEmpty()) {
//            tmp = q.poll();
//            if(tmp.layerNo != preLayer){
//                oneResult = new ArrayList<>();
//                oneResult.add(tmp.node.val);
//                res.add(oneResult);
//            }else{
//                res.get(tmp.layerNo).add(tmp.node.val);
//            }
//            if (tmp.node.left != null)
//                q.add(new IndexNode(tmp.node.left, tmp.layerNo + 1));
//            if (tmp.node.right!= null)
//                q.add(new IndexNode(tmp.node.right, tmp.layerNo + 1));
//            preLayer = tmp.layerNo;
//        }
//        return res;
//    }
//
//}
//
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int Q = sc.nextInt();
//        int[] A = new int[N]; // 注意溢出问题
//        long sum = 0;
//        for (int i = 0; i < N; ++i) {
//            A[i] = sc.nextInt();
//            if (A[i] % 2 == 0) sum += A[i];
//        }
//        int Iq = 0;
//        int Xq = 0;
//        int tmp =0;
//        for (int i = 0; i < Q; ++i) {
//            // Q changes
//            Iq = sc.nextInt()-1; // index
//            Xq = sc.nextInt(); // change num
//            tmp = A[Iq]+Xq;
//
//            if((A[Iq]&1)==1 && (tmp&1)==1){
//                System.out.println(sum); // odd ->odd
//            }else if((A[Iq]&1)==1 && (tmp&1)==0){
//                sum += tmp;
//                System.out.println(sum);
//            }else if((A[Iq]&1)==0 && (tmp&1)==1){
//                sum -= A[Iq];
//                System.out.println(sum);
//            }else if((A[Iq]&1)==0 && (tmp&1)==0){
//                sum += Xq;
//                System.out.println(sum);
//            }
//           A[Iq] = tmp;
//        }


//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] X = new int[N];
//        for (int i = 0; i < N; ++i) {
//            X[i] = sc.nextInt();
//        }
//        X[0] = 0 - X[0];
//        int ans1 = isNonDesc(X, 1, 1);
//        X[0] = 0 - X[0];
//        int ans2 = isNonDesc(X, 1, 0);
//        if (ans1 == -1 && ans2 == -1) {
//            System.out.println(-1);
//        }
//        if (ans1 == -1 && ans2 != -1) {
//            System.out.println(ans2);
//        }
//        if (ans1 != -1 && ans2 == -1) {
//            System.out.println(ans1);
//        }
//        if (ans1 != -1 && ans2 != -1) {
//            System.out.println(Math.min(ans2, ans1));
//        }
//
//    }
//
//    public static int isNonDesc(int[] X, int next, int opCount) {
//        if (next == X.length) return opCount;
//        if (opCount == -1) return -1;
//        X[next] = 0 - X[next];
//        int ans1 = isNonDesc(X, next + 1, X[next] >=X[next-1]?opCount+1:-1);
//        int ans = -1;
//        X[next] = 0 - X[next];
//        int ans2 = isNonDesc(X, next + 1, X[next] >=X[next-1]?opCount:-1);
//        if (ans1 == -1 && ans2 == -1) {
//            ans = -1;
//        } else if (ans1 == -1 && ans2 != -1) {
//            ans = ans2;
//        } else if (ans1 != -1 && ans2 == -1) {
//            ans = ans1;
//        } else if (ans1 != -1 && ans2 != -1) {
//            ans = Math.min(ans2, ans1);
//        }
//        return ans;
//    }

//[1531324800][login],{"roleid":"1"}
//[1531364400][login],{"roleid":"2"}
//[1531368000][logout],{"roleid":"1"}
//[1531371600][other],{"roldid":"2"}
//[1531371600][logout],{"roleid":"2"}
//[1531371540][login],{"roleid":"3"}
//[1531375200][logout],{"roleid":"3"}
//

//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Long> inTime = new ArrayList<>();
//        HashMap<Long, String> inToId = new HashMap<>();
//        String line = "";
//        HashMap<String, Long> idToOut = new HashMap<>();
//        long time = 0L;
//        long out = 0L;
//        String id = "";
//        String type = "";
//        ArrayList<String > ans = new ArrayList<>();
//        double maxMatchRate = 0.0;
//        while (sc.hasNextLine()) {
//            line = sc.nextLine();
//            if(line.isEmpty()) break;
//            id = line.split(":")[1];
//            id = id.substring(1, id.length() - 2);
//            time = Long.parseLong(line.split("]")[0].substring(1));
//            type = line.split("]")[1].substring(1);
//            if (type.equals("logout")) {
//                idToOut.put(id, time);
//            } else if (type.equals("login")) {
//                inTime.add(time);
//                inToId.put(time, id);
//            }
//        }
//        inTime.sort(new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                return (int) (o1-o2);
//            }
//        });
//
//        long otherin,otherout = 0;
//        long in;
//        String otherId="";
//        double tmp = 0;
//        long ontime, otherontime=0;
//        for(int i=0;i<inTime.size();++i){
//            in = inTime.get(i);
//            id = inToId.get(in);
//            out = idToOut.get(id);
//            ontime =out-in;
//            for(int t=i+1; t< inTime.size() &&inTime.get(t)<out;++t){
//                otherin = inTime.get(t);
//                otherId = inToId.get(otherin);
//                otherout = idToOut.get(otherId);
//                otherontime = otherout - otherin;
//                if(otherout<out){
//                    tmp = 20000*(otherout-otherin)/(otherontime + ontime);
//                    if(tmp > maxMatchRate){
//                        ans = new ArrayList<String >();
//                        ans.add(id);
//                        ans.add(otherId);
//                    }
//                }else {
//                    tmp = 20000*(out-otherin)/(otherontime + ontime);
//                    if(tmp > maxMatchRate){
//                        ans = new ArrayList<String>();
//                        ans.add(id);
//                        ans.add(otherId);
//                    }
//                }
//            }
//        }
//
//        for(String t:ans){
//            System.out.println(t);
//        }
//
//    }
//
//}

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] addr = new int[N];
        int preCount=0;
        int currCount =0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<N;++i){
            addr[i] = sc.nextInt();
            set.add(addr[i]);
        }
        for(int i=2;i<set.size();++i){
            int [] cache = new int[i];
            for(int j=0;j<i;++j){

            }
            for(int j=0;j<N;++j){

            }
        }

    }
}