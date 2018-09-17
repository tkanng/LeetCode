import java.util.Arrays;
import java.util.Stack;

public class Sort {

    public static void main(String[] args) {
        int [] arr = {9,1,2};
//        quickSort1(arr, 0, arr.length-1);
        quickSort2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));


    }

    public  static void quickSort1(int[] nums, int lo, int hi){
        if(lo<hi){
            int pos = divide(nums, lo, hi);
            quickSort1(nums, lo ,pos-1);
            quickSort1(nums,pos+1, hi);
        }
    }

    public static int divide(int [] nums,int lo, int hi){
        int val = nums[lo];
        while (lo<hi){
            while (lo<hi && nums[hi]>=val){
                hi--;
            }
            if(lo<hi) nums[lo] = nums[hi];

            while (lo<hi && nums[lo]<=val){
                lo++;
            }
            if(lo<hi) nums[hi] = nums[lo];
        }
        nums[lo] = val;
        return lo;
    }

    static class  Range{

        int lo =0;
        int hi= 0;
        Range(int lo, int hi){
            this.lo= lo;
            this.hi= hi;
        }
    }


    public static void quickSort2(int[] nums, int lo, int hi){
        Stack<Range> stack = new Stack<>();
        if (lo<hi){
            stack.push(new Range(lo, hi));
        }
        while (!stack.isEmpty()){
            Range r = stack.pop();
            int tmp = divide(nums, r.lo, r.hi );
            if(tmp-1>lo){
                stack.push(new Range(r.lo, tmp-1));
            }
            if(tmp+1<hi){
                stack.push(new Range(tmp+1, r.hi));
            }
        }
    }
}


