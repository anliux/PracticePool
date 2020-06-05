# 知识点



# I. 数据结构
## 数学
- 最大值：`int a = Math.max(i,j);`
  - 注：参数是两个值
- 最小值：`int b = Math.min(i,j);`
  - 注：参数是两个值
- 绝对值：`int c = Math.abs(i);`
- 次幂值：`int d = Math.pow(a,b);` -- a的b次幂
- 向上取整：`int e = Math.ceil(i);`
  - 返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
- 向下取整：`int f = Math.floor(i);`
  - 返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。




## 数组

- ### ArrayList
  - 创建：`ArrayList<ArrayList<Integer>> result = new ArrayList<>();` 
    - 注：参考要求的返回值类型
  - 与数组int[]的相互转换：
    - `List<int[]> answer = new ArrayList<>(); return (int[][])answer.toArray(new int[0][]); `



- ### Arrays常用方法：
  - `Arrays.fill(arrName, arrValue)`: 将值arrValue赋值给arrName数组的每个位置。
  - `Arrays.copyOfRange(arrName, start, end)`: 返回左闭右开索引值范围内的数组片段。



- ### 其他类的数组相关方法：
  - `System.arraycopy(Object src,int srcPos,Object dest, int destPos,int length)`: 制数组复
    - src：源数组；dest：目标数组
    - Pos：位置；srcPos：源数组的起始位置；destPos：目标数组的起始位置
    - length：复制的长度
    - 参考题目：easy-88题



## 字符串
- ### String常用方法：
  - `char[] chars = str.toCharArray();` 
    - 将此字符串转换为一个新的字符数组。
  - `charAt(int index)` 
    - 返回指定索引处的 char 值。
  - `boolean equals(Object anObject)`：
    - 将此字符串与指定的对象比较。参数不为空且相等时返回true。
  - `replace(CharSequence target, CharSequence replacement)`：
    - 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
  - `String str = String.join(" ", arrStr);`：
    - 将字符串数组arrStr中的元素通过连字符连接起来，可用于特定格式输出等。
  - `String[] s1=s.trim().split(" +");`  
    - 加上+以后，可以剪去字符串之间的多个空格，只保留非空格字符。  
    

- ### StringBuilder / StringBuffer 常用方法：
  - 创建：`StringBuilder sb = new StringBuilder();`
  - 添加元素，可连续添加：`sb.append(words[i]).append(" ");`
  - 转为字符串类型：`String str = sb.toString();`



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
 
- ### LinkedList常用方法：
  - add()：将指定元素添加到此列表的结尾。
    - add(int index, E element)：在此列表中指定的位置插入指定的元素。
    - addFirst(E e)：将指定元素插入此列表的开头。
    - addLast(E e)：将指定元素添加到此列表的结尾。
  - get(int index)：返回此列表中指定位置处的元素。
    - getFirst()：返回此列表的第一个元素。
    - getLast()：返回此列表的最后一个元素。
  - poll()：获取并移除此列表的头（第一个元素）
    - pollFirst()：获取并移除此列表的第一个元素；如果此列表为空，则返回 null。
    - pollLast()：获取并移除此列表的最后一个元素；如果此列表为空，则返回 null。
 
 
 
 ## 栈
 - ### 注：栈Stack的父类Vector<E>
 - ### 常用方法
   - 长度：stack.size() -- 实现了父类Vector的size()方法；
   - 转为数组：stack.toArray() -- 实现了父类Vector的toArray()方法；
 
 
 

## 队列
- ### 实现的子类：
  - LinkedList

- ### 常用方法
  - poll()：获取并移除此列表的头（第一个元素），如果此队列为空，则返回 null。
  - remove()：获取并移除此队列的头。



## 哈希表
- ### HashSet：
  - `public boolean add(E e)`: 返回值是布尔型
    - 如果此 set 中尚未包含指定元素，则添加指定元素。
    - 更确切地讲，如果此 set 没有包含满足 (e==null ? e2==null : e.equals(e2)) 的元素 e2，则向此 set 添加指定的元素 e。
    - 如果此 set 已包含该元素，则该调用不更改 set 并返回 false。

- ### HashMap:
  - 新建哈希表：`Map<Integer, Integer> map = new HashMap<>();`
    - 注意：哈希表是键值对，尖括号中对应key-value的数据类型，别只写一个。
  - `getOrDefault(Object key, V defaultValue)` : 如果存在key返回对应的value，否则返回defaultValue

