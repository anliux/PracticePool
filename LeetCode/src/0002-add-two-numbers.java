//0002-两数相加
//思路：模拟初等数学加法



//耗时：2ms，击败99.97%的用户
/*

   算法：
    - 定义res链表结点并初始化，定义三个结点p，q，cur追踪两链表的移动和res链表的当前位置，定义进位carry
    - 循环直到两链表均为空:
      - 定义变量存储当前结点对应的值val，存储前需要判断当前结点是否为null，为空时返回0，可以用三目运算符；
      - 定义sum和将上述变量和进位carry的和，并整除计算进位carry；
      - 将整除取余结果存入新建结点并赋值给cur.next，然后将cur向后移动；
      - 判断p，q结点是否为空，不为空时p，q结点向后移动。
    - 循环结束后，判断最高位是否仍有进位，即carry是否大于0
    - 返回res.next链表

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义存储结果的链表res，并初始化（这个值用不到，可以定义为0）
        ListNode res = new ListNode(0);
        ListNode p = l1, q = l2, cur = res;

        //定义进位变量carry
        int carry = 0;

        //循环：直到p和q都为null
        while(p!=null || q!=null){
            //定义变量保存结点对应的值：需要判断是否为null
            int a = (p==null) ? 0 : p.val;
            int b = (q==null) ? 0 : q.val;

            //定义和sum，并根据sum求进位carry
            int sum = a + b + carry;
            carry = sum / 10; 

            //新建结点并将sum取余结果存入，然后赋值给cur.next
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            //更新p和q
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }

        //循环结束后，判断最高位是否有进位
        if(carry > 0){
            cur.next = new ListNode(carry);
        }

        //返回结果链表res：不包含头结点
        return res.next;
    }
}
