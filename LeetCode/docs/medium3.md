# medium3
- 本文题号范围：201-300


# 目录
<!-- GFM-TOC -->
* []()
* [240. 搜索二维矩阵II](#240-搜索二维矩阵ii)
* []()
* []()
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
   - [二维数组中的查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0240-search-a-2d-matrix-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#剑指offer题解目录)
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
