# easy2
- 本文题号范围：201-400


# 目录
<!-- GFM-TOC -->
* [202. 快乐数](#202-快乐数)
* [206. 反转链表](#206-反转链表)
* []()
* [226. 翻转二叉树](#226-翻转二叉树)
* []()
* [263. 丑数](#263-丑数)
<!-- GFM-TOC -->



# 202. 快乐数
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



# 206. 反转链表
- ## 题目链接：
  - [reverse-linked-list](https://leetcode-cn.com/problems/reverse-linked-list/)

- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  
- ## 题目描述
  - 反转一个单链表。
  - 示例: 输入: 1->2->3->4->5->NULL，输出: 5->4->3->2->1->NULL
  - 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

- ## 解题思路
  - 思路：迭代；递归
    - 注：配合图示理解效果更佳。
    - 注意：链表要特别注意结点存储的顺序，防止把链子断了。
  - 迭代：
    - 复杂度：时间O(n)，空间O(1)
    - 分析：用双指针，实现每两个链表结点之间反转，以达到整体反转链表的目的。
      - 其实用到三个指针，因为在两个结点反转的时候，需要把cur存起来，防止丢失next信息使得链表断开。
    - 算法：
      - 定义双指针：当前指针cur指向当前结点，前指针pre指向当前结点的前一个结点；
      - 循环：当cur不指向null时遍历链表
        - 定义临时结点tmp，将cur的next结点信息存在tmp中；
        - 将cur的下个结点指向pre，完成反转；
        - 将pre和cur往后移动一个结点：pre赋值为cur，cur赋值为tmp（此时，pre与cur直接断开了，但是下个循环就会连起来）；
        - 注：循环到最后，cur会赋值为尾结点指向的null，这时pre是最后一个不为空的结点，并且和cur不连接，可以作为返回值。
      - 返回结果pre。
    - 注：本方法自带判空，也可以处理单个结点的链表。
  - 递归：
    - 复杂度：时间O(n)，空间O(n)
    - 递归核心思想：
      - 遍历链表，当越过尾节点后终止递归并返回新的头结点pre，并在回溯时修改各节点的 next 引用指向。
    - 算法：
      - recur(cur, pre) 递归函数：
        - 终止条件：当 cur 为空，则返回尾节点 pre （即反转链表的头节点）；
        - 递归后继节点，记录返回值（即反转链表的头节点）为 res ；
        - 修改当前节点 cur 引用指向前驱节点 pre ；
        - 返回反转链表的头节点 res ；
      - reverseList(head) 函数：
        - 调用并返回 recur(head, null) 。
        - 传入 null 是因为反转链表后， head 节点指向 null ；
    
- ## 代码链接：
  - [反转链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0206-reverse-linked-list.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 226. 翻转二叉树
- ## 题目链接：
  - [invert-binary-tree](https://leetcode-cn.com/problems/invert-binary-tree/)

- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  
- ## 题目描述
  - 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
  - 示例 1：
    - 输入：root = [4,2,7,1,3,6,9]
    - 输出：[4,7,2,9,6,3,1]
  - 限制：0 <= 节点个数 <= 1000

- ## 解题思路
  - 思路：递归；循环
  - 递归：
    - 复杂度：时间O(n), 空间O(n)
    - 分析：先序遍历，并交换每个节点的左右子树，交换时递归；当root为null时，结束遍历并返回
    - 算法：
      - 判空：root为null时，返回null；
      - 交换root的左右子树，并递归；
        - 注1：交换和递归可以分开，也可以合起来；
        - 注2：root为叶子节点时，也符合，递归时，root为空，停止递归并返回；
      - 返回结果root。
  - 循环实现：
    - 复杂度：时间O(n), 空间O(n)
    - 分析：利用栈（或队列）遍历树的所有节点 node ，并交换每个 node 的左 / 右子节点。
    - 算法：
      - 判空：root为空时，返回null
      - 初始化栈，并将root根节点添加到栈；
      - 循环：当栈不为空时，循环
        - 弹出栈顶结点，并赋值给node变量，
        - 添加子节点：将弹出结点的左右子树入栈 -- 注意判空：当子树不为空时入栈；
        - 交换node结点的左右子树 -- 注：此处不必判空，叶子节点的两个子树null和null交换也没问题，不必特意加判空，增加代码复杂性；
      - 返回结果root
      - 注：栈相当于保存结点的名字，并设置一定的修改顺序，交换子节点的效果是直接反映在原二叉树里的。
  - 栈的知识点：
    - 初始化并添加元素：`Stack<TreeNode> stack = new Stack<>() {{ add(root); }};`，不过最好分开写。
    - 压栈弹栈：push，pop；add也可以添加元素。
    
- ## 代码链接
  - [翻转二叉树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0226-invert-binary-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 263. 丑数
- ## 题目链接：
  - [ugly-number](https://leetcode-cn.com/problems/ugly-number/)

- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 编写一个程序判断给定的数是否为丑数。
  - 丑数就是只包含质因数 2, 3, 5 的正整数。
  - 示例 1:
    - 输入: 6
    - 输出: true
    - 解释: 6 = 2 × 3
  - 示例 2:
    - 输入: 8
    - 输出: true
    - 解释: 8 = 2 × 2 × 2
  - 示例 3:
    - 输入: 14
    - 输出: false 
    - 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
  - 说明：
    - 1 是丑数。
    - 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。

- ## 解题思路
  - 思路：数学法
    - 对能被2,3,5整除的数不断除2,3,5，最后剩1就是，剩0就不是，除2可以用位运算替换
    - 第一步先判空，最小的丑数是1，小于1则不符合。
  - 算法：
    - 判空：当num小于1时，返回false；
    - while循环：依次整除2，3，5
      - 首先整除取余，当可以整除时，进行整除；
    - 最后进行判断：当最终剩余的数字是1时，证明是丑数；否则，返回false。

- ## 代码链接：
  - [丑数](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0263-ugly-number.java)

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
