# hard
- 本文题号范围：1-200


# 目录
<!-- GFM-TOC -->
* [154. 寻找旋转排序数组中的最小值II](#154-寻找旋转排序数组中的最小值ii)
* []()
* []()
* []()
<!-- GFM-TOC -->



# 154. 寻找旋转排序数组中的最小值II
- ## 题目链接：
  - [find-minimum-in-rotated-sorted-array-ii](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  
- ## 题目描述
  - 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    - 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]。
  - 请找出其中最小的元素。
  - 注意数组中可能存在重复的元素。
  - 示例 1：输入: [1,3,5], 输出: 1;
  - 示例 2：输入: [2,2,2,0,1], 输出: 0
  - 说明：这道题是 寻找旋转排序数组中的最小值 的延伸题目。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

- ## 解题思路
  - 参考：剑指 11. 旋转数组的最小数字
  - 思路：暴力法；排序；二分。
  - 注：
    - 本题与<153-medium>的区别：本题规定可能存在重复元素，153题规定不存在重复元素。
    - 153题与本题：暴力法和排序没有区别，二分需要在判断时注意处理重复元素。
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
      - 注：因为可能存在重复元素，因此需要考虑某两个元素相等的情况。
    - 注意：比较的是mid与right，如果用left指针，可能出问题。
    - 算法：
      - 定义双指针；
      - 左右指针不相等时遍历数组：取mid，比较mid对应元素与right对应元素，mid大则left=mid+1，mid小则right=mid；
        - 注意：如果mid与right对应元素相等，则right--；（分类讨论各种情况可以验证抛弃right后min仍然在left到right范围内）。
      - 返回left对应元素(right也行，因为最后两个指针相等了)。

- ## 代码链接：
  - [寻找旋转排序数组中的最小值II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0154-find-minimum-in-rotated-sorted-array-ii.java)

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
