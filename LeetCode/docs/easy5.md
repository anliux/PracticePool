# easy5
- 本文题号范围：801-1000


# 目录
<!-- GFM-TOC -->
* [836. 矩形重叠](#836-矩形重叠)
* []()
* []()
* []()
* []()
* []()
* []()
* []()
* []()
* []()
* []()
<!-- GFM-TOC -->



# 836. 矩形重叠
- ## 题目链接：
  - [rectangle-overlap](https://leetcode-cn.com/problems/rectangle-overlap/)

- ## 题目标签：
  - [数学](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/Math.md)
  
- ## 题目描述
  - 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
  - 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
  - 给出两个矩形，判断它们是否重叠并返回结果。
  - 示例 1：
    - 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
    - 输出：true
  - 示例 2：
    - 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
    - 输出：false
  - 说明：
    - 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
    - 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 
- ## 解题思路
  - 思路：检查位置；检查区域
  - 检查位置：
    - 复杂度：时间O(1)，空间O(1)
    - 分析：
      - 考虑不重叠情况：四周，即一个矩阵在另一个矩阵的左侧，右侧，上侧，下侧
      - 代码体现为：
        - 左侧：`rec1[2] <= rec2[0]`；
        - 右侧：`rec1[0] >= rec2[2]`；
        - 上方：`rec1[1] >= rec2[3]`；
        - 下方：`rec1[3] <= rec2[1]`。
      - 将不重叠情况排除，剩余的就是重叠情况
    - 算法：
      - 直接return：将不重叠情况排除，剩余的就是重叠情况。
  - 检查区域：
    - 复杂度：时间O(1)，空间O(1)
    - 分析：
      - 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形；
      - 那么这代表了两个矩形与 x 轴平行的边（水平边）投影到 x 轴上时会有交集，与 y 轴平行的边（竖直边）投影到 y 轴上时也会有交集。
      - 因此，我们可以将问题看作一维线段是否有交集的问题。
      - 考虑分离情况来辅助理解重叠情况：
        - x轴：如果不重叠，那么左端点的最大值(即分离的大矩形的左端点)，会大于右端点的最小值(即分离的小矩形的右端点)
        - y轴：同理
        - 总结就是分离“min<max, 大的最小值(在小矩形里)小于小的最大值(在大矩形里)”，等于就是重合的情况。
      - 因此，重叠就是“min>max，大的最小值(小矩形)大于小的最大值(大矩形)”
      - 交集代码体现：
        - x轴：`min(rec1[2], rec2[2]) > max(rec1[0], rec2[0])`
        - y轴：`min(rec1[3], rec2[3]) > max(rec1[1], rec2[1])`
        - 考虑不重叠情况来辅助理解重叠情况。
      - 两个方向都有交集时，证明可以构成重叠区域，此时重叠。
        - 考虑两个方向都存在交集是因为如果一真一假，可能只是边界重合，但没有重叠。
    - 算法：
      - 直接return：两个方向都有交集时，返回true。

- ## 代码链接：
  - [矩形重叠](https://github.com/anliux/PracticePool/blob/master/LeetCode/src/0836-ectangle-overlap.java)

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
