//18.1-在 O(1) 时间内删除链表节点
//思路：时间复杂度n；时间复杂度1



//时间复杂度n：双指针 - 0ms，击败100%的用户
/*
  - 算法：
      - 特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
      - 初始化： pre = head , cur = head.next 。
      - 定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出。
      - 保存当前节点索引，即 pre = cur 。
      - 遍历下一节点，即 cur = cur.next 。
      - 删除节点： 执行 pre.next = cur.next 。
      - 返回值： 返回链表头部节点 head 即可。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        //头结点判断
        if(head.val == val)
            return head.next;

        //定义双指针
        ListNode pre = head, cur = head.next;

        //遍历: 判断+后移
        while(cur!=null && cur.val!=val){
            pre = cur;
            cur = cur.next;
        }   

        //不是遍历到尾结点没找到的情况：删除找到的结点
        if(cur!=null){
            pre.next = cur.next;
        }
            
        //遍历结束，返回头结点
        return head; 
    }
}



//时间复杂度1: 原题给定需要删除节点的指针，可以实现时间复杂度O（1）
/*
 - 算法：
      - 判空：头结点和删除结点，任一为null，则返回null；
      - 判断非尾结点：定义next结点，将next的值赋值给删除结点，然后将删除结点的next更新为next的next；
      - 如果删除结点的next为null，分类讨论：
        - 整个链表只有一个结点的情况：头结点等于删除结点，则将头结点指向null，即删除链表中的唯一结点；
        - 如果删除结点是尾结点，则定义指针cur，并遍历链表，直到cur的next为删除结点，然后将cur的next更新为null。
      - 删除完成后，返回头结点head。
*/
public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
    if (head == null || tobeDelete == null)
        return null;
    if (tobeDelete.next != null) {
        // 要删除的节点不是尾节点
        ListNode next = tobeDelete.next;
        tobeDelete.val = next.val;
        tobeDelete.next = next.next;
    } else {
        if (head == tobeDelete)
             // 只有一个节点
            head = null;
        else {
            ListNode cur = head;
            while (cur.next != tobeDelete)
                cur = cur.next;
            cur.next = null;
        }
    }
    return head;
}
