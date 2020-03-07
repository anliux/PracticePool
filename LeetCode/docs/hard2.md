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
      - 定义结果数组output，数组长度为滑动窗口个数 `n-k+1`
      - 两层循环：外层控制起始，内层控制小窗口内的遍历
        - 定义最大值max，遍历本窗口内的所有数字并更新max，然后将max作为output[i]存入结果数组
      - 返回结果数组

- ## 代码链接：
  - [滑动窗口最大值]()

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
