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


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []  scores = new int[n];
        int [] doors = new int[n];
        for(int i=0;i<n;i++){
            scores[i] = sc.nextInt();
            doors[i] = sc.nextInt()-1;
        }
        if(n==0) {
            System.out.println(0);
            return;
        }
        int max =scores[0];
        int maxIdx =0;
        for(int i=0;i<n;++i){
            if(scores[i] >max){
                max = scores[i];
                maxIdx = i;
            }
        }
        int idx = maxIdx;
        int ret = max;
        while(scores[doors[idx]] >=0){
            ret += scores[doors[idx]];
            idx = doors[doors[idx]];
        }
        System.out.println(ret);


    }
}

