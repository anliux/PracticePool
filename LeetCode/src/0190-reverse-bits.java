//0190-颠倒二进制位
//思路：位运算



//耗时：1ms，击败100%的用户
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //定义一个辅助变量res，并初始化为0
        int res = 0;

        //循环32次：遍历所有32位
        for(int i=0; i<32; i++){
            //res左移一位空出最低位，并将n的最低位取出加到res
            res = res << 1;
            res += n&1;

            //砍去n的最低位
            n = n >> 1;
        }

        //返回结果
        return res;
    }
}
