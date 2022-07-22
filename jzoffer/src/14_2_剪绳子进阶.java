//14.2 - 剪绳子进阶
//思路：贪心


//贪心：0ms/100%; 38.6 MB/12.69%
class Solution {
    public int cuttingRope(int n) {
        if(n==2)
            return 1;
        else if(n==3)
            return 2;
        long res = 1;
        
        while(n>4){//每次减去3，最终的乘积最大。长度小于等于4时，不再裁减，保持原长度乘积最大
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
