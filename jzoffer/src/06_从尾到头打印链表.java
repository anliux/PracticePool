/*
06-从尾到头打印链表
剑指提供两种思路：栈和递归；
cyc大神提供另一种思路：头插法 (未验证)。
评论区提供另一种思路：两次链表
*/


//思路1 - 栈：后进先出的结果与栈结构完美契合。
//使用ArrayList<>
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

//使用int[]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        //先存入栈，符合先进后出的性质
        Stack<Integer> stack = new Stack<>();

        //遍历链表：依次入栈，直到链表末尾
        while(head != null){
            stack.add(head.val);
            head = head.next;
        }
        
        //新建结果数组，并依次从栈中将元素弹出
        int[] res = new int[stack.size()];

        for(int i = 0; !stack.isEmpty(); i++){
            res[i] = stack.pop();
        }

        //返回结果数组
        return res;
    }
}



//思路2 - 递归：先调用后输出，直到结点指向为空

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


//思路3：两次遍历链表
//0ms，击败100%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        //定义计数器和当前的node结点
	int count = 0;
        ListNode node = head; 
        
	//第一次遍历链表：算出长度/链表元素个数    
	while(node != null){
            count++;
            node = node.next;
        }
        
	//定义结果数组，并将当前结点node复位到head，为再次遍历链表做准备
        int[] res = new int[count];
        node = head;
	    
	//第二次遍历：正序遍历链表，倒序遍历数组    
        for(int i = count-1; i >= 0; i--){
            res[i] = node.val;
            node = node.next;
        }
        return res;//返回结果
    }
}
