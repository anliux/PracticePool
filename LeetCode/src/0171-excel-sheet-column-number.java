//0171-Excel表列序号
//思路：进制转换 之 其他进制转十进制



//耗时：2ms，击败41%的用户
/*
 - 初始化结果ans = 0，遍历时将每个字母与A做减法，因为A表示1，所以减法后需要每个数加1，计算其代表的数值num = 字母 - ‘A’ + 1
  - 因为有26个字母，所以相当于26进制，每26个数则向前进一位，所以每遍历一位则ans = ans * 26 + num
  - 以ZY为例，Z的值为26，Y的值为25，则结果为26 * 26 + 25=701
  - 算法：初始化；遍历字符串：从高位到低位；返回结果。
*/
class Solution {
    public int titleToNumber(String s) {
       //定义结果res并初始化为0；
       int res = 0;

       //从左到右遍历字符串
       for(int i=0; i<s.length(); i++){
           int num = s.charAt(i) - 'A' + 1;
           res = res * 26 + num;
       }

       return res;
    }
}
