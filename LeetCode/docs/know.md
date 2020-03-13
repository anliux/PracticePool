# 知识点



# I. 数据结构
## 数组
- ### 复制数组：
  - `arraycopy(Object src,int srcPos,Object dest, int destPos,int length)`
  - src：源数组；dest：目标数组
  - Pos：位置；srcPos：源数组的起始位置；destPos：目标数组的起始位置
  - length：复制的长度
  - 参考题目：easy-88题




## 字符串
- ### 常用方法：
  - boolean equals(Object anObject)：将此字符串与指定的对象比较。参数不为空且相等时返回true。



## 链表
- ### 新建链表
  - `ListNode list=new ListNode();` ：初始化一个空节点，无值,不提倡此种写法。
  - `ListNode list=new ListNode(0);`：初始化一个节点值为0的空节点，最常用最正规写法
  - `ListNode list=null;`：为空，什么都没有，一般不这么写；
  - 注：链表结点定义没有尖括号。

- ### 链表结点取值
  - `value = list.val;` -- 将结点List的值赋值给变量value，没有圆括号。
  
- ### 注意点：
  - 操作结点时，注意存储顺序，必要时将结点信息存入临时变量，防止链表断开。
 
 
 
 
 ## 栈
 - ### 注：栈Stack的父类Vector<E>
 - ### 常用方法
   - 长度：stack.size() -- 实现了父类Vector的size()方法；
   - 转为数组：stack.toArray() -- 实现了父类Vector的toArray()方法；
 
 
 

## 哈希表
- ### HashSet：
  - `public boolean add(E e)`: 返回值是布尔型
    - 如果此 set 中尚未包含指定元素，则添加指定元素。
    - 更确切地讲，如果此 set 没有包含满足 (e==null ? e2==null : e.equals(e2)) 的元素 e2，则向此 set 添加指定的元素 e。
    - 如果此 set 已包含该元素，则该调用不更改 set 并返回 false。

- ### HashMap:
  - `getOrDefault(Object key, V defaultValue)` : 如果存在key返回对应的value，否则返回defaultValue



## 双向队列ArrayDeque：
- ### 简介
  - Deque：接口的大小可变数组的实现。
  - ArrayDeque：数组双端队列没有容量限制；它们可根据需要增加以支持使用。它们不是线程安全的；在没有外部同步时，它们不支持多个线程的并发访问。禁止 null 元素。此类很可能在用作堆栈时快于 Stack，在用作队列时快于 LinkedList。

- ### 常用方法：
  - add(E e)：将指定元素插入此双端队列的末尾。
  - addFirst(E e)：将指定元素插入此双端队列的开头。
  - addLast(E e)：将指定元素插入此双端队列的末尾。
  - getFirst()：获取，但不移除此双端队列的第一个元素。
  - getLast()：获取，但不移除此双端队列的最后一个元素。
  - isEmpty()：如果此双端队列未包含任何元素，则返回 true。
  - remove()：获取并移除此双端队列所表示的队列的头
  - remove(Object o)：从此双端队列中移除指定元素的单个实例。
  - removeFirst()：获取并移除此双端队列第一个元素。
  - removeLast()：获取并移除此双端队列的最后一个元素。
  - size()：返回此双端队列中的元素数。
  - toArray()：返回一个以恰当顺序包含此双端队列所有元素的数组（从第一个元素到最后一个元素）。
  - toArray(T[] a)：返回一个以恰当顺序包含此双端队列所有元素的数组（从第一个元素到最后一个元素）；返回数组的运行时类型是指定数组的运行时类型。



# II. 算法思想
## 排序
- ### 时间复杂度：
  - 最快是O(nlogn)，包括希尔，归并，快速，堆；
  - 最慢是O(n^2)，包括冒泡，选择，插入；
    - 冒泡和插入：最好的情况是O(n);

- ### 稳定性：
  - 稳定：冒泡，插入，归并；
  - 不稳定：选择，希尔，快排，堆；



## 动态规划
- 动态规划三要素：重叠子问题、最优子结构、状态转移方程
- 思维框架：明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case。
- 思考步骤：暴力递归寻找要素；用备忘录优化子问题；自底向上消除重叠计算；



## 递归
- 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。





### END
