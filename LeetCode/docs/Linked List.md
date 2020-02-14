# 链表
- 内含题目：37

# 目录
<!-- GFM-TOC -->
* [21. 合并两个有序链表](#21-合并两个有序链表)
* [83. 删除排序链表中的重复元素](#83-删除排序链表中的重复元素)
* []()
* []()
* []()
* []()
* []()
<!-- GFM-TOC -->



# 21. 合并两个有序链表
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 将两个有序链表合并为一个新的有序链表并返回。
    - 新链表是通过 拼接 给定的两个链表的所有节点组成的。  
  - ### 解题思路
    -  思路：递归；迭代
    - 递归：
      - 边界：当任一链表为null时，直接返回剩余链表（即返回非空链表）
        - 注：这里包括当两链表都是null的情况，因为仍然会返回其一。
      - 比较：将两个链表中头部较小的一个，与剩下元素的 merge 操作结果合并，最终返回此链表
        - 当list1[0]<list2[0]时：list1[0] + merge(list1[1:], list2)，并返回list1
        - 否则（包含等于情况）：list2[0] + merge( list1l, list2[1:])，并返回list2
    - 迭代
      - 顺序迭代的思路
      - 设定一个哨兵节点 "prehead" （以便在最后比较容易地返回合并后的链表）
      - 维护一个 prev 指针，并调整它的 next 指针
      - 重复以下过程，直到 l1 或者 l2 指向了 null ：
        - 如果 l1 当前位置的值小于等于 l2 ，把 l1 的值接在 prev 节点的后面，同时将 l1 指针往后移一个。
        - 否则，对 l2 做同样的操作。
        - 不管将哪一个元素接在了后面，都把 prev 向后移一个元素。
      - 最后加一步对于空链表的分析，并返回prehead

- ## 代码链接：
  - [合并两个有序链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0021-merge-two-sorted-lists.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 83. 删除排序链表中的重复元素
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
  - ### 解题思路
    - 思路：简单链表操作
    - 因为是已排序链表，因此只需比较next值，相同则更新next，不同则更新current
      - 相同时next指向next的next，不同时移动当前结点current到它的next
    - 注意是head，不是current，current相当于for循环中的int i

- ## 代码链接：
  - [删除排序链表中的重复元素](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0083-remove-duplicates-from-sorted-list.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->





### END
