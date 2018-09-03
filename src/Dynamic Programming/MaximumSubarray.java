public class MaximumSubarray {

    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);
    }
    public  int maxSubArray(int [] nums){

        if(nums.length==0)
            return 0;

        int [] f = new int[nums.length];

        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;++i){
            if(f[i-1] <0 || i ==0){
                f[i] = nums[i];
            }else {
                f[i] = nums[i] + f[i-1];
            }

            if(f[i] > max) max = f[i];

        }
        return max;
    }



}
