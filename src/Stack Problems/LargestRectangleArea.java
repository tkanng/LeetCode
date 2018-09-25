import java.util.Stack;

/*
那么，是否可以对每个高度的分别计算面积呢？简单的说就是以每个柱子的高度作为最后矩形的高度，计算形成的最大矩形的面积

隐含的方法就是对于每个柱子，它的高度记为H，需要

向左找第一个高度小于H的柱子位置，下标记为l
向右找第一个高度小于H的柱子位置，下标记为r
那么，以H作为高的矩形的宽为(r - l - 1)，面积为(r - l - 1) * H

只需要把所有这样的面积求出来取最大值即可
 */

// https://www.jianshu.com/p/b871972747c0
// http://www.cnblogs.com/grandyang/p/8887985.html   总结链接

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        // 递增的单调栈
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int cur = stack.pop(); // 向右找第一个高度小于H的柱子位置
                int left = stack.isEmpty() ? -1 : stack.peek(); // 向左找第一个高度小于H的柱子位置
                res = Math.max(res, (i - left - 1) * heights[cur]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, (heights.length - left - 1) * heights[cur]);
        }
        return res;
    }

    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area is " + largestRectangleArea(hist));
    }

    //分治法解决直方图中最大矩形问题
    public int largestRectangleArea2(int[] A) {
        // write code here
        return countCore(A, 0, A.length - 1);
    }
    private int countCore(int[] A, int left, int right) {
        if (left > right)
            return 0;
        if (left == right)
            return A[left];
        int highIndex = findMin(A, left, right);
        int max = (right - left + 1) * A[highIndex];
        max = Math.max(max, countCore(A, left, highIndex - 1));
        max = Math.max(max, countCore(A, highIndex + 1, right));
        return max;
    }
    private int findMin(int[] A, int left, int right) {
        int min = left;
        for (int i = left + 1; i <= right; i++)
            if (A[i] < A[min])
                min = i;
        return min;
    }

}
