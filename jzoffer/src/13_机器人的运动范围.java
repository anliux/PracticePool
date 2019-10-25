//13 - 机器人的运动范围
//回溯法（dfs）。并增加一个位数和的限制条件。

public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] flag = new int[rows][cols];
		return dfs(0,0,rows,cols,flag,threshold);
    }

	private int dfs(int i,int j,int rows,int cols,int[][] flag,int threshold){
		if(i<0 || j<0 || i>=rows || j>=cols || numSum(i)+numSum(j)>threshold || flag[i][j]==1)
			return 0;
		flag[i][j]=1;
		return dfs(i-1,j,rows,cols,flag,threshold)
			  +dfs(i+1,j,rows,cols,flag,threshold)
			  +dfs(i,j-1,rows,cols,flag,threshold)
			  +dfs(i,j+1,rows,cols,flag,threshold)
			   +1;
	}

	private int numSum(int n){
		int sum = 0;
		do{
			sum = sum + n%10;
		}while((n=n/10)>0);
		return sum;
	}
}