//0054-螺旋矩阵
//思路：模拟，设定边界



//耗时：0ms，击败100%的用户
/*
  - 算法：
    - 复杂度：时间O(mn), 空间O(1) -- m、n为矩阵的行列数。
    - 判空：当数组长度为0时，return new int[0];；
    - 初始化四个边界，以及结果数组的索引值；
    - 初始化结果数组res；
    - 循环：死循环，跳出控制在循环体内。
      - 按照“从左向右、从上向下、从右向左、从下向上” 的顺序遍历，同时更新各个指标的值。
      - 用for循环完成一条边的遍历：注意循环起始位置是某一边界值；
      - 每次遍历完一条边之后，都要进行判断，当边界交错时，break跳出循环。
    - 返回结果数组res。
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //判空
        if(matrix.length == 0)
            return new ArrayList<>();

        //初始化边界值和结果数组索引值
        int l = 0, r = matrix[0].length-1, t = 0, b = matrix.length-1;

        //初始化结果数组
        List<Integer> list = new ArrayList<>();

        //循环：模拟循环并更新参数
        while(true){
            //从左到右
            for(int i = l; i <= r; i++){
                list.add(matrix[t][i]);
            }

            if(++t > b)
                break;

            //从上到下
            for(int i = t; i <= b; i++){
                list.add(matrix[i][r]);
            }

            if(l > --r)
                break;

            //从右到左
            for(int i = r; i >= l; i--){
                list.add(matrix[b][i]);
            }

            if(t > --b)
                break;

            //从下到上
            for(int i = b; i >= t; i--){
                list.add(matrix[i][l]);
            }

            if(++l > r)
                break;
        }

        //返回结果数组
        return list;
    }
}
