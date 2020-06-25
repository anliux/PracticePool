//49 - 丑数
//思路：三指针 -- 设置数组保存找到的丑数，以空间换时间



public class Solution {
    public int GetUglyNumber_Solution(int index) {
        //这里默认了index是正整数
        //结合丑数规律，考虑了前6项可以直接返回，稍微简化运算。
        if(index<=6)
            return index;
        
        //定义数组，第一个元素是1
        int [] dp = new int[index];
        dp[0]=1;
        
        //设置索引flag：均从第一个丑数1开始，例如dp[i2]，指向乘以对应因子的最近基数
        int i2=0,i3=0,i5=0;
        
        //遍历:这里i是第几个丑数
        for(int i=1;i<index;i++){
            //更新nextFlag的值，并取其中的最小值
            int next2=dp[i2]*2, next3=dp[i3]*3, next5=dp[i5]*5;
            dp[i]=Math.min(next2,Math.min(next3,next5));
            
            //取到符合的最近邻丑数以后，更新对应的索引flag
            //注：这里不能用if-else-if，只能if-if，否则报错。不知道为什么。
            if(dp[i]==next2){
                i2++;
            }
            if(dp[i]==next3){
                i3++;
            }
            if(dp[i]==next5){
                i5++;
            }
            
        }
        return dp[index-1];
    }
}
