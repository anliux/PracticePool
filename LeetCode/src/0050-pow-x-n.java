//50. Pow(x, n)
//快速幂


//快速幂-递归：0ms/100%; 40.3 MB/94.62%
class Solution {
    public double myPow(double x, int n) {
        //考虑边界值，防止负数取相反数溢出
        long N = n;
                
        if(N>0)
            return quickMul(x,N);
        else
            return (1.0 / quickMul(x,-N));
        //return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N){        
        if(N==0)
            return 1.0;
        
        double y = quickMul(x, N/2);
                
        if(N%2 == 0)
            return y*y;
        else
            return y*y*x;
        //return N % 2 == 0 ? y * y : y * y * x;
    }
}



//评论区大佬改进：对负指数和奇偶数部分进行了统一
class Solution {
    public double myPow(double x, int n) {
        //递归出口
        if(n==0)
            return 1.0;
        else if(n==1)
            return x;
        else if(n==-1)
            return 1.0/x;
        
        double half = myPow(x, n/2);
        double mod = myPow(x, n%2);
        return half * half * mod;
    }
}



//直接调用pow函数
public class Solution {
    public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
  }
}
