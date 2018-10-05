public class FindMedianInTwoSortedArrays {

    // 讲解视频：https://www.youtube.com/watch?v=KB9IcSCDQ9k
    /*

    因为最终构成的合并数组中，一定满足 max(num1[m1-1],num2[m2-1]) <= min(num1[m1],num2[m2])
    （意思是在num1中取出m1个数+num2中取出m2个数组成的最终数组的左半部分，他们的最大值小于等于最终数组右半数组的最小值），
    因此如果出现num1[m1]>num2[m2-1]则不满足这样的情况，因此需要挑战m1的选择，下标要往小了选，对应的sorted数组值就会变小。
    二分搜索的操作方式就是，减少右边界的值。﻿

    應該是說要盡量選到nums1[m1]>nums2[m2-1]，然後nums1[m1]越小越好的。
    不知道理解的對不對﻿
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int k = (n1 + n2 + 1) / 2;
        int l = 0;
        int r = n1;
        while (l < r) {
            int m1 = l + (r - l) / 2; // nums1和nums2结合后的有序数组中，前一半元素中有m1个来自nums1
            int m2 = k - m1; // m2个来自nums2
            if (nums1[m1] < nums2[m2 - 1])
                l = m1 + 1;
            else
                r = m1;
        }
        int m1 = l;
        int m2 = k - l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1)
            return c1;
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
}
