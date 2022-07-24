//15 - 二进制中1的个数
//设计二进制，考虑位运算。分析常规思路的不足，使用技巧解法。

//技巧解法: 0ms/100%
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){//需要判断是否为0，直接写n会报类型错误
            count++;//n不为0，则至少有一个1，可直接自增1
            n = (n-1) & n;//位运算规律：(n-1) & n，会让n最后一位的1变为0
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
