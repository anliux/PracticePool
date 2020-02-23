# 链表
- 内含题目：37

# 目录
<!-- GFM-TOC -->
* [21. 合并两个有序链表](#21-合并两个有序链表)
* [83. 删除排序链表中的重复元素](#83-删除排序链表中的重复元素)
* [141. 环形链表](#141-环形链表)
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



# 141. 环形链表
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个链表，判断链表中是否有环。
    - 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
  - ### 解题思路
    - 思路：哈希表；双指针
    - 哈希表：
      - 复杂度：时间O(n)，空间O(n)
      - 思路：可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
      - 分析：遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
        - 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
        - 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
      - 注：哈希表有hashmap和hashset两种，hashmap存储键值对，而hashset存储对象。本题仅需要存储各个结点，因此选择hashset
      - 算法：新建hashset；遍历链表直到next为null(即达到尾结点)：验证，已存在则返回true，否则更新到下一结点；遍历结束后仍没有返回时，返回false。
    - 双指针：
      - 复杂度：时间O(n)，空间O(1)
      - 思路：通过使用具有 ‘不同速度’ 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
        - 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
        - 否则，快慢指针最终会相遇
      - 算法：判空；新建快慢指针；循环直到两指针相等：循环中若出现任一指针为null，则返回false；循环结束后返回true
        - 注：循环条件为相等，而不是判空；反过来也可以，只是看起来代码不够优雅了。
        - 注：判空时判断当前结点和next是为了避免下面操作的空指针异常，不单单是为了判断循环结束。注意循环中的判空条件是fast和fast.next，因为快指针在前，如果快指针没问题，那么慢指针也没问题。

- ## 代码链接:
  - [环形链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0141-linked-list-cycle.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->


### END
