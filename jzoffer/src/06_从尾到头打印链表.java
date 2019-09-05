/*
06-从尾到头打印链表
剑指提供两种思路：栈和递归；cyc大神提供另一种思路：头插法。
这里仅测试剑指的两种思路。
*/

/*
思路1 - 栈：后进先出的结果与栈结构完美契合。
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>(); //新建栈
		while(listNode != null) //遍历并压栈直至遍历所有结点
		{
			stack.add(listNode.val); //压栈
			listNode = listNode.next; //结点指向结点的next
		}
		ArrayList<Integer> ret = new ArrayList<>(); //新建容器ret
		while(!stack.isEmpty()) // 遍历直到栈空
			ret.add(stack.pop()); //弹栈并将值赋值给ret容器
		return ret; //返回容器变量
    }
}

/*
思路2 - 递归：先调用后输出，直到结点指向为空
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
		if(listNode != null)
		{
			ret.addAll(printListFromTailToHead(listNode.next));
			ret.add(listNode.val);
		}
		return ret;
    }
}