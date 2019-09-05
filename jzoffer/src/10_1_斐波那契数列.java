//10.1 - 斐波那契数列
//典型递归，但用递归重复过多；用循环实现递归。

public class Solution {
    public int Fibonacci(int n) {
        int pre1 = 0; //第一项
        int pre2 = 1; //第二项
        int fib = 0; //定义运算结果
        if(n==0) //根据公式，n=0时返回0
            return 0;
        if(n==1) //根据公式，n=1时返回1
            return 1;
        for(int i=2; i<=n; i++) //循环计算
        {
            fib=pre1+pre2;
            pre1=pre2; //将前一项的值赋值给后一项
            pre2=fib; //将前一项的值赋值给后一项
        }
        return fib; //
    }
}