//30-包含min函数的栈
//思路：两个栈；一个栈；不用栈



//两个栈：14 ms/22.91%; 43.6 MB/20.86%
//算法：两个栈，一个正常操作，另一个存储最小值

/*
  - 两个栈：
    - 用两个栈，一个栈去保存正常的入栈出栈的值，另一个栈去存最小值，也就是用栈顶保存当前所有元素的最小值。
    - 存最小值的栈的具体操作流程如下：
      - 将第一个元素入栈。
      - 新加入的元素如果大于栈顶元素，那么新加入的元素就不处理。
      - 新加入的元素如果小于等于栈顶元素，那么就将新元素入栈。
      - 出栈元素不等于栈顶元素，不操作。
      - 出栈元素等于栈顶元素，那么就将栈顶元素出栈。
*/

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        //stack正常入栈，minStack判断是否是最小值后入栈
        stack.add(x);
        
        //minStack为空时，push；不为空时，与栈顶元素比较，小于等于当前min则存入
        if(minStack.isEmpty() || x<=minStack.peek())
            minStack.add(x);
    }
    
    public void pop() {
        //stack正常出栈，minStack栈顶与stack出栈对比，相等时出栈
        int a = stack.pop();
        //这里需要用equals()而不是==，Integer 缓存[-128,127]的值,当添加的值超过该范围时,会重新在堆中new 一个对象
        if(a.equals(minStack.peek()))
            minStack.pop();
    }
    
    public int top() {
        //peek()获取栈顶的值
        return stack.peek();
    }
    
    public int min() {
        //min存放在minStack的顶部，返回minStack的peek即可
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
 
 
 
 //一个栈：7ms，击败87%的用户(leetcode记录)
 /*
    - 只用一个变量去保存最小值，这时的关键是：如何保留最小值的记录（如果最小值弹出了，就会用到历史的最小值）
    - 解决：当有更小的值来的时候，只需要把之前的最小值入栈，当前更小的值再入栈即可。当这个最小值要出栈的时候，下一个值便是之前的最小值了。
    - 注意：push()中的if判断需要包含等于：因为如果此时的x弹出，最小值仍是原来的那个。如果等于就不压栈，那么一旦弹出，原相等的最小值就没了。
      - 等于不会死循环，这里的push是库函数不是上面的push
 */
 class MinStack {

    /** initialize your data structure here. */
    //新建一个栈，与一个存储当前最小值的变量（注意最小值初始化值）
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public MinStack() {
        // 当用一个栈、一个min变量时，这里用不到
    }
    
    public void push(int x) {
        //如果x比min更小，则先将min压栈，并更新min的值；然后再将x压栈
        if(x <= min){ //需要包含等于：因为如果此时的x弹出，最小值仍是原来的那个
            stack.push(min);//等于不会死循环，下面的push是库函数不是上面的push
            min = x;
        }
        stack.push(x);

    }
    
    public void pop() {
        //判断：如果弹出最小值，那么将min更新为stack中的下一个值并将其弹栈
        if(stack.pop() == min) //这里pop一次
            min = stack.pop(); //将栈中原最小值下面的元素也pop，并将值返回给min
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        //直接返回min变量
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
