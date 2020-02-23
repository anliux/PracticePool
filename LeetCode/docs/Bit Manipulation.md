# 位运算
- 内含题目：56

# 目录
<!-- GFM-TOC -->
* [136. 只出现一次的数字](#136-只出现一次的数字)
* []()
* []()
* []()
* []()
* []()
* []()
* []()
* []()

<!-- GFM-TOC -->



# 136. 只出现一次的数字
- ## 简述：（[easy](https://github.com/anliux/PracticePool/blob/master/LeetCode/docs/easy.md)）
  - ### 题目描述
    - 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    - 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
  - ### 解题思路
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
* ## [返回顶部目录](#目录)
<!-- GFM-TOC -->




### END