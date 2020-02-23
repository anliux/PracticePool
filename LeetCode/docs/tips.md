# Tips



## 防溢出越界
- 取平均防止溢出：mid=(min+max)/2 --> mid=min+(max-min)/2
- 定义最值并初始化为范围内最值，特别是求最小值时
  - 代码体现：`int min = Integer.MAX_VALUE;` or `int max = Integer.MIN_VALUE;`



## 优化
- 正向递归冗余时，考虑逆向递归则重复少
- 数组正向遍历移动多或复杂度高等时，考虑从尾部遍历则移动少或者不需要额外空间



## 选择
- 哈希表有hashmap和hashset两种，hashmap存储键值对，而hashset存储对象。仅需要存储单个时选择hashset，两个时选择hashmap



### END
