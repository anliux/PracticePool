# medium1
- 本文题号范围：1-100


# 目录
<!-- GFM-TOC -->
* [2. 两数相加](#2-两数相加)
* [3. 无重复字符的最长子串](#3-无重复字符的最长子串)
* [5. 最长回文子串](#5-最长回文子串)
* [6. Z字形变换](#6-z字形变换)
* []()
* []()
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

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"


- ## 代码链接：
  - []()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



### END
