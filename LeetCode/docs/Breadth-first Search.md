# 广度优先搜索
- 内含题目：72

# 目录
<!-- GFM-TOC -->
* [101. 对称二叉树](#101-对称二叉树)
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)
* [107. 二叉树的层次遍历II](#107-二叉树的层次遍历ii)
* [111. 二叉树的最小深度](#111-二叉树的最小深度)
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
- ## 简述：（[medium2](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium2.md)）
  - ### 题目描述
    - 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
  - ### 解题思路
    - 广度优先搜索（BFS）
      - 按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
    - 思路：递归；迭代；队列+两层遍历。
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
    - 队列+两层遍历：
      - 分析：
        - 按层打印：题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。BFS 通常借助 队列 的先入先出特性来实现。
        - 每层打印到一行：将本层全部节点打印到一行，并将下一层全部节点加入队列，以此类推，即可分为多行打印。
        - 需要用到循环嵌套，但总的循环次数仍是n，因此时间复杂度仍为O(n)。
      - 算法：
        - 复杂度：时间O(n)，空间O(n)
        - 判空：当根节点为空，则返回空列表 [] ；
          - (注：根结点判空需要新建，因此可以转为先初始化，然后对根结点判非空)
        - 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
        - BFS 循环： 当队列 queue 为空时跳出；
          - 新建一个临时列表 tmp ，用于存储当前层打印结果；
          - 当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
            - 出队： 队首元素出队，记为 node；
            - 打印： 将 node.val 添加至 tmp 尾部；
            - 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
          - 将当前层结果 tmp 添加入 res 。
        - 返回值： 返回打印结果列表 res 即可。
        - 注意：内循环次数控制的for循环
          - 使用i--，让size()只在循环开始使用一次，使循环次数不受队列长度变化影响，妙啊！
          - 若i从0开始，使用i++，那么queue的size每一轮都在变，会导致错误。
          
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



# 111. 二叉树的最小深度
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个二叉树，找出其最小深度。
    - 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    - 说明: 叶子节点是指没有子节点的节点。
  - ### 解题思路
    - 思路：dfs（递归，迭代）；bfs
    - 相似题目：104题 - 二叉树的最大深度
    - 易错：最小深度是从根节点到最近叶子节点的最短路径上的节点数。当左右子树都为空，最小深度才为1。[1,2]最小深度是2。
    - dfs递归：
      - 复杂度：时间O(n)，空间O(n)
      - 规律：树的最小深度 = 1 + min(左子树的深度，右子树的深度)
      - 算法：首先判空；其次返回调用本体的左右子树的高，取得min值，并且+1后返回
        - 判空：根结点为null时返回0，根结点的左右子结点全为null时返回1（仅一子树为空时，返回>1，需要再判断）
      - 注意：初始化变量min时，应初始化为一个较大的数，否则会出错。此时，最好设为范围内最值`Integer.MAX_VALUE`
    - 其余两种方法复杂度相同，代码略 

- ## 代码链接
  - [二叉树的最小深度](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0111-minimum-depth-of-binary-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->





### END
