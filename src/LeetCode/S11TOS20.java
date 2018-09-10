public class S11TOS20 {


    // S11 Brute Force
    public int maxArea(int[] height) {
        int x = 0;
        int y = 1;
        int len = height.length;
        if (len < 2) return 0;
        int ans=0;
        for (; x < len - 1; ++x) {
            for (; y<len; ++y) {
                ans = Math.max(ans,(y-x)*Math.min(height[x], height[y]));
            }
        }
        return ans;
    }

    // S11 双指针法与证明：https://leetcode.com/problems/container-with-most-water/discuss/6099/yet-another-way-to-see-what-happens-in-the-on-algorithm/174248
    

}
