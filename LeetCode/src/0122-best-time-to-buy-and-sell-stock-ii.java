//0122-买卖股票的最佳时机II
//思路：暴力法；贪心；



//暴力法：执行通过，提交超时。不知道代码对不对。超时也算另一种错误吧
//注：暴力遍历所有情况并比较得到最大值。遍历的过程有的地方没想明白，不知道对不对。
class Solution {
    public int maxProfit(int[] prices) {
        //涉及调用本体递归，因此定义函数封装
        return calculate(prices, 0);
    }

    private int calculate(int [] prices, int start){//参数：数组和起始位置
        //首先排除数组长度为0和1的无法交易情况
        if(prices.length < 2)
            return 0;
        //定义最终结果的最大值max：初始化为边界0即可
        int max = 0;

        //遍历：从start开始，到数组末尾为止
        while(start < prices.length){
            //定义每次更新开始位置时的最大值变量tmp
            int tmp = 0;

            //从start的下一位开始遍历
            for(int i = start+1; i < prices.length; i++){
                //当存在顺差时，将差值累加到profit，并递归调用本体计算从下一位开始后面的收益
                if(prices[i] > prices[start]){
                    int profit = prices[i] - prices[start] + calculate(prices, i+1);
                    tmp = Math.max(tmp, profit);
                }
            }

            //遍历结束后更新max，start自增1
            max = Math.max(tmp, max);
            start++;
        }

        //返回最终结果
        return max;
    }
}



//贪心：1ms，击败99.68%的用户
/*
   - 算法流程：
      - 遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
      - 设 tmp 为第 i-1 日买入与第 i 日卖出赚取的利润，即 tmp = prices[i] - prices[i - 1]；
      - 当该天利润为正 tmp > 0，则将利润加入总利润 profit；当利润为 0 或为负，则直接跳过；
      - 遍历完成后，返回总利润 profit。
*/
class Solution {
    public int maxProfit(int[] prices) {
        //定义变量max存储最终结果
        int max = 0;

        //遍历：从第二个位置开始，比较，并将差值为正的tmp累加到max
        for(int i=1;i<prices.length; i++){
            if(prices[i] - prices[i-1] > 0)
                max += prices[i] - prices[i-1];
        }

        //返回最终结果
        return max;
    }
}
