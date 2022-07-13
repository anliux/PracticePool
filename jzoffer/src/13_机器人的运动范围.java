//13 - 机器人的运动范围
//DFS: 1 ms/62.39%; 38.1 MB/85.36%
//(参考12题的解法)
class Solution {
    public int movingCount(int m, int n, int k) {
        //定义与二维数组大小相同的标记数组：用来标记某一格是否符合k值条件
        boolean[][] visited = new boolean[m][n];

        //从(0,0)坐标开始，调用dfs
        return dfs(0,0,m,n,k,visited);

    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        //参数：当前坐标i和j，边界坐标m和n，k值，标记数组visited
        //判false：四个边越界 或 不符合k值条件 或 已判断过本格不符
        if(i>=m || i<0 || j>=n || j<0 || (i/10 + i%10 + j/10 + j%10)>k || visited[i][j]){
            return 0;//注意返回值是int，一步都没有前进，则返回0
        }

        //如果没有在上一步排除，则标记为可以前进格
        visited[i][j] = true;

        //返回结果：可以只向下或向右两个方向移动的递归
        return 1 + dfs(i+1,j,m,n,k,visited) + dfs(i,j+1,m,n,k,visited)
            +  dfs(i-1,j,m,n,k,visited) + dfs(i,j-1,m,n,k,visited);
	    //需要+1，把当前匹配的格子也计算在内。
    }
}




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
