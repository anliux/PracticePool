//65 - 不用加减乘除做加法
//关键：发现规律--不进位加法对应异或，进位对应与运算+左移1位，
//循环跳出条件为当两数其一为0（官方说法是进位为0），即把循环中的第一个数看作不进位加法，第二个数看作与运算左移



//三步走+位运算：0ms/100%; 38.2 MB/58.46%
class Solution {
    public int add(int a, int b) {
        while(b!=0){
            //计算非进位和sum
            int sum = a ^ b;

            //计算进位carry
            int carry = (a & b) << 1;

            //更新值
            a = sum;
            b = carry;
        }
        //返回非进位和
        return a;
    }
}

//改用do-while：0ms/100%; 38.1 MB/77.99%
class Solution {
    public int add(int a, int b) {
        do{
            int sum = a ^ b;//计算非进位和
            int carry = (a & b) << 1;//计算进位
            a = sum;
            b = carry;
        }while(b != 0);
        return a;
    }
}



//这里的简化：。。。
public class Solution {
    public int Add(int num1,int num2) {
	// 找准判停条件是关键
        return (num2==0) ? num1 : Add(num1^num2, (num1&num2)<<1);
    }
}
