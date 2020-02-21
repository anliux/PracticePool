//0125-验证会问串
//思路：双指针



//双指针：3ms，击败95.5%的用户
/*

 - 分析：
    - 不区分大小写：先转为小写 `s = s.toLowerCase();`
    - 按顺序处理字符串的每个字符：字符串转为字符数组 `char[] chs = s.toCharArray();`
    - 不计除了字母和数字之外的字符：判断字符是否在字母或者数字的范围内，不在时直接略个这个字符
    - 最后如果没有出现不相等的情况，则返回true
  - 算法：转为小写；转为字符数组；双指针遍历：当遇到非数字和非字母的字符时指针指向下一个位置，之后判断两指针对应的字符是否相等；返回结果。

*/
class Solution {
    public boolean isPalindrome(String s) {
        //字符串转为小写
        s = s.toLowerCase();

        //为了便于处理，转为字符数组
        char [] chs = s.toCharArray();

        //定义大小两个指针
        int left = 0;
        int right = chs.length - 1;

        //遍历：循环，直到两个指针交错（循环包含等于）
        while(left <= right){
            //首先排除不属于字母和数字范围的字符
            if((chs[left]<'0' || chs[left]>'9') && (chs[left]<'a') || chs[left]>'z' )
                left++;
            else if((chs[right]<'0' || chs[right]>'9') && (chs[right]<'a') || chs[right]>'z' )
                right--;
            
            //否则，如果两指针对应字符不相等，返回false
            else if(chs[left] != chs[right])
                return false;
            
            //否则，如果两针值对应字符相等，则更新两指针的值
            else{
                left++;
                right--;
            }
        }

        //如果没有出现不成立的情况，则返回true
        return true;
    }
}
