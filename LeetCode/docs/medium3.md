# medium3
- 本文题号范围：201-300


# 目录
<!-- GFM-TOC -->
* [215. 数组中的第K个最大元素](#215-数组中的第K个最大元素)
* [240. 搜索二维矩阵II](#240-搜索二维矩阵ii)
* [264. 丑数II](#264-丑数ii)
* [300. 最长上升子序列](#300-最长上升子序列)
<!-- GFM-TOC -->



# 215. 数组中的第K个最大元素
- ## 题目链接：
  - [kth-largest-element-in-an-array](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

- ## 题目标签：《未整理》
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [分治算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/....md)
  
- ## 题目描述
  - 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
  - 示例 1:
    - 输入: [3,2,1,5,6,4] 和 k = 2
    - 输出: 5
  - 示例 2:
    - 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    - 输出: 4
  - 说明: 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

- ## 解题思路
  - 参考：剑指40. 最小的k个数
    - 区别：本题只需要取到第k个数，而不是最大的k个数 
  - 思路：
    - 库函数排序；基于快速排序的数组划分。
  - 分析：
    - 排序：最基本的思路，先排序后取第k大的数字。复杂度O(nlogn).
    - 快速排序的数组划分：二分思想 + 快排基准数两侧不一定是排好序的
  - 库函数排序：
    - 对原数组从小到大排序后取出第k大的元素
    - 排序函数：`Arrays.sort(数组名);`
    - 取第k大元素的数组：
      - 倒着取：举例法，如果k=1，取末尾第一个，即lens-1; k=2,倒数第二个，lens-2.
      - 因此是取lens-k对应的元素
  - 快速排序
    - 快排的两个核心思想：哨兵划分和递归
    - 哨兵划分操作： 
      - 以数组某个元素（一般选取首元素）为 基准数 ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边
    - 递归：
      - 对 左子数组 和 右子数组 递归执行 哨兵划分，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序
    - 步骤：
      - 递归出口：子数组长度为 1 时终止递归;
      - 初始化哨兵指针为left和right；
      - 循环：当哨兵指针相遇时终止
        - 循环：从右向左找第一个小于基准数的元素；
        - 循环：从左向右找第一个大于基准数的元素；
        - 交换两个哨兵元素；
      - 交换基准元素和哨兵i (哨兵i j相遇，用哪个都行)
        - 此时：基准元素两侧分别是`左小|基准|右大`的分布
      - 两侧分别递归排序。 
  - 基于快速排序的数组划分
    - 分析：
      - 题目只要求返回最小的 k 个数，对这 k 个数的顺序并没有要求。因此，只需要将数组划分为 最小的 k 个数 和 其他数字 两部分即可，而快速排序的哨兵划分可完成此目标。
      - 根据快速排序原理，如果某次哨兵划分后 基准数正好是第 k+1 小的数字 ，那么此时基准数左边的所有数字便是题目所求的 最小的 k 个数 。
      - 根据此思路，考虑在每次哨兵划分后，判断基准数在数组中的索引是否等于 k ，若 true 则直接返回此时数组的前 k 个数字即可。
    - 算法流程：
      - getLeastNumbers() 函数：
        - 若 k 大于数组长度，则直接返回整个数组；
        - 执行并返回 quick_sort() 即可；
      - quick_sort() 函数：
        - 注意，此时 quick_sort() 的功能不是排序整个数组，而是搜索并返回最小的 k 个数。
        - 哨兵划分：
          - 划分完毕后，基准数为 arr[i] ，左 / 右子数组区间分别为 [l, i - 1] , [i + 1, r] ；
        - 递归或返回：
          - 若 k < i，代表第 k + 1 小的数字在 左子数组 中，则递归左子数组；
          - 若 k > i，代表第 k + 1 小的数字在 右子数组 中，则递归右子数组；
          - 若 k = i，代表此时 arr[k] 即为第 k + 1 小的数字，则直接返回数组前 k 个数字即可；
    - 复杂度分析：
      - O(n), O(logn) 
      - 本方法优化时间复杂度的本质是通过判断舍去了不必要的递归（哨兵划分）。
  - 相关知识点：
    - `Arrays.copyOfRange(arrName, start, end)`: 返回左闭右开索引值范围内的数组片段。

- ## 代码链接：
  - [数组中的第K个最大元素](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0215-kth-largest-element-in-an-array.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 240. 搜索二维矩阵II
- ## 题目链接：
  - [search-a-2d-matrix-ii](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

- ## 题目标签：
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  - [分治算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Divide%20and%20Conquer.md)
  
- ## 题目描述
  - 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
  - 每行的元素从左到右升序排列。每列的元素从上到下升序排列。
  - 示例: 现有矩阵 matrix 如下：给定 target = 5，返回 true; 给定 target = 20，返回 false。

    ```html
    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
    ```

- ## 解题思路
  - 思路：暴力法；线性查找。
  - 暴力法：忽略存在的顺序，直接暴力查找；时间复杂度高。
    - 复杂度：时间O(mn)，空间O(1)  -- m 为行数，n 为 列数。
  - 线性查找：
    - 复杂度：时间O(m+n)，空间O(1)  -- m 为行数，n 为 列数。
    - 关键：站在右上角看。这个矩阵其实就像是一个Binary Search Tree。
    - 分析：
      - 分析复杂问题：从一个具体的例子入手
      - 可以发现：该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
      - 考虑从右上角或者左下角开始，可以避免可能选取区域重叠。
      - 右上角：左侧为小于，下侧为大于。若小，下移；若大，左移。
      - 测试用例考虑：有目标；没有目标（大于max，小于min，介于但不存在）；空指针；行列数非正
      - 空指针即地址为null，行列数非正，这两个需要排除。而没有目标中各种情况都属于找不到，返回false即可，无需特意判断。
    - 算法本质： 
      - 每轮 i 或 j 移动后，相当于生成了“消去一行（列）的新矩阵”， 索引(i,j) 指向新矩阵的左下角元素（标志数）
      - 因此可重复使用以上性质消去行（列）。
    - 算法：判空(如果定义了范围，可省略)；定义右上角行列索引值；遍历数组：范围内，大则左移，小则下移，否则返回true；最后返回false。
  
 - ## 代码链接：
   - [搜索二维矩阵II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0240-search-a-2d-matrix-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 264. 丑数II
- ## 题目链接：
  - [ugly-number-ii](https://leetcode-cn.com/problems/ugly-number-ii/)

- ## 题目标签：
  - [堆](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Heap.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)
  
- ## 题目描述
  - 编写一个程序，找出第 n 个丑数。
  - 丑数就是质因数只包含 2, 3, 5 的正整数。
  - 示例:
    - 输入: n = 10
    - 输出: 12
    - 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
  - 说明:   
    - 1 是丑数。
    - n不超过1690。

- ## 解题思路
  - 求丑数的思路：
    - 验证一个数是否是丑数：先看是否能整除2，即取模得0，若可以则整除2直至余数不为0；然后重复3和5
  - 常规思路：
    - 从1开始，依次验证各个数是否符合
    - 问题：对每个数字进行了运算，时间复杂度高
  - 改进思路：
    - 以空间换时间，创建数组保存已经找到的丑数，并在此基础上乘以因子继续找
    - 现在的思路是在丑数的基础上找新的丑数，避免了遍历每个自然数的操作
    - 具体思路：找下一个丑数，设置flag2,3,5，可从已有丑数基础上乘以因子2,3,5，取最小值，同时改变flag值
  - 注意：
    - Math.min()针对两个数，因此写为：`Math.min(next2, Math.min(next3, next5))`
  - 面试思路：三指针法
    - 分析：思路大致同改进思路。
      - 基数是2，3，5，设置三个指针参数，分别作为三个基数的倍数，求乘积后取三者最小值作为下一个丑数。
      - 求得最小值对应的指针，并更新。
    - 算法：
      - 初始化数组dp[]，三个指针i2，i3，i5;
      - for循环：计算指定前n个丑数
        - 定义并求三个乘积结果：乘积 = 前一个dp[i] * 某个指针；
        - 用两个min找出三者中的最小值，作为下一个丑数存入dp[i]中；
        - 比较并找出dp[i]对应的指针，并+1；
      - 返回结果dp[n-1]。
    - 注：if判断最小指针时，不能用if-else-if的格式，会报错；只能用if-if-if的格式
      - 不知道为什么。

- ## 代码链接：
  - [丑数II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0264-ugly-number-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 300. 最长上升子序列
- ## 题目链接：
  - [longest-increasing-subsequence](https://leetcode-cn.com/problems/longest-increasing-subsequence/)

- ## 题目标签：
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)
  
- ## 题目描述
  - 给定一个无序的整数数组，找到其中最长上升子序列的长度。
  - 示例: 输入: [10,9,2,5,3,7,101,18]，输出: 4 
    - 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
  - 说明: 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
  - 你算法的时间复杂度应该为 O(n^2)。进阶: 你能将算法的时间复杂度降低到 O(nlogn) 吗?

- ## 解题思路
  - 思路：动态规划；二分+动态规划。
  - 动态规划：
    - 复杂度：时间O(n^2), 空间O(n)
    - 状态定义：dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
    - 转移方程： 设 `j∈[0,i)`，考虑每轮计算新 dp[i] 时，遍历 `[0,i)` 列表区间，做以下判断：
      - 1. 当 nums[i]>nums[j] 时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j]+1 ；
      - 2. 当 nums[i]<=nums[j] 时： nums[i] 无法接在 nums[j] 之后，此情况上升子序列不成立，跳过。
      - 上述所有 1. 情况 下计算出的 dp[j]+1 的最大值，为直到 i 的最长上升子序列长度（即 dp[i] ）。实现方式为遍历 j 时，每轮执行 dp[i]=max(dp[i],dp[j]+1)。
      - 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
    - 初始状态：dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
    - 返回值：返回 dp 列表最大值，即可得到全局最长上升子序列长度。

  - 二分+动态规划
    - 复杂度：时间O(nlogn), 空间O(n)

- ## 代码链接：
  - [最长上升子序列]()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



### END
