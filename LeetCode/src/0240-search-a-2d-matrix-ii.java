//0240-搜索二维矩阵 II
//思路：暴力法；线性查找



//暴力法：时间复杂度过高


//线性查找：7ms，击败89%的用户
/*
    - 算法本质： 
      - 每轮 i 或 j 移动后，相当于生成了“消去一行（列）的新矩阵”， 索引(i,j) 指向新矩阵的左下角元素（标志数）
      - 因此可重复使用以上性质消去行（列）。
    - 算法：判空(如果定义了范围，可省略)；定义右上角行列索引值；遍历数组：范围内，大则左移，小则下移，否则返回true；最后返回false。
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //判空
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        
        //定义右上角元素的索引值
        int row = 0;
        int col = matrix[0].length - 1;

        //范围内遍历数组：大则左移，小则下移，否则true
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > target)
                col--;
            else if(matrix[row][col] < target)
                row++;
            else
                return true;
        }

        //如果找不到，返回false
        return false;
    }
}
