# 递归
- 内含题目：15


# 目录
<!-- GFM-TOC -->
* [50. pow函数](#50-pow函数)
* []()
<!-- GFM-TOC -->



# 50. pow函数
- ## 简述：（[medium](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium.md)）
  - ### 题目描述
    - 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    - 不得使用库函数，不需要考虑大数问题。
    - -100.0 < x < 100.0; -2^31 <= n <= 2^31-1; -10^4 <= x^n <= 10^4
  - ### 解题思路
    - 乘方功能，即实现类似pow()函数的功能
      - 注：double pow(double base, double exponent) -- 返回值类型默认为double型，可根据题目要求进行强转
      - 一行代码：`return Math.pow(base,exponent);`
    - 本题难点：
      - 不能使用库函数，考虑从pow算法的计算方法入手
      - 指数为正数时，正常叠乘底数
      - 指数是负数时，需要先求倒数，后求指数绝对值(负数，直接求相反数即可，越简单越好)的次幂值
      - n = 0，任意数的 0 次方均为 1
      - 注：底数为0的情况，正常算即可
    - 快速幂
      - 降幂的思想: 不是叠乘，而是二分，结果=降幂的2次方
      - 求x的64次幂：每次平方即可 `x -> x^2 -> x^4 -> x^8 -> x^16 -> x^32 -> x^64`
      - 求x的77次幂：奇偶数不同处理 `x -> x^2 -> x^4 -> x^9 -> x^19 -> x^38 -> x^77`
      - 当我们要计算 `x^n` 时，我们可以先递归地计算出 `y=x^⌊n/2⌋`，其中 `⌊a⌋` 表示对 a 进行下取整；
      - 根据递归计算的结果，如果 n 为偶数，那么 `x^n = y^2` ；如果 n 为奇数，那么 `x^n = y^2 * x`
    - 快速幂-递归版：
      - 首先：分为正指数和负指数，赋不同的计算形式
        - 正和0：直接调用；
        - 负：指数取相反数，结果取倒数 
      - 其次：
        - 指数如果为0：`结果=1.0`
        - 指数为偶数：`结果=y*y` 
        - 指数为奇数：`结果=y*y*x`
    - 快速幂改进：
      - 将负指数和奇偶指数统一
      - 首先：判断指数为0，1，-1时的返回值
      - 其次：降幂一次，求double half的值
      - 然后：指数对2取余的值作为指数带入函数本体，作为half mod的值
      - return half的平方 乘以 mod;
    - 注意：
      - 考虑指数的特殊情况：为1时返回base，为0时返回1.
      - 考虑指数是负数的情况：设置标志，先把指数取相反数变为正数，用公式计算，最后求结果的倒数（当标志为真时）
      - 可以考虑：用右移代替除以2，用与1运算代替整除取余%，可提高运算效率。
    
- ## 代码链接：
  - [pow(x,n)](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0050-pow-x-n.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->






# 
<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->





<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




### END