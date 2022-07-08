//10.3 - 跳台阶
//思路同斐波那契数列
//注意：首项和次项同斐波那契数列的区别；根据题目对求和结果取模，或注意变量超出int范围
//0ms，击败100%
class Solution {
    public int numWays(int n) {
        if(n == 0 || n== 1)
            return 1;
        int a = 1, b = 1, sum = 0;//注意首项赋值
        for(int i = 2; i <= n; i++){
            sum = (a + b) % 1000000007;//对求和结果取模
            a = b;
            b = sum;
        }
        return sum;
    }
}



//其他代码：
public class Solution {
    public int JumpFloor(int target) {
        if(target<=0)
            return 0;
        //此处有稍稍的优化
        if(target==1 || target==2)
            return target;
        int result = 0;//这里必须优化否则报错
        int pre1=1;
        int pre2=2;
        for(int i=3;i<=target;i++)
        {
            result=pre1+pre2;
            pre1=pre2;
            pre2=result;
        }
        return result;
    }
}
