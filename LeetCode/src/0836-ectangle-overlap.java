//0836-矩形重叠
//思路：检查位置；检查区域



//检查位置：0ms，击败100%的用户
//算法：直接return：将不重叠情况排除，剩余的就是重叠情况。
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //检查位置：排除不重叠的左右上下，注：rec1在rec2的某侧
        //注: 包含等于
        return !(rec1[2] <= rec2[0]    // 左
              || rec1[0] >= rec2[2]    // 右
              || rec1[1] >= rec2[3]    // 上
              || rec1[3] <= rec2[1] ); // 下
    }
}



//检查区域：0ms，击败100%的用户
//算法：直接return：两个方向都有交集时，返回true
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //检查区域：x轴和y轴都有交集则可构成重叠区域，不包括等于
        //口诀：min>max
        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
               Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }
}
