//47. 礼物的最大价值



//dp: 2 ms/97.71%; 43.8 MB/70.48%
class Solution {
    public int maxValue(int[][] grid) {
        //dp: dp[i,j] = max(dp[i-1,j]+grid[i,j], dp[i,j-1]+grid[i,j])
        //初始化，并赋值dp数组的第一个元素
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        //dp数组的第一行赋值：
        for(int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j]; 
        }

        //dp数组的第一列赋值：
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //内外循环遍历：
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        //返回结果
        return dp[row-1][col-1];
    }
}



//dp-加一行一列改进：2 ms/97.71%; 44.1 MB/28.50%
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
                //注意dp[i][j]对应的是grid[i-1][j-1]
            }
        }
        return dp[row][col];
    }
}
