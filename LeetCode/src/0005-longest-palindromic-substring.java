//0005-最长回文子串
//思路：暴力匹配；动态规划；中心扩散；Manacher 算法。
//   - “暴力匹配”是基础，“动态规划”必须掌握，“中心扩散” 要会写，“Manacher 算法”不用看



//暴力法：736ms，击败7.44%的用户
/*
  - 算法：
      - 定义valid函数，用于判断left到right范围内的子串是否是回文串；
      - 主体函数中：边界值判断，字符串长度为0和1的直接返回s，即s.length()<2时；
      - 定义几个变量：最长子串的长度lens，最长子串结果res。字符串s可以用s.substring()截取；
      - 循环：两层遍历，外层控制起始基准，内层控制从基准开始到末尾的所有子串，并if进行判断并更新相应的变量数值；
      - 最内层if判断：如果当前子串的长度大于最长子串长度lens，并且valid为真，则更新lens，并将最长子串res更新为当前子串；
      - 循环结束后返回res。
*/
class Solution {
    public String longestPalindrome(String s) {
        //边界值判断：s长度为0和1时，是回文串
        if(s.length() < 2)
            return s;
        
        //定义最长子串res和最长子串长度lens，并初始化
        int lens = 0;
        //String res = s.charAt(0); //前后数据类型不符会报错，只能用substring截取
        String res = s.substring(0,1); //左闭右开，即只取s的第一个字符作为子串。

        //两层循环遍历所有子串
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if((j-i+1>lens) && valid(s, i, j)){
                    lens = j - i + 1;
                    res = s.substring(i, j+1);
                }
            }
        }

        //返回结果子串
        return res;
    }

    private boolean valid(String s, int left, int right){
        //双指针验证是否是回文串
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}



//动态规划：142ms，击败23.4%的用户
/*
   - 算法：
      - 定义字符串长度lens，方便后面使用；判断边界条件：lens<2时
      - 定义布尔型二维数组`dp[][]`，（注：不需要初始化对角线为true，因为控制好i和j区间，对角线用不到，经测试可以ac）
      - 定义int遍历maxlens和start，并初始化start=0，maxlens=1，而不是0，因为回文串长至少是1，例如"ac"，返回"a"；
      - 两层循环遍历全部数组，因为遍历中会用到dp[i+1][j-1]，要注意遍历的顺序(不是常规那种)，否则遍历过程中会遇到dp[i+1][j-1]没有值的情况
        - 外循环：控制结尾j，内循环遍历从字符串索引0开始到结尾j的所有子串；（不是常规的外起始i，内从起始i到字符串末尾的方式）
      - 内循环体：两部分 - 首先，判断dp[i][j]的真假；其次，dp为真时更新记录最长子串信息的变量。
      - 最后截取子串并返回。
*/
class Solution {
    public String longestPalindrome(String s) {
        //定义字符串长度，方便后面使用
        int lens = s.length();

        //边界值判断：lens为0或1时，s必为回文串
        if(lens < 2)
            return s;
        
        //定义布尔型二维数组dp
        boolean dp[][] = new boolean[lens][lens];
        
        //定义最长子串信息的变量：最长子串仅记录起始位置start和长度maxlens，最后截取
        int maxlens = 1;
        int start = 0;

        //两层循环：外层控制子串起始位置，内层控制从起始位置到末尾的所有子串
        for(int j = 1; j < lens; j++){
            for(int i = 0; i < j; i++){
                //第一部分：判断dp[i][j]的真假
                if(s.charAt(i) == s.charAt(j)){
                    //两端点值相同时，进一步判断i和j的距离，符合条件时终止
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }


                //第二部分：如果dp[i][j]为真，更新记录最长子串的start和maxlens
                if(dp[i][j] == true){
                    //判断：当j-i+1 > maxlens的情况下，更新。否则保持原样。
                    if(j-i+1 > maxlens){
                        start = i;
                        maxlens = j - i + 1;
                    }
                }
            }
        }

        //循环结束后，根据最长子串的信息start和maxlens截取子串，并返回
        return s.substring(start, start+maxlens);
    }
}



//中心扩散：
