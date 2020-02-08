//0028-实现strStr()
//思路：暴力法（超时）；kmp（未尝试）；indexOf()（直接用内置函数）



//indexOf(): 一行代码解决
/*
  indexOf():
  - 返回：
      - 如果字符串参数作为一个子字符串在此对象中出现，则返回第一个这种子字符串的第一个字符的索引；
      - 如果它不作为一个子字符串出现，则返回 -1。
      - (与题目要求完全相符)

  在其他题目中也用到过indexOf，只是本题的要求与indexOf返回值完全相同

  注：今后可尝试其他方法
*/
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}