//0012-整数转罗马数字
//思路：贪心；哈希表



//耗时：5ms，击败90.96%的用户
/*
  - 算法：
    - 复杂度：时间O(1)，空间O(1) -- 因为表的长度是有限的13个。
    - 首先：建表，使用两个数组模拟哈希表的键值对，一个数组values存放数字，一个数组strs存放数字对应的字母，数字按照从大到小的顺序；
      - 注意：strs数组赋值时，记得给字母加双引号。
    - 新建可变字符串StringBuilder，命名为res，用于存放转化为的字母；
    - 遍历数字数组：
      - 从头开始，整除结果quotient如果是0，continue直接结束本次循环并进入下一次循环；
      - 整除结果如果不是0，则对应到字符串数组中，并使用小循环将'商'次的对应字母添加到结果字符串；
      - 将num减去进行添加的`quotient * values[i]`；
      - 对num的值进行判断，为0时终止循环。
    - 返回结果：先转为String，然后返回。
    - 注意：对特殊值的处理是，将几个特殊值加入表中。
*/
class Solution {
    public String intToRoman(int num) {
        //制表：用两个数组将数值与字符存放起来，模拟哈希表的键值对关系
        //注意：要将特殊的6组规则也放入表中，避免复杂判断和计算
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //定义可变字符串StringBuilder来存放最终结果
        StringBuilder res = new StringBuilder();

        //遍历数字数组values，直到num为0，或者遍历完毕
        for(int i = 0; i < values.length; i++){
            //num对value[i]整除的商存储起来：如果是0，结束本次循环并开始下次循环
            int quotient = num / values[i];
            if(quotient == 0)
                continue; //为0时跳出本次循环，并重新进入下次循环。

            //将value[i]对应的字母添加到res：商是几，就添加几次
            for(int j = 0; j < quotient; j++){//仅仅是控制次数的小循环
                res.append(strs[i]);
            }

            //更新num
            num = num - quotient * values[i];

            //判断num的值：为0时，提前终止循环
            if(num == 0)
                break;
        }

        //将res转为String，并返回
        return res.toString();
    }
}
