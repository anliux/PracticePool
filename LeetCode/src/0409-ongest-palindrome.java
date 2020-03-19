//0409-最长回文串
//思路：哈希表法



//哈希表法：1ms，击败100%的用户
/*
- 算法：
    - 定义int数组；
    - 第一次遍历字符串：统计字符出现的次数，注意遍历之前要先将s转为字符数组；
    - 定义计数器；
    - 第二次遍历int数组：将偶数直接累加，奇数-1累加；
    - 判断是否可以额外增加一个中间字符，并返回结果。
    - 注：遍历可用for-each形式。
*/
class Solution {
    public int longestPalindrome(String s) {
        //定义int数组；第一次遍历字符串s；定义计数器；第二次遍历数组；返回计数器结果。
        
        //定义int数组
        int [] count = new int[58];

        //第一次遍历字符串，并统计每个字符出现的次数
        for(char chs : s.toCharArray()){
            count[chs - 'A'] += 1;
        }

        //定义计数器res
        int res = 0;

        //第二次遍历int数组：将偶数个字符数累加，奇数个字符数-1后累加
        for(int n : count){
            res += n - (n & 1); //n&1：奇数得1，偶数得0
        }

        //判断并返回
        return (res < s.length()) ? (res + 1) : res;
    }
}
