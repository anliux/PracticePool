//0083-删除排序链表中的重复元素
//思路：简单链表操作



//耗时：1ms，击败98.6%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //定义当前指针的链表结点
        ListNode current = head;

        //循环：直到链表末尾。注意判空
        while(current != null && current.next != null){
            //判断本结点与next结点的值：相同则更新next，不同则更新current
            if(current.val == current.next.val)
                current.next = current.next.next;
            else 
                current = current.next;
        }

        //返回值：注意是head，不是current，current相当于for循环中的int
        return head;
    }
}
