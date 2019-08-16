/*
09-用两个栈实现队列

注意：栈相关的用法（创建、压栈弹栈、判空等）
*/
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    //栈1负责进栈，栈2负责弹栈
	public void push(int node) {
        stack1.push(node); //若进栈，找栈1即可
    }
    
    public int pop() { //弹栈前先对栈2判空
		if(stack1.empty() && stack2.empty()) //当栈1和2都空时，抛出异常
			throw new RuntimeException("Queue is empty!");
		if(stack2.empty()) //当栈2空时，先从栈1弹出并存入栈2，之后进行弹出操作
		{
			while(!stack1.empty()) //这里要循环直至栈1为空，否则取不到第一个进栈的元素
				stack2.push(stack1.pop());
		}
		return stack2.pop(); //当栈2非空时，直接弹出即可
    }
}
