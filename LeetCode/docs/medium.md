# medium1
- 本文题号范围：1-100


# 目录
<!-- GFM-TOC -->
* [2. 两数相加](#2-两数相加)
* [3. 无重复字符的最长子串](#3-无重复字符的最长子串)
* []()
* []()
* []()
* []()
<!-- GFM-TOC -->




# 2. 两数相加
- ## 题目链接：
  - [add-two-numbers](https://leetcode-cn.com/problems/add-two-numbers/)

- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
  - 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
  - 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  - 示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4), 输出：7 -> 0 -> 8, 原因：342 + 465 = 807

- ## 解题思路
  - 思路：模拟初等数学的加法运算
  - 分析：
    - 非空链表按照逆序，同初等数学加法计算从低位到高位，根据示例，结果也是逆序，最后不用反转；
    - 进位：两个数字相加（考虑到进位）可能出现的最大和为 9+9+1=19 ，使用变量carry来跟踪进位，并将carry带入下一次迭代；
    - 结果返回一个额外的链表，因此定义一个链表res来存储每一位，最后返回res.next
    - 边界情况：两链表长度不同；一链表为空；两链表最后一位仍然有进位..等等。
  - 算法：
    - 定义res链表结点并初始化，定义三个结点p，q，cur追踪两链表的移动和res链表的当前位置，定义进位carry
    - 循环直到两链表均为空:
      - 定义变量存储当前结点对应的值val，存储前需要判断当前结点是否为null，为空时返回0，可以用三目运算符；
      - 定义sum和将上述变量和进位carry的和，并整除计算进位carry；
      - 将整除取余结果存入新建结点并赋值给cur.next，然后将cur向后移动；
      - 判断p，q结点是否为空，不为空时p，q结点向后移动。
    - 循环结束后，判断最高位是否仍有进位，即carry是否大于0
    - 返回res.next链表
  - 链表知识点：
    - 新建链表结点：`ListNode dummyHead = new ListNode(0);`
    
- ## 代码链接：
  - [两数相加](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0002-add-two-numbers.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 3. 无重复字符的最长子串
- ## 题目链接：
  - [longest-substring-without-repeating-characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  - [滑动窗口](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Sliding%20Window.md)
  
- ## 题目描述
  - 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
  - 示例 1: 输入: "abcabcbb"，输出: 3。解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
  - 示例 2: 输入: "bbbbb"，输出: 1。解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
  - 示例 3: 输入: "pwwkew"，输出: 3。解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
  - 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

- ## 解题思路
  - 思路：暴力法；滑动窗口。
  - 暴力法：
    - 复杂度：O(n^3)，O(min(m,n)) -- 字符串 n 的大小以及字符集/字母 m 的大小。
    - 分析：
      - 假设有一个函数 boolean allUnique(String substring) ，如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false。
      - 遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。 如果事实证明返回值为 true，那么将会更新无重复字符子串的最大长度的答案。
      - 为了枚举给定字符串的所有子字符串，需要枚举它们开始和结束的索引。假设开始和结束的索引分别为 i 和 j。那么有 0≤i<j≤n（这里的结束索引 j 是按惯例排除的）。因此，使用 i 从 0 到 n−1 以及 j 从 i+1 到 n 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
      - 要检查一个字符串是否有重复字符，使用集合。
      - 遍历字符串中的所有字符，并将它们逐个放入 set 中。在放置一个字符之前，检查该集合是否已经包含它。如果包含，返回 false。循环结束后，返回 true。
    - 算法：
    - HashSet知识点：
      - 新建：`Set<Character> set = new HashSet<>();`
      - add(E e) ：如果此 set 中尚未包含指定元素，则添加指定元素。
      - contains(Object o) ：如果此 set 包含指定元素，则返回 true。
      - isEmpty() ：如果此 set 不包含任何元素，则返回 true。
      - size() ：返回此 set 中的元素的数量（set 的容量）。
 



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
