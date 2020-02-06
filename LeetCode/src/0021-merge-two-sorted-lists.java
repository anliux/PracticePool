//0021-合并两个有序链表
//思路：递归；迭代 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



//递归：1ms，击败87%的用户
/*
	算法：
    - 边界：当任一链表为null时，直接返回剩余链表（即返回非空链表）
      - 注：这里包括当两链表都是null的情况，因为仍然会返回其一。
    - 比较：将两个链表中头部较小的一个，与剩下元素的 merge 操作结果合并，最终返回此链表
      - 当list1[0]<list2[0]时：list1[0] + merge(list1[1:], list2)，并返回list1
      - 否则（包含等于情况）：list2[0] + merge( list1l, list2[1:])，并返回list2
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //先判空，后比较并进入递归
		if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}



//迭代：1ms，击败87%的用户
/*
    算法：
	- 顺序迭代的思路
    - 设定一个哨兵节点 "prehead" （以便在最后比较容易地返回合并后的链表）
    - 维护一个 prev 指针，并调整它的 next 指针
    - 重复以下过程，直到 l1 或者 l2 指向了 null ：
      - 如果 l1 当前位置的值小于等于 l2 ，把 l1 的值接在 prev 节点的后面，同时将 l1 指针往后移一个。
      - 否则，对 l2 做同样的操作。
      - 不管将哪一个元素接在了后面，都把 prev 向后移一个元素。
    - 最后加一步对于空链表的分析，并返回prehead
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建结点prehead，并将结点值赋值为-1
        //注：操作的是prehead的next结点(prev初始也一样)
        ListNode prehead = new ListNode(-1);

        //从头开始遍历两链表
        ListNode prev = prehead;

        //两链表均非空的情况：
        //判断后：对链表结点和prev结点的位置均进行移动，其中prev的移动属于公共操作
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        //某链表为空的情况：
        prev.next = (l1 == null) ? l2 : l1;

        //最终返回哨兵结点prehead的next
        return prehead.next;

    }
}