- ### HashMap常用方法
  - 新建：`Map<Integer, Integer> map = new HashMap<>();`
  - 判断key是否在哈希表中：`boolean map.containsKey(i);`，存在时返回true
  - 判断value是否在哈希表中（可能有多个value）：`boolean map.containsValue(i);`，存在时返回true
  - 获取key键对应的值：`map.get(key)`
    - 返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null。
  - 将键值对存入哈希表中：`map.put(key,value)`
  - 移除哈希表中指定的键值对：`map.remove(key)`  --  从此映射中移除指定键的映射关系（如果存在）
  - 移除哈希表中所有的键值对：`map.clear()` -- 移除map中的所有映射关系
  - 哈希表判空：`map.isEmpty()` -- 如果此映射不包含键-值映射关系，则返回 true。
  - 哈希表大小：`map.size()` --  返回此映射中的键-值映射关系数


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


## 树
- 二叉排序树/二叉搜索树
  - 左小右大；
  - 二叉排序树的中序遍历：递增序列。
    - 左根右：递增；右根左：递减。
  
- 打印中序遍历
    ```
    // 打印中序遍历
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left); // 左
        System.out.println(root.val); // 根
        dfs(root.right); // 右
    }
    ```

- 平衡二叉树
  - 平衡：子树高度差<2，并且子树也是平衡树
   ```
        // 自顶向下
        return Math.abs( height(root.left) - height(root.right) ) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
        
        // 自底向上
        //先枝剪，排除不符合的情况：判空，左-1，右-1；当左右子树都符合平衡树时，返回计算结果
        return Math.abs(left-right)<2 ? 1+Math.max(left, right) : -1;
   ```
  
  
  
# II. 算法思想
## 排序
- ### 时间复杂度：
  - 最快是O(nlogn)，包括希尔，归并，快速，堆；
  - 最慢是O(n^2)，包括冒泡，选择，插入；
    - 冒泡和插入：最好的情况是O(n);

- ### 稳定性：
  - 定义：稳定性是指排序前后，数列中的相同数字的相对位置不变。
    - 例如：A1=A2，A1在A2的前面；排序后，仍然是A1在A2前面。
  - 稳定：冒泡，插入，归并；
  - 不稳定：选择，希尔，快排，堆；



## 动态规划
- 动态规划三要素：重叠子问题、最优子结构、状态转移方程
  - 思维框架：明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case。
  - 思考步骤：暴力递归寻找要素；用备忘录优化子问题；自底向上消除重叠计算；



## 递归
- 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。



## 滑动窗口
- 滑动窗口中，两指针朝同一个方向滑动，比如全部朝右++的方向移动。



# III. 记忆

## 关键词知识点

- 用数组处理字母：“包含大小写字母”：
  - 可以定义为`char[58]`，因为大小写加上中间的字符一共58个；
  - 可以定义为`char[128]`，因为字符的 ASCII 值的范围为`[0, 128)`。

- 字符串中字母出现次数计数：
  - charAt获取字母，剪去'A'可以将字母转为数字，然后作为数组索引值，再讲索引值对应的count作为数组元素。
  - eg:`words[s.charAt(i) - 'A'] += 1;`


## 常规记忆知识点
- 创建哑结点dumb，用于连接后续结点，最后返回dumb.next。例如“剑指25题：合并两个排序链表”
  - ListNode dumb = new ListNode(-1);
  - ListNode cur = dumb;
  - .....
  - return dump.next;
- 奇偶数的二进制特性：
  - 二进制的奇数最低位是1，偶数最低位是0：可通过和数字1做与运算`n&1`得出数字n的奇偶性。

- 不用常规方法做加法：
  - 1+2+..+n：利用递归来实现循环while的功能(通过定义一个布尔型变量来运算)，利用短路 && 来实现 if 的功能

- 求最大公约数：辗转相除法
  - 算法：以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数。
  - 计算公式gcd(a,b) = gcd(b,a mod b)，前一个可看做被除数，后一个是除数，(a%b)即为余数，递归。
  - 多个数字的最大公约数：`gcd(a,b,c)=gcd(gcd(a,b),c);`
  - 示例：
    ```
    // 辗转相除法
      private int gcd (int a, int b) {
          return b == 0? a: gcd(b, a % b);//余数为0时，返回除数的值。
      }
    ```
    
    
    
### END
