//22-链表中倒数第 K 个结点
//思路：快慢指针



//快慢指针：0ms/100%;39.2 MB/90.20%
/*
  - 算法：
    - 判空：当链表为空或者k为0时返回空；
    - 初始化快慢指针；
    - 构建k的距离：循环实现，并判断，当快指针为null时，返回null(针对于k大于结点数的情况)
    - 双指针共同移动，直到快指针指向null，则返回慢指针对应结点。
  - 其他方法：数学思想
    - 先遍历统计链表长度，记为 n ；设置一个指针走 (n−k) 步，即可找到链表倒数第 k 个节点。
    - 缺点：两次遍历，用上述方法一次遍历即可达成。
  - 注意：剑指原书指出，本题关于鲁棒性的考点
    - 链表为空：返回空
    - k为0：返回空
    - 如果k大于链表节点数：返回空。
      - 在快指针走时进行判断：`if(former == null) return null;`
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        //判空：链表为空，或k=0时返回null
        if(head == null || k == 0)
            return null;
        
        //初始化快慢指针
        ListNode fast = head, slow = head;

        //构建快慢指针距离
        for(int i = 0; i < k; i++){
            //先判断快指针是否超过链表指向了null
            if(fast == null)
                return null;
            
            //向后移动一步；
            fast = fast.next;
        }

        //两指针同步移动，直到快指针指向null
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        //返回结果
        return slow;
    }
}
