# medium4
- 本文题号范围：301-400


# 目录
<!-- GFM-TOC -->
* [322. 零钱兑换](#322-零钱兑换)
* []()
* []()
* []()
<!-- GFM-TOC -->



# 322. 零钱兑换
- ## 题目链接：
  - [coin-change](https://leetcode-cn.com/problems/coin-change/)

- ## 题目标签：
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)
  
- ## 题目描述
  - 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
  - 示例 1: 输入: coins = [1, 2, 5], amount = 11, 输出: 3, 解释: 11 = 5 + 5 + 1
  - 示例 2: 输入: coins = [2], amount = 3, 输出: -1
  - 说明: 你可以认为每种硬币的数量是无限的。

- ## 解题思路
  - 思路：动态规划（自顶向下；自底向上）
    - 注：暴力递归会超时
  - 动态规划：
    - 复杂度：时间O(Sn), 空间O(S) -- S为金额，n为面值种类总数；
    - 状态转移方程：`f(n) = f(n-coin_i) + 1` -- f(n)为amount=n时的最少硬币个数；
    - 自底向上较自顶向下对重复计算部分有优化；
    - 边界值：amount=0时返回0，amount<0时返回-1；
    - f(amount)最大为1元硬币组成的，因此如果结果比amount+1还大，就返回amount；
    - 算法：
      - 新建dp数组：长度为`amount+1`，因为要额外存放`dp[0]`；
      - 新建最大值`max=amount+1;`, 并将max的值赋值给dp数组的每个位置: `Arrays.fill(dp, max);`;
      - 初始化`dp[0]=0;`;
      - 循环：外层控制当前金额，内层遍历硬币面值;
        - 内层：当硬币面值`coins[j]`小于等于当前金额i时，取`dp[i]`与`dp[i-coins[j]]+1`的最小值;
      - 返回前对结果进行判断：最大为1元硬币构成的amount.
    - Arrays 数组知识点：
      - fill(int[] a, int val)：将指定的 int 值分配给指定 int 型数组的每个元素。
      
- ## 代码链接：
  - [零钱兑换](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0332-coin-change.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->







# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  
- ## 题目描述
 

- ## 解题思路


- ## 代码链接：
  - []()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  
- ## 题目描述
 

- ## 解题思路


- ## 代码链接：
  - []()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->


### END
