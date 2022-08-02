//29-顺时针打印矩阵
//思路：模拟，设定边界


//模拟路径：0ms/100%; 43.5 MB/20.76%
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //判空
        if(matrix.length == 0)
            return new int[0];

        //初始化边界值 和 结果数组的当前指针
        int left=0, right=matrix[0].length-1, top=0, bottom=matrix.length-1;
        int cur = 0;

        //初始化结果数组
        int[] res = new int[(right+1) * (bottom+1)];

        //死循环：走一条边；更新边界值；判断边界值交错则跳出；
        while(true){//注意行top或bottom，列left或right
            //从左到右: top行, left++列
            for(int i = left; i<=right; i++){
                res[cur] = matrix[top][i];
                cur++;
            }

            //更新边界值(top+1), 判断更新后的边界值是否交叉: 等于不算交叉
            top++;
            if(top>bottom)
                break;

            //从上到下：top++行，right列
            for(int i = top; i<=bottom; i++){
                res[cur] = matrix[i][right];
                cur++;
            }

            //更新边界值(right-1)，并判断更新后的边界值是否交叉
            right--;
            if(right<left)
                break;

            //从右到左: bottom行，right--列
            for(int i = right; i>=left; i--){
                res[cur] = matrix[bottom][i];
                cur++;
            }

            //更新边界值(bottom-1)，并判断更新后的边界值是否交叉
            bottom--;
            if(bottom<top)
                break;

            //从下到上: bottom--行, left列
            for(int i = bottom; i >= top ; i--){
                res[cur] = matrix[i][left];
                cur++;
            }

            //更新边界值(left+1)，并判断更新后的边界值是否交叉
            left++;
            if(left>right)
                break;
        }

        //返回结果数组
        return res;
    }
}



//代码优化版
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //判空
        if(matrix.length == 0)
            return new int[0];

        //初始化边界值 和 结果数组的当前指针
        int left=0, right=matrix[0].length-1, top=0, bottom=matrix.length-1;
        int cur = 0;

        //初始化结果数组
        int[] res = new int[(right+1) * (bottom+1)];

        //死循环：走一条边；更新边界值；判断边界值交错则跳出；
        while(true){//注意行top或bottom，列left或right
            //从左到右: top行, left++列
            for(int i = left; i<=right; i++){
                res[cur++] = matrix[top][i];
            }
            if(++top>bottom)
                break;

            //从上到下：top++行，right列
            for(int i = top; i<=bottom; i++){
                res[cur++] = matrix[i][right];
            }
            if(--right<left)
                break;

            //从右到左: bottom行，right--列
            for(int i = right; i>=left; i--){
                res[cur++] = matrix[bottom][i];
            }
            if(--bottom<top)
                break;

            //从下到上: bottom--行, left列
            for(int i = bottom; i >= top ; i--){
                res[cur++] = matrix[i][left];
            }
            if(++left>right)
                break;
        }

        //返回结果数组
        return res;
    }
}
