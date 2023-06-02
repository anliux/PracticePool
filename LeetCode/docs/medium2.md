# medium2
- 本文题号范围：101-200


# 目录
<!-- GFM-TOC -->
* []()
* []()
* [102. 二叉树的层次遍历](#102-二叉树的层次遍历)
* [105. 从前序与中序遍历序列构造二叉树](#105-从前序与中序遍历序列构造二叉树)
* [113. 路径总和 II](#113-路径总和-ii)
* [122. 卖股票的最佳时机II](#122-卖股票的最佳时机ii)
* [138. 复制带随机指针的链表](#138-复制带随机指针的链表)
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



# 105. 从前序与中序遍历序列构造二叉树
- ## 题目链接：
  - [construct-binary-tree-from-preorder-and-inorder-traversal](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  
- ## 题目描述
  - 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
  - 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
  - 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

- ## 解题思路
  - 参考 《剑指》7题：重建二叉树
  - 分析：因为是树的结构，一般都是用递归来实现。
    - 用数学归纳法的思想就是，假设最后一步，就是root的左右子树都已经重建好了，那么只要考虑将root的左右子树安上去即可。
    - 根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围。
    - 根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树。那么我们只要找到中序遍历中root的位置，就可以确定好左右子树的范围。
    - 正如上面所说，只需要将确定的左右子树安到root上即可。
    - 递归要注意出口，假设最后只有一个元素了，那么就要返回。  
  - 具体分析：
    - 前序遍历的首元素 为 树的根节点 node 的值。
    - 在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 `[ 左子树 | 根节点 | 右子树 ]` 。
    - 根据中序遍历中的左（右）子树的节点数量，可将 前序遍历 划分为 `[ 根节点 | 左子树 | 右子树 ]`
  - 算法：
    - 通过【前序遍历列表】确定【根节点 (root)】
    - 将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
    - 递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】
  - 算法具体：
    - 递推参数： 根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right ；
    - 终止条件： 当 left > right ，代表已经越过叶节点，此时返回 nullnull ；
    - 递推工作：
      - 建立根节点 node ： 节点值为 preorder[root] ；
      - 划分左右子树： 查找根节点在中序遍历 inorder 中的索引 i ；
        - 为了提升效率，本文使用哈希表 dic 存储中序遍历的值与索引的映射，查找操作的时间复杂度为 O(1)；
        - TIPS： i - left + root + 1 含义为 根节点索引 + 左子树长度 + 1
      - 构建左右子树： 开启左右子树递归；
    - 返回值：回溯返回 node ，作为上一层递归中根节点的左 / 右子节点；
  - 哈希表保存中序遍历细节：
    - 在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做的时间复杂度较高。
    - 考虑使用哈希表来快速地定位根节点。
    - 对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。
      - 在构造二叉树的过程之前，对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。在此后构造二叉树的过程中，我们就只需要 O(1) 的时间对根节点进行定位了
  - 知识点：
    - `Arrays.copyOfRange(T[ ] original,int from,int to)` ：将一个原始的数组original，从下标from开始复制，复制到下标to，生成一个新的数组。注意这里包括下标from，不包括下标to。
  - 注意：评论区说了，此题的解题技巧就是：背！！下！！来！！
 
 - ## 代码链接
   - [从前序与中序遍历序列构造二叉树](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0150-construct-binary-tree-from-preorder-and-inorder-traversal.java)
  
<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 113. 路径总和 II
- ## 题目链接：
  - [path-sum-ii](https://leetcode.cn/problems/path-sum-ii/)
  
- ## 题目标签：
  - [树](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Tree.md)
  - [回溯]() ...
  
- ## 题目描述
  - 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
  - 叶子节点 是指没有子节点的节点。
  - 示例 1：
    - 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    - 输出：[[5,4,11,2],[5,8,4,5]]
  - 示例 2：
    - 输入：root = [1,2,3], targetSum = 5
    - 输出：[]
  - 示例 3：
    - 输入：root = [1,2], targetSum = 0
    - 输出：[]
  - 提示：
    - 树中节点总数在范围 [0, 5000] 内
    - `-1000 <= Node.val <= 1000`
    - `-1000 <= targetSum <= 1000`

- ## 解题思路
  - 分析：
    - 本题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分。
    - 先序遍历： 
      - 按照 “根、左、右” 的顺序，遍历树的所有节点。
    - 路径记录： 在先序遍历中，记录从根节点到当前节点的路径。
      - 当路径为 ① 根节点到叶节点形成的路径 且 ② 各节点值的和等于目标值 sum 时，将此路径加入结果列表。
  - 算法流程：
    - pathSum(root, sum) 函数：
      - 初始化： 结果列表 res ，路径列表 path 。
        - 初始化为全局变量更方便 
      - 返回值： 返回 res 即可。
    - void recur(root, tar) 函数：
      - 递推参数： 当前节点 root ，当前目标值 tar 。
      - 终止条件： 若节点 root 为空，则直接返回。
      - 递推工作：
        - 路径更新： 将当前节点值 root.val 加入路径 path ；
        - 目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 0 ）；
        - 路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。
          - 注意：记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
          - 这里新建LinkedList并传入当前path 
        - 先序遍历： 递归左 / 右子节点。
        - 路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。
          - 这里：递归是可以保证遍历整棵树的
          - 当达到叶子结点时，叶节点的左右结点都是null，会返回并执行这一步 

- ## 代码链接
  - [路径总和II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0113-path-sum-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 122. 卖股票的最佳时机II
- ## 题目链接：
  - [best-time-to-buy-and-sell-stock-ii](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)

- ## 题目标签：
  - [贪心](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Greedy.md)
  
- ## 题目描述
  - 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
  - 在每一天，你可以决定是否购买和/或出售股票。你在任何时候**最多**只能持有**一股**股票。你也可以先购买，然后在**同一天**出售。
  - 返回**你能获得的最大**利润 。
  - 示例 1：输入：prices = [7,1,5,3,6,4], 输出：7
    - 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    - 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
    - 总利润为 4 + 3 = 7 。
  - 示例 2：输入：prices = [1,2,3,4,5], 输出：4
    - 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    - 总利润为 4 。
  - 示例 3：输入：prices = [7,6,4,3,1], 输出：0
    - 在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
  - 提示：
    - `1 <= prices.length <= 3 * 104`
    - `0 <= prices[i] <= 104`

- ## 解题思路
  - 贪心算法的贪心关键：
    - “等价于每天都买卖”
    - 策略是：所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱)
  - 股票买卖策略：
    - 单独交易日： 
      - 设今天价格 p1、明天价格 p2，则今天买入、明天卖出可赚取金额 p2−p1（负值代表亏损）。
    - 连续上涨交易日： 
      - 设此上涨交易日股票价格分别为 p1,p2,...,pn，
      - 则第一天买最后一天卖收益最大，即 pn−p1；
      - 等价于每天都买卖，即 pn−p1=(p2−p1)+(p3−p2)+...+(pn−pn−1)。
    - 连续下降交易日： 
      - 则不买卖收益最大，即不会亏钱。
    - 交易规则：
      - 遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。 
  - 算法流程：
    - 判空：
      - 本题给出了范围length>=1，可省略这步 
    - 定义并初始化变量
      - 定义`int max = prices[0];` 
    - 遍历数组
      - 从第2个元素开始遍历：for括号判断，如果没有第2个元素会直接推出循环，计划通
      - 对本日与前一日差值`prices[i]-prices[i-1]`进行判断
        - 如果`>0`，则累加到max中
        - 否则无操作(无操作则不需要写什么)
    - 返回结果max     
  - 复杂度分析：
    - 时间复杂度 O(N) ： 只需遍历一次price；
    - 空间复杂度 O(1) ： 变量使用常数额外空间。

- ## 代码链接：
  - [卖股票的最佳时机II](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0122-best-time-to-buy-and-sell-stock-ii.java)

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 138. 复制带随机指针的链表
- ## 题目链接：
  - [copy-list-with-random-pointer](https://leetcode.cn/problems/copy-list-with-random-pointer/)

- ## 题目标签：
  - [链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Linked%20List.md)
  - [哈希表](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Hash%20Table.md)
  
- ## 题目描述
  - 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
  - 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
  - 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
  - 返回复制链表的头节点。
  - 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
  - val：一个表示 Node.val 的整数。
  - random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
  - 你的代码 只 接受原链表的头节点 head 作为传入参数。

- ## 解题思路
  - 硬拷贝，两种思路：哈希表；拼接拆分。
  - 分析：
    - 本题链表的节点新增了 random 指针，指向链表中的 任意节点 或者 null 。
    - 这个 random 指针意味着在复制过程中，除了构建前驱节点和当前节点的引用指向 pre.next，还要构建前驱节点和其随机节点的引用指向 pre.random 。 
    - 注：本方法多次用到类似"random.next = next.random"的结构，
  - 哈希表：
    - 分析：
      - 核心：哈希表保存一份新老结点的对应关系，之后将老结点的链子复制到新结点中
      - map.get(老结点)获取对应的新结点，map.get(老结点.next)获取老结点的next结点对应的新结点。
      - 利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可。
    - 算法流程：
      - 步骤：判空；初始化；遍历：复制结点并存表；cur置为head；遍历：构建新结点链接；返回。
      - 复杂度：O(N),O(N)
      - 若头节点 head 为空节点，直接返回 null；
      - 初始化： 哈希表 dic ， 节点 cur 指向头节点；
      - 复制链表：
        - 建立新节点，并向 dic 添加键值对 (原 cur 节点, 新 cur 节点） ；
        - cur 遍历至原链表下一节点；
      - cur置为head
      - 构建新链表的引用指向：
        - 构建新节点的 next 和 random 引用指向；
        - cur 遍历至原链表下一节点；
      - 返回值： 新链表的头节点 dic[cur] ；
  - 拼接拆分：
    - 分析：
      - 考虑构建 `原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> ……` 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点 
      - 先拼接，后链接新结点与其random，之后按间隔拆分原结点与新结点。
    - 算法流程：
      - 步骤：判空；初始化当前结点cur；遍历：复制各结点并拼接；遍历：构建新结点的random；拆分；返回结果。
      - 复杂度：O(N),O(1)
      - 复制各节点，构建拼接链表:
      - 构建新链表各节点的 random 指向：
        - 当访问原节点 cur 的随机指向节点 cur.random 时，对应新节点 cur.next 的随机指向节点为 cur.random.next 。
      - 拆分原 / 新链表：每次间隔
        - 设置 pre / cur 分别指向原 / 新链表头节点，遍历执行 pre.next = pre.next.next 和 cur.next = cur.next.next 将两链表拆分开。
      - 原链表不能修改，否则报错：拼接链表只有一个null，最后在拆分后的原列表的末尾手动加一个null
        - pre.next = null; 
        - 报错：Next pointer of node with label 1 from the original list was modified.
      - 返回新链表的头节点 res 即可。

- ## 代码链接：
  - [复制带随机指针的链表](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0138-copy-list-with-random-pointer.java)

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
  - 思路：
    - 库函数(trim+split)；
    - 双指针一次翻转(没用split)；
    - 两次翻转(整体一次，单个单词一次)
  - 分析：
    - 两次翻转：从字符数组的角度，一次翻转所有字母，一次翻转每个单词。每个单词以空格分隔。
    - 一次翻转：从字符串数组的角度，从后遍历字符串数组，并添加到可变字符串，判断后添加一个空格。
    - 翻转：即依次交换收尾，然后夹逼。
    - 可以将翻转功能定义为private函数然后直接调用，提高代码复用性。
    - 多空格：`String[] s1=s.trim().split(" +");` -- 加上+以后，可以剪去字符串之间的多个空格，只保留非空格字符。  
  - 库函数：
    - 用到：trim，split，SttringBuilder
    - 步骤：拆分-倒序组合-转化为String返回
    - 越过了对空格的处理
  - 双指针一次翻转：
    - 重点处理空格
    - 分析：
      - 没有使用split，而是手动进行了判断处理
      - 但又用到了取子串的函数。。。
      - 先剪好String两边的空格   
      - 倒序遍历：遇到空格就append到sb，继续滑过空格后更新两指针。
      - 最后转为字符串。
    - 步骤：
      - 枝剪；初始化：指针和sb；倒序遍历：遇空格append，滑过所有空格后更新指针；转换后返回。
      - 首先枝剪掉s两边的空格
      - 初始化：
        - 两指针；
        - 可变字符串StringBuilder，用来保存结果。
      - 倒序遍历：
        - 小指针向左找空格：不是空格时指针递减；
        - 小指针遇到第一个空格后：将两指针范围内的子串添加到sb；
        - 小指针向左越过所有空格：是空格时指针递减；
        - 更新大指针
      - 返回结果：
        - 将StringBuilder转为字符串后返回，注意格式。
    - 注意：
      - s.charAt()取的是字符，判断是否等于空格时，空格用单引号；
      - 最后返回时，记得再次枝剪一次。 
  - 两次翻转：(虽然但是，这不还是用了trim+split吗。。)
    - 定义翻转指定索引值的字符串的函数并定义为私有；
    - 首先处理空格：剪去所有空格后，将字符串数组重新用一个空格连起来；
    - 将字符串转为字符数组；
    - 定义双指针：大指针遍历并找空格，小指针为要翻转单词的首个索引；
    - 遍历：翻转每个单词；
    - 翻转整个字符串；
    - 返回：新建字符串，并将字符数组传入。
  - 一次翻转
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
