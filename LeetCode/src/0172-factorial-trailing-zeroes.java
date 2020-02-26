//0172-阶乘后的零
//思路：数学规律



//耗时：1ms，击败99.89%的用户
//算法：定义计数器count并初始化为0；n为正时循环：n/5计算个数并计入count，之后更新n=n/5；返回计数器count。
class Solution {
    public int trailingZeroes(int n) {
        //定义计数器count并初始化
        int count = 0;

        //循环：直到不再符合n>0
        while(n > 0){
            count += n/5;
            n = n/5;
        }

        //返回计数器
        return count;
    }
}
