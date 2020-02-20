//0118-杨辉三角
//思路：动态规划



//耗时：1ms，击败97.73%的用户
/*
 算法：
  - 首先，生成整个 triangle 列表，三角形的每一行都以子列表的形式存储。
  - 然后，检查行数为 0 的特殊情况（直接返回triangle），否则返回 [1] （[1]只有一个元素，赋值为1）。
  - 循环遍历：
    - 外循环：控制行数，本行遍历结束后记得把本行结果添加到triangle
    - 内循环：控制每行的元素
  - 最后返回所得triangle

*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //初始化二维数组
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        //当参数为0时，返回以上空数组triangle
        if(numRows==0) return triangle;

        //初始化第一行第一列基础元素1：先新建，后定位并赋值
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        //遍历：外循环即外层List控制行数，内循环即内层List控制每行需要添加的元素
        for(int i=1; i<numRows; i++){
            //内层List需要先手动新建，后赋值；需要用到本行与上一行
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i-1);

            //第一个元素和最后一个元素总是1，中间的元素是prevRow行的j-1和j的和
            row.add(1);

            for(int j=1; j<i; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            row.add(1);

            //本行遍历结束后，将结果row添加到triangle
            triangle.add(row);
        }

        //最后返回所得triangle
        return triangle;        
    }
}
