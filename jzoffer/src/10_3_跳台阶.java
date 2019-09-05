//10.3 - 跳台阶
//思路同斐波那契数列，注意首项和次项同斐波那契数列的区别

public class Solution {
    public int JumpFloor(int target) {
        if(target<=0)
            return 0;
        //此处有稍稍的优化
        if(target==1 || target==2)
            return target;
        int result = 0;//这里必须优化否则报错
        int pre1=1;
        int pre2=2;
        for(int i=3;i<=target;i++)
        {
            result=pre1+pre2;
            pre1=pre2;
            pre2=result;
        }
        return result;
    }
}