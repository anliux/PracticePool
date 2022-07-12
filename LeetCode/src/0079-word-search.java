//79. 单词搜索
//典型的回溯题，不过可以用dfs深度优先遍历解决
//可参考剑指-12题.矩阵中的路径



//DFS+枝剪：4 ms/97.95%和43.2 MB/57.57%
class Solution {
    public boolean exist(char[][] board, String word) {
        //将目标字符串转为字符数组
        char[] words = word.toCharArray();

        //遍历二维数组：以每个元素作为入口尝试与目标字符串word进行匹配，即调用dfs()函数
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //这里dfs放在if里，而不是直接return，因为要遍历所有，而不是中途判断是否有false
                if(dfs(board, words, i, j, 0))
                    return true;
            }
        }

        //遍历二维数组后没有符合的情况存在，则返回false
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k){
        //5个参数：二维数组，目标字符数组，坐标值i和j，目标字符数组当前索引值

        //判断不符合的情况：四个方向越界 或 i-j对应的元素与k对应的words中的元素不符
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!= words[k])
            return false;
        //判断递归出口：如果已经达到word的最后，且没有被上一步判false，则返回true
        if(k == words.length - 1)
            return true;
        
        //前两步都不符合：开始进入深度遍历，先将此时二维数组的i-j锁定，即赋空值
        board[i][j] = ' ';

        //设置布尔型res变量，对i-j四个方向进行递归dfs()函数的判断，一真即真
        boolean res = dfs(board, words, i+1, j, k+1) ||
                      dfs(board, words, i-1, j, k+1) ||
                      dfs(board, words, i, j+1, k+1) ||
                      dfs(board, words, i, j-1, k+1);


        //回退一格：将二维数组的i-j重新赋值为原值，即word[k]对应的值
        board[i][j] = words[k];


        //返回res的值
        return res;
    }
}
