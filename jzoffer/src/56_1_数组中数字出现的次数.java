//56.1 - 数组中数字出现的次数
//思路：异或+分组+异或



//耗时：1 ms/100.00%; 43.3 MB/11.95%
class Solution {
    public int[] singleNumbers(int[] nums) {
        //初始化全部异或结果变量
        int res = 0;

        //遍历
        for(int i : nums){
            res ^= i;
        }

        //取res中第一位为1的位
        int flag = 1;
        while((flag & res) == 0)//注意运算符优先级，需要加小括号
            flag <<= 1;

        //定义结果数组a和b
        int a = 0, b = 0;

        //遍历，分流
        for(int i : nums){
            if((i & flag) == 0)
                a ^= i;
            else
                b ^= i;
        }

        //返回结果
        return new int[]{a,b};
    }
}
