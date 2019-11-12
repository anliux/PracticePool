//64 - 求 1+2+3+...+n
//不能使用常规循环、判断、乘除的情况下，考虑借助逻辑与运算短路的特点

public class Solution {
    public int Sum_Solution(int n) {
		//定义求和变量
        int sum = n;

		//定义一个不需要返回、只需要借助来做短路与运算的布尔型变量
		//&&：可以用来做判断，前一个成立则做后一个，前一个不成立时，后一个不再做。
        boolean ans = (n>0) && ((sum+=Sum_Solution(n-1))>0);

		//最后返回sum值即可。

        return sum;
    }
}

//注：用双或也可以
/*

public class Solution {
    public int Sum_Solution(int n) {
        boolean falg=(n==0)||((n+=Sum_Solution(n-1))>-1);
        return n;
    }
}

*/