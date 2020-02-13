//0069-x的平方根
//思路：二分；牛顿迭代法



//二分：2ms，击败84.9%的用户
/*
    - 如果 x<2，返回 x。
    - 当 x≥2 时，它的整数平方根一定小于 x/2 且大于 0，即 0<a<x/2。由于 a 一定是整数，此问题转换成在有序整数集中寻找一个特定值
    - 找到边界，取中间值并求平方，在与x比较后调整边界，循环逼近，最后返回边界值中较小的一个。
*/
class Solution {
    public int mySqrt(int x) {
        //x是非负整数，x<2 即 0 和 1
        if(x<2)
            return x;
        
        //定义左右边界
        int left = 2, right = x / 2;

        //循环：直到left<=right不再成立
        while(left <= right){
            //定义中间值pivot，中间值乘积nums，为防止溢出，num定义为long
            int pivot = left + (right - left) / 2;
            long num = (long) pivot * pivot;

            //判断num与x的大小
            if(num > x)
                right = pivot - 1;
            else if(num < x)
                left = pivot + 1;
            else 
                return pivot;
        }

        //向下取整，当上述循环条件不成立时，最终right会小于left
        return right;
    }
}
