# medium1
- 本文题号范围：1-100


# 目录
<!-- GFM-TOC -->
* [2. 两数相加](#2-两数相加)
* [3. 无重复字符的最长子串](#3-无重复字符的最长子串)
* [5. 最长回文子串](#5-最长回文子串)
* [6. Z字形变换](#6-z字形变换)
* [8. 字符串转换整数atoi](#8-字符串转换整数atoi)
* [11. 盛最多水的容器](#11-盛最多水的容器)
* [12. 整数转罗马数字](#12-整数转罗马数字)
* [15. 三数之和](#15-三数之和)
<!-- GFM-TOC -->




# 2. 两数相加
- ## 题目链接：
  - [add-two-numbers](https://leetcode-cn.com/problems/add-two-numbers/)

- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
  - 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
  - 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  - 示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4), 输出：7 -> 0 -> 8, 原因：342 + 465 = 807

- ## 解题思路
  - 思路：模拟初等数学的加法运算
  - 分析：
    - 非空链表按照逆序，同初等数学加法计算从低位到高位，根据示例，结果也是逆序，最后不用反转；
    - 进位：两个数字相加（考虑到进位）可能出现的最大和为 9+9+1=19 ，使用变量carry来跟踪进位，并将carry带入下一次迭代；
    - 结果返回一个额外的链表，因此定义一个链表res来存储每一位，最后返回res.next
    - 边界情况：两链表长度不同；一链表为空；两链表最后一位仍然有进位..等等。
  - 算法：
    - 定义res链表结点并初始化，定义三个结点p，q，cur追踪两链表的移动和res链表的当前位置，定义进位carry
    - 循环直到两链表均为空:
      - 定义变量存储当前结点对应的值val，存储前需要判断当前结点是否为null，为空时返回0，可以用三目运算符；
      - 定义sum和将上述变量和进位carry的和，并整除计算进位carry；
      - 将整除取余结果存入新建结点并赋值给cur.next，然后将cur向后移动；
      - 判断p，q结点是否为空，不为空时p，q结点向后移动。
    - 循环结束后，判断最高位是否仍有进位，即carry是否大于0
    - 返回res.next链表
  - 链表知识点：
    - 新建链表结点：`ListNode dummyHead = new ListNode(0);`
    
- ## 代码链接：
  - [两数相加](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0002-add-two-numbers.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 3. 无重复字符的最长子串
- ## 题目链接：
  - [longest-substring-without-repeating-characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)
  - [滑动窗口](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Sliding%20Window.md)
  
- ## 题目描述
  - 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
  - 示例 1: 输入: "abcabcbb"，输出: 3。解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
  - 示例 2: 输入: "bbbbb"，输出: 1。解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
  - 示例 3: 输入: "pwwkew"，输出: 3。解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
  - 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

- ## 解题思路
  - 思路：暴力法；滑动窗口。
  - 暴力法：
    - 复杂度：O(n^3)，O(min(m,n)) -- 字符串 n 的大小以及字符集/字母 m 的大小。
    - 分析：
      - 假设有一个函数 boolean allUnique(String substring) ，如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false。
      - 遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。 如果事实证明返回值为 true，那么将会更新无重复字符子串的最大长度的答案。
      - 为了枚举给定字符串的所有子字符串，需要枚举它们开始和结束的索引。假设开始和结束的索引分别为 i 和 j。那么有 0≤i<j≤n（这里的结束索引 j 是按惯例排除的）。因此，使用 i 从 0 到 n−1 以及 j 从 i+1 到 n 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
      - 要检查一个字符串是否有重复字符，使用集合。
      - 遍历字符串中的所有字符，并将它们逐个放入 set 中。在放置一个字符之前，检查该集合是否已经包含它。如果包含，返回 false。循环结束后，返回 true。
    - 算法：
      - 定义判断左闭右开区间内是否符合各个字符唯一的函数allUnique；
      - 主函数内定义结果变量res并初始化为0；
      - 两层循环：外循环定义起始基准，内循环定义基准起到末尾的所有子串，并调用allUnique函数判断，为真时与res比较并将res更新为其中的最大值；
      - 返回res。
    - HashSet知识点：
      - 新建：`Set<Character> set = new HashSet<>();`
      - add(E e) ：如果此 set 中尚未包含指定元素，则添加指定元素。
      - contains(Object o) ：如果此 set 包含指定元素，则返回 true。
      - isEmpty() ：如果此 set 不包含任何元素，则返回 true。
      - size() ：返回此 set 中的元素的数量（set 的容量）。
  - 滑动窗口
    - 复杂度：O(n)，O(min(m,n)) -- 字符串 n 的大小以及字符集/字母 m 的大小。
    - 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 i到j（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 i-j左闭右开 向右滑动 1 个元素，则它将变为 i+1到j+1（左闭，右开）。
    - 分析：
      - 使用 HashSet 将字符存储在当前窗口  `[i,j)` 左闭右开（最初 j=i）中。 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i 这样做，就可以得到答案。
      - 优化：使用哈希map，如果 s[j] 在 `[i,j)` 范围内有与 j' 重复的字符，我们不需要逐渐增加 i ，直接跳过 [i，j′] 范围内的所有元素，并将 i 变为 j′+1。
      - HashMap：记录char的位置+1，便于窗口start位置的滑动
    - 算法：
      - 定义一个 map 存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
      - 定义不重复子串的开始位置为 start，结束位置为 end
      - 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
      - 无论是否更新 start，都会更新其 map 数据结构和结果 ans。

- ## 代码链接：
  - [无重复字符的最长子串](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0003-longest-substring-without-repeating-characters.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 5. 最长回文子串
- ## 题目链接：
  - [longest-palindromic-substring](https://leetcode-cn.com/problems/longest-palindromic-substring/)

- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Dynamic%20Programming.md)
  
- ## 题目描述
  - 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
  - 示例 1：输入: "babad"，输出: "bab"，注意: "aba" 也是一个有效答案。
  - 示例 2：输入: "cbbd"，输出: "bb"

- ## 解题思路
  - ### 思路：暴力匹配；动态规划；中心扩散；Manacher 算法。
    - “暴力匹配”是基础，“动态规划”必须掌握，“中心扩散” 要会写，“Manacher 算法”不用看
  - ### 暴力匹配：
    - 复杂度：O(n^3)，O(1)
    - 分析：
      - 根据回文子串的定义，枚举所有长度大于等于 2 的子串，依次判断它们是否是回文；
      - 在具体实现时，可以只针对大于“当前得到的最长回文子串长度”的子串进行“回文验证”；
      - 在记录最长回文子串的时候，可以只记录“当前子串的起始位置”和“子串长度”，不必做截取。
      - 暴力解法时间复杂度高，但是思路清晰、编写简单，可以作为基础来优化实现其他方法。
    - 算法：
      - 定义valid函数，用于判断left到right范围内的子串是否是回文串；
      - 主体函数中：边界值判断，字符串长度为0和1的直接返回s，即s.length()<2时；
      - 定义几个变量：最长子串的长度lens，最长子串结果res。字符串s可以用s.substring()截取；
      - 循环：两层遍历，外层控制起始基准，内层控制从基准开始到末尾的所有子串，并if进行判断并更新相应的变量数值；
      - 最内层if判断：如果当前子串的长度大于最长子串长度lens，并且valid为真，则更新lens，并将最长子串res更新为当前子串；
      - 循环结束后返回res。
    - 字符串相关知识点：
      - `substring(int beginIndex, int endIndex)` ：索引值左闭右开，返回一个新字符串，它是此字符串的一个子字符串。
      - `charAt(int index)` ：返回指定索引处的 char 值。
      - 注：substring是截取子串，charAt是返回字符串中的某一个字符，注意使用场景，以及返回值所存储到的变量的数据类型。
  - ### 动态规划：
    - 复杂度：O(n^2)，O(n^2)
      - 虽然以时间换空间，但是仍然需要两层循环来遍历整个字符串。
    - “动态规划”作为一种打表格法，是在用“空间”换“时间”。
    - 动态规划思考路径：状态？状态转移方程？初始化？输出？状态压缩？
    - 本题关键：
      - 在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质，这就是状态转移。
      - 因此可以把“状态”定义为原字符串的一个子串是否为回文子串。
      - dp[i][j] 表示子串 s[i, j] 是否为回文子串。
      - 状态转移方程：`dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]`
      - i 和 j 的关系是 i <= j ，因此，只需要填这张表的一半；
      - 边界条件是：表达式 [i+1, j-1] 不构成区间，即长度严格小于2，即 j-1-(i+1)+1<2，整理得 j-i<3。
        - 显然：当子串 s[i, j] 的长度等于2或者等于3的时候，只需要判断一下头尾两个字符是否相等就可以直接下结论了。
      - 找到时，仅记录
    - 算法：
      - 定义字符串长度lens，方便后面使用；判断边界条件：lens<2时
      - 定义布尔型二维数组`dp[][]`，（注：不需要初始化对角线为true，因为控制好i和j区间，对角线用不到，经测试可以ac）
      - 定义int遍历maxlens和start，并初始化start=0，maxlens=1，而不是0，因为回文串长至少是1，例如"ac"，返回"a"；
      - 两层循环遍历全部数组，因为遍历中会用到dp[i+1][j-1]，要注意遍历的顺序(不是常规那种)，否则遍历过程中会遇到dp[i+1][j-1]没有值的情况
        - 外循环：控制结尾j，内循环遍历从字符串索引0开始到结尾j的所有子串；（不是常规的外起始i，内从起始i到字符串末尾的方式）
      - 内循环体：两部分 - 首先，判断dp[i][j]的真假；其次，dp为真时更新记录最长子串信息的变量。
      - 最后截取子串并返回。
  - ### 中心扩散：
    - 复杂度：O(n^2)，O(1)
    - 中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
    - 回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
      - 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "b"；
      - 偶数回文串的“中心”是位于中间的两个字符的“空隙”，例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”；
      - 综上，遍历中心位置时，要同时计算 (i,i) 和 (i,i+1)，因此，for循环到length-2为止。
    - 算法：
      - 定义一个函数centerSpread，返回以left和right为中心扩散时的回文串
        - while在left和right没有超过字符串s的首尾时循环；
        - 循环体：if判断，相等时移动指针，不等时跳出循环；
        - 跳出循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取i和j，而substring是左闭右开的，取(i+1,j)
      - 主体函数：
        - 边界值s.length()=0和1时为真，返回s；
        - 定义最长子串res及其长度maxLens，并初始化，注意长度最小为1；
        - for循环遍历中心位置i，直到i<s.length()-1，因为循环体中会调用奇数和偶数两种扩散方式，防止角标越界；
        - 循环体中首先，分别定义奇数串和偶数串，并调用函数计算(i,i)和(i,i+1)作为中心的扩散结果；
        - 循环体重其次：取奇数串和偶数串中最长的一个作为maxLensStr，并与res的长度maxLens比较，更长时更新res及maxLens；
        - 循环结束后返回res。
  - ### Manacher(马拉车)算法：
    - Manacher算法本质上还是中心扩散法，只不过它使用了类似 KMP 算法的技巧，充分挖掘了已经进行回文判定的子串的特点，在遍历的过程中，记录了已经遍历过的子串的信息，也是典型的以空间换时间思想的体现。

- ## 代码链接：
  - [最长回文子串](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0005-longest-palindromic-substring.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 6. Z字形变换
- ## 题目链接：
  - [zigzag-conversion](https://leetcode-cn.com/problems/zigzag-conversion/)

- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  
- ## 题目描述
  - 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
  - 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，按照Z字排列
  - 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
  - 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
  - 示例 1: 输入: s = "LEETCODEISHIRING", numRows = 3，输出: "LCIRETOESIIGEDHN"
  - 示例 2: 输入: s = "LEETCODEISHIRING", numRows = 4，输出: "LDREOEIIECIHNTSG"

- ## 解题思路
  - 思路：按行排序
  - 本题关键：最后只需要按行输出，并不需要考虑中间的空格，即忽略空格，只要按Z字形将s铺在每一行即可
    - 注：如果找规律，然后使用二维数组把每个字符放到正确的位置，再输出，就走了弯路，没有看清本题的本质。
  - 复杂度：O(n)，O(n)
  - 分析：
    - 整体的思路是遍历字符串，遍历过程中将每行都看成新的字符串构成字符串数组，最后再将该数组拼接起来即可
    - 边界值：如果 numRows=1 则说明当前字符串即为结果，直接返回 s
    - 遍历整个字符串：向下向右，向下向右，反复循环
    - 设定 down 变量表示是否向下，loc 变量表示当前字符串数组的下标（down表示方向，loc表示所在行）
      - 如果 down 为 true，则 loc+=1，字符串数组下标向后移动，将当前字符加入当前字符串中
      - 如果 down 为 false，则表示向右，则 loc−=1，字符串数组下标向前移动，将当前字符加入当前字符串中
  - 算法：边界值-初始化-循环-拼接并返回。
    - 边界值处理：当numRows=1时，返回s；
    - 定义变量len为行数n和s长度的最小值：考虑如果s长度更小，只需要开辟更小的空间即可；
    - 定义长度为len的字符串数组，并初始化为空串 `""`；
    - 定义所在行的位置变量loc，定义布尔型变量down；
    - 循环：遍历字符串s，将每个字符放在正确的位置，根据down的真假更新loc的值，并截取s的子串添加到字符串数组的正确行；
    - 新建字符串res，并将上述字符串数组拼接起来，最后返回。
  
- ## 代码链接：
  - [Z字形变换](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0006-zigzag-conversion.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 8. 字符串转换整数atoi
- ## 题目链接：
  - [string-to-integer-atoi](https://leetcode-cn.com/problems/string-to-integer-atoi/)

- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)

- ## 题目描述
  - 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
  - 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
  - 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
  - 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
  - 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
  - 在任何情况下，若函数不能进行有效的转换时，请返回 0。
  - 说明：
  - 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,2^31−1]。如果数值超过这个范围，请返回INT_MAX(2^31−1)或INT_MIN (−2^31) 。
  - 示例 1: 输入: "42"，输出: 42
  - 示例 2: 输入: "   -42"，输出: -42.
    - 解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
  - 示例 3: 输入: "4193 with words"，输出: 4193.
    - 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
  - 示例 4: 输入: "words and 987"，输出: 0.
    - 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。
  - 示例 5: 输入: "-91283472332"，输出: -2147483648。
    - 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。因此返回 INT_MIN (−2^31) 。

- ## 解题思路
  - 思路：正则和非正则。
    - 非正则的话，本题就是考虑多种不同的边界情况然后用一堆if-else来完成，同时面向测试用例编程来完善代码；
    - 正则表达式解题：更快更简洁，但是不熟练。这里贴代码和思路。
  - 关键：本题需要考虑的情况比较多，要非常细心。例如测试题目所列情况以及下列情况：
    - "    -42" --> -42；" + 413" --> 0；"0-1" --> 0；"- 234" -- > 0；"-2147483648" --> -2147483648；"+1" --> 1等
  - 非正则：
    - 函数返回值是int型，在任何情况下，不能进行有效的转换时都返回 0；
    - 从非空格字符开始算起：`str.trim()`剪去空格
      - str.trim() ：返回字符串的副本，忽略前导空白和尾部空白；如果字符串是空串，则返回str。
    - 判空：字符串为null，或者字符串长度为0时返回 0；
    - 定义结果变量res=0，起始位start=0；
    - 取第一个字符并赋值给firstChar
    - 考虑结果的符号正负：定义符号变量sign=1，然后判断firstChar是否是正负号中的一个，如果不是，不操作，继续后续步骤；
    - 循环：遍历字符串直到末尾，同时逐个取字符进行判断
      - 如果不是数字，就结束循环并返回结果：`Character.isDigit(j)==false`时`return (int) res * sign;`
      - 将第i个字符转为数字并赋值给变量：`pop = str.charAt(i) - '0';`
      - 为防止溢出，对res的值进行越界判断：sign为1时，以及为-1时，分类讨论
      - 排除各种异常情况后，计算res的值：`res = (int) res*10 + pop;`
    - 循环结束后返回`return res * sign;`
    - 注：越界判断参考<easy-7题>
      - 对于正数部分：
        - 考虑常规：`rev > Integer.MAX_VALUE/10` 时，rev * 10 必定大于Integer的Max值，不符合条件
        - 考虑临界：`rev == Integer.MAX_VALUE / 10` 时，整除会削去个位的值，因此，若再乘以10，个位是0。这时再加某值，这个值需要小于MAX值的个位，否则越界。因此：`pop > Integer.MAX_VALUE % 10`
      - 对于负数部分：因为sign符号是return的时候再添加的，所以需要rev和pop在此处写为-rev和-pop
        - 同理：`rev < Integer.MIN_VALUE / 10， 以及 rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10`
  - 正则：
    - 参考题解评论区大佬的代码实现，虽然简洁但是奈何不会啊....
  - 正则表达式知识点：
    - 参考[菜鸟教程-正则表达式](https://www.runoob.com/java/java-regular-expressions.html)
    - `^[\\+\\-]?\\d+`
    - `^ 表示匹配字符串开头，我们匹配的就是 '+'  '-'  号`
    - `[] 表示匹配包含的任一字符，比如[0-9]就是匹配数字字符 0 - 9 中的一个`
    - `? 表示前面一个字符出现零次或者一次，这里用 ? 是因为 '+' 号可以省略`
    - `\\d 表示一个数字 0 - 9 范围`
    - `+ 表示前面一个字符出现一次或者多次，\\d+ 合一起就能匹配一连串数字了`

- ## 代码链接：
  - [字符串转换整数atoi](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0008-string-to-integer-atoi.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 11. 盛最多水的容器
- ## 题目链接：
  - [container-with-most-water](https://leetcode-cn.com/problems/container-with-most-water/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)

- ## 题目描述
  - 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
  - 说明：你不能倾斜容器，且 n 的值至少为 2。
  - 示例: 输入: [1,8,6,2,5,4,8,3,7]，输出: 49

- ## 解题思路
  - 思路：暴力法；双指针法
  - 暴力法：
    - 复杂度：时间O(n^2)，空间O(1)
    - 简单地考虑每对可能出现的线段组合并找出这些情况之下的最大面积
    - 算法：定义最大面积max；两层循环：外层控制起始基准，内层控制从基准到末尾的所有可能情况，计算并更新最大值；返回结果max。
  - 双指针法：
    - 复杂度：时间O(n)，空间O(1)
    - 关键：两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
    - 在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
    - 使用变量 maxarea 来持续存储到目前为止所获得的最大面积。 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxarea，并将指向较短线段的指针向较长线段那端移动一步。
    - 算法：
      - 定义双指针left和right，以及面积最大值max并初始化；
      - 循环直到两指针交错：计算当前指针构成的面积，并对max更新，然后移动较小的指针；
      - 最后返回结果max。

- ## 代码链接：
  - [盛最多水的容器](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0011-container-with-most-water.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 12. 整数转罗马数字
- ## 题目链接：
  - [integer-to-roman](https://leetcode-cn.com/problems/integer-to-roman/)

- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)

- ## 题目描述
  - 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
  - 对应关系：I: 1; V: 5; X: 10; L: 50; C: 100; D: 500; M: 1000
  - 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
  - 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    - I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    - X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    - C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
  - 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
    - 示例 1: 输入: 3，输出: "III"
    - 示例 2: 输入: 4，输出: "IV"
    - 示例 3: 输入: 9，输出: "IX"
    - 示例 4: 输入: 58，输出: "LVIII"。解释: L = 50, V = 5, III = 3.
    - 示例 5: 输入: 1994，输出: "MCMXCIV"。解释: M = 1000, CM = 900, XC = 90, IV = 4.

- ## 解题思路
  - 思路：贪心；哈希表。
    - 贪心的思想，哈希表的方法。
  - 参考<easy-13. 罗马数字转整数>，是本题的逆向，使用了查表发和相邻字符比较。
  - 分析：
    - 类型找零，用最少张数的纸币凑够所需的值，从最大的面值开始凑起。
    - 贪心或者哈希表法，都是围绕这一核心。其中哈希表可以用数组构建表的查表法替代。
    - 本题“整数转罗马数字”也有贪心类似的思想：
      - 在表示一个较大整数的时候，“罗马数字”的设计者不会让你都用 1 加起来；
      - 我们总是希望写出来的“罗马数字”的个数越少越好，以方便表示，并且这种表示方式还应该是唯一的。
    - 贪心算法的规则：每一步都使用当前较大的罗马数字作为加法因子，最后得到罗马数字表示就是长度最少的
    - 注意范围：int，且在 1 到 3999 的范围内。
  - 算法：
    - 复杂度：时间O(1)，空间O(1) -- 因为表的长度是有限的13个。
    - 首先：建表，使用两个数组模拟哈希表的键值对，一个数组values存放数字，一个数组strs存放数字对应的字母，数字按照从大到小的顺序；
      - 注意：strs数组赋值时，记得给字母加双引号。
    - 新建可变字符串StringBuilder，命名为res，用于存放转化为的字母；
    - 遍历数字数组：
      - 从头开始，整除结果quotient如果是0，continue直接结束本次循环并进入下一次循环；
      - 整除结果如果不是0，则对应到字符串数组中，并使用小循环将'商'次的对应字母添加到结果字符串；
      - 将num减去进行添加的`quotient * values[i]`；
      - 对num的值进行判断，为0时终止循环。
    - 返回结果：先转为String，然后返回。
    - 注意：对特殊值的处理是，将几个特殊值加入表中。

- ## 代码链接：
  - [整数转罗马数字](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0012-integer-to-roman.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 15. 三数之和
- ## 题目链接：
  - [3sum](https://leetcode-cn.com/problems/3sum/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)

- ## 题目描述
  - 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
  - 注意：答案中不可以包含重复的三元组。
  - 示例：给定数组 nums = [-1, 0, 1, 2, -1, -4]，
  - 满足要求的三元组集合为：[ [-1, 0, 1], [-1, -1, 2] ]

- ## 解题思路
  - 

- ## 代码链接：
  - [三数之和]()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->


### END
