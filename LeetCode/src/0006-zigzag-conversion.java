//0006-Z字形变换
//思路：按行排序



//耗时：16ms，击败34.7%的用户
/*
  - 算法：边界值-初始化-循环-拼接并返回。
    - 边界值处理：当numRows=1时，返回s；
    - 定义变量len为行数n和s长度的最小值：考虑如果s长度更小，只需要开辟更小的空间即可；
    - 定义长度为len的字符串数组，并初始化为空串 `""`；
    - 定义所在行的位置变量loc，定义布尔型变量down；
    - 循环：遍历字符串s，将每个字符放在正确的位置，根据down的真假更新loc的值，并截取s的子串添加到字符串数组的正确行；
    - 新建字符串res，并将上述字符串数组拼接起来，最后返回。
*/
class Solution {
    public String convert(String s, int numRows) {
        //算法：边界值-初始化-循环-拼接并返回。

        //边界值：row为1时，直接返回s
        if(numRows == 1) return s;


        //初始化：
        int len = Math.min(s.length(), numRows);//考虑s长度更小时节约空间
        String [] rows = new String[len];
        for(int i=0; i<len; i++)
            rows[i] = "";

        //定义所在的行数位置loc，以及是否向下的标志变量down
        int loc = 0;
        boolean down = false;


        //循环：遍历字符串s，将每个字符都存放到正确的位置
        for(int i=0; i<s.length(); i++){
            rows[loc] += s.substring(i,i+1); //注意这里要用+号连接字符串
            
            //判断并更新标志变量down
            if(loc == 0 || loc == numRows-1) //这里按行数numRows,不是数组长度
                down = !down; //注意布尔型变量翻转的语句
            
            //更新loc
            loc += (down) ? 1 : -1;
        }


        //拼接并返回：新建字符串变量res，并将上述字符串数组通过+号拼接
        String res = "";
        for(int i=0; i<len; i++){
            res = res + rows[i];
        }
        return res;


    }
}
