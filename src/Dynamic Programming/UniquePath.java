public class UniquePath {


    //自底向上
    public int uniquePaths(int m, int n) {
        // 函数里面，首先需要做的事情就是 1. 输入异常处理 2. 输入特殊情况处理，直接返回结果
        if(m<=0 ||n<=0)
            return 0;
        // 特殊情况处理！
        if(m==1||n==1)
            return 1;


        int [][] paths = new int[m][n];

        for(int i=0;i<m;i++){
            paths[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            paths[0][i] = 1;
        }

        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                paths[i][j] = paths[i-1][j] + paths[i][j-1];

            }
        }

        return paths[m-1][n-1];
    }

    // 递归实现
    public int uniquePaths2(int m, int n){
        if(m<1 ||n<1)
            return 0;
        if(m==1 || n==1)
            return 1;
        return uniquePaths2(m-1, n) + uniquePaths2(m, n-1);
    }



}
