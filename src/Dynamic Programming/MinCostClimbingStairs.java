public class MinCostClimbingStairs {
    /*
    Let dp[i] be the minimum cost to reach the i-th stair.
Base cases:

dp[0]=cost[0]
dp[1]=cost[1]

DP formula:

dp[i]=cost[i]+min(dp[i-1],dp[i-2])
     */


    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }


}
