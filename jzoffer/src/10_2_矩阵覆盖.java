//10.2 - 矩阵覆盖
//思路同斐波那契数列，注意首项和次项同斐波那契数列的区别。

public class Solution {
    public int RectCover(int target) {
        if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        int pre1=1;
        int pre2=2;
        int result=0;
        for(int i=3; i<=target; i++)
        {
            result=pre1+pre2;
            pre1=pre2;
            pre2=result;
        }
        return result;
    }
}