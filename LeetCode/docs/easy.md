# easy题目

<!-- GFM-TOC -->
* [1. 两数之和](#1-两数之和)
* [7. 整数反转](#7-整数反转)
* [9. 回文数](#9-回文数)
* [13. 罗马数字转整数](#13-罗马数字转整数)
* [14. 最长公共前缀](#14-最长公共前缀)
* [20. 有效的括号](#20-有效的括号)
* [21. 合并两个有序链表](#21-合并两个有序链表)
* [26. 删除排序数组中的重复项](#26-删除排序数组中的重复项)
* [27. 移除元素](#27-移除元素)
* [28. 实现strSetr()](#28-实现strstr)
* [35. 搜索插入位置](#35-搜索插入位置)
* [38. 外观数列](#38-外观数列)
* [53. 最大子序和](#53-最大子序和)
* [58. 最后一个单词的长度](#58-最后一个单词的长度)
* [66. 加一](#66-加一)
* [67. 二进制求和](#67-二进制求和)
* [69. x的平方根](#69-x的平方根)
* [70. 爬楼梯](#70-爬楼梯)
* [83. 删除排序链表中的重复元素](#83-删除排序链表中的重复元素)
* [88. 合并两个有序数组](#88-合并两个有序数组)
* [100. 相同的树](#100-相同的树)
* [101. 对称二叉树](#101-对称二叉树)
* [104. 二叉树的最大深度](#104-二叉树的最大深度)
* [107. 二叉树的层次遍历II](#107-二叉树的层次遍历ii)
* [108. 将有序数组转换为二叉搜索树](#108-将有序数组转换为二叉搜索树)
* [110. 平衡二叉树](#110-平衡二叉树)
* [111. 二叉树的最小深度](#111-二叉树的最小深度)
* [112. 路径总和](#112-路径总和)
* [118. 杨辉三角](#118-杨辉三角)
* [119. 杨辉三角II](#119-杨辉三角ii)
* [121. 买卖股票的最佳时机](#121-买卖股票的最佳时机)
* [122. 买卖股票的最佳时机II](#122-买卖股票的最佳时机ii)
* [125. 验证回文串](#125-验证回文串)
* [136. 只出现一次的数字](#136-只出现一次的数字)
* [141. 环形链表](#141-环形链表)
* [155. 最小栈](#155-最小栈)
* [160. 相交链表](#160-相交链表)
* [167. 两数之和II-输入有序数组](#167. 两数之和ii-输入有序数组)
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

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->

  
  
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

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



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

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 13. 罗马数字转整数
- ## 题目链接：
  - [roman-to-integer](https://leetcode-cn.com/problems/roman-to-integer/)
  
- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)

- ## 题目描述
  - 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
  - 规则：通常情况下，罗马数字中小的数字在大的数字的右边。
    - 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
  - 特例：
    - 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
    - 数字 9 表示为 IX。
  - 这个特殊的规则只适用于以下六种情况：
    - I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    - X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    - C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和  900。
  - 要求：给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
  - 示例：
    - 示例 1: 输入: "III"，输出: 3
    - 示例 2: 输入: "IV"，输出: 4
    - 示例 3: 输入: "IX"，输出: 9
    - 示例 4: 输入: "LVIII"，输出: 58，解释: L = 50, V= 5, III = 3.
    - 示例 5: 输入: "MCMXCIV"，输出: 1994，解释: M = 1000, CM = 900, XC = 90, IV = 4.
  - 对应表格为：
  
| 字符 | 数值 |
| :-------------: | ------------- |
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

- ## 解题思路
  - 思路：
    - 多个字符对应不同的数字，考虑“查表法”，可用哈希表 或者 “switch”
    - 比较相邻两个字符，若高位不小于低位，直接相加；否则，要用低位的大数减去高位的小数。
    - 将每位对应的数字累加：可以从高位到低位，即从字符串的0到length-1
  - 查表法：
    - 可以定义一个私有函数来实现查表的功能，使代码更清晰
    - 查表可以使用哈希表，或者直接用switch对应，据说switch更快
    - 本题标签是“数学”和“字符串”，并没有“哈希表”，因此先不强求使用哈希表
      - 注：因为如果使用哈希表，put、get、取值比较等等并不方便，需要思考的东西太多了，明明用简单是数学就可以搞定的。
  - 比较相邻字符：
    - 首先注意一点：数字的高位在左，低位在右；而用索引获取字符串时，低位在左，高位在右
    - 遍历字符串，判停条件可以设置为字符串长度
    - 定义变量sum保存求和的值，当字符大小是 “左大右小” 或者 “相等” 时，直接相加；否则左边的数变为负数累加
      - 此处可以先判断左小右大的情况，剩余情况用else概括
    - 注意循环内外放置的语句，临界情况要通过特值进行验证
    - 循环时为避免混乱，只对pre进行累加，并在最后将pre值更新为原num，即向右移动一下
    - 因为循环的是后一个位置i，而循环累加的是pre，因此循环结束后，还需要把最后一个pre手动累加到sum
  - String相关使用：
    - `charAt(i)`方法：用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。索引从左0开始。
    - `substring(int beginIndex, int endIndex)`方法：返回字符串的子字符串，左闭右开，end可省略。
    - 长度：`s.length()` -- 注：数组的长度没有小括号 `arr.length;`
  - switch格式：
    - `switch(ch) { case 'I': return 1; ... default: return 0;}`

- ## 代码链接：
  - [罗马数字转整数](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0013-roman-to-integer.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 14. 最长公共前缀
- ## 题目链接：
  - [longest-common-prefix](https://leetcode-cn.com/problems/longest-common-prefix/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)

- ## 题目描述
  - 编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 ""。
  - 示例 1: 输入: ["flower","flow","flight"]，输出: "fl"
  - 示例 2: 输入: ["dog","racecar","car"]，输出: ""，解释: 输入不存在公共前缀。
  - 说明: 所有输入只包含小写字母 a-z 。

- ## 解题思路
  - 思路：官方题解给了多种方法（水平扫描法，水平扫描，二分，分治，字典树），重点看第一种
  - 水平扫描法：减法思想
    - 复杂度分析：时间复杂度低（战胜100%），空间复杂度高（战胜14%），相当于空间换时间了
    - 当字符串数组为空时，即长度为0时，即不存在公共前缀，返回空字符串""；
    - 以字符串数组中的第一个元素为基准，遍历整个数组，进行比较；
    - prefix保存当前最长公共前缀，如果prefix不是当前字符串的前缀，则删除最后一个字符再进行比较，一直到prefix变成当前字符串的前缀，或者变成空字符串
    - 注意是求公共前缀，不是最长公共子序列，因此可以从后面减，也是while判0的原因
  - 字符串相关使用：
    - indexOf():
      - 功能：查找字符串，或字符 Unicode 编码在字符串出现的位置
      - 语法：`indexOf(int ch, int fromIndex)`或`indexOf(String str, int fromIndex)` -- 注意字符char是int型
      - 索引值从0开始
      - 返回从 fromIndex 位置开始查找指定字符或字符串在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回-1。
      - 使用fromIndex=i时，从索引位置i开始查找，包括位置i；查找所得的索引位置仍然是从整个字符串排序所得的位置，并不重新计算
      - fromIndex可省略：省略时默认为从索引0开始查找
    - substring():
      - 功能：返回字符串的子字符串
      - 语法：`substring(int beginIndex)`或`substring(int beginIndex, int endIndex)`
      - 索引值从0开始
      - 左闭右开：包括begin，不包括end
      - end可省略：省略时默认截取到字符串的最后
    - isEmpty():
      - 功能：判断字符串是否为空的布尔型返回值
      - isEmpty完全等同于`string.length()==0`
      - 如果String本身是null，那么使用`string.isEmpty()`会报空指针异常（NullPointerException)
      - 判断一个String为空的最安全的方法，还是`string ==null || string.isEmpty();`

- ## 代码链接：
  - [最长公共前缀](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0014-longest-common-prefix.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 20. 有效的括号
- ## 题目链接：
  - [valid-parentheses](https://leetcode-cn.com/problems/valid-parentheses/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Stack.md)
  
- ## 题目描述
  - 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
  - 有效字符串需满足：
    - 左括号必须用相同类型的右括号闭合。
    - 左括号必须以正确的顺序闭合。
    - 注意空字符串可被认为是有效字符串。
  - 示例：
    - 示例 1: 输入: "()"，输出: true
    - 示例 2: 输入: "()[]{}"，输出: true
    - 示例 3: 输入: "(]"，输出: false
    - 示例 4: 输入: "([)]"，输出: false
    - 示例 5: 输入: "{[]}"，输出: true

- ## 解题思路
  - 思路：暴力法；栈
  - 暴力法：
    - 简单粗暴，耗时多(可能超时)
    - 每次检测是否有最里侧的成对某种括号，若有，则替换所有成对括号为空字符串，直到检测不到相邻的成对括号
    - 遍历完成后，如果是有效表达式，则最后的字符串会只剩下空串，判断是否==空串
    - 法一：在while小括号中判断：
      - while每次判断是否有相邻括号，如果有，则进入循环并进行替换操作
      - 不用先判断是否为空，因为while判断包含
    - 法二：在while的循环体中判断：
      - while(true)无限循环替换动作并在最后判断字符串长度是否改变，如果没有，break。
      - 需要先判断是否为空，否则直接进入while循环
    - 法二比法一稍快
      - 经测试，法一超出时间限制，法二耗时100ms，超过5%的用户
  - 处理单一类型的括号的算法：
    - 遍历：左加右减（遇到左括号+1，遇到右括号-1）
    - 但是在处理多种类型括号且有顺序穿插的时候就不好用了
    - 因此可以借鉴栈的应用中对四则运算表达式的处理
  - 递归结构：
    - 有效表达式的子表达式也应该是有效表达式，即一种递归结构
  - 栈：
    - 表示问题的递归结构时，栈数据结构可以派上用场。
    - 因为对整体结构一无所知，无法真正地从内到外处理这个问题。
    - 栈可以帮助我们递归地处理这种情况，即从外部到内部。
    - 有效表达式：从整体表达式中一次删除一个较小的表达式，最后剩留下一个空字符串。
  - 算法
    - 初始化哈希表 char型
    - 初始化栈 char型
    - 遍历字符串，每次对遍历到的字符进行判断
      - 压栈：遇到开括号，将其推到栈上。
      - 弹栈：否则，当栈非空，且当前字符串的字符与栈顶元素配对成功时，弹栈
      - 无效：否则，表达式无效。
    - 最后，若栈非空，则表达式无效。
    - 注：官方题解里设置一堆其他函数和一堆this，其实写到一个函数里也可以的，还可以防止漏写避免错误
  - 栈方法的复杂度分析(官方题解)：
    - 时间复杂度：O(n)
    - 空间复杂度：O(n)
  - 字符串相关使用：
    - contains(CharSequence s):
      - 字符串要用双引号括起来
      - 当且仅当此字符串包含指定的 char 值序列时，返回 true。
    - replace("new","old")和replaceAll("new","old"):
      - 相同点：替换所有匹配的字符串（都是替换所有）
      - 不同点：replace支持字符替换，字符串替换；replaceAll是正则表达式替换
      - 注：replaceAll也支持字符串操作，但在LeetCode中运行会报错
      - 综上，写replace即可
    - replaceFirst("new","old"):
      - 仅替换第一次出现的
      - 同replaceAll，支持正则表达式和一般字符串
  - 栈的相关使用：
    - 定义：
      - Stack < Character > stack = new Stack < Character >(); -- 定义栈中元素为char类型
    - 进栈：
      - stack.push(c); -- char c进栈
    - 出栈：
      - stack.pop() -- 弹出栈顶的元素
    - 判空：
      - stack.empty() -- 测试堆栈是否为空

- ## 代码链接：
  - [有效的括号](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0020-valid-parentheses.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 21. 合并两个有序链表
- ## 题目链接：
  - [merge-two-sorted-lists](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
  
- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)

- ## 题目描述
  - 将两个有序链表合并为一个新的有序链表并返回。
  - 新链表是通过 拼接 给定的两个链表的所有节点组成的。  
  - 示例：输入：1->2->4, 1->3->4，输出：1->1->2->3->4->4

- ## 解题思路
  - 思路：递归；迭代
  - 递归：
    - 边界：当任一链表为null时，直接返回剩余链表（即返回非空链表）
      - 注：这里包括当两链表都是null的情况，因为仍然会返回其一。
    - 比较：将两个链表中头部较小的一个，与剩下元素的 merge 操作结果合并，最终返回此链表
      - 当list1[0]<list2[0]时：list1[0] + merge(list1[1:], list2)，并返回list1
      - 否则（包含等于情况）：list2[0] + merge( list1l, list2[1:])，并返回list2
    - 递归的复杂度分析：
      - 时间复杂度：O(m+n)
      - 空间复杂度：O(m+n)
  - 迭代
    - 顺序迭代的思路
    - 设定一个哨兵节点 "prehead" （以便在最后比较容易地返回合并后的链表）
    - 维护一个 prev 指针，并调整它的 next 指针
    - 重复以下过程，直到 l1 或者 l2 指向了 null ：
      - 如果 l1 当前位置的值小于等于 l2 ，把 l1 的值接在 prev 节点的后面，同时将 l1 指针往后移一个。
      - 否则，对 l2 做同样的操作。
      - 不管将哪一个元素接在了后面，都把 prev 向后移一个元素。
    - 最后加一步对于空链表的分析，并返回prehead
    - 迭代的复杂度分析：
      - 时间复杂度：O(m+n)
      - 空间复杂度：O(1)
  - 链表相关使用：
    - 链表结点：ListNode l1, ListNode l2 -- 头结点的位置
    - 判空：直接结点名与null比较 `l2 == null;`
    - 结点对应的值：`l1.val` -- 结点l1对应的值
    - 下一个结点：`l1.next` -- 结点1的下一个结点
    - 新建一个哨兵结点保存整个组合链表的地址，最后prehea.next方便返回最终值：`ListNode prehead = new ListNode(-1);`
      - `ListNode list=new ListNode()` ：初始化一个空节点，无值,不提倡此种写法。
      - `ListNode list=new ListNode(0)`：初始化一个节点值为0的空节点，最常用最正规写法
      - `ListNode list=null`：为空，什么都没有，一般不这么写；
      - 注：参数为结点值

- ## 代码链接：
  - [合并两个有序链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0021-merge-two-sorted-lists.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 26. 删除排序数组中的重复项
- ## 题目链接：
  - [remove-duplicates-from-sorted-array](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  
- ## 题目描述
  - 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
  - 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
  - 示例 1: 给定数组 nums = [1,1,2], 函数返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
    - 你不需要考虑数组中超出新长度后面的元素。
  - 示例 2: 给定 nums = [0,0,1,1,1,2,2,3,3,4], 函数返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
    - 你不需要考虑数组中超出新长度后面的元素。
  - 说明: 为什么返回数值是整数，但输出的答案是数组呢?
    - 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

- ## 解题思路
  - 思路：双指针
  - 双指针具体操作：
    - 数组完成排序后，放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。
      - i，j是数组索引值
      - 注：j负责遍历整个数组（循环），i负责控制新数组的长度（返回值）
    - 只要 nums[i] = nums[j]，就增加 j 以跳过重复项（j是快指针）；
      - 仅j增加，没有其他操作，可作为循环体中if判断的不成立情况，这时，每次循环仅j自增
    - 当 nums[j] != nums[i] 时，跳过重复项的运行已经结束；
      - 这种情况下，有后续操作，可作为循环体中if判断成立的情况，并把后续操作放在if语句中
    - 把 nums[j] 的值复制到 nums[i + 1]；
    - 然后递增 i，再次重复相同的过程，直到 j 到达数组的末尾为止。
    - 遍历结束后返回慢指针 i+1
  - 注意：
    - 返回值是最终无重复数组的长度
    - 双指针操作前，先判空：若长度为0，返回0
    - 针对已经排序好的数组进行的操作
    - 双指针不是双循环，j要遍历到末尾，因此j作为for循环指标，而i在循环体中，符合条件时增加
  - 复杂度分析
    - 时间复杂度：O(n)，假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
    - 空间复杂度：O(1)。

- ## 代码链接：
  - [删除排序数组中的重复项](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0026-remove-duplicates-from-sorted-array.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 27. 移除元素
- ## 题目链接：
  - [remove-element](https://leetcode-cn.com/problems/remove-element/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  
- ## 题目描述
  - 给定一个数组 nums 和一个值 val，原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
  - 不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
  - 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
  - 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
    - 你不需要考虑数组中超出新长度后面的元素。
  - 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
    - 注意这五个元素可为任意顺序。
    - 你不需要考虑数组中超出新长度后面的元素。
  - 说明:
    - 为什么返回数值是整数，但输出的答案是数组呢?
    - 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

- ## 解题思路
  - 思路：双指针（参考26题）
  - 双指针具体操作：
    - 保留两个指针 i 和 j，其中 i 是慢指针，j 是快指针。
    - 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。
    - 只要 nums[j] != val，就复制 nums[j] 到 nums[i] ，并同时递增两个索引。
    - 重复这一过程，直到 j 到达数组的末尾，该数组的新长度为 i。
  - 注意：
    - i是存放新数组的，i的每个值都保证不为val
    - 是与数组之外的值进行比较，因此i和j都从0开始遍历
    - if语句与26题的区别：先赋值给nums[i]，后i++，因为val是数组以为的值，不能保证已有的索引值符合
    - 返回值是i，因为 i 始终指向的是预备存储的位置，即比实际新数组的末尾更前一位
  - 当要删除元素很少时的双指针：
    - 注：这里的双指针不是快慢指针，是首尾指针，一前一后逼近
    - 若val只占1或2个，且在首、尾等位置时，为了避免不必要的操作，对原来双指针方法进行改进
    - 当遇到 nums[i] = valnums[i]=val 时，可以将当前元素与最后一个元素进行交换，并释放最后一个元素。
      - 这实际上使数组的大小减少了 1。
    - 请注意，被交换的最后一个元素可能是想要移除的值。但是不要担心，在下一次迭代中，仍然会检查这个元素

  - 复杂度分析
    - 时间复杂度：O(n)，假设数组总共有 n 个元素，i 和 j 至少遍历 2n 步。
    - 空间复杂度：O(1)。

- ## 代码链接：
  - [移除元素](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0027-remove-element.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 28. 实现strStr()
- ## 题目链接：
  - [implement-strstr](https://leetcode-cn.com/problems/implement-strstr/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  
- ## 题目描述
  - 实现 strStr() 函数。
  - 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
  - 如果不存在，则返回 -1。
  - 示例 1: 输入: haystack = "hello", needle = "ll"，输出: 2
  - 示例 2: 输入: haystack = "aaaaa", needle = "bba"，输出: -1
  - 说明:
    - 当 needle 是空字符串时，应当返回什么值呢？这是一个在面试中很好的问题。
    - 对于本题而言，当 needle 是空字符串时应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

- ## 解题思路
  - 思路：暴力法（超时）；kmp（未尝试）；indexOf()（直接用内置函数）
  - 题目标签是"字符串"和"双指针"，题解是kmp算法，但因为是简单题所以好多人用indexOf()
  - 双指针暴力解决会超时
  - 尝试用indexOf()解决：（一行代码）
  - public int indexOf(String str)
    - 返回指定子字符串在此字符串中第一次出现处的索引。
    - 返回的整数是  this.startsWith(str, k), 为 true 的最小 k 值。 
    - 参数：str - 任意字符串。 
    - 返回：
      - 如果字符串参数作为一个子字符串在此对象中出现，则返回第一个这种子字符串的第一个字符的索引；
      - 如果它不作为一个子字符串出现，则返回 -1。
      - (与题目要求完全相符)
  - 待续：
    - 以后可尝试用kmp算法或其他算法而不是碉堡侠

- ## 代码链接：
  - [实现strStr()](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0028-implement-strstr.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 35. 搜索插入位置
- ## 题目链接：
  - [search-insert-position](https://leetcode-cn.com/problems/search-insert-position/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  
- ## 题目描述
  - 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
  - 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
  - 假设数组中无重复元素。
  - 示例 1: 输入: [1,3,5,6], 5，输出: 2
  - 示例 2: 输入: [1,3,5,6], 2，输出: 1
  - 示例 3: 输入: [1,3,5,6], 7，输出: 4
  - 示例 4: 输入: [1,3,5,6], 0，输出: 0

- ## 解题思路
  - 思路：暴力法；二分查找
  - 暴力法：
    - 遍历并比较，直到`nums[i] < target`不再成立
  - 二分法：
    - 题目要求是排序数组中找目标值，考虑二分查找
    - 定义min, max, mid
    - mid不停与目标值比较，并进行相应的操作
      - 在min<max的情况下进行循环
      - 如果mid等于目标值，就返回mid
      - 如果mid大于目标值，就将mid-1的值赋给max并循环
      - 如果mid小于目标值，就将mid+1的值赋给min并循环
    - 注：常规二分法写出来会超时（无语...）
  - 内置二分查找函数：Arrays.binarySearch(nums, target)
  - 内置形式一：
    - 格式：`binarySearch(Object[], Object key)`
    - 参数：
      - 方法的object[]参数是要查找的数组，key参数为要查找的key值。
    - 返回值：
      - 1、找到的情况下：如果key在数组中，则返回搜索值的索引。
      - 2、找不到的情况下：
        - [1] 搜索值不是数组元素，且在数组范围内，从1开始计数，得“ - 插入点索引值”；
        - [2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
        - [3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
        - [4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
  - 内置形式二：
    - 格式：`binarySearch(Object[], int fromIndex, int toIndex, Object key)`
    - 参数：
      - 方法的object[]参数为要查找的数组，
      - fromindex参数为开始索引（包括），toindex为结束索引（不包括），两个参数之间为查找的范围。
      - key为要查找的key。
    - 返回值：
      - 1.找到的情况下：如果key在数组中，则返回搜索值的索引。
      - 2.找不到的情况下：
        - [1] 该搜索键在范围内，但不是数组元素，由1开始计数，得“ - 插入点索引值”；
        - [2] 该搜索键在范围内，且是数组元素，由0开始计数，得搜索值的索引值；
        - [3] 该搜索键不在范围内，且小于范围（数组）内元素，返回–(fromIndex + 1)；
        - [4] 该搜索键不在范围内，且大于范围（数组）内元素，返回 –(toIndex + 1)。
  - 返回值：
      - `int a = Arrays.binarySearch(nums, target);`
      - `if(a<0) a = - a - 1;`
      - `return a;`

- ## 代码链接：
  - [搜索插入位置](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0035-search-insert-position.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 38. 外观数列
- ## 题目链接：
  - [count-and-say](https://leetcode-cn.com/problems/count-and-say/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)

- ## 题目描述
  - 外观数列 是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
    - `1, 11, 21, 1211, 111221, ...`
    - 1 被读作  "one 1"  ("一个一") , 即 11。
    - 11 被读作 "two 1s" ("两个一"）, 即 21。
    - 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
  - 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
  - 注意：整数序列中的每一项将表示为一个字符串。
  - 示例 1: 输入: 1，输出: "1"，解释：这是一个基本样例。
  - 示例 2: 输入: 4，输出: "1211"
    - 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。

  
```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

- ## 解题思路
  - 思路：字符串
  - 本题的本质是计数器，本题的关键是理清数字规律，并将数学规律转为代码
    - 本题输入是int型，返回值是String型
    - 首先自定义n=1时，s="1"; 
    - 当n=1时直接返回；当n>=2时，再进行后续的复杂操作
      - 注：题目要求"正整数 n（1 ≤ n ≤ 30）"，故不作其他判断，甚至能用穷举法存入字典查表解决...
    - 两层循环：外循环控制行数，内循环遍历上一行生成的字符串并“报数”
    - 外循环：2-n（包含等于n），从2开始，n=1的情况直接返回
    - 内循环：
      - 从s的[0]开始设置"flag"-pre，计数器count，循环从1开始向后遍历，数(动词)与pre相等的个数，直到不再相等
      - 不相等的时候，调整pre为不再相等的位置的数字，并将count归为1，重新开始计数
  - 注：本题标签是字符串，考虑用可变字符串StringBuilder，最后toString()转为String形式
  - String 和 StringBuilder / StringBuffer
    - String是字符串常量，不可变
    - StringBuilder / StringBuffer是字符串变量，可变。
    - Buffer线程安全，慢；Build线程不安全，快
  - StringBuilder使用：
    - 新建：`StringBuilder str=new StringBuilder();`
    - 添加元素：`str.append(count).append(pre); ` -- 注：添加到str字符串的后面，即最右侧
    - 转为String型（即不可变型，或题目要求型）：`s=str.toString();`

- ## 代码链接：
  - [外观数列](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0038-count-and-say.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 53. 最大子序和
- ## 题目链接：
  - [maximum-subarray](https://leetcode-cn.com/problems/maximum-subarray/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [分治算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Divide%20and%20Conquer.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)
  
- ## 题目描述
  - 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
  - 示例: 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6
    - 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
  - 进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

- ## 解题思路
  - 思路：暴力法；动态规划；贪心；分治
  - 暴力法：
    - 复杂度：时间O(N^2)，空间O(1)
    - 寻找所有的可能子序和，并求最大值
    - 首先定义并初始化max为数组第一个元素
    - 按照一定规律遍历数组，比如从i开始遍历到末尾，不断取和，比较并取max，然后i++
    - 两层循环：外循环控制开始的i值，内循环控制在i索引开始，形成的子序列
  - 贪心：
    - 复杂度：时间O(n)，空间O(1)
    - 从左向右遍历，一个个数累加；当sum<0，重新开始找子序列
      - 所求最大值max可由if判断语句比较得到，也可由Math.max(i,j)直接求得
      - sum初始化为0，小于0的sum说明累加后比初始值更小了
      - "重新找"指的是：sum归0， 并从下一个元素起，重新累加
  - 动态规划：
    - 复杂度：时间O(n), 空间O(n)，可优化到O(1)
      - 只用到dp数组中的前一项，因此可以用int代替一维数组，对空间复杂度优化
    - dp[i]: nums中，以nums[i]结尾的最大子序和
    - dp[i]=max(dp[i-1]+nums[i], nums[i]);
  - 分治：
    - 复杂度：时间O(nlogn)，空间O(logn)
    - 取数组的中心点为中心，那么最大子序列要么在中心左，要么在右，要么跨中心
    - 分三种情况进行考虑
    - 跨中心的情况，又可以分治中心点左侧和右侧的最大子序列问题
    - 注：对比以上思路，分治的思路过于复杂，不详细分析了。
  - 注：
    - 类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值`max=Integer.MIN_VALUE;`
    - Integer是java.lang包下的，自动导入不用再手写import
    - Math是java.lang包下的，不用再手写import
    - 本题可以定义max为数组第一个元素，因为只是累加计算
    
- ## 代码链接：
  - [最大子序和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0053-maximum-subarray.java)


<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 58. 最后一个单词的长度
- ## 题目链接：
  - [length-of-last-word](https://leetcode-cn.com/problems/length-of-last-word/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)

- ## 题目描述
  - 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
  - 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
  - 英文：(last word means the last appearing word if we loop from left to right) in the string.
    - 由英文表述可知：是从左向右遍历字符串
  - 如果不存在最后一个单词，请返回 0 。
  - 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。

- ## 解题思路
  - 标签字符串的简单题
  - 因为是从左向右遍历，因此可以从末尾开始，即从最右侧的非空格开始计数
    - 需要考虑最右侧的空格和不是空格的情况
  - 初始化count为0，从length-1开始往回遍历，从非空格开始计数，当开始计数以后，且再次遇到空格时停止计数并返回
  - 需要考虑多种临界：比如单个字母返回1

- ## 代码链接：
  - [最后一个单词的长度](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0058-length-of-last-word.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 66. 加一
- ## 题目链接：
  - [plus-one](https://leetcode-cn.com/problems/plus-one/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述
  - 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
  - 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
  - 你可以假设除了整数 0 之外，这个整数不会以零开头。
  - 示例 1: 输入: [1,2,3],输出: [1,2,4] 
    - 解释: 输入数组表示数字 123。
  - 示例 2: 输入: [4,3,2,1], 输出: [4,3,2,2]
    - 解释: 输入数组表示数字 4321。

- ## 解题思路
  - 思路：其实是数学问题，即+1，存在一个“进位”与否的问题
    - 可能的情况就只有两种：除 9 之外的数字加一；数字 9。
    - 加一得十进一位个位数为 0 加法运算如不出现进位就运算结束了且进位只会是一。
    - 所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 1 个位数置为 0，如此循环直到判断没有再进位就退出循环返回结果。
    - 特殊情况：当出现 99、999 之类的数字时，循环到最后也需要进位，这时，只需手动将它进一位。
  - 关键：取余后判断是否为0，若为0，则有进位，继续循环；否则，直接返回数组
  - 从末尾开始遍历至索引值为0，遍历到的digits[i]+1后取余，然后判断；
  - 若循环结束后还没有返回，则可能是多个9的情况，直接新建长度+1的新数组，赋值第一个元素为1并返回

- ## 代码链接：
  - [加一](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0066-plus-one.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 67. 二进制求和
- ## 题目链接：
  - [add-binary](https://leetcode-cn.com/problems/add-binary/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)

- ## 题目描述
  - 给定两个二进制字符串，返回他们的和（用二进制表示）。
  - 输入为非空字符串且只包含数字 1 和 0。
  - 示例 1: 输入: a = "11", b = "1"，输出: "100"
  - 示例 2: 输入: a = "1010", b = "1011"，输出: "10101"

- ## 解题思路
  - 同66题，本题同样存在“进位”问题，不同的是本题是字符，且二进制
  - 不好的方法：用内置函数，将a和b转为十进制，求和，然后将结果转为二进制
    - 首先，关键步骤用内置函数就是刷流氓
    - 其次，转十进制容易溢出，不好的思路
  - 思路：逐位计算（位运算的方法要考虑过多的细枝末节，这里不详述）
  - 补0使两字符串长度相等，然后从末尾开始遍历，并不断添加结果，最后对结果进行反转
    - 补0：在遍历过程中判断，长度小于0时直接返回0
    - 添加：需要在字符串上添加，因此使用可变字符串StrinBuilder
    - 反转：添加顺序是每次在右侧添加，即不断将较高位添加到右侧，因此最后需要反转
  - 定义可变字符串res，进位标志flag
  - 循环：从末尾开始，同时遍历两个字符串，并在两字符串均遍历至第一个元素时终止循环（双或）
  - 赋值sum=flag，并分别取a和b两字符串的最右位累加到sum
  - 用三目运算符在判断的同时得到sum的值，其中先判断i和j是否大于等于0为了补0，`a.charAt(i)-'0'`根据字符距离得到相应数值计算结果
  - 之后对所得sum值判断：取余得到添加结果，整除得到flag的值
  - 返回时需要对最后一次循环后flag的值进行判断，之后反转，并转为String型
  - 注：本代码好几处把几句代码合并到一句的

- ## 代码链接：
  - [二进制求和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0067-add-binary.java)


<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 69. x的平方根
- ## 题目链接：
  - [sqrtx](https://leetcode-cn.com/problems/sqrtx/)
  
- ## 题目标签：
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)

- ## 题目描述
  - 实现 int sqrt(int x) 函数。
  - 计算并返回 x 的平方根，其中 x 是非负整数。
  - 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
  - 示例 1: 输入: 4，输出: 2
  - 示例 2: 输入: 8，输出: 2
    - 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

- ## 解题思路
  - 思路：二分；牛顿迭代法
    - 注：二分是程序员的正常思路，牛顿迭代法是利用数学中的一个结论
    - 牛顿法是近似求根的经典方法，会更快
  - 二分：
    - 复杂度：时间O(logn), 空间O(1)
    - 当 x≥2 时，它的整数平方根一定小于 x/2 且大于 0，即 0<a<x/2。由于 a 一定是整数，此问题转换成在有序整数集中寻找一个特定值
    - 如果 x < 2，返回 x。
    - 定义将要使用的变量，注意保存平方的变量定义为long防止溢出
    - 令左边界为 2，右边界为 x/2。
    - 循环：当 left <= right 时：
      - 令 pivot = (left + right) / 2，long num 为pivot的平方，比较 num * num 与 x：
        - 注：防止溢出，化简二分的求和为减法 -- `pivot = left + (right - left) / 2;``
      - 如果 num > x，更新右边界为 right = pivot -1。
      - 如果 num < x，更新左边界为 left = pivot + 1。
      - 如果 num == x，即整数平方根为 num，返回 num。
    - 返回 right。
  - 牛顿迭代法：
    - 复杂度：时间O(logn), 空间O(1)
    - 一种在实数域和复数域上近似求解方程的方法
    - 求开平方，即求c(c>=0)的算术平方根，等同于求f(x)=x^2-c的正根，得迭代公式x(n+1) = 0.5 * ( x(n) + c/x(n) )
    - 本题向下取整，x(i+1)-x(i)的误差控制在1以内，最后当误差小于 1 时结束迭代。
    - 注意：
      - x0 和 x1定义为double型
      - 为避免引入过多变量，可只使用x0和x1，而在循环体中，将这两个变量赋新值
      - 循环结束后，将x1转换为int型后返回 
      
- ## 代码链接：
  - [x的平方根](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0069-sqrtx.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 70. 爬楼梯
- ## 题目链接：
  - [climbing-stairs](https://leetcode-cn.com/problems/climbing-stairs/)
  
- ## 题目标签：
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)

- ## 题目描述
  - 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
  - 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
  - 注意：给定 n 是一个正整数。
  - 示例 1：输入：2，输出：2
  - 示例 2：输入：3，输出：3

- ## 解题思路
  - 爬楼梯是典型的动态规划问题，已知开始两项可利用公式计算出所有`f(n) = f(n-1) + f(n-2)`
  - 思路：暴力法（直接调用本体）；动态规划法（用dp数组保存结果）；斐波那契数法（用）
    - 暴力法：直接调用本体，过多的重复操作，复杂度过高
    - 动态规划法：用dp数组保存结果，相比上一种方法改进了时间复杂度
    - 斐波那契数法：不用数组，而用几个变量在循环体中不断更新，相比上一种方法节约了空间
  - 暴力法：
    - 复杂度：时间O(2^n)，空间O(n)
    - 前两项直接返回结果，其他调用本体函数：`return climbStairs(n-1) + climbStairs(n-2);`
    - 是最直接的思路，但是由于中间有太多重复操作，比如某个i，会在调用中计算多次
  - 动态规划法：
    - 复杂度：时间O(n)，空间O(n)
    - 改进：引入数组 dp[] 来保存计算得到的中间值，避免冗余 
    - `dp[i]=dp[i−1]+dp[i−2]`
    - 注：数组索引值0不赋值，因此定义数组长度为n+1；
    - 易错：因为有给数组索引值1和2的位置赋值操作，特别注意数组越界问题，赋值前一定加判断n==1和n==2
  - 斐波那契数法：
    - 复杂度：时间O(n)，空间O(1)
    - 改进：用变量更新代替数组，改进了空间复杂度
    - 易错：最终b==c，但是c是定义在循环体中的，循环结束就释放了，因此返回b，特别注意

- ## 代码链接：
  - [爬楼梯](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0070-climbing-stairs.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 83. 删除排序链表中的重复元素
- ## 题目链接：
  - [remove-duplicates-from-sorted-list](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
  
- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)

- ## 题目描述
  - 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
  - 示例 1: 输入: 1->1->2，输出: 1->2
  - 示例 2: 输入: 1->1->2->3->3，输出: 1->2->3

- ## 解题思路
  - 思路：简单链表操作
  - 因为是已排序链表，因此只需比较next值，相同则更新next，不同则更新current
    - 相同时next指向next的next，不同时移动当前结点current到它的next
  - 注意是head，不是current，current相当于for循环中的int i
  
- ## 代码链接：
  - [删除排序链表中的重复元素](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0083-remove-duplicates-from-sorted-list.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 88. 合并两个有序数组
- ## 题目链接：
  - [merge-sorted-array](https://leetcode-cn.com/problems/merge-sorted-array/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述
  - 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
  - 说明:
    - 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    - 假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
  - 示例:
    - 输入:
    - nums1 = [1,2,3,0,0,0], m = 3
    - nums2 = [2,5,6],       n = 3
    - 输出: [1,2,2,3,5,6]

- ## 解题思路
  - 相似题目：（0021-合并两个有序链表）
  - 思路：暴力法；双指针从前遍历；双指针从后遍历
  - 暴力法
    - 先复制数组2到数组1，后排序
    - 复杂度：时间O((m+n)log(m+n))，空间O(1)
  - 双指针从前往后：
    - 先把数组1存起来，然后选值存入数组1，最后如果仍有剩余，直接存入
    - 复杂度：时间O(n)，空间O(n)
  - 双指针从后往前：
    - 改进：优化了空间复杂度，不用另外存数组1
    - 复杂度：时间O(n)，空间O(1)
  - System.arraycopy()复制数组：src复制到dest
    -  arraycopy(Object src,int srcPos,Object dest, int destPos,int length)
    - src：源数组；dest：目标数组
    - Pos：位置；srcPos：源数组的起始位置；destPos：目标数组的起始位置
    - length：复制的长度
  - 注意
    - 数组是引用型数据变量，操作即改变本体，不需要return，结果保存在数组1中即可  
    - 本身不难，但要特别注意临界值
  
- ## 代码链接：
  - [合并两个有序数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0088-merge-sorted-array.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 100. 相同的树
- ## 题目链接：
  - [same-tree](https://leetcode-cn.com/problems/same-tree/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)

- ## 题目描述
  - 给定两个二叉树，编写一个函数来检验它们是否相同。
  - 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
  - 图和示例略，具体而言，是按“中-左-右”的顺序对两棵树进行遍历和判断是否相等

- ## 解题思路
  - 思路：递归；迭代
    - 注：标签里有“深度优先搜索”，dfs分为递归和非递归，递归比较顺手...
  - 递归：
    - 复杂度：时间O(n)，平衡二叉树是最优为O(logn)，空间O(n)
    - 先判断根节点是否相同，在调用本体分别对左节点和右节点进行判断
    - 首先：判空，即全空true，一空false
    - 根节点的值判断是否相等：不等false，相等返回对左和右的调用本体结果
  - 迭代：
    - 复杂度：时间O(n)，平衡二叉树是最优为O(logn)，空间O(n)
    - 从根开始，每次迭代将当前结点从双向队列中弹出。然后判断：非空且值相等时，压入子结点
    - 注：代码太多了，用递归就好

- ## 代码链接：
  - [相同的树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0100-same-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 101. 对称二叉树
- ## 题目链接：
  - [symmetric-tree](https://leetcode-cn.com/problems/symmetric-tree/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)
  - [广度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Breadth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，检查它是否是镜像对称的。注：数组层序遍历树。
  - 示例1：二叉树 [1,2,2,3,4,4,3] 是对称的。
  - 示例2：二叉树 [1,2,2,null,3,null,3] 则不是镜像对称的:
  - 图略

- ## 解题思路
  - 思路：递归；迭代
  - 递归
    - 复杂度：时间O(n)，空间O(n)
    - 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
    - 如果同时满足下面的条件，两个树互为镜像：
      - 它们的两个根结点具有相同的值。
      - 每个树的右子树都与另一个树的左子树镜像对称。
    - 定义镜像函数：
      - 判空：全空；一空一不空；
      - 根结点相等时，返回调用本体判断（结点1的左和结点2的右）以及（结点1的右和结点2度左）；
      - 注：借鉴100题的递归优化方法先判全空，后判根结点值相等，最后false这种设置可能用空指针异常，判相等一定记得 && 全不空
  - 迭代
    - 复杂度：时间O(n)，空间O(n)
    - 利用队列进行迭代。队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束
     - 注：代码太多了，用递归就好

- ## 代码链接：
  - [对称二叉树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0101-symmetric-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 104. 二叉树的最大深度
- ## 题目链接：
  - [maximum-depth-of-binary-tree](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，找出其最大深度。
  - 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
  - 说明: 叶子节点是指没有子节点的节点。
  - 示例：给定二叉树 [3,9,20,null,null,15,7]，则最大深度为3（层序遍历树表示为数组）

- ## 解题思路
  - 思路：递归；迭代
  - 递归
    - 复杂度：时间O(n)，空间O(n)
    - 规律：树的高度 = 1 + max(左子树的高，右子树的高)
    - 算法：首先判空；其次返回调用本体的左右子树的高，取得max值，并且+1后返回
    - 注：可以看作是深度优先搜索DFS
  - 迭代
    - 复杂度：时间O(n)，空间O(n)
    - 在栈的帮助下将上面的递归转换为迭代。
    - 使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
    - 从包含根结点且相应深度为 1 的栈开始。然后继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。
    - 具体代码略
    
- ## 代码链接：
  - [二叉树的最大深度](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0104-maximum-depth-of-binary-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 107. 二叉树的层次遍历II
- ## 题目链接：
  - [binary-tree-level-order-traversal-ii](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [广度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Breadth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
  - 例如：
    - 给定二叉树 [3,9,20,null,null,15,7],（中-左-右层序遍历）
    - 返回其自底向上的层次遍历为：[ [15,7], [9,20], [3] ]

- ## 解题思路
  - 参考102题：二叉树的层次遍历([medium.md](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium.md))
  - 层序遍历，考虑广度优先
  - 与102题的区别：
    - 最后需要反转结果:`Collections.reverse(levels);`
  - 知识点：
    - Collections.copy()：对java list的复制
    - Collections.reverse()：对集合倒序
    - 集合反转使用：`Collections.reverse(res);`
    
- ## 代码链接：
  - [二叉树的层次遍历II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0107-binary-tree-level-order-traversal-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 108. 将有序数组转换为二叉搜索树
- ## 题目链接：
  - [convert-sorted-array-to-binary-search-tree](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)

- ## 题目描述
  - 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
  - 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
  - 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
  - 示例: 给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]

- ## 解题思路
  - ### 基础知识补充：
    - 遍历树的方法。DFS：先序遍历，中序遍历，后序遍历；BFS。
    - 二叉搜索树的中序遍历是一个升序序列。将有序数组作为输入，可以把该问题看做根据中序遍历序列创建二叉搜索树。
    - 中序遍历不能唯一确定一棵二叉搜索树。
    - 先序和后序遍历不能唯一确定一棵二叉搜索树。
    - 先序/后序遍历和中序遍历的关系：`inorder = sorted(postorder) = sorted(preorder)`
    - 中序+后序、中序+先序可以唯一确定一棵二叉树。
    - 高度平衡意味着每次必须选择中间数字作为根节点。
      - 这对于奇数个数的数组是有用的，但对偶数个数的数组没有预定义的选择方案。
      - 对于偶数个数的数组，要么选择中间位置左边的元素作为根节点，要么选择中间位置右边的元素作为根节点，不同的选择方案会创建不同的平衡二叉搜索树。方法一始终选择中间位置左边的元素作为根节点，方法二始终选择中间位置右边的元素作为根节点。方法一和二会生成不同的二叉搜索树，这两种答案都是正确的。
  - ### 中序遍历：始终选择中间位置左边元素作为根节点
    - 复杂度：时间O(n)，空间O(n)
    - 中间左：向下取整，整除2即可取小。具体地，被除数为奇数时向下取整，被除数为偶数时可以整除直接返回得数
    - 方法 helper(left, right) 使用数组 nums 中索引从 left 到 right 的元素创建 BST：
      - 如果 left > right，子树中不存在元素，返回空。
      - 找出中间元素：p = (left + right) // 2。
      - 创建根节点：root = TreeNode(nums[p])。
      - 递归创建左子树 root.left = helper(left, p - 1) 和右子树 root.right = helper(p + 1, right)。
    - 返回 helper(0, len(nums) - 1)。
  - ### 中序遍历：始终选择中间位置右边元素作为根节点
    - 复杂度：时间O(n)，空间O(n)
    - 中间右：在中间左的取平均基础上，加一个判断，如果被除数是奇数，整除会向下取整，因此手动mid++
    - 注意：因为数组索引值从0开始，因此偶数个时，
  - ### 中序遍历：选择任意一个中间位置元素作为根节点
    - 复杂度：时间O(n)，空间O(n)
    - 左右随机：在中间左的取平均基础上，加一个判断，如果被除数是奇数，整除会向下取整，因此手动mid随机取+0或+1
    - 取随机数代码：
      - `Random rand = new Random();`
      - `if ((left + right) % 2 == 1) mid += rand.nextInt(2);`

- ## 代码链接:
  - [将有序数组转换为二叉搜索树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0108-convert-sorted-array-to-binary-search-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 110. 平衡二叉树
- ## 题目链接：
  - [balanced-binary-tree](https://leetcode-cn.com/problems/balanced-binary-tree/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，判断它是否是高度平衡的二叉树。
  - 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
  - 示例 1: 给定二叉树 [3,9,20,null,null,15,7]，返回 true 。
  - 示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]，返回 false 。

- ## 解题思路
  - 思路：dfs -- 自顶向下，自底向上
  - 平衡二叉树（Balanced Binary Tree）具有以下性质：
    - 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1
    - 并且左右两个子树都是一棵平衡二叉树。
    - 注：子树也是平衡树在题目中没有说，但是具有此性质，判断时需要判断左右子树也平衡才行
  - 自顶向下：
    - 复杂度：时间O(nlogn)，空间O(n)
    - 算法：判空返回真；调用height函数判断子树高度差<2,以及调用本体函数判断左右子树是否平衡
    - height函数：判空返回-1，否则返回1+max(root.left的高度,root.right的高度)
      - 注：-1与高度值区分，最大子树高度+1是指加上子树到根结点这层
    - 注意：
      - 减法：要取绝对值，否则可能是负数 `Math.abs()`
  - 自底向上：
    - 复杂度：时间O(n)，空间O(n)
    - 方法一计算 height 存在大量冗余。每次调用 height 时，要同时计算其子树高度。但是自底向上计算，每个子树的高度只会计算一次。可以递归先计算当前节点的子节点高度，然后再通过子节点高度判断当前节点是否平衡，从而消除冗余。
    - 算法：
      - 使用与方法一中定义的 height 方法。逻辑相反，首先判断子树是否平衡，然后比较子树高度判断父节点是否平衡。
      - 算法如下：检查子树是否平衡。如果平衡，则使用它们的高度判断父节点是否平衡，并计算父节点的高度。
      - 当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
    
- ## 代码链接:
  - [平衡二叉树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0110-balanced-binary-tree.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 111. 二叉树的最小深度
- ## 题目链接：
  - [minimum-depth-of-binary-tree](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)
  - [广度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Breadth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，找出其最小深度。
  - 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
  - 说明: 叶子节点是指没有子节点的节点。
  - 示例: 给定二叉树 [3,9,20,null,null,15,7],返回最小深度2

- ## 解题思路
  - 思路：dfs（递归，迭代）；bfs
  - 相似题目：104题 - 二叉树的最大深度
  - 易错：最小深度是从根节点到最近叶子节点的最短路径上的节点数。当左右子树都为空，最小深度才为1。[1,2]最小深度是2。
  - dfs递归：
    - 复杂度：时间O(n)，空间O(n)
    - 规律：树的最小深度 = 1 + min(左子树的深度，右子树的深度)
    - 算法：首先判空；其次返回调用本体的左右子树的高，取得min值，并且+1后返回
      - 判空：根结点为null时返回0，根结点的左右子结点全为null时返回1（仅一子树为空时，返回>1，需要再判断）
    - 注意：初始化变量min时，应初始化为一个较大的数，否则会出错。此时，最好设为范围内最值`Integer.MAX_VALUE`
  - 其余两种方法复杂度相同，代码略 

- ## 代码链接:
  - [二叉树的最小深度](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0111-minimum-depth-of-binary-tree.java)
  
<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->





# 112. 路径总和
- ## 题目链接：
  - [path-sum](https://leetcode-cn.com/problems/path-sum/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [深度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Breadth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
  - 说明: 叶子节点是指没有子节点的节点。
  - 示例: 
    - 给定如下二叉树[5,4,8,11,null,13,4,7,2,null,null,null,1]，以及目标和 sum = 22
    - 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

- ## 解题思路
  - 思路：递归；迭代
  - 注意：题目返回值类型是布尔型，即找到是否存在此类路径即可，不需要求出对应路径
  - 递归：
    - 复杂度：时间O(n)，空间O(n)
    - 思路：sum值作为一个指标，遍历的同时，sum减去当前结点值；如果最后结果是0，说明对应路径即为所求。
    - 遍历整棵树：
      - 如果当前节点不是叶子，对它的所有孩子节点，递归调用 hasPathSum 函数，其中 sum 值减去当前节点的权值；
      - 如果当前节点是叶子，检查 sum 值是否为 0，也就是是否找到了给定的目标和。
    - 算法：判空；更新sum值；当子树为空且sum==0时为真；否则继续调用本体函数判断子树的情况。
    - 注：子树判断为“双或”，即只要存在任一子树符合即可为真
  - 迭代
    - 复杂度：时间O(n)，空间O(n)
    - 具体：略

- ## 代码链接:
  - [路径总和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0112-path-sum.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 118. 杨辉三角
- ## 题目链接：
  - [pascals-triangle](https://leetcode-cn.com/problems/pascals-triangle/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述
  - 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
  - 在杨辉三角中，每个数是它左上方和右上方的数的和。每行生成方式为：首尾补1，其余位置为上一行两数相加。

- ## 解题思路
  - 思路：动态规划
  - “左上方和右上方的数的和”放在数组中即为正上方和斜前方，即上一行i-1和i的位置
  - 复杂度：时间O(n^2)，空间O(n^2)
  - 首先，生成整个 triangle 列表，三角形的每一行都以子列表的形式存储。
  - 然后，检查行数为 0 的特殊情况（直接返回triangle），否则返回 [1] （[1]只有一个元素，赋值为1）。
  - 循环遍历：
    - 外循环：控制行数，本行遍历结束后记得把本行结果添加到triangle
    - 内循环：控制每行的元素
  - 最后返回所得triangle
  - List知识点  
    - 新建：`List<List<Integer>> triangle = new ArrayList<List<Integer>>();`
    - 添加一位数组：新建并添加：
      - 外层List添加元素：直接add添加内层元素，参数新建内层List -- `triangle.add(new ArrayList<>());`
      - 内层List添加元素：先get(index)定位对应外层元素的索引值，然后跟着add(val)添加内层元素 -- `triangle.get(0).add(1);`
    - 取值用get(index)

- ## 代码链接:
  - [杨辉三角](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0118-pascals-triangle.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 119. 杨辉三角II
- ## 题目链接：
  - [pascals-triangle-ii](https://leetcode-cn.com/problems/pascals-triangle-ii/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  
- ## 题目描述
  - 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
  - 示例: 输入: 3，输出: [1,3,3,1]
  - 进阶：你可以优化你的算法到 O(k) 空间复杂度吗？

- ## 解题思路
  - 思路：动态规划；公式法(略)
  - 本题与118题的区别：118是生成所有，本体是生成最大行
  - 优化1:仅保留前一行即可，即二维List改为一维List
  - 优化2:倒着遍历可以节约空间，只定义一个List即可。否则需要定义一个pre的List，和一个cur的List
  - 非负索引k：不需要考虑0，直接从1开始算起
  - 算法：新建一维List；添加第0行元素1；循环：外层行数，内层倒着遍历并set()重置原有元素；返回一维List。
  - 注意：根据示例，3对应[1,3,3,1]，即从第0行开始算起；不同于118题，根据示例，是从第1行开始算起的。
  - 知识点：set()
    - set(int index, E element)
    - 用指定元素替换列表中指定位置的元素（可选操作）。
    - 参数：index - 要替换的元素的索引; element - 要在指定位置存储的元素
    - 返回：以前在指定位置的元素
    - 注意：获取List已有元素用get() -- `cur.set(j, cur.get(j - 1) + cur.get(j));`
    
- ## 代码链接:
  - [杨辉三角II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0119-pascals-triangle-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->




# 121. 买卖股票的最佳时机
- ## 题目链接：
  - [best-time-to-buy-and-sell-stock](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)

- ## 题目描述
  - 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  - 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
  - 注意你不能在买入股票前卖出股票。
  - 示例 1: 输入: [7,1,5,3,6,4]，输出: 5
    - 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    - 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
  - 示例 2: 输入: [7,6,4,3,1]，输出: 0
    - 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0

- ## 解题思路
  - 思路：暴力法；一次遍历
  - 暴力法：
    - 复杂度：时间O(n^2)，空间O(1)
    - max初始化为0(至少为0)；
    - 两次遍历：外层控制开始位置，内层比较从开始位置往后的值，并不断更新减去开始结点所得的最大值。
    - 最终返回max。
  - 一次遍历：
    - 复杂度：时间O(n)，空间O(1)
    - 思路：找到最小的谷之后的最大的峰
    - 维持两个变量 - minprice 和 maxprofit，它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。
    - 算法：定义两个最值并初始化；遍历：先小后大 - 当[i]值更小时，更新min，否则，比较[i]-min与max的大小并更新max；返回max。
    
- ## 代码链接:
  - [买卖股票的最佳时机](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0121-best-time-to-buy-and-sell-stock.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 122. 买卖股票的最佳时机II
- ## 题目链接：
  - [best-time-to-buy-and-sell-stock-ii](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [贪心算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Greedy.md)

- ## 题目描述
  - 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  - 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
  - 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
  - 示例 1: 输入: [7,1,5,3,6,4]，输出: 7
    - 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    - 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
  - 示例 2: 输入: [1,2,3,4,5]，输出: 4
    - 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    - 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
  - 示例 3: 输入: [7,6,4,3,1]，输出: 0
    - 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

- ## 解题思路
  - 思路：暴力法；贪心；
  - 暴力法：（dfs递归）
    - 复杂度：时间O(n^n)，空间O(1)
    - 两层遍历，外层控制开始位置，内层验证所有情况并找到最值。（计算与所有可能的交易组合相对应的利润，并找出它们中的最大利润）
    - 定义calculate函数，传入数组和起始位置参数，并在符合条件时递归调用本体
    - 注：参考官方题解写了一份代码，最后意料之中的超时了。超时也是错误，迷惑行为大赏....PS本篇官方题解就是屎
  - 贪心：
    - 复杂度：时间O(n)，空间O(1)
    - 股票买卖策略：
      - 单独交易日：设今天价格 p1 、明天价格 p2 ，则今天买入、明天卖出可赚取金额 p2−p1 (负值代表亏损）。
      - 连续上涨交易日：设此上涨交易日股票价格分别为 p1,p2,...,pn ，则第一天买最后一天卖收益最大，即 pn−p1 ；等价于每天都买卖，即 pn−p1=(p2−p1)+(p3−p2)+...+(pn−pn−1)。
      - 连续下降交易日：则不买卖收益最大，即不会亏钱。
    - 算法流程：
      - 遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
      - 设 tmp 为第 i-1 日买入与第 i 日卖出赚取的利润，即 tmp = prices[i] - prices[i - 1]；
      - 当该天利润为正 tmp > 0，则将利润加入总利润 profit；当利润为 0 或为负，则直接跳过；
      - 遍历完成后，返回总利润 profit。
    - 这篇写得很清晰，比云里雾里的官方题解好多了。  

- ## 代码链接:
  - [买卖股票的最佳时机II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0122-best-time-to-buy-and-sell-stock-ii.java)
  
<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->
 


# 125. 验证回文串
- ## 题目链接：
  - [valid-palindrome](https://leetcode-cn.com/problems/valid-palindrome/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)

- ## 题目描述
  - 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
  - 说明：本题中，我们将空字符串定义为有效的回文串。
  - 示例 1: 输入: "A man, a plan, a canal: Panama"，输出: true
  - 示例 2: 输入: "race a car"，输出: false

- ## 解题思路
  - 思路：双指针
  - 复杂度：时间O(n)，空间O(1)
  - 分析：
    - 不区分大小写：先转为小写 `s = s.toLowerCase();`
    - 按顺序处理字符串的每个字符：字符串转为字符数组 `char[] chs = s.toCharArray();`
    - 不计除了字母和数字之外的字符：判断字符是否在字母或者数字的范围内，不在时直接略个这个字符
    - 最后如果没有出现不相等的情况，则返回true
  - 算法：转为小写；转为字符数组；双指针遍历：当遇到非数字和非字母的字符时指针指向下一个位置，之后判断两指针对应的字符是否相等；返回结果。
  - 字符串知识点：
    - 转为小写 `s = s.toLowerCase();`
    - 字符串转为字符数组 `char[] chs = s.toCharArray();`
    
- ## 代码链接:
  - [验证回文串](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0125-valid-palindrome.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 136. 只出现一次的数字
- ## 题目链接：
  - [single-number](https://leetcode-cn.com/problems/single-number/)
  
- ## 题目标签：
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  - [位运算](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Bit%20Manipulation.md)

- ## 题目描述
  - 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
  - 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
  - 示例 1: 输入: [2,2,1]，输出: 1
  - 示例 2: 输入: [4,1,2,1,2]，输出: 4

- ## 解题思路
  - 思路：暴力法；排序；哈希表；异或
  - 分析题目：非空，整数，并有一个元素一次，其他两次。
  - 暴力法：
    - 复杂度：时间O(n^2)，空间O(n)，不需要额外空间
    - 每次从数组中取一个数，记为cur，然后从剩下的数中查找，如果找不到，则cur即为要找的那个数
    - 两层循环：外层控制起始比较的标准，内层控制从起始结点起到末尾为止的所有元素
  - 排序：
    - 优化暴力法：先排序，后快慢指针
  - 哈希表
    - 复杂度：时间O(n)，空间O(n)
    - 哈希表有较多思路，比如遍历，当有对应i时remove，没有时add等等，但需要用到库函数。
    - 这里记录一种引入count计数，并两次for循环的方法。其中两次循环均以数组对应元素nums[i]作为key，count作为value
    - 算法：
      - 新建哈希表；
      - 第一次遍历：定义count，get()传入nums[i]并判断get结果是否为null，如果为null，则count==1；否则count=1+get()结果，最后将nums[i]和count用put()放入哈希表
      - 第二次遍历：验证nums[i]作为key，对应的count值是否为1，为1时返回对于nums[i]值
      - 注：根据题目，非空数组，且必存在符合条件的出现一次的数，因此所给的用例一定在上一步返回，但是！！这里不写return会报错，虽然上一步会找到并返回，但是不写return时，程序有逻辑错误。PS：因为所给的用例一定在上一步返回了，所有这里返回任意int型整数即可。
    - hashmap相关知识点：
      - 新建哈希表： `Map<Integer, Integer> map = new HashMap<>();`
      - `get(Object key)` -- 返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null。
      - `put(K key, V value)` -- 在此映射中关联指定值与指定键。
      - `containsKey(Object key)` -- 如果此映射包含对于指定键的映射关系，则返回 true。
      - `containsValue(Object value)` -- 如果此映射将一个或多个键映射到指定值，则返回 true。
      - `remove(Object key)` -- 从此映射中移除指定键的映射关系（如果存在）。
      - 注：哈希表函数的参数大部分是针对key的
  - 异或： 
    - 位运算，求异，即找不同，相同为0，不同为1。且：0和0为0，0和1为1，而1和1为0.
    - 交换律：`a ^ b ^ c <=> a ^ c ^ b`
    - 任何数与0异或为任何数 `0 ^ n => n` -- 与0运算时，有1即为1，否则为0.
    - 相同的数异或为0: `n ^ n => 0`
    - 示例：
      - var a = [2,3,2,4,4]，
      - `2 ^ 3 ^ 2 ^ 4 ^ 4` 等价于 `2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3`
    - 算法：定义一个变量a，并初始化为nums[0]；从nums[1]开始遍历，在循环体中不断异或`a=a^nums[i]`；返回遍历结束后返回a
      
- ## 代码链接:
  - [只出现一次的数字](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0136-single-number.java)
  
<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 141. 环形链表
- ## 题目链接：
  - [linked-list-cycle](https://leetcode-cn.com/problems/linked-list-cycle/)
  
- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)

- ## 题目描述
  - 给定一个链表，判断链表中是否有环。
  - 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
  - 对于题目中所给的“pos”却没有用到的迷惑行为： 
    - pos是给官方代码生成环形链表的
    - 生成后的链表即代码模版中的head
    - 你只需要判断这个链表是否环形
    - 注意理解题意

- ## 解题思路
  - 思路：哈希表；双指针
  - 哈希表：
    - 复杂度：时间O(n)，空间O(n)
    - 思路：可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
    - 分析：遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
      - 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
      - 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
    - 注：哈希表有hashmap和hashset两种，hashmap存储键值对，而hashset存储对象。本题仅需要存储各个结点，因此选择hashset
    - 算法：新建hashset；遍历链表直到next为null(即达到尾结点)：验证，已存在则返回true，否则更新到下一结点；遍历结束后仍没有返回时，返回false。
    - hashset()相关知识点：
      - 新建： `Set<ListNode> nodesSeen = new HashSet<>();`
      - `add(E e)` ：如果此 set 中尚未包含指定元素，则添加指定元素。
      - `contains(Object o)` ：如果此 set 包含指定元素，则返回 true。注意contains有s
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
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 155. 最小栈
- ## 题目链接：
  - [min-stack](https://leetcode-cn.com/problems/min-stack/)
  
- ## 题目标签：
  - [栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Stack.md)
  - [设计](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Design.md)

- ## 题目描述
  - 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
  - push(x) -- 将元素 x 推入栈中。
  - pop() -- 删除栈顶的元素。
  - top() -- 获取栈顶元素。
  - getMin() -- 检索栈中的最小元素。
  - 示例:
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
``` 

- ## 解题思路
  - 注：本题重点是getMin()，因此可以考虑借用现成栈实现，相当于重写功能
  - 思路：两个栈；一个栈；不借用栈
  - 两个栈：
    - 用两个栈，一个栈去保存正常的入栈出栈的值，另一个栈去存最小值，也就是用栈顶保存当前所有元素的最小值。
    - 存最小值的栈的具体操作流程如下：
      - 将第一个元素入栈。
      - 新加入的元素如果大于栈顶元素，那么新加入的元素就不处理。
      - 新加入的元素如果小于等于栈顶元素，那么就将新元素入栈。
      - 出栈元素不等于栈顶元素，不操作。
      - 出栈元素等于栈顶元素，那么就将栈顶元素出栈。
  - 一个栈：
    - 只用一个变量去保存最小值，这时的关键是：如何保留最小值的记录（如果最小值弹出了，就会用到历史的最小值）
    - 解决：当有更小的值来的时候，只需要把之前的最小值入栈，当前更小的值再入栈即可。当这个最小值要出栈的时候，下一个值便是之前的最小值了。
    - 注意：push()中的if判断需要包含等于：因为如果此时的x弹出，最小值仍是原来的那个。如果等于就不压栈，那么一旦弹出，原相等的最小值就没了。
      - 等于不会死循环，这里的push是库函数不是上面的push
  - 栈相关知识点
    - empty()：测试堆栈是否为空。
    - peek()： 查看堆栈顶部的对象，但不从堆栈中移除它。
    - pop()：  移除堆栈顶部的对象，并作为此函数的值返回该对象。
    - push(E item)： 把项压入堆栈顶部。
    - search(Object o)：返回对象在堆栈中的位置，以 1 为基数（指栈顶元素的位置为1）。
    
- ## 代码链接:
  - [最小栈](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0155-min-stack.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->
  


# 160. 相交链表
- ## 题目链接：
  - [intersection-of-two-linked-lists](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)
  
- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)

- ## 题目描述
  - 编写一个程序，找到两个单链表相交的起始节点。
  - 注意：
    - 如果两个链表没有交点，返回 null.
    - 在返回结果后，两个链表仍须保持原有的结构。
    - 可假定整个链表结构中没有循环。
    - 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

- ## 解题思路
  - 思路：暴力法；哈希表法；双指针法
  - 方法一: 暴力法
    - 对链表A中的每一个结点 ai ，遍历整个链表 B 并检查链表 B 中是否存在结点和 ai 相同。
    - 复杂度分析：时间复杂度 : (mn)。空间复杂度 : O(1)。
  - 方法二: 哈希表法 
    - 遍历链表 A 并将每个结点的地址/引用存储在哈希表中。然后检查链表 B 中的每一个结点 bi 是否在哈希表中。若在，则 bi 为相交结点。
    - 复杂度分析：时间复杂度 : O(m+n)。空间复杂度 : O(m) 或 O(n)。
  - 方法三：双指针法 
    - 复杂度：时间O(m+n)，空间O(1)。
    - 思路：链表A：a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在第二个c起点相遇。若不相交，a+b = b+a 。因此相遇处是NULL（尾）
    - 算法：判空；新建结点；循环：两结点移动，直到相等。
    - 注：没有公共时，最后都指向null，此时相等，退出循环。因此不会死循环。
    - 代码使用了三目运算符，很巧妙。

- ## 代码链接:
  - [相交链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0160-intersection-of-two-linked-lists.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->
  


# 167. 两数之和II-输入有序数组
- ## 题目链接：
  - [two-sum-ii-input-array-is-sorted](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)
  
- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)

- ## 题目描述
  - 给定一个 已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
  - 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
  - 说明:
    - 返回的下标值（index1 和 index2）不是从零开始的。
    - 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
  - 示例:
    - 输入: numbers = [2, 7, 11, 15], target = 9
    - 输出: [1,2]
    - 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

- ## 解题思路
  - 分析：与1题的区别：数组是有序的。
    - 注：1题的解题思路包括暴力法；哈希表（两次哈希表；一次哈希表）
  - 思路：双指针与二分查找的结合
  - 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
    - 如果两个指针指向元素的和 sum==target，那么得到要求的结果；
    - 如果 sum>target，移动较大的元素，使 sum 变小一些；
    - 如果 sum<target，移动较小的元素，使 sum 变大一些。
  - 复杂度：时间O(N)，空间O(1)。
  - 算法：判空；定义两变量作为左右指针并初始化；循环直到(a<b)不再成立：比较sum与target并移动指针；最后返回null。
    - 循环条件(a<b)：题目要求index1必须小于index2
    - 找到时返回数组的索引值要+1：题目要求返回的下标值（index1 和 index2）不是从零开始的，是从1开始的。
  
- ## 代码链接:
  - [相交链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0167-two-sum-ii-input-array-is-sorted.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->
  


### END
