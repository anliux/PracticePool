//10.4 变态跳台阶
//虽然是变态，但是找到等比数列规律且发现可以用位移运算以后还是很简单的。

public class Solution {
    public int JumpFloorII(int target) {
        if(target<=0)
            return 0;
        return 1<<(target-1);//位移target-1次相当于求了2的多少次。
    }
}