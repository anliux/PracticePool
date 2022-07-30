//25-合并两个排序的链表
//思路：递归；迭代 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



//递归：0ms/100%; 41.6 MB/27.69%
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



//迭代：0ms/100%; 41.4 MB/53.16%
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建结点prehead，并将结点值赋值为-1 (val 赋值为其他值也没有问题)
        //注：操作的是prehead的next结点(cur初始也一样)
        ListNode prehead = new ListNode(-1), cur = prehead;
        
        //两链表均非空的情况：包含走一半，其中一个链表已走完，则直接跳出的情况
        //判断后：对链表结点和prev结点的位置均进行移动，其中prev的移动属于公共操作
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;//注意：这里是cur.next，形成链，后面cur指针从cur移动到next
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        //某链表为空的情况：注意这里是对prev进行操作，考虑没有直接跳过的情况，是将上述循环中没有走完的小部分结点连到prev结点后
        cur.next = (l1==null)? l2 : l1;

        //最终返回哨兵结点prehead的next
        return prehead.next;
    }
}
