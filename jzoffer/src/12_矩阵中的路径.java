//12 - 矩阵中的路径
//回溯法的典型题



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



//回溯法：官方思路
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //标志位，初始化为false。注：给定matrix是一维，但实际表示的是二维。
        boolean[] flag = new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                 //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                 if(judge(matrix,i,j,rows,cols,flag,str,0)){
                     return true;
                 }
            }
        }
		//别忘了这句。
        return false;
    }
     
    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，标志数组，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;

        //递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，都直接false，说明这条路不通
        if(i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true)
            return false;

        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可（回溯过程中，k不再是0）
		//k即当前所验证的str位置，上个if没return说明是符合的。
        if(k == str.length-1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;
         
        //回溯，递归寻找，向不同方向找，每次找到了就给k加一，找不到，还原
		//if判定条件中的judge又各自深入，直到k==str.length-1，则开始往上返回。
        if(judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
           judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
           judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
           judge(matrix,i,j+1,rows,cols,flag,str,k+1)  )
        {
            return true;
        }

        //走到这，说明这一条路不通，还原标志位的已走过印记，return终止，再试其他的路径
        flag[index] = false;
        return false;
    } 
 
}
