# medium题目

<!-- GFM-TOC -->
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)

<!-- GFM-TOC -->



# 102. 二叉树的层次遍历
- ## 题目链接：
  - [binary-tree-level-order-traversal](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [广度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Breadth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
  - 例如: 
    - 给定二叉树: [3,9,20,null,null,15,7],
    - 返回其层次遍历结果：[ [3], [9,20], [15,7] ]

- ## 解题思路
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
    - 二维数组与树相关知识点
      - 新建二维数组：`List<List<Integer>> levels = new ArrayList<List<Integer>>();`
      - 二维数组长度：`数组名.size()`
      - 二维数组添加元素：`数组名.add()`
      - 二维数组中新建一位数组：`levels.add(new ArrayList<Integer>());`
      - List的get()：get(int index)，返回列表中指定位置的元素

- ## 代码链接
  - [二叉树的层次遍历](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0102-binary-tree-level-order-traversal.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#medium题目)
<!-- GFM-TOC -->






### END
