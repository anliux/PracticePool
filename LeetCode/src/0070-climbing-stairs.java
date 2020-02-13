//0070-爬楼梯
//思路：暴力法；动态规划；斐波那契
//`f(n) = f(n-1) + f(n-2)`



//暴力法：超时
//调用本体，中间函数f(i)计算多次，冗余
class Solution {
    public int climbStairs(int n) {
        //fn = fn-1 + fn-2;
        if(n==1 || n==2)
            return n;
        else 
            return climbStairs(n-1) + climbStairs(n-2);
    }
}



//动态规划：0ms，击败100%的用户
//改进：使用数组dp[]存储中间函数的值，改进了时间复杂度
class Solution {
    public int climbStairs(int n) {
        //这一步不能省略，否则当n=1时，dp[2]会数组越界异常
        if(n==1 || n==2)
            return n;
        
        //定义数字dp[]，注意dp[0]不赋值，因此数组长度定义为n+1
        int [] dp = new int[n+1];

        //按照公式，需要第一项和第二项已知，方能计算后面的值
        dp[1] = 1;
        dp[2] = 2;
        
        //循环从3开始，到n为止
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}



//斐波那契数法：0ms，击败100%的用户
//改进：将数组改为不断更新几个变量的值，改进了空间复杂度
class Solution {
    public int climbStairs(int n) {
        //首先判断n为1和2的情况
        if(n==1 || n==2)
            return n;
        
        //对第一个数和第二个数初始化
        int a = 1, b = 2;

        //循环：从i=3开始，直到n为止
        for(int i=3; i<=n; i++){
            //更新a b c三个变量的值
            int c = a + b;
            a = b;
            b = c;
        }

        //最终b==c，但是c是定义在循环体中的，循环结束就释放了，因此返回b，特别注意
        return b;
    }
}
