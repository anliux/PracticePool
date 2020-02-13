# 二分查找
- 内含题目：83

# 目录
<!-- GFM-TOC -->
* [35. 搜索插入位置](#35-搜索插入位置)
* [69. x的平方根](#69-x的平方根)
* []()
* []()
* []()
* []()
<!-- GFM-TOC -->



# 35. 搜索插入位置
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    - 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
  - ### 解题思路
    - 思路：暴力法；二分查找
    - 暴力法：
      - 遍历并比较，直到`nums[i] < target`不再成立
    - 二分：
      - 常规二分查找的写法会超时....
    - 内置函数二分查找：
      - 使用`Arrays.binarySearch(nums, target)`并在找不到时返回-a-1
      - 用时0ms...

- ## 代码链接：
  - [搜索插入位置](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0035-search-insert-position.java)


<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 69. x的平方根
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 实现 int sqrt(int x) 函数。
    - 计算并返回 x 的平方根，其中 x 是非负整数。
    - 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
  - ### 解题思路
    - 思路：二分；牛顿迭代法
      - 注：二分是程序员的正常思路，牛顿迭代法是利用数学中的一个结论
      - 牛顿法是近似求根的经典方法，会更快
    - 二分：
      - 复杂度：时间O(logn), 空间O(1)
      - 当 x≥2 时，它的整数平方根一定小于 x/2 且大于 0，即 0<a<x/2。由于 a 一定是整数，此问题转换成在有序整数集中寻找一个特定值
      - 用二分查找的思想不断取中间值并比较，最终逼近结果
    - 牛顿迭代法：
      - 复杂度：时间O(logn), 空间O(1)
      - 一种在实数域和复数域上近似求解方程的方法
      - 求开平方，即求c(c>=0)的算术平方根，等同于求f(x)=x^2-c的正根，得迭代公式x(n+1) = 0.5 * ( x(n) + c/x(n) )
      - 本题向下取整，x(i+1)-x(i)的误差控制在1以内，最后当误差小于 1 时结束迭代。

- ## 代码链接：
  - [x的平方根](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0069-sqrtx.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



#






### END
