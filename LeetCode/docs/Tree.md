# 树
- 内含题目：152

# 目录
<!-- GFM-TOC -->
* [100. 相同的树](#100-相同的树)
* [101. 对称二叉树](#101-对称二叉树)
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)
* [104. 二叉树的最大深度](#104-二叉树的最大深度)
* [107. 二叉树的层次遍历II](#107-二叉树的层次遍历ii)
* [108. 将有序数组转换为二叉搜索树](#108-将有序数组转换为二叉搜索树)
* [110. 平衡二叉树](#110-平衡二叉树)
* []()
* []()
<!-- GFM-TOC -->



# 100. 相同的树
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定两个二叉树，编写一个函数来检验它们是否相同。
    - 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    - 图和示例略，具体而言，是按“中-左-右”的顺序对两棵树进行遍历和判断是否相等
  - ### 解题思路
    - 思路：递归；迭代
      - 注：标签里有“深度优先搜索”，大概是迭代里体现了？...
    - 递归：
      - 复杂度：时间O(n)，平衡二叉树是最优为O(logn)，空间O(n)
      - 先判断根节点是否相同，在调用本体分别对左节点和右节点进行判断
      - 首先：判空，即全空true，一空false
      - 根节点的值判断是否相等：不等false，相等返回对左和右的调用本体结果
    - 迭代：
      - 复杂度：时间O(n)，平衡二叉树是最优为O(logn)，空间O(n)
      - 从根开始，每次迭代将当前结点从双向队列中弹出。然后判断：非空且值相等时，压入子结点
      - 注：代码太多了，用递归就好

- ## 代码链接：
  - [相同的树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0100-same-tree.java)
  
<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
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



# 104. 二叉树的最大深度
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个二叉树，找出其最大深度。
    - 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    - 说明: 叶子节点是指没有子节点的节点。
    - 示例：给定二叉树 [3,9,20,null,null,15,7]，则最大深度为3（层序遍历树表示为数组）
  - ### 解题思路
    - 思路：递归；迭代
    - 递归
      - 复杂度：时间O(n)，空间O(n)
      - 规律：树的高度 = 1 + max(左子树的高，右子树的高)
      - 算法：首先判空；其次返回调用本体的左右子树的高，取得max值，并且+1后返回
    - 迭代
      - 复杂度：时间O(n)，空间O(n)
      - 在栈的帮助下将上面的递归转换为迭代。
      - 使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
      - 从包含根结点且相应深度为 1 的栈开始。然后继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。
      - 具体代码略
    
- ## 代码链接：
  - [二叉树的最大深度](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0104-maximum-depth-of-binary-tree.java)



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



# 108. 将有序数组转换为二叉搜索树
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
  - ### 解题思路
    - 遍历树的方法。DFS：先序遍历，中序遍历，后序遍历；BFS。
    - 二叉搜索树的中序遍历是一个升序序列。将有序数组作为输入，可以把该问题看做根据中序遍历序列创建二叉搜索树。
    - 高度平衡意味着每次必须选择中间数字作为根节点。
    - 中序遍历：始终选择中间位置左边元素作为根节点
      - 复杂度：时间O(n)，空间O(n)
      - 中间左：向下取整，整除2即可取小。具体地，被除数为奇数时向下取整，被除数为偶数时可以整除直接返回得数
      - 方法 helper(left, right) 使用数组 nums 中索引从 left 到 right 的元素创建 BST：
        - 如果 left > right，子树中不存在元素，返回空。
        - 找出中间元素：p = (left + right) // 2。
        - 创建根节点：root = TreeNode(nums[p])。
        - 递归创建左子树 root.left = helper(left, p - 1) 和右子树 root.right = helper(p + 1, right)。
      - 返回 helper(0, len(nums) - 1)。
    - 中序遍历：始终选择中间位置右边元素作为根节点
      - 复杂度：时间O(n)，空间O(n)
      - 中间右：在中间左的取平均基础上，加一个判断，如果被除数是奇数，整除会向下取整，因此手动mid++
      - 注意：因为数组索引值从0开始，因此偶数个时，
    - 中序遍历：选择任意一个中间位置元素作为根节点
      - 复杂度：时间O(n)，空间O(n)
      - 左右随机：在中间左的取平均基础上，加一个判断，如果被除数是奇数，整除会向下取整，因此手动mid随机取+0或+1
      - 取随机数代码：
        - `Random rand = new Random();`
        - `if ((left + right) % 2 == 1) mid += rand.nextInt(2);`

- ## 代码链接
  - [将有序数组转换为二叉搜索树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0108-convert-sorted-array-to-binary-search-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 110. 平衡二叉树
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个二叉树，判断它是否是高度平衡的二叉树。
    - 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
  - ### 解题思路
    - 思路：dfs -- 自顶向下，自底向上
    - 平衡二叉树（Balanced Binary Tree）具有以下性质：
      - 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1
      - 并且左右两个子树都是一棵平衡二叉树。
      - 注：子树也是平衡树在题目中没有说，但是具有此性质，判断时需要判断左右子树也平衡才行
    - 自顶向下：
      - 复杂度：时间O(nlogn)，空间O(n)
      - 算法：判空返回真；调用height函数判断子树高度差<2,以及调用本体函数判断左右子树是否平衡
      - height函数：判空返回-1，否则返回1+max(root.left的高度,root.right的高度)
        - 注：-1与高度值区分，最大子树高度+1是指加上子树到根结点这层
      - 注意：
        - 减法：要取绝对值，否则可能是负数 `Math.abs()`
    - 自底向上：
      - 复杂度：时间O(n)，空间O(n)
      - 方法一计算 height 存在大量冗余。每次调用 height 时，要同时计算其子树高度。但是自底向上计算，每个子树的高度只会计算一次。可以递归先计算当前节点的子节点高度，然后再通过子节点高度判断当前节点是否平衡，从而消除冗余。
      - 算法：
        - 使用与方法一中定义的 height 方法。逻辑相反，首先判断子树是否平衡，然后比较子树高度判断父节点是否平衡。
        - 算法如下：检查子树是否平衡。如果平衡，则使用它们的高度判断父节点是否平衡，并计算父节点的高度。
        - 当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
    
- ## 代码链接
  - [平衡二叉树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0110-balanced-binary-tree.java)  
  
<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->







<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->





  
### END
