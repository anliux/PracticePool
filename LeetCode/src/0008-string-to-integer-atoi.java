//0008-字符串转换整数atoi
//思路：正则；非正则



//正则：15ms，击败7.63%的用户
//需要导入包
import java.util.regex.*;
class Solution {
    public int myAtoi(String str) {
        //清空字符串开头和末尾空格（这是trim方法功能，事实上我们只需清空开头空格）
        str = str.trim();
        //java正则表达式
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;
        //判断是否能匹配
        if (m.find()){
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e){
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return value;
    }
}



//非正则：3ms，击败52.43%的用户
/*
   - 函数返回值是int型，在任何情况下，不能进行有效的转换时都返回 0；
    - 从非空格字符开始算起：`str.trim()`剪去空格
      - str.trim() ：返回字符串的副本，忽略前导空白和尾部空白；如果字符串是空串，则返回str。
    - 判空：字符串为null，或者字符串长度为0时返回 0；
    - 定义结果变量res=0，起始位start=0；
    - 取第一个字符并赋值给firstChar
    - 考虑结果的符号正负：定义符号变量sign=1，然后判断firstChar是否是正负号中的一个，如果不是，不操作，继续后续步骤；
    - 循环：遍历字符串直到末尾，同时逐个取字符进行判断
      - 如果不是数字，就结束循环并返回结果：`Character.isDigit(j)==false`时`return (int) res * sign;`
      - 将第i个字符转为数字并赋值给变量：`pop = str.charAt(i) - '0';`
      - 为防止溢出，对res的值进行越界判断：sign为1时，以及为-1时，分类讨论
      - 排除各种异常情况后，计算res的值：`res = (int) res*10 + pop;`
    - 循环结束后返回`return res * sign;`
    - 注：越界判断参考<easy-7题>
      - 对于正数部分：
        - 考虑常规：`rev > Integer.MAX_VALUE/10` 时，rev * 10 必定大于Integer的Max值，不符合条件
        - 考虑临界：`rev == Integer.MAX_VALUE / 10` 时，整除会削去个位的值，因此，若再乘以10，个位是0。这时再加某值，这个值需要小于MAX值的个位，否则越界。因此：`pop > Integer.MAX_VALUE % 10`
      - 对于负数部分：因为sign符号是return的时候再添加的，所以需要rev和pop在此处写为-rev和-pop
        - 同理：`rev < Integer.MIN_VALUE / 10， 以及 rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10`
*/
class Solution {
    public int myAtoi(String str) {
        //首先剪去空格
        str = str.trim();

        //判空
        if(str == null || str.length() == 0)
            return 0;
        
        //定义结果res，符号sign，以及起始位start
        int res = 0;
        int sign = 1; //正1负-1，默认为1，因为正号可以省略
        int start = 0;

        //获取第一个位置的字符，并对其可能是符号位进行判断
        char firstChar = str.charAt(0);
        if(firstChar == '+'){
            sign = 1;
            start++;
        }else if(firstChar == '-'){
            sign = -1;
            start++;
        }

        //循环：遍历字符串，直到遇到非数字字符，或者遍历完成字符串
        for(int i = start; i < str.length(); i++){
            //首先判断是否是非数字字符
            if(Character.isDigit(str.charAt(i)) == false)
                return res * sign;

            //将第i个字符转为数字并赋值给变量
            int pop = str.charAt(i) - '0';
            
            //从正数最值和负数最值的角度分别讨论越界问题：下一步要 res*10
            if(sign == 1){//正数：普遍情况和临界值
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
            }
            if(sign == -1){//负数：普遍情况和临界值
                if(-res < Integer.MIN_VALUE/10 || (-res == Integer.MIN_VALUE/10 && -pop < Integer.MIN_VALUE % 10))
                    return Integer.MIN_VALUE;
            }

            //排除各种不符情况后，计算res的值
            res = res * 10 + pop;
        }

        //遍历到字符串结尾结束后，返回res的值：sign在return环节体现
        return res * sign;
    }
}
