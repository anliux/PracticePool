//65 - 不用加减乘除做加法
//关键：发现规律--不进位加法对应异或，进位对应与运算+左移1位，
//循环跳出条件为当两数其一为0（官方说法是进位为0），即把循环中的第一个数看作不进位加法，第二个数看作与运算左移

public class Solution {
    public int Add(int num1,int num2) {
		// 找准判停条件是关键
        return (num2==0) ? num1 : Add(num1^num2, (num1&num2)<<1);
    }
}