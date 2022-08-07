# Tips



## 数值定义时需要注意会不会超出范围
- 斐波那契数列：
  - 要么定义为long，要么做取模控制在int范围内；除非n<=39。



## 防溢出越界空指针
- 凡事出现数组索引或者链表指针向后移动的语句，要先判空。
- 取平均防止溢出：mid=(min+max)/2 --> mid=min+(max-min)/2
- 定义最值并初始化为范围内最值，特别是求最小值时
  - 代码体现：`int min = Integer.MAX_VALUE;` or `int max = Integer.MIN_VALUE;`



## 优化
- 正向递归冗余时，考虑逆向递归则重复少
- 数组正向遍历移动多或复杂度高等时，考虑从尾部遍历则移动少或者不需要额外空间



## 选择
- 哈希表有hashmap和hashset两种，hashmap存储键值对，而hashset存储对象。仅需要存储单个时选择hashset，两个时选择hashmap



## 字符与字符串
- str.charAt()获取char字符，str.substring()获取字符串。注意赋值给的变量类型，以及单双引号。



## 关键词与思路
- ### “有序”：考虑双指针逼近
  - 注：可以先排序，“无序”变“有序”

- ### 两链表的第一个公共结点：
  - 思路：链表A：a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在第二个c起点相遇。若不相交，a+b = b+a 。因此相遇处是NULL（尾）
  - 算法：判空；新建结点；循环：两结点移动，直到相等。
  - 循环体用三目运算符：`pa = (pa == null) ? headB : pa.next;`


## 多态报错
- 第一种是多态的方式创建LinkedList，只可以调用LinkedList中实现的Lisit接口的方法，而不可以调用LinkedList自身扩展的一些方法。
- <img width="680" alt="image" src="https://user-images.githubusercontent.com/32152091/183297847-f4d27914-864f-4a18-ad1a-0ee740a722ed.png">


### END
