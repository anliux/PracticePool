# medium11
- 本文题号范围：901-1000


# 目录
<!-- GFM-TOC -->
* [946. 验证栈序列](#946-验证栈序列)
* [](#)
<!-- GFM-TOC -->



# 946. 验证栈序列
- ## 题目链接：
  - [validate-stack-sequences](https://leetcode.cn/problems/validate-stack-sequences/)

- ## 题目标签：
  - [栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Stack.md)
  
- ## 题目描述
  - 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
  - 示例 1：
    - 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    - 输出：true
    - 解释：我们可以按以下顺序执行：
      - push(1), push(2), push(3), push(4), pop() -> 4,
      - push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
  - 示例 2：
    - 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    - 输出：false
    - 解释：1 不能在 2 之前弹出。
  - 提示：
    - 1 <= pushed.length <= 1000
    - 0 <= pushed[i] <= 1000
    - pushed 的所有元素 互不相同
    - popped.length == pushed.length
    - popped 是 pushed 的一个排列

- ## 解题思路
  - 思路关键点：
    - 模拟：同样用栈辅助。
    - 根据弹出的数字去栈顶匹配：匹配到时继续走，没匹配到时压栈直到指定数字出现。 
    - 两个数组会有两个索引值，不需要控制的压栈数组可以考虑使用foreach循环。
    - 判断结果也很巧妙，只有当遍历了压栈序列退出循环，而辅助栈也全部弹栈的情况下为真。
  - 模拟思路：
    - 考虑借用一个辅助栈 stack，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。
      - 注意这里判断是否成功用的是：遍历压栈序列结束后，辅助栈是否为空。 
    - 入栈操作： 按照压栈序列的顺序执行。
    - 出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
    - 由于题目规定 栈的所有数字均不相等 ，因此在循环入栈中，每个元素出栈的位置的可能性是唯一的（若有重复数字，则具有多个可出栈的位置）。因而，在遇到 “栈顶元素 == 弹出序列的当前元素” 就应立即执行出栈。
  - 算法流程：初始化栈和索引值；遍历压栈数组(内外循环)；返回结果
    - 初始化： 辅助栈 stack ，弹出序列的索引 i ；
    - 遍历压栈序列： 各元素记为 num ；
      - 元素 num 入栈；
      - 循环出栈：若 stack 的栈顶元素 == 弹出序列元素 popped[i] ，则执行出栈与 i++ ；
    - 返回值： 若 stack 为空，则此弹出序列合法。
  - 复杂度：
    - 时间O(N), 空间O(N)
  - 注意：
    - 题目指出 pushed 是 popped 的排列 。因此，无需考虑 pushed 和 popped 长度不同 或 包含元素不同 的情况 
    
- ## 代码链接：
  - [验证栈序列](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0946-validate-stack-sequences.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  
- ## 题目描述
  - 

- ## 解题思路
  - 
    
- ## 代码链接：

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  
- ## 题目描述
  - 

- ## 解题思路
  - 
    
- ## 代码链接：

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->








# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  
- ## 题目描述
  - 

- ## 解题思路
  - 
    
- ## 代码链接：

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->







<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



### END
