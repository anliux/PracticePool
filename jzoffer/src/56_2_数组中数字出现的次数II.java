//56.2 - 数组中数字出现的次数II
//思路：位运算+遍历统计



//位运算+遍历统计
/*
  - 算法：
    - 初始化一个统计数组counts，长度根据定义的元素范围：`<2^31`设置为32；
    - 两层循环：外循环遍历数组元素，内循环统计数组元素中每一位的1的个数
      - 外循环因为不涉及索引值，因此可以用`for(int i : array)`的形式
      - 内循环中，`元素 & 1`求最低位是否为1并累加到统计数组counts的对应元素，然后将数组元素无符号右移一位后，循环再次计算。
    - 初始化结果变量res，和参数m=3
      - 注：这里m可以根据题目要求修改为其他数字，依然适用
    - 遍历统计数组counts，对每一位`%3`，并通过或运算添加到res
      - 这里用到了或运算的性质，比较巧妙。
      - 注：这里因为res左移，因此先计算高位，从高到低 `counts[31-i] % m`
    - 返回结果变量res。
*/
class Solution {
    public int singleNumber(int[] nums) {
        //初始化一个统计数组，并设置长度为32
        int[] counts = new int[32];

        //两层循环：外层遍历数组nums，内层统计数组元素的每一位的1的个数。
        for(int i : nums){
            for(int j = 0; j < 32; j++){
                counts[j] += (i & 1);
                i = i >>> 1;
            }
        }

        //定义结果变量res，以及参数m=3
        int res = 0, m = 3;

        //遍历统计数组counts，并用或运算将遍历取余结果添加到res变量
        for(int i = 0 ; i < 32; i++){
            res = res << 1;
            res = res | (counts[31-i] % m); 
                //注：这里因为res左移，因此先计算高位，从高到低
        }

        //返回结果变量res
        return res;
    }
}
