//14-2 - 剪绳子进阶
//思路：贪心



//贪心：0ms，击败100%的用户
class Solution {
    public int cuttingRope(int n) {
        if(n <= 1)
            return 0;
        else if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        
        long res = 1;
        while(n > 4){
            reas *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }
}
