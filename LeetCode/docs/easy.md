# easy题目

<!-- GFM-TOC -->
* [1. 两数之和](#1-两数之和)
* [7. 整数反转](#7-整数反转)
* [9. 回文数](#9-回文数)
* []()
* []()
* []()
<!-- GFM-TOC -->



# 1. 两数之和
- ## 题目链接：
  - [two-sum](https://leetcode-cn.com/problems/two-sum/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  
- ## 题目描述
  - 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
  - 假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
  - 示例:
    - 给定 nums = [2, 7, 11, 15], target = 9
    - 因为 nums[0] + nums[1] = 2 + 7 = 9, 所以返回 [0, 1]

- ## 解题思路
  - 1. 暴力法：思路简单，双层循环时间复杂度高 O(n^2), O(1)
  - 2. 哈希表：用空间换时间，降低时间复杂度 O(n), O(n)
  - 哈希表有两种思路：
    - 一种是先保存到表，后进行匹配
    - 一种是在保存到表的同时进行匹配
  - 两遍哈希表：
    - 在第一次迭代中，将每个元素的值和它的索引添加到表中。
    - 在第二次迭代中，检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。
    - 注意，该目标元素不能是 nums[i] 本身！
    - tips：此处的反推思路
      - 因为判断存在的`map.containsKey(key)`找的是key，为了方便求和等式计算，把key值设置为数组的值，同时因此把value值设置为数组索引（这就跟常规思路有点反了）。基于以上，在判断不能是nums[i]本身时，就要用`map.get(complement) != i`
      - 如果是正常的键值对应，`map.containsKey(key)`中，判断是否包含某个键key是没有意义的。因此虽然上面的思路有点别扭，但是改过来的思路不能通过。
  - 一遍哈希表：
    - 在进行迭代并将元素插入到表中的同时，检查表中是否已经存在当前元素所对应的目标元素。
    - 如果它存在，那我们已经找到了对应解，并立即将其返回。
  - 注意：哈希表的使用方式
    - 定义：`Map<Integer, Integer> map = new HashMap<>();`
    - 存入数据：`map.put(K key, V value)`
    - 获取数据：`map.get(key`) -- 根据键key，获取key对应的值value
    - 判断是否存在某键：`map.containsKey(key)` -- 找的是键key，即，是否包含某个key，与值value无关；注意不要漏掉小s
  - 找到所求：
    - 新建匿名数组并将所求得的i和j传入新数组，然后return
  - 找不到所求：抛出异常 `throw new IllegalArgumentException("No two sum solution");`

- ## 代码链接：
  - [两数之和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0001-two-sum.java)
  
  
  
# 7. 整数反转
- ## 题目链接：
  - [reverse-integer](https://leetcode-cn.com/problems/reverse-integer/)
  
- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    - 示例 1: 输入: 123, 输出: 321
    - 示例 2: 输入: -123, 输出: -321
    - 示例 3: 输入: 120, 输出: 21
  - 注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,2^31−1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

- ## 解题思路
  - 思路：使用数学方法取单个位，并重新组合；注意题目的临界条件。
  - 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，使用数学方法:
    - 通过整除取余取出最低位，通过整除得到除去最低位以外的数字：
      - `//pop operation:`
      - `pop = x % 10;`
      - `x /= 10;`
    - 定义临时变量，将临时变量乘以10以提升位数，并在此基础上加上新取出的最低位，循环这个过程
      - `//push operation:`
      - `temp = rev * 10 + pop;`
      - `rev = temp;`
  - 只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,2^31−1]，在`temp = rev * 10 + pop;`这一步很容易越界
    - int最大值是2147483647，最小值是-2147483648，题目明确要求，因此不能定义long来防止越界
    - 因此要在这一步之前加保险，仔细判断
    - 注意：正数和负数这两段都需要判断
  - 对于正数部分：
    - 考虑常规：`rev > Integer.MAX_VALUE/10` 时，`rev * 10` 必定大于Integer的Max值，不符合条件
    - 考虑临界：`rev == Integer.MAX_VALUE / 10` 时，整除会削去个位的值，因此，若再乘以10，个位是0。这时再加某值，这个值需要小于MAX值的个位，否则越界。因此：`pop > Integer.MAX_VALUE % 10`
  - 对于负数部分：
    - 同理
    - `rev < Integer.MIN_VALUE / 10`， 以及 `rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10`
  - 判停条件：
    - 先取最低位，后进行x的整除运算，因此当x变为个位数的时候，取出最低位再整除之后，x得0
    - 因此循环的判停条件是：当x等于0的时候停止循环
  - 注意：运算符优先级
    - &&的优先级高于||的优先级，在if判断中可以省略小括号
    - 但是保险起见，同时方便阅读，建议加上小括号进行区分“先算双与，后算双或”的顺序
  - 复杂度分析:
    - 时间复杂度：O(log(x))，x 中大约有 log10(x) 位数字。
    - 空间复杂度：O(1)。
    
- ## 代码链接：
  - [整数反转](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0007-reverse-integer.java)



# 9. 回文数
- ## 题目链接：
  - [palindrome-number](https://leetcode-cn.com/problems/palindrome-number/)
  
- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    - 示例 1: 输入: 121， 输出: true
    - 示例 2: 输入: -121， 输出: false
      - 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    - 示例 3: 输入: 10， 输出: false
      - 解释: 从右向左读, 为 01 。因此它不是一个回文数。
    - 进阶: 你能不将整数转为字符串来解决这个问题吗？

- ## 解题思路
  - 回文数：即反转之后与原数值相等，考虑借鉴第7题的整数反转
    - 注：将数字转换为字符串，并检查字符串是否为回文，这需要额外的非常量空间
  - 改进：反转后的数字大于int.MAX时，将遇到整数溢出问题。因此考虑只反转一半，并与原始数值比较
  - 临界：
    - 所有负数都不可能是回文
    - 最后一位是0且数字本身不是0的，都不是回文：最后一位是0，为了使该数字为回文，则其第一位数字也应该是0，符合的只有0
    - 奇数位的数字：当数字长度为奇数时，可以通过 revertedNumber/10 去除处于中位的数字。
      - 例如，当输入为 12321 时，在 while 循环的末尾可以得到 x = 12，revertedNumber = 123，
      - 由于处于中位的数字不影响回文（它总是与自己相等），所以可以简单地将其去除：
      - 代码表示为：`return x == revertedNumber || x == revertedNumber/10;`
    - 所有个位数正数都是回文：不过不需要特意判断，这种情况包含在奇数位数中了
  - 判停：判断已反转到一半
    - 将原始数字除以 10，然后给反转后的数字乘上 10，
    - 当原始数字小于反转后的数字时，就意味着已经处理了一半位数的数字。
    
- ## 代码链接：
  - [回文数](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0009-palindrome-number.java)



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：






# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：






# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：






# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：






# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：








### END
