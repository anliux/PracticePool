//0122-买卖股票的最佳时机II
//思路：贪心



//暴力法：执行通过，提交超时。
//注：暴力遍历所有情况并比较得到最大值。不推荐。



//贪心：0ms/100%; 43.2MB/14.59%
//贪心算法的贪心关键：“等价于每天都买卖”
//  策略是：所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱)
class Solution {
    public int maxProfit(int[] prices) {
        //定义变量max存储最终结果
        int max = 0;

        //遍历：从第二个位置开始比较，当差值为正时累加到结果变量max
        for(int i=1;i<prices.length; i++){
            if(prices[i] - prices[i-1] > 0)//如果>0，则累加到max中
                max += prices[i] - prices[i-1];
            //否则无操作(无操作则不需要写什么)
        }

        //返回最终结果
        return max;
    }
}
