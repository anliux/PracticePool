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
* [28. 实现strStr()](#28-实现strstr())
* []()
* []()
* []()
* []()
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
  - [remove-element](https://leetcode-cn.com/problems/remove-element/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  
- ## 题目描述
  - 

- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->



# 
- ## 题目描述


- ## 解题思路


- ## 代码链接：



<!-- GFM-TOC -->
* ## [返回顶部目录](#easy题目)
<!-- GFM-TOC -->





### END
