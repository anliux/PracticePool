# medium2
- 本文题号范围：101-200


# 目录
<!-- GFM-TOC -->
* []()
* []()
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)
* []()
* [153. 寻找旋转排序数组中的最小值](#153-寻找旋转排序数组中的最小值)
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

- ## 代码链接:
  - [二叉树的层次遍历](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0102-binary-tree-level-order-traversal.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 153. 寻找旋转排序数组中的最小值
- ## 题目链接：
  - [find-minimum-in-rotated-sorted-array](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  
- ## 题目描述
  - 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    - 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2])。
  - 请找出其中最小的元素。
  - 你可以假设数组中不存在重复元素。
  - 示例 1: 输入: [3,4,5,1,2], 输出: 1
  - 示例 2: 输入: [4,5,6,7,0,1,2], 输出: 0

- ## 解题思路
  - 思路：暴力法；排序；二分。
  - 注：
    - 本题与<154. 寻找旋转排序数组中的最小值 II>的区别：本题规定不存在重复元素，154题可能存在重复元素。
    - 本题java解法貌似不需要判空，毕竟如果空，也不知道返回什么来表示。抛出异常？
  - ### 暴力法：
    - 复杂度：时间O(n)，空间O(1)
    - 算法：定义最小值；遍历数组并更新最小值；返回最小值。
  - ### 排序：
    - 复杂度：时间O(nlogn)，空间O(1)
    - 算法：Arrays.sort()排序；返回索引为0的元素。
    - 注：这种方法代码两行，但是时间复杂度高于暴力法。
  - ### 二分：
    - 复杂度：时间O(logn)，空间O(1)
    - 利用好“升序数组”这一特性，使用类似二分查找的方法，用双指针遍历数组
      - 注：因为不存在重复元素，因此不要考虑某两个元素相等的情况。
    - 算法：
      - 定义双指针；
      - 左右指针不相等时遍历数组：取mid，比较mid对应元素与right对应元素，mid大则left=mid+1，mid小则right=mid；
      - 返回left对应元素(right也行，因为最后两个指针相等了)。
    
- ## 代码链接：
  - [寻找旋转排序数组中的最小值](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0153-find-minimum-in-rotated-sorted-array.java)

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
