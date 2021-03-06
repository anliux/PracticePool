# 回溯算法
- 内含题目：60

# 目录
<!-- GFM-TOC -->
* [17. 电话号码的字母组合](#17-电话号码的字母组合)
* [39. 组合总和](#39-组合总和)
* [](#)
* [](#)
* [](#)
* [](#)
<!-- GFM-TOC -->



# 17. 电话号码的字母组合
- ## 简述：（[medium](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium.md)）
  - ### 题目描述
    - 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    - 假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
  - ### 解题思路
    - 1. 暴力法：思路简单，双层循环时间复杂度高 O(n^2), O(1)
    - 2. 哈希表：用空间换时间，降低时间复杂度 O(n), O(n)
    - 哈希表有两种思路：
      - 一种是先保存到表，后进行匹配
      - 一种是在保存到表的同时进行匹配
- ## 代码链接：
  - []()

<!-- GFM-TOC -->
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->



# 39. 组合总和
- ## 简述：（[medium](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/medium.md)）
  - ### 题目描述
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
  - ### 解题思路
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



### END
