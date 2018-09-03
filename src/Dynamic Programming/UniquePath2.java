import java.util.Arrays;

public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1)
                break;
            else paths[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1)
                break;
            else paths[0][j] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 0)
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[4][5];

        System.out.println(Arrays.toString(a[0]));

    }
}
