//63-股票的最大利润
//思路：暴力法；一次遍历; 动态规划



//暴力法：243 ms/6.93%; 43.2 MB/5.32%
//可以AC，但是太慢了
class Solution {
    public int maxProfit(int[] prices) {
        //定义max，并初始化为0（不存在时返回0，即范围内最小值为0）
        int max = 0;

        //遍历：两层循环
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        //返回结果
        return max;
    }
}



//一次遍历：1ms/51.82%; 43 MB/10.97%
//思路：找到最小的谷之后的最大的峰; 注意初始化值和循环开始值
class Solution {
    public int maxProfit(int[] prices) {
        //判空
        if(prices == null || prices.length < 2)
            return 0;

        //初始化两个最值
        int min = prices[0];
        int maxDiff = 0;

        //循环：一次遍历，并得到最终的max
        for(int i = 1; i < prices.length; i++){
            //每次首先更新min
            min = (prices[i-1]<min) ? prices[i-1] : min;

            //加入后一个元素: 对比当前差值与最大差值
            if(prices[i]-min > maxDiff)
                maxDiff = prices[i] - min;
        }

        //返回最值max
        return maxDiff;
    }
}

//当没有判空时：初始化要用到Integer的最值
class Solution {
    public int maxProfit(int[] prices) {
        //定义最值，并初始化为合适的值。
        int min = Integer.MAX_VALUE; //初始化min必须特别小心
        int max = 0; //max作为最终返回值，最小为0，代表不存在

        //遍历：寻找最小的谷之后的最大的峰
        for(int i=0; i<prices.length; i++){
            //先小后大：先看是否符合更新min的标准；否则，再看是否符合更新max的标准
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min > max)
                max = prices[i] - min;
        }

        //返回max
        return max;
    }
}
