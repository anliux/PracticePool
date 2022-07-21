# medium4
- 本文题号范围：301-400


# 目录
<!-- GFM-TOC -->
* [322. 零钱兑换](#322-零钱兑换)
* []()
* [343. 整数拆分](#343-整数拆分)
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



# 343. 整数拆分
- ## 题目链接：
  - [integer-break](https://leetcode-cn.com/problems/integer-break/)

- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)
  
- ## 题目描述
  - 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
  - 示例 1:
    - 输入: 2
    - 输出: 1
    - 解释: 2 = 1 + 1, 1 × 1 = 1。
  - 示例2:
    - 输入: 10
    - 输出: 36
    - 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
  - 说明: 你可以假设 n 不小于 2 且不大于 58。

- ## 解题思路
  - ### 贪心：
    #### 每一步都做一个贪婪的选择，基于这个选择，可以得到最优解。一般需要数学方式证明贪婪选择的正确性。
    - 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
    - 如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
    - 证明：
      - 当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。
      - 因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。
      - 又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所以剪成一段长度为 3 比长度为 2 得到的乘积更大。
    - 注：
      - 贪心：偏数学题算法，数学思路走通以后代码实现即可。
      - 定n>1,m>1，故dp[1]可0可1 (leetcode的测试用例中dp[1]为1)；为方便循环计算，可设为1
      - pow() 方法用于返回第一个参数的第二个参数次方。
        - double pow(double base, double exponent) -- 返回值类型默认为double型，而题目要求的是int型，强转为int
  - ### 动态规划：
    - 分析发现符合dp的问题特征：
      - 求一个问题的最优解； 
      - 整体的问题的最优解是依赖于各个子问题的最优解； 
      - 小问题之间还有相互重叠的更小的子问题； 
      - 从上往下分析问题，从下往上求解问题；
    - 不用过多分析，将问题无脑分解为更小的问题。
      - 从小到大，依次计算所有可能解并保存在数组中，直到计算到target为止。
    - 思路：
      - dp[i] 表示长度为i的绳子剪成m段后的最大乘积。
      - 初始化dp[2] = 1 表示如果一个绳子长度为2必然只能分成两段长度为1的绳子，两者的乘积为1。 
      - 然后尝试对绳子进行分割，如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪，代码中的j就是表示尝试剪的长度。 
      - 剪下一段后，剩余部分可以剪也可以不剪。
        - 如果不剪则得到的长度乘积为 j * (i - j) 。
        - 如果剪得到的长度为j * dp[i - j]
        - 两者取最大值 
      - 不断修改剪的长度j （j范围为[2, i -1]）。
      - 从所有结果中找到最大值即为dp[i]的结果。 
      - 从而有状态转移方程dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))    
    - 注意：
      - i/2的略微优化没成，就暂时先这样吧..
      - dp[i]的值包含的内容（包括两个嵌套的Math.max()）需要缕清楚，别写错写漏了

- ## 代码链接：
  - [整数拆分](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0343-integer-break.java)

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
