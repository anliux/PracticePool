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
* [16. 最接近的三数之和](#16-最接近的三数之和)
* [17. 电话号码的字母组合](#17-电话号码的字母组合)
* [34. 在排序数组中查找元素的第一个和最后一个位置](#34-在排序数组中查找元素的第一个和最后一个位置)
* [39. 组合总和](#39-组合总和)
* [40. 组合总和II](#40-组合总和ii)
* [50. pow函数](#50-pow函数)
* [53. 最大子数组和](#53-最大子数组和)
* [54. 螺旋矩阵](#54-螺旋矩阵)
* [79. 单词搜索](#79-单词搜索)
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
  - 示例 1: 
    - 输入: "abcabcbb"，输出: 3。
    - 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
  - 示例 2: 
    - 输入: "bbbbb"，输出: 1。
     - 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
  - 示例 3: 
    - 输入: "pwwkew"，输出: 3。
    - 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
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
      - 使用双指针：
        - 左开右闭，来标记滑动窗口，左开不算在无重复字符串中，且在计算窗口大小时省去 -1 的步骤。
        - 左右指针在滑动时指向相同的字符：left指向哈希表存储的前一个位置，right指向后一个重复位置，并将最新位置保存在哈希表中
          - 左指针初始化为-1：保证最开始的right-left的正确性
          - 注意：左指针需要保证指向最靠近right的重复字符，因此可以用max方法筛选
        - 左指针赋值的过程：即为重新计算无重复子串的过程
      - 哈希表：
        - 使用字母-最后出现位置 的键值对 来标记各个字母
        - 重复的部分：没有用set，用键值对的key的唯一性来保证
      - 核心思想：
        - 左右指向重复字符，左开右闭，中间夹着的就是无重复子串
        - 更新：有新的重复字符出现时，即更新，并重新开始计算最大的窗口大小
    - 算法：
      - 步骤：初始化；定义哈希表；右指针遍历：判断存在时更新左指针，每次更新右指针，更新res；返回res。
      - 初始化结果变量res=0，left = -1;
      - 定义哈希表map：存储 (k, v)，其中 key 值为字符，value 值为字符位置
      - for循环遍历：用右指针遍历直到末尾
        - 初始化字符：`char chs = s.charAt(end);` -- 以end对应的字符为基准进行遍历
        - 判断：map.containsKey -- 判断chs是否已经存在窗口中
          - 当存在时，更新left的值为left和map.get(key)中的max；
        - 每次讲将字符和对应的位置存入哈希表
        - 更新res：为res和right-left中的max；
      - 返回结果变量res。

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
  - 思路：双指针
  - 分析：
    - 题目要求返回值类型 `List<List<Integer>>`：新建变量ans存储结果 `List<List<Integer>> ans = new ArrayList();`
    - 题目要求“三个数”之和：判空 -- 数组为空或者数组长度小于3时返回ans（空）
    - 首先排序：排序后就可以用双指针逼近结果 `Arrays.sort(nums);`
    - 因为是三个数，因此需要三个指针：本题设置一个基准i，然后将i+1和nums.length-1作为双指针，然后这两个指针逼近
    - 外循环：遍历基准，从0开始，到数组末尾为止，循环体中首先排除各种不符合的情况，然后移动指针查找符合的元素 
      - 不符合1：基准大于0时必然不符，nums[i]>0则break；
      - 不符合2：基准重复的去重，在i>0的情况下，nums[i]==nums[i-1]时会导致重复，continue继续循环；
      - 定义左右指针；
      - 内循环：以nums[i]为基准移动指针，直到左右指针相遇（相等或交错即停止）
        - 定义sum为基准与左右指针的和
        - 对所得sum的正负进行判断
        - sum为正时，偏大，right指针减小；sum为负时，偏小，left指针增大；
        - sum为0时：添加到结果ans，对左右指针的下一个值判断并去重，之后移动指针
    - 返回结果ans。
  - 算法：
    - 定义二维List；
    - 边界值判断：判空和判断数组长度小于3；
    - 排序得到有序数组；
    - 循环：外循环控制基准，内循环控制某个基准的双指针遍历数组
      - 边界值判断：基准大于0；基准去重；
      - 定义左右指针；
      - 内循环：求sum；根据sum的正负情况分别移动指针 -- 注意sum为0时指针去重；
    - 返回结果。
  - ArrayList知识点
    - 新建：`List<List<Integer>> ans = new ArrayList();`
    - 添加：`ans.add(Arrays.asList(nums[i],nums[L],nums[R]));` -- 不需要new
    - Arrays的方法 `asList(T... a)`：返回一个受指定数组支持的固定大小的列表。
    
- ## 代码链接：
  - [三数之和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0015-3sum.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 16. 最接近的三数之和
- ## 题目链接：
  - [3sum-closest](https://leetcode-cn.com/problems/3sum-closest/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [双指针](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Two%20Pointers.md)

- ## 题目描述
  - 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
  - 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
  - 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
  - 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

- ## 解题思路
  - 思路：双指针
  - 注：本题同上一题15题非常相似，用形似的步骤求解即可
  - 算法：边界值；排序；两层循环遍历；返回结果。没要求，因此不用去重。
    - 边界值：假设必存在答案的话，此步可省略（否则也不知道该return什么）；
    - 数组排序：调用`Arrays.sort(nums)`; 用nlogn的时间复杂度；
    - 定义结果res，并初始化为数组中的前三个元素之和，否则容易出现定义过大或过小的问题；
    - 两层循环：外层控制基准，内层控制双指针遍历数组
      - 定义左右指针
      - 内循环：求基准+左右指针对应元素的和；更新res；根据sum与target比较情况移动指针；
    - 返回结果res。

- ## 代码链接：
  - [最接近的三数之和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0016-3sum-closest.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 17. 电话号码的字母组合（未完待续）
- ## 题目链接：
  - [letter-combinations-of-a-phone-number](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  - [回溯算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Backtracking.md)

- ## 题目描述
  - 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
  - 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
  - 示例:
    - 输入："23"
    - 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    - 说明: 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

- ## 解题思路
  - 思路：回溯
  - 复杂度：时间`O(3^m * 4^n)`,空间`O(3^m * 4^n)` -- m是输入数字对应3个字母的数目，n是对应4个的数目，m+n=数字总数
  - 分析：
    - 回溯是一种通过穷举所有可能情况来找到所有解的算法。
    - 如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
    - 给出如下回溯函数 backtrack(combination, next_digits) ，它将一个目前已经产生的组合 combination 和接下来准备要输入的数字 next_digits 作为参数。
    - 如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。
    - 如果还有数字需要被输入：
      - 遍历下一个数字所对应的所有映射的字母。
      - 将当前的字母添加到组合最后，也就是 combination = combination + letter 。
      - 重复这个过程，输入剩下的数字： backtrack(combination + letter, next_digits[1:]) 。
  - 算法：
    - 新建哈希表：将数字和数字对应的字符存入哈希表；
    - 新建

- ## 代码链接：
  - []()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 34. 在排序数组中查找元素的第一个和最后一个位置
- ## 题目链接：
  - [find-first-and-last-position-of-element-in-sorted-array](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)

- ## 题目描述
  - 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
  - 你的算法时间复杂度必须是 O(log n) 级别。
  - 如果数组中不存在目标值，返回 [-1, -1]。
  - 示例 1:
    - 输入: nums = [5,7,7,8,8,10], target = 8
    - 输出: [3,4]
  - 示例 2:
    - 输入: nums = [5,7,7,8,8,10], target = 6
    - 输出: [-1,-1]

- ## 解题思路
  - 参考：剑指-53.1-在排序数组中查找数字的思路
  - 思路：二分查找
  - 复杂度：时间O(logn), 空间O(1)
  - 分析：
    - 排序数组中的搜索问题，首先想到 二分法 解决。
      - 但可能只找到target其中之一，若向前向后遍历来找所有target，则时间复杂度变为暴力遍历相同的O(n)。
    - 排序数组 nums 中的所有数字 target 形成一个窗口，记窗口的 左 / 右边界 索引分别为 left 和 right ，分别对应窗口左边 / 右边的首个元素。
    - 本题要求统计数字 target 的出现次数，可转化为：使用二分法分别找到 左边界 left 和 右边界 right ，易得数字 target 的数量为 right−left+1 
      - 分别用二分求左右边界，则时间复杂度仍为O(logn)。
  - 算法：
    - 初始化边界指针为数组的左右端点；
    - 两次二分；
      - 不等时，同二分处理；
      - nums[mid]与target相等时：
        - 右边界：在mid对应元素的右侧，因此小指针更新为mid+1；
        - 左边界：在mid对应元素的左侧，因此大指针更新为mid-1；
        - 注：这种区别可以通过<=的等于号，并配合if-else实现。
    - 判空：根据左右边界值索引求长度，若为0，则target不存在，返回{-1,-1}
    - 新建数组，并将最终的左右边界索引传入后返回；
    - 注：target不存在的情况会返回0，符合预期结果。
  - 改进：两次二分的代码可以封装起来，然后进行调用，并直接返回差值。
    - 数组 nums 中元素都为整数，因此可以分别二分查找 target 和 target−1 的右边界，将两结果相减并返回即可。
    - 未尝试：如果target-1对应的值不存在或存在多个，需要考虑的东西很多。  
  
- ## 代码链接：
  - [在排序数组中查找元素的第一个和最后一个位置](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0034-find-first-and-last-position-of-element-in-sorted-array.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 39. 组合总和
- ## 题目链接：
  - [combination-sum](https://leetcode-cn.com/problems/combination-sum/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [回溯算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Backtracking.md)

- ## 题目描述
  - 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
  - candidates 中的数字可以无限制重复被选取。
  - 说明：
    - 所有数字（包括 target）都是正整数。
    - 解集不能包含重复的组合。  
  - 示例 1:
    - 输入: candidates = [2,3,6,7], target = 7,
    - 所求解集为: [  [7],  [2,2,3]  ]
 - 示例 2:
   - 输入: candidates = [2,3,5], target = 8,
   - 所求解集为: [ [2,2,2,2],  [2,3,3],  [3,5]  ]

- ## 解题思路
  - 思路：回溯法+深度优先遍历
  - 分析：
    - 根据示例 1：输入: candidates = [2,3,6,7]，target = 7。
      - 候选数组里有 2 ，如果找到了 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
      - 同理考虑 3，如果找到了 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下去；
      - 根据图示，得到路径[[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]，而示例中的解集只有 [[7], [2, 2, 3]]；
      - 重复的原因是在较深层的结点值考虑了之前考虑过的元素，因此我们需要设置“下一轮搜索的起点”即可（这里可能没有说清楚，已经尽力了）。
    - 图示分析：
      - ![0039-1](https://raw.githubusercontent.com/anliux/PracticePool/master/LeetCode/images/0039-1.png)
      - ![0039-2](https://raw.githubusercontent.com/anliux/PracticePool/master/LeetCode/images/0039-2.png)
    - 去重复
      - 在搜索的时候，需要设置搜索起点的下标 begin ，由于一个数可以使用多次，下一层的结点从这个搜索起点开始搜索；
      - 在搜索起点 begin 之前的数因为以前的分支搜索过了，所以一定会产生重复。
    - 剪枝提速
      - 如果一个数位搜索起点都不能搜索到结果，那么比它还大的数肯定搜索不到结果，基于这个想法，我们可以对输入数组进行排序，以减少搜索的分支；
      - 排序是为了提高搜索速度，非必要；
      - 搜索问题一般复杂度较高，能剪枝就尽量需要剪枝。
      - 把候选数组排个序，遇到一个较大的数，如果以这个数为起点都搜索不到结果，后面的数就更搜索不到结果了。
  - 算法：
    - 主体函数+调用函数
    - 主体函数：新建二维结果数组res；对给定数组排序；调用dfs函数；返回结果数组res。
    - 调用函数：
      - 参数列表：给定数组candidates，除存入path元素之外的剩余目标值rest，开始位置索引值begin，本路径path，最终结果res
      - 首先：判断rest是否等于0，等于是即为找到一组，将结果存入res，并返回；
      - 循环遍历给定数组：首先判断rest是否小于数组元素，小于则break；然后将数组元素添加到path的后面之后调用dfs深度遍历；之后回溯，将path的last元素去掉重新遍历。
  - 知识点：
    - ArrayDeque：双向队列接口
      - addFirst(E e)：将指定元素插入此双端队列的开头。
      - addLast(E e)：将指定元素插入此双端队列的末尾。
      - removeLast()：获取并移除此双端队列的最后一个元素。
    - ArrayList：数组
      - 构造函数：ArrayList(Collection<? extends E> c)：
        - 构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
      - add(E e)：将指定的元素添加到此列表的尾部。
      
- ## 代码链接：
  - [组合总和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0039-combination-sum.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 40. 组合总和II
- ## 题目链接：
  - [combination-sum-ii](https://leetcode-cn.com/problems/combination-sum-ii/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [回溯算法](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Backtracking.md)

- ## 题目描述
  - 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
  - candidates 中的每个数字在每个组合中只能使用一次。
  - 说明：
    - 所有数字（包括目标数）都是正整数。
    - 解集不能包含重复的组合。 
  - 示例 1:
    - 输入: candidates = [10,1,2,7,6,1,5], target = 8,
    - 所求解集为: `[  [1, 7],  [1, 2, 5],  [2, 6],  [1, 1, 6]  ]`
  - 示例 2:
    - 输入: candidates = [2,5,2,1,2], target = 5,
    - 所求解集为: `[  [1,2,2],  [5]  ]`

- ## 解题思路
  - 思路：回溯+dfs
  - 分析：
    - 对比：
      - 第 39 题：candidates 中的数字可以无限制重复被选取。
      - 第 40 题：candidates 中的每个数字在每个组合中只能使用一次。
    - 编码的不同在于下一层递归的起始索引不一样。
      - 第 39 题：还从候选数组的当前索引值开始。
      - 第 40 题：从候选数组的当前索引值的下一位开始。
    - 相同之处：解集不能包含重复的组合。
      - 为了使得解集不包含重复的组合，除了使用哈希表以外，还可以先对数组升序排序，重复的元素一定不是排好序以后的第 1 个元素和相同元素的第 1 个元素。根据这个思想，我们先对数组升序排序是有必要的。候选数组有序，对于在递归树中发现重复分支，进而“剪枝”也是有效的。
    - 关键思路：以 target 为根结点，依次减去数组中的数字，直到小于 0 或者等于 0，把等于 0 的结果记录到结果集中。
      - 当然你也可以以 0 为根结点，依次加上数组中的数字，直到大于 target 或者等于 target，把等于 target 的结果记录到结果集中。
    - “解集不能包含重复的组合”，就提示我们得对数组先排个序（“升序”或者“降序”均可，下面示例中均使用“升序”）。
    - “candidates 中的每个数字在每个组合中只能使用一次”，那就按照顺序依次减去数组中的元素，递归求解即可：遇到 0 就结算且回溯，遇到负数也回溯。
    - candidates 中的数字可以重复，可以借助「力扣」第 47 题：“全排列 II” 的思想，在搜索的过程中，找到可能发生重复结果的分支，把它剪去。
  - 图解
    -    
  - 算法
    - 
    - 
    
- ## 代码链接：
  - [最接近的三数之和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0016-3sum-closest.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 50. pow函数
- ## 题目链接：
  - [pow(x,n)](https://leetcode.cn/problems/powx-n/)

- ## 题目标签：
  - [递归](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Recurrence.md)
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)

- ## 题目描述
  - 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
  - 不得使用库函数，不需要考虑大数问题。
  - -100.0 < x < 100.0; -2^31 <= n <= 2^31-1; -10^4 <= x^n <= 10^4

- ## 解题思路
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



# 53. 最大子数组和
- ## 题目链接：
  - [maximum-subarray](https://leetcode.cn/problems/maximum-subarray/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [动态规划](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述
  - 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
  - 子数组 是数组中的一个连续部分。
  - 示例 1：
    - 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    - 输出：6
    - 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
  - 示例 2：
    - 输入：nums = [1]
    - 输出：1
  - 示例 3：
    - 输入：nums = [5,4,-1,7,8]
    - 输出：23
  - 提示：
    - 1 <= nums.length <= 105
    - -104 <= nums[i] <= 104
  - 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

- ## 解题思路
  - 思路：暴力法；动态规划；贪心；分治
  - 暴力法：
    - 关键：双层遍历，寻找所有的可能子序和，并求最大值
    - 复杂度：时间O(N^2)，空间O(1)
    - 算法：
      - 首先定义并初始化max为数组第一个元素：
        - 注意不是0，而应是数组中的某个元素
      - 按照一定规律遍历数组，比如从i开始遍历到末尾，不断取和，比较并取max，然后i++
      - 两层循环：外循环控制开始的i值，内循环控制在i索引开始，形成的子序列
        - 注意：如果外层循环作为第一个元素，可能会有问题，直接让内层循环开始累加即可。 
  - 贪心：
    - 关键：sum为负数时，舍弃并重新开始计数
      - 如果sum为负数，那么后面无论累加什么，都会更小 
    - 复杂度：时间O(n)，空间O(1)
    - 分析：从左向右遍历，一个个数累加；当sum<0，重新开始找子序列
      - 所求最大值max可由if判断语句比较得到，也可由Math.max(i,j)直接求得
      - sum初始化为0，小于0的sum说明累加后比初始值更小了
      - "重新找"指的是：sum归0， 并从下一个元素起，重新累加
    - 算法：
      - 如果题目没有给定非空的范围，第一步判空；
      - 定义最大值max为数组第一个元素，定义子序列和sum为0；
      - 遍历数组：从0到length（左闭右开）
        - 求和：将nums[i]累加到sum；
        - 更新max的值为max和sum中最大的一个；
        - 判断sum与0：如果sum<0，则设置sum=0，重新开始计算子序列和；
      - 返回结果max。
  - 动态规划：
    - 复杂度：时间O(n), 空间O(n)，可优化到O(1)
      - 只用到dp数组中的前一项，因此可以用int代替一维数组，对空间复杂度优化
    - 分析：
      - dp[i]: nums中，以nums[i]结尾的最大子序和
      - `dp[i] = max(dp[i-1] + nums[i], nums[i]);`
      - 如果加上nums[i]之后的和，比nums[i]本身更小了，说明从nums[i]开始的子序列必然大于从前的和，因此重新开始计算。
    - 算法：
      - 初始化dp数组和max，dp[i]是指以nums[i]结尾的最大子序和;
      - 遍历数组：求dp[i]，并更新max为max和dp[i]中的最大值；
      - 返回结果变量max。
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
  - [最大子数组和](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0053-maximum-subarray.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 54. 螺旋矩阵
- ## 题目链接：
  - [spiral-matrix](https://leetcode-cn.com/problems/spiral-matrix/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述
  - 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
  - 示例 1:
    - 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
    - 输出: [1,2,3,6,9,8,7,4,5]
  - 示例 2:
    - 输入: [  [1, 2, 3, 4],  [5, 6, 7, 8],  [9,10,11,12] ]
    - 输出: [1,2,3,4,8,12,11,10,9,5,6,7]

- ## 解题思路
  - 思路：模拟，设定边界
  - 分析：
    - 判空：当数组长度为0时，返回new int[0]; -- 注：本题规定了取值范围，因此判空可以省略。
    - 顺时针打印矩阵的顺序是 “从左向右、从上向下、从右向左、从下向上” 循环。
    - 因此，考虑设定矩阵的“左、上、右、下”四个边界，模拟以上矩阵遍历顺序。
  - 算法：
    - 复杂度：时间O(mn), 空间O(1) -- m、n为矩阵的行列数。
    - 判空：当数组长度为0时，return new ArrayList<>()；
    - 初始化四个边界，以及结果数组的索引值；
    - 初始化结果数组list；
    - 循环：死循环，跳出控制在循环体内。
      - 按照“从左向右、从上向下、从右向左、从下向上” 的顺序遍历，同时更新各个指标的值。
      - 用for循环完成一条边的遍历：注意循环起始位置是某一边界值；
      - 每次遍历完一条边之后，都要进行判断，当边界交错时，break跳出循环。
    - 返回结果。
  - 注意：
    - 1. 与剑指offer29题的区别：本题返回值类型是List
    - 2. 如果用List，不用index，则if判断中，同时进行边界值更新时++--在前。
    - 3. List 本身是个接口，实例化其子类ArrayList `List<Integer> res = new ArrayList<Integer>();`
    
- ## 代码链接：
  - [螺旋矩阵](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0054-spiral-matrix.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 79. 单词搜索
- ## 题目链接：
  - [word search](https://leetcode.cn/problems/word-search/)

- ## 题目标签：
  - [深度优先遍历](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Depth-first%20Search.md)

- ## 题目描述
  - 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
  - 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

- ## 解题思路
  - 参考：剑指offer 12. 矩阵中的路径
  - 本问题是典型的矩阵搜索问题，可使用《深度优先搜索（DFS）+ 剪枝》解决。
    - 深度优先搜索：
      - 可以理解为暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
    - 剪枝：
      - 在搜索中，遇到 “这条路不可能和目标字符串匹配成功” 的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为 “可行性剪枝”
  - DFS 解析：
    - 递归参数： 
      - 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
    - 终止条件：
      - 返回 false ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
      - 返回 true ： k = len(word) - 1 ，即字符串 word 已全部匹配。
    - 递推工作：
      - 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
      - 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
      - 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
    - 返回值： 返回布尔量 res ，代表是否搜索到目标字符串。
    - 注意：
      - 使用空字符（Python: '' , Java/C++: '\0' ）做标记是为了防止标记字符与矩阵原有字符重复。当存在重复时，此算法会将矩阵原有字符认作标记字符，从而出现错误。
      - 递归之后：占用的空串位置释放，赋原值
  - 代码步骤：
    - 将目标word转为字符数组；
    - 遍历数组：从每一个位置作为入口尝试与目标word匹配，并在具体位置调用dfs()函数
      - 二维数组：用i，j遍历
      - dfs：以当前i-j位置，和word的初始位置开始匹配
        - 这里dfs放在if里，而不是直接return，因为要遍历所有，而不是中途判断是否有false
      - 遍历数组之外需要补充匹配失败的情况：遍历二维数组后没有符合的情况存在，则返回false
        - 这里不能少，否则会存在没有返回值返回的情况 
    - dfs(char[][] board, char[] word, int i, int j, int k)
      - char[][] board: 二维数组
      - char[] word：目标字符串word
      - i，j: 入口
      - k：word中的当前字符指针
    - dfs()函数的步骤：
      - 判断几种不符合的情况：超出四个边界或与word中k对应的字符不匹配，则返回false
        - 注意：大于等于length-1的等于号即属于不符合的情况 
      - 判断递归出口：如果已经达到word的最后，且没有被上一步判false，则返回true
      - 前两步都不符合：开始进入深度遍历，先将此时二维数组的i-j锁定，即赋空值
      - 设置布尔型res变量，对i-j四个方向进行递归dfs()函数的判断，一真即真
      - 回退一格：将二维数组的i-j重新赋值为原值，即word[k]对应的值 (判断了对应才会赋空值并深度遍历)
      - 返回res的值
  - 知识点：
    - str.toCharArray()：字符串转为字符数组
    - 几处判断为短路双与：一真即真，只要找到一种匹配情况即可

- ## 代码链接：
  - [单词搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0079-word-search.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述

- ## 解题思路

- ## 代码链接：

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述

- ## 解题思路

- ## 代码链接：

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->


# 
- ## 题目链接：
  - []()

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)

- ## 题目描述

- ## 解题思路

- ## 代码链接：






### END
