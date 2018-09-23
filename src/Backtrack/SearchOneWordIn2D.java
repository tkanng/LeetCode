public class SearchOneWordIn2D {
    public boolean exist(char[][] board, String word) {
        // 首先找到多个匹配word第一个字符的其实位置
        if (word.length() == 0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 直接遍历所有节点开始搜索
        boolean flag = false;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                flag = isMatch(board, visited, i, j, 0, word);
                if (flag)
                    return true;
            }
        }
        return false;
        // 然后针对每一个位置，做搜寻
    }


    public boolean isMatch(char[][] board, boolean[][] visited, int x, int y, int wordStart, String word) {
        int xMax = board.length;
        int yMax = board[0].length;
        if (wordStart == word.length())
            return true;
        // 判断是否越界
        if (x < 0 || x >= xMax || y < 0 || y >= yMax || visited[x][y] || word.charAt(wordStart) != board[x][y])
            return false;
        //当前位置字符已经等于word.charAt(start)了,判断四个方向是否能匹配word的下一个字符
        visited[x][y] = true;
        boolean flag =
                isMatch(board, visited, x - 1, y, wordStart + 1, word) ||
                isMatch(board, visited, x + 1, y, wordStart + 1, word) ||
                isMatch(board, visited, x, y - 1, wordStart + 1, word) ||
                isMatch(board, visited, x, y + 1, wordStart + 1, word);

        visited[x][y] = false;
        return flag;
    }
}
