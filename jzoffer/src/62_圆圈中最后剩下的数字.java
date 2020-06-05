//62 - 圆圈中最后剩下的数字
//思路：模拟环形链表；数学法。



//7ms，击败99.84%的用户
class Solution {
    public int lastRemaining(int n, int m) {
        if(n<1 || m<1)
            return -1;
        int res = 0;
        for(int i = 2; i <= n; i++){
            res = (res + m) % i;
        }
        return res;
    }
}
