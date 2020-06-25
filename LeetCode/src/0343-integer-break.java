//0343 - 整数拆分
//法一：贪心；法二：动态规划



//贪心算法：n>5时，尽可能剪3。若剩余1，则从3中取一段，与剩余的1凑成两个2。
public class Solution {
    public int cutRope(int target) {
        if(target<2)
            return 0;
        if(target==2)
            return 1;
        if(target==3)
            return 2;
        
        int timeOf3 = target/3;
        if(target-timeOf3*3==1)
            timeOf3--;
        int timeOf2 = (target-timeOf3*3)/2;
        return (int)(Math.pow(3,timeOf3))*(int)(Math.pow(2,timeOf2));
    }
}



//动态规划：不用过多分析，将问题无脑分解为更小的问题。
//从小到大，依次计算所有可能解并保存在数组中，直到计算到target为止。
public class Solution {
    public int cutRope(int target) {
        int[] dp = new int[target+1];
        dp[1]=1;//定n>1,m>1，故dp[1]可0可1；为方便循环计算，可设为1
       
        for(int i=2; i<=target; i++){
            for(int j=1; j<i; j++){ //可设置为i/2以优化，但是总有case不通过，故作罢。
                dp[i]=Math.max(dp[i], Math.max(j*(i-j),dp[j]*(i-j)));
				//这里要考虑全面问题。考虑分为两段，和分为更小的问题f(j)与另一段小绳乘积。
            }
        }
        return dp[target];
    }
}
