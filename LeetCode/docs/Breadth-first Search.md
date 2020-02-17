# 广度优先搜索
- 内含题目：72

# 目录
<!-- GFM-TOC -->
* [101. 对称二叉树](#101-对称二叉树)
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)
* [107. 二叉树的层次遍历II](#107-二叉树的层次遍历ii)
* []()
* []()
* []()
* []()
* []()
* []()
<!-- GFM-TOC -->



# 101. 对称二叉树
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个二叉树，检查它是否是镜像对称的。注：数组层序遍历树。
    - 示例1：二叉树 [1,2,2,3,4,4,3] 是对称的。
    - 示例2：二叉树 [1,2,2,null,3,null,3] 则不是镜像对称的:
    - 图略
  - ### 解题思路
  - 思路：递归；迭代
  - 递归
    - 复杂度：时间O(n)，空间O(n)
    - 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
    - 如果同时满足下面的条件，两个树互为镜像：
      - 它们的两个根结点具有相同的值。
      - 每个树的右子树都与另一个树的左子树镜像对称。
    - 定义镜像函数：
      - 判空：全空；一空一不空；
      - 根结点相等时，返回调用本体判断（结点1的左和结点2的右）以及（结点1的右和结点2度左）；
      - 注：借鉴100题的递归优化方法先判全空，后判根结点值相等，最后false这种设置可能用空指针异常，判相等一定记得 && 全不空
  - 迭代
    - 复杂度：时间O(n)，空间O(n)
    - 注：广度和深度应该在本方法体现吧。。但是代码太多了，用递归就好

- ## 代码链接：
  - [对称二叉树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0101-symmetric-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 102. 二叉树的层次遍历
- ## 简述：（[medium](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium.md)）
  - ### 题目描述
    - 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
  - ### 解题思路
    - 广度优先搜索（BFS）
      - 按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
    - 思路：递归；迭代
    - 递归：
      - 复杂度：时间O(n)，空间O(n)
      - 层序遍历考虑广度优先搜索
      - 首先确认树非空，然后调用递归函数 `helper(node, level)`，参数是当前节点和节点的层次。
      - 输出列表称为 levels，当前最高层数就是列表的长度 `len(levels)`。
      - 比较访问节点所在的层次 level 和当前最高层次 `len(levels)` 的大小，如果前者更大就向 levels 添加一个空列表。
      - 将当前节点插入到对应层的列表 `levels[level]` 中。
      - 递归非空的孩子节点：`helper(node.left / node.right, level + 1)`。
      - 注：
        - 递归解法本质上还是dfs，不过add的时候会根据记录的level来判断加到哪个层次
        - 整体步骤：进入helper函数后：判断是否新建level（二维数组），添加结点值，子节点非空时调用helper(必要判断，因为添加右结点时不用新建level)
        - helper函数相当于从根结点开始，层序遍历整棵树，同时记录结点值到数组
  
- ## 代码链接
  - [二叉树的层次遍历](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0102-binary-tree-level-order-traversal.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 107. 二叉树的层次遍历II
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
  - ### 解题思路
    - 参考102题：二叉树的层次遍历([medium.md](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium.md))
    - 层序遍历，考虑广度优先
    - 与102题的区别：
      - 最后需要反转结果:`Collections.reverse(levels);`
    
- ## 代码链接：
  - [二叉树的层次遍历II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0107-binary-tree-level-order-traversal-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




### END
