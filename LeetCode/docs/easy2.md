# easy2
- 本文题号范围：201-400


# 目录
<!-- GFM-TOC -->
* [202. 快乐数](#202-快乐数)
* [206. 反转链表](#206-反转链表)
* []()
* []()
* []()
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
    - 分析：
      - 递归的两个条件：
        - 终止条件是当前节点或者下一个节点==null
        - 在函数内部，改变节点的指向，也就是 head 的下一个节点指向 head 递归函数那句：`head.next.next = head;`
        - 不好理解，其实就是 head 的下一个节点指向head：相当于head与head.next和head形成了一个环。
      - 递归函数中每次返回的 cur 其实只最后一个节点，在递归函数内部，改变的是当前节点的指向。
    - 算法：
      - 判空：当head为空，或者仅有一个结点时，返回head本身；
      - 递归：结点cur赋值为head.next的反转链表结果，这句会一直dfs到末尾，然后开始返回；
        - 把head看做一个结点，把剩余结点并且已经调用过反转函数的返回值看做cur。
      - 形成环：将head.next的下一个结点赋值为head，即将head.next连接到head；
      - 切断head与head.next的连接；
      - 最后返回cur：cur是尾结点。
    
- ## 代码链接：
  - [反转链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0206-reverse-linked-list.java)

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
