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
        //删除头结点：返回head.next
        if(head.val == val)
            return head.next;
        
        //定义双指针
        ListNode pre = head, cur = head.next;

        //遍历链表，并在寻找到val对应结点之后终止循环
        while(cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }

        //跳过cur，直接将pre与cur.next连接
        pre.next = cur.next;
        return head;
    }
}



//时间复杂度1：原题给了需要删除节点的指针，所以才能实现时间复杂度O（1）
