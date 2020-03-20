# medium3
- 本文题号范围：201-300


# 目录
<!-- GFM-TOC -->
* [215. 数组中的第K个最大元素](#215-数组中的第K个最大元素)
* [240. 搜索二维矩阵II](#240-搜索二维矩阵ii)
* []()
* [300. 最长上升子序列](#300-最长上升子序列)
<!-- GFM-TOC -->



# 215. 数组中的第K个最大元素
- ## 题目链接：
  - [kth-largest-element-in-an-array(https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

- ## 题目标签：
  - [堆](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [分治算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  
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
  - 思路：排序；快排；堆。
  - 排序：
    - 复杂度：时间O(nlogn)，空间O(1)
    - 算法：调用Arrays函数排序；获取数组的`(arr.length-k)`个元素并返回。
    - 本方法属于直接用库函数的偷懒方法。
  - 堆：
    - 复杂度：时间O(nlogk)，空间O(1)，k是题目所述k值。
    - 

- ## 代码链接：
  - []()

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
