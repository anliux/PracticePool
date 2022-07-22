//14.1 - 剪绳子
//法一：贪心；法二：动态规划

//贪心算法：0 ms/100.00%, 38.2 MB/56.02%
//算法：n>5时，尽可能剪3。若剩余1，则从3中取一段，与剩余的1凑成两个2。
class Solution {
    public int cuttingRope(int n) {
        //贪心：优先3，余1则凑双2
        
        //初始化：
        //定n>1,m>1，故dp[1]可0可1 (leetcode的测试用例中dp[1]为1)；为方便循环计算，可设为1
        if(n<=0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        else if(n==3)
            return 2;

        //优先3：先求可分到多少个3；如果余1，则抽一个3和1组双2
        int three = n / 3;
        if(n - three*3 == 1)
            three--;
        int two = (n - three*3) / 2;
        
        //求乘积，并返回结果
        return (int) (Math.pow(3,three)) * (int) (Math.pow(2,two));
            //Math.pow(): 返回值类型默认为double型，而题目要求的是int型，强转为int
    }
}



//动态规划：1 ms/46.15%, 38.1 MB/60.40%
//从小到大，依次计算所有可能解并保存在数组中，直到计算到target为止。
class Solution {
    public int cuttingRope(int n) {
        //动态规划: max = max(dp[i], j*(i-j), j*dp[i-j])
        
        int[] dp = new int[n+1];//n+1: 需要取到索引值为n的元素

        //初始化：推演或已知得最初几个值对应的结果(n>1, m>1, n剪为m段)
        dp[1] = 1;
        dp[2] = 1;//2需要至少剪为两端，m>1
        //注意初始化不能定义dp[3]，因为n的取值是从2开始，如果n=2，就越界了，除非加if判断，同时dp[3]也符合下面的计算

        //遍历：求出n之前的所有结果，2结果已知，从3开始
        for(int i = 3; i<=n; i++){
            for(int j = 1; j < i; j++){//从j处剪
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
                //只剪j一刀：j*(i-j); 剪多刀：j*dp[i-j]
                //这两个值比较的同时，还要与dp[n]的初始化值0进行比较，类似求最值里与基准值进行比较一样吧，可能。。。
            }
        }
        return dp[n];
    }
}



//放一个评论区神奇查表法
class Solution {
    public int cuttingRope(int n) {
        int[] res = {0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243, 324, 486, 729, 972, 1458, 2187, 2916, 4374, 6561, 8748, 13122, 19683, 26244, 39366, 59049, 78732, 118098, 177147, 236196, 354294, 531441, 708588, 1062882, 1594323, 2125764, 3188646, 4782969, 6377292, 9565938, 14348907, 19131876, 28697814, 43046721, 57395628, 86093442, 129140163, 172186884, 258280326, 387420489, 516560652, 774840978, 1162261467, 1549681956};
        return res[n];
    }
}
