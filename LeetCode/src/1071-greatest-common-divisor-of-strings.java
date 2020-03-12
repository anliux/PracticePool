//1071-字符串的最大公因子
//思路：辗转相除法



//辗转相除法：1ms，击败94%的用户
/*
    - 辗转相除：
      - 欧几里德算法又称辗转相除法，是指用于计算两个正整数a，b的最大公约数。
      - 应用领域有数学和计算机两个方面；
      - 以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数；
      - 计算公式`gcd(a,b) = gcd(b,a mod b)`，前一个可看做被除数，后一个是除数，(a%b)即为余数，递归。
    - 算法：
      - 定义求最大公因数的函数gcd：使用公式`gcd(a,b) = gcd(b,a mod b)`；
      - 判断s1+s2与s2+s1是否相等，不相等时返回空串；
      - 相等时，返回s1的子串，子串从0开始，取到gcd长度为止。
*/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //判断两字符拼接是否相等
        if(!(str1 + str2).equals(str2 + str1))
            return "";
        
        //相等，则返回子串
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    //定义求最大公因数的函数
    private int gcd(int a, int b){ //余数为0时返回除数
        return (b==0)? a: gcd(b, a % b);
    }
}
