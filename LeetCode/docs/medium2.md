# medium2
- 本文题号范围：101-200


# 目录
<!-- GFM-TOC -->
* []()
* []()
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)
* [151. 翻转字符串里的单词](#151-翻转字符串里的单词)
* [153. 寻找旋转排序数组中的最小值](#153-寻找旋转排序数组中的最小值)
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



# 102. 二叉树的层次遍历
- ## 题目链接：
  - [binary-tree-level-order-traversal](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [广度优先搜索](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Breadth-first%20Search.md)

- ## 题目描述
  - 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
  - 例如: 
    - 给定二叉树: [3,9,20,null,null,15,7],
    - 返回其层次遍历结果：[ [3], [9,20], [15,7] ]

- ## 解题思路
  - 参考：剑指offer-33题-二叉树的遍历
  - 广度优先搜索（BFS）
    - 按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
  - 思路：递归；迭代；队列+两层遍历
  - 递归：
    - 复杂度：时间O(n)，空间O(n)
    - 层序遍历考虑广度优先搜索
    - 首先确认树非空，然后调用递归函数 `helper(node, level)`，参数是当前节点和节点的层次。
    - 输出列表称为 levels，当前最高层数就是列表的长度 `len(levels)`。
    - 比较访问节点所在的层次 level 和当前最高层次 `len(levels)` 的大小，如果前者更大就向 levels 添加一个空列表。
    - 将当前节点插入到对应层的列表 `levels[level]` 中。
    - 递归非空的孩子节点：`helper(node.left / node.right, level + 1)`。
    - 注：
      - 递归解法本质上还是dfs，不过add的时候会根据记录的level来判断加到哪个层次
      - 整体步骤：进入helper函数后：判断是否新建level（二维数组），添加结点值，子节点非空时调用helper(必要判断，因为添加右结点时不用新建level)
      - helper函数相当于从根结点开始，层序遍历整棵树，同时记录结点值到数组
    - 二维数组与树相关知识点
      - 新建二维数组：`List<List<Integer>> levels = new ArrayList<List<Integer>>();`
      - 二维数组长度：`数组名.size()`
      - 二维数组添加元素：`数组名.add()`
      - 二维数组中新建一位数组：`levels.add(new ArrayList<Integer>());`
      - List的get()：get(int index)，返回列表中指定位置的元素
  - 队列+两层遍历：
    - 分析：
      - 按层打印：题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。BFS 通常借助 队列 的先入先出特性来实现。
      - 每层打印到一行：将本层全部节点打印到一行，并将下一层全部节点加入队列，以此类推，即可分为多行打印。
      - 需要用到循环嵌套，但总的循环次数仍是n，因此时间复杂度仍为O(n)。
    - 算法：
      - 复杂度：时间O(n)，空间O(n)
      - 判空：当根节点为空，则返回空列表 [] ；
        - (注：根结点判空需要新建，因此可以转为先初始化，然后对根结点判非空)
      - 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
      - BFS 循环： 当队列 queue 为空时跳出；
        - 新建一个临时列表 tmp ，用于存储当前层打印结果；
        - 当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
          - 出队： 队首元素出队，记为 node；
          - 打印： 将 node.val 添加至 tmp 尾部；
          - 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
        - 将当前层结果 tmp 添加入 res 。
      - 返回值： 返回打印结果列表 res 即可。
      - 注意：内循环次数控制的for循环
        - 使用i--，让size()只在循环开始使用一次，使循环次数不受队列长度变化影响，妙啊！
        - 若i从0开始，使用i++，那么queue的size每一轮都在变，会导致错误。
        
- ## 代码链接:
  - [二叉树的层次遍历](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0102-binary-tree-level-order-traversal.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 151. 翻转字符串里的单词
- ## 题目链接：
  - [reverse-words-in-a-string](https://leetcode-cn.com/problems/reverse-words-in-a-string/)
  
- ## 题目标签：
  - [字符串](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/String.md)
  
- ## 题目描述
  - 给定一个字符串，逐个翻转字符串中的每个单词。
  - 示例 1：输入: "the sky is blue", 输出: "blue is sky the"
  - 示例 2：输入: "  hello world!  ", 输出: "world! hello"
    - 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
  - 示例 3：输入: "a good   example", 输出: "example good a"
    - 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
  - 说明：
    - 无空格字符构成一个单词。
    - 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    - 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
  - 进阶：请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。

- ## 解题思路
  - 思路：两次翻转(字符角度)；一次翻转(字符串角度)
  - 注：本题按照对空格处理和不对空格处理，分别整理代码。
  - 分析：
    - 两次翻转：从字符数组的角度，一次翻转所有字母，一次翻转每个单词。每个单词以空格分隔。
    - 一次翻转：从字符串数组的角度，从后遍历字符串数组，并添加到可变字符串，判断后添加一个空格。
    - 翻转：即依次交换收尾，然后夹逼。
    - 可以将翻转功能定义为private函数然后直接调用，提高代码复用性。
    - 多空格：`String[] s1=s.trim().split(" +");` -- 加上+以后，可以剪去字符串之间的多个空格，只保留非空格字符。  
  - 算法1：两次翻转
    - 定义翻转指定索引值的字符串的函数并定义为私有；
    - 首先处理空格：剪去所有空格后，将字符串数组重新用一个空格连起来；
    - 将字符串转为字符数组；
    - 定义双指针：大指针遍历并找空格，小指针为要翻转单词的首个索引；
    - 遍历：翻转每个单词；
    - 翻转整个字符串；
    - 返回：新建字符串，并将字符数组传入。
  - 算法2：一次翻转
    - 首先处理空格：剪去所有空格后，将字符串数组重新用一个空格连起来；
    - 定义可变字符串StringBuilder；
    - 从后遍历字符串数组：如果不是第一个元素，则额外添加空格，否则，只添加元素本身；
    - 将可变字符串转为String类型，并返回。
    - 注：简单多了，但是用了很多库函数吧。

- ## 代码链接：
  - [翻转字符串里的单词](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0151-reverse-words-in-a-string.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 153. 寻找旋转排序数组中的最小值
- ## 题目链接：
  - [find-minimum-in-rotated-sorted-array](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

- ## 题目标签：
  - [数组](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Array.md)
  - [二分查找](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Binary%20Search.md)
  
- ## 题目描述
  - 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    - 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2])。
  - 请找出其中最小的元素。
  - 你可以假设数组中不存在重复元素。
  - 示例 1: 输入: [3,4,5,1,2], 输出: 1
  - 示例 2: 输入: [4,5,6,7,0,1,2], 输出: 0

- ## 解题思路
  - 思路：暴力法；排序；二分。
  - 注：
    - 本题与<154-hard>的区别：本题规定不存在重复元素，154题可能存在重复元素。
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
      - 注：因为不存在重复元素，因此不要考虑某两个元素相等的情况。
    - 注意：比较的是mid与right，如果用left指针，可能出问题。
    - 算法：
      - 定义双指针；
      - 左右指针不相等时遍历数组：取mid，比较mid对应元素与right对应元素，mid大则left=mid+1，mid小则right=mid；
      - 返回left对应元素(right也行，因为最后两个指针相等了)。
    
- ## 代码链接：
  - [寻找旋转排序数组中的最小值](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0153-find-minimum-in-rotated-sorted-array.java)

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
