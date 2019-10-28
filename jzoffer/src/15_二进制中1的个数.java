//15 - 二进制中1的个数
//设计二进制，考虑位运算。分析常规思路的不足，使用技巧解法。

//技巧解法
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}

//Integer.bitCount(); -- 计算一个int，long类型在二进制下“1”的数量。
//注：integer是lang包里的，不需要import。
public class Solution {
    public int NumberOf1(int n) {
        return Integer.bitCount(n);
    }
}