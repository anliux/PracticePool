# hard2
- 本文题号范围：201-400


# 目录
<!-- GFM-TOC -->
* [239. 滑动窗口最大值](#239-滑动窗口最大值)
* []()
* []()
* []()
<!-- GFM-TOC -->



# 239. 滑动窗口最大值
- ## 题目链接：
  - [sliding-window-maximum](https://leetcode-cn.com/problems/sliding-window-maximum/)

- ## 题目标签：
  - [堆](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Heap.md)
  - [滑动窗口](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Sliding%20Window.md)
  
- ## 题目描述
  - 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
  - 返回滑动窗口中的最大值。
  - 示例: 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3, 输出: [3,3,5,5,6,7] 
  - 提示：你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
  - 进阶：你能在线性时间复杂度内解决此题吗？

- ## 解题思路
  - 思路：暴力法；双向队列；动态规划
  - ### 暴力法：
    - 复杂度：时间O(nk)，空间O(n-k+1)，n是数组元素个数
    - 遍历每个滑动窗口，找到每个窗口的最大值。
    - 一共有 N - k + 1 个滑动窗口，每个有 k 个元素，于是算法的时间复杂度为 O(Nk)，表现较差。
    - 算法：
      - 定义数组元素个数n
      - 判空：`n*k==0`，意味着n和k中存在0，此时，新建长度为0的数组并返回
        - 注：测试用例`输入：[] 0; 输出：[]`，因此判空不能返回null，需要返回新建长度为0的数组
      - 定义结果数组output，数组长度为滑动窗口个数 `n-k+1`
      - 两层循环：外层控制起始，内层控制小窗口内的遍历
        - 定义最大值max，遍历本窗口内的所有数字并更新max，然后将max作为output[i]存入结果数组
      - 返回结果数组
  - ### 双向队列
    - 复杂度：时间O(n)，空间O(n)
    - 存储双向队列的索引，以优化时间复杂度
      - 队首存储每个窗口的最大值，队尾存储可能成为最大值的其他元素（当最大值滑出后）
    - 先遍历第一个窗口，找出最大值；然后从第二个窗口开始遍历，以每个窗口最右端为基准，遍历至最后一个元素
    - 清理双向队列:
      - 只保留当前滑动窗口中有的元素的索引。
      - 移除比当前元素小的所有元素，它们不可能是最大的。
    - 算法：
      - 定义数组元素个数n；
      - 判空：`n*k==0`；
      - 边界值：`k=1`时返回原数组；
      - 新建数组双端队列deq：`ArrayDeque<Integer> deq = new ArrayDeque<Integer>();`；
      - 定义窗口最大值对应的索引max_index；
      - 首先：遍历第一个窗口，清理队首队尾，将元素添加到队列last，并找出最大值；
      - 定义输出数组output，并将第一个元素初始化为max_index对应的元素；
      - 其次：以每个窗口的最右端为基准，从第二个窗口开始，遍历至数组末尾最后一个元素
        - 首先清理队首first：判断 -- 当队列不为空，且队首等于本窗口最左侧的左侧元素时，移除首位（i-k是已经滑出本窗口的最近索引）；
        - 其次清理队尾last：循环（可能存在多个不符的队尾元素） -- 当队列不为空，且当前元素大于队尾时，移除队尾元素；
          - 这里：如果i索引值大于已有队尾，会在这一步移除，因此，下一步直接添加到队尾即可，包含了两种情况
        - 将当前元素的索引添加到队列（作为在最大值滑出窗口后，可能成为最大值的元素，放入队尾）
        - 最后将队首索引值对应的数组元素赋值给第i个元素
      - 返回结果数组output
      - 注：
        - 存入队列的是索引值，不是数组元素值；
        - 赋值给结果数组output的是队首索引值对应的数组元素，不是直接将队首元素存入结果数组；
        - 清理队首队尾重复代码，可以封装到一个函数中，这里就全写在同一个函数中了；
    - 双向队列知识点：
      - Deque：接口的大小可变数组的实现。
      - ArrayDeque：数组双端队列没有容量限制；它们可根据需要增加以支持使用。它们不是线程安全的；在没有外部同步时，它们不支持多个线程的并发访问。禁止 null 元素。此类很可能在用作堆栈时快于 Stack，在用作队列时快于 LinkedList。
      - add(E e)：将指定元素插入此双端队列的末尾。
      - addFirst(E e)：将指定元素插入此双端队列的开头。
      - addLast(E e)：将指定元素插入此双端队列的末尾。
      - getFirst()：获取，但不移除此双端队列的第一个元素。
      - getLast()：获取，但不移除此双端队列的最后一个元素。
      - isEmpty()：如果此双端队列未包含任何元素，则返回 true。
      - remove()：获取并移除此双端队列所表示的队列的头
      - remove(Object o)：从此双端队列中移除指定元素的单个实例。
      - removeFirst()：获取并移除此双端队列第一个元素。
      - removeLast()：获取并移除此双端队列的最后一个元素。
      - size()：返回此双端队列中的元素数。
      - toArray()：返回一个以恰当顺序包含此双端队列所有元素的数组（从第一个元素到最后一个元素）。
      - toArray(T[] a)：返回一个以恰当顺序包含此双端队列所有元素的数组（从第一个元素到最后一个元素）；返回数组的运行时类型是指定数组的运行时类型。
      
- ## 代码链接：
  - [滑动窗口最大值](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0239-sliding-window-maximum.java)

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
