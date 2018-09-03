import java.util.Arrays;

public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minSums = new int[m][n];
        // 初始化，边界值
        minSums[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            minSums[i][0] = minSums[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            minSums[0][j] = minSums[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                minSums[i][j] = grid[i][j] + ((minSums[i][j - 1] < minSums[i - 1][j]) ? minSums[i][j - 1] : minSums[i - 1][j]);
            }
        }
        return minSums[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(grid);
    }

}
