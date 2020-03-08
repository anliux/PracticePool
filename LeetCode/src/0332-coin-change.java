//0332-零钱兑换
//思路：动态规划



//动态规划：26ms，击败18.67%的用户
/*
  - 算法：
      - 新建dp数组：长度为`amount+1`，因为要额外存放`dp[0]`；
      - 新建最大值`max=amount+1;`, 并将max的值赋值给dp数组的每个位置: `Arrays.fill(dp, max);`;
      - 初始化`dp[0]=0;`;
      - 循环：外层控制当前金额，内层遍历硬币面值;
        - 内层：当硬币面值`coins[j]`小于等于当前金额i时，取`dp[i]`与`dp[i-coins[j]]+1`的最小值;
      - 返回前对结果进行判断：最大为1元硬币构成的amount.
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        //新建dp数组
        int [] dp = new int[amount+1];

        //定义dp可能的最大值max，并用max填充dp数组的每个位置，并初始化第一个元素为0
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        //循环：外层控制当前金额，内层遍历硬币面值
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                //判断：当硬币面值coins[j]小于等于当前金额i时
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }

        //返回前对结果进行判断：最大为1元硬币构成的amount
        return (dp[amount]>amount) ? -1 : dp[amount];
    }
}
