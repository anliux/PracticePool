# easy3
- 本文题号范围：401-600


# 目录
<!-- GFM-TOC -->
* [509. 斐波那契数](#509-斐波那契数)
* [543. 二叉树的直径](#543-二叉树的直径)
* []()
* []()
<!-- GFM-TOC -->



# 509. 斐波那契数
- ## 题目链接：
  - [fibonacci-number](https://leetcode-cn.com/problems/fibonacci-number/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  
- ## 题目描述
  - 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
  - F(0) = 0,   F(1) = 1,   F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
  - 给定 N，计算 F(N)。
  - 示例 1：输入：2, 输出：1, 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
  - 示例 2：输入：3, 输出：2, 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
  - 示例 3：输入：4, 输出：3, 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
  - 提示: 0 ≤ N ≤ 30

- ## 解题思路
  - 思路：递归
  - 本题类似 <70题-爬楼梯>
  - 注意点：爬楼梯与斐波那契数的前几项不同，注意边界值判断
    - 爬楼梯：1，1，2，... f(0)=1, f(1)=1, f(2)= 2,..
    - 斐波那契数列：0，1，1，2，... f(0)=0, f(1)=1, f(2)=1, f(3)=2,...

- ## 代码链接：
  - [斐波那契数](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0509-fibonacci-number.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 543. 二叉树的直径
- ## 题目链接：
  - [diameter-of-binary-tree](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  
- ## 题目描述
  - 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
  - 示例: 给定二叉树 [1,2,3,4,5,null,null]
    - 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
  - 注意：两结点之间的路径长度是以它们之间边的数目表示。

- ## 解题思路
  - 思路：dfs 递归
  - 深度优先遍历+递归：
    - 复杂度：时间O(结点数)，空间O(树高)
    - 分析：
      - 二叉树的直径不一定过根节点，因此需要去搜一遍所有子树(例如以root，root.left, root.right...为根节点的树)对应的直径，取最大值。
      - root的直径 = root左子树高度 + root右子树高度
      - root的高度 = max {root左子树高度, root右子树高度} + 1
    - 算法：因为要迭代，所以定义额外的函数
      - 定义全局遍历max
      - 定义私有函数来进行迭代：
        - 判断：树结点为空时，返回0，终止迭代；否则进行下述步骤；
        - 本结点的左右结点分别调用本体迭代，并存储在遍历left和right中；
        - 更新最大值max为max和（left+right）的最大值；
        - 更新树的最大深度为`Math.max(right, left)+1`
      - 原函数：
        - 直接将结点传入私有函数，并返回全局遍历max

- ## 代码链接：
  - [二叉树的直径](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0543-diameter-of-binary-tree.java)

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
