# easy6
- 本文题号范围：1001-1200


# 目录
<!-- GFM-TOC -->
* [1013. 将数组分成和相等的三个部分](#1013-将数组分成和相等的三个部分)
* []()
* [1103. 分糖果II](#1103-分糖果ii)
* []()
<!-- GFM-TOC -->



# 1013. 将数组分成和相等的三个部分
- ## 题目链接：
  - [partition-array-into-three-parts-with-equal-sum](https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  
- ## 题目描述
  - 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
  - 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
  - 示例 1：
    - 输入：[0,2,1,-6,6,-7,9,1,2,0,1], 输出：true
    - 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
  - 示例 2：
    - 输入：[0,2,1,-6,6,7,9,-1,2,0,1], 输出：false
  - 示例 3：
    - 输入：[3,3,6,5,-2,2,5,1,-9,4], 输出：true
    - 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
  - 提示：3 <= A.length <= 50000, -10^4 <= A[i] <= 10^4
  
- ## 解题思路
  - 思路：寻找切分点
  - 复杂度：时间O(n)，空间O(1)
  - 分析：
    - 首选算A的累加和能否被3整除，不可以那分不了3等分。
    - 遍历并累加，当达到第一个三分之一结点时，即为i（贪心），当达到第一个三分之二结点时，即为j。
    - 注：返回值是布尔型，即只要得到是否存在即可，不需要找出i和j的值。
    - 其他思路：双指针前后向中间逼近，不用考虑中间那段怎么分，只要左右两段累加和等于3等分的数值，中间剩的那段也就找到了。
  - 算法：
    - 遍历数组并求和sum，然后计算sum是否可以被3整除，不能则false，否则继续以下步骤；
    - 将sum更新为sum整除3的结果作为sum累加的target；
    - 定义当前和curSum，以及计数器count；
    - 循环：到`i<length-1`是精髓
      - 累加到curSum；
      - 判断：当curSum等于sum时，计数器+1，并将curSum置0，紧接着判断计数器是否为2，为2即可返回true；
    - 否则，循环结束后还没有return时，证明找不到，返回false。
    - 注：因为题目规定了数组长度取值范围，因此没有判空。
  - 注意测试用例`[1,-1,1,-1]`，因此循环时需要保证最后一个数组非空，即循环时，到`i<length-1`。
  
- ## 代码链接：
  - [将数组分成和相等的三个部分](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/1013-partition-array-into-three-parts-with-equal-sum.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 1103. 分糖果II
- ## 题目链接：
  - [distribute-candies-to-people](https://leetcode-cn.com/problems/distribute-candies-to-people/)

- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
  - 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
  - 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
  - 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
  - 注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
  - 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
  - 示例 1：输入：candies = 7, num_people = 4; 输出：[1,2,3,1]
    - 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
    - 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
    - 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
    - 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
  - 示例 2：输入：candies = 10, num_people = 3; 输出：[5,2,3]
    - 第一次，ans[0] += 1，数组变为 [1,0,0]。
    - 第二次，ans[1] += 2，数组变为 [1,2,0]。
    - 第三次，ans[2] += 3，数组变为 [1,2,3]。
    - 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
  - 提示：1 <= candies <= 10^9; 1 <= num_people <= 1000

- ## 解题思路
  - 思路：暴力法；数学
  - 暴力法：
    - 复杂度：时间O(sqrt(m),n)，空间O(1) -- m为糖果数，n为人数
    - 暴力法：一遍又一遍地遍历人数
    - 不断地遍历数组，如果还有糖就一直分，直到没有糖为止。
    - 优雅暴力：规划好循环；善用取余调转起始；Math.min()控制糖果数不足的情况。
  - 数学：
    - 复杂度：时间O(n)，空间O(1)
    - 数学法：遍历一次人数
    - 找到每个人可获得的糖果数的公式，直接遍历一遍人数并求得值存入结果数组
    - 具体过程: [本题官方题解](https://leetcode-cn.com/problems/distribute-candies-to-people/solution/fen-tang-guo-ii-by-leetcode-solution/)
    - 注：数学方法时间复杂度低，但是推导过程过于复杂，看了一半没有再继续了。以后吧...
    
- ## 代码链接：
  - [分糖果II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/1103-distribute-candies-to-people.java)

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
  - [分糖果II]()

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
