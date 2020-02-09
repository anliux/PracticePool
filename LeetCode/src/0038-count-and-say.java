//38-外观数列
//思路：字符串实现计数器



//字符串实现计数器：3ms，击败64%的用户
/*
  算法
  - 本题的本质是计数器，本题的关键是理清数字规律，并将数学规律转为代码
    - 本题输入是int型，返回值是String型
    - 首先自定义n=1时，s="1"; 
    - 当n=1时直接返回；当n>=2时，再进行后续的复杂操作
      - 注：题目要求"正整数 n（1 ≤ n ≤ 30）"，故不作其他判断，甚至能用穷举法存入字典查表解决...
    - 两层循环：外循环控制行数，内循环遍历上一行生成的字符串并“报数”
    - 外循环：2-n（包含等于n），从2开始，n=1的情况直接返回
    - 内循环：
      - 从s的[0]开始设置"flag"-pre，计数器count，循环从1开始向后遍历，数(动词)与pre相等的个数，直到不再相等
      - 不相等的时候，调整pre为不再相等的位置的数字，并将count归为1，重新开始计数
  - 注：本题标签是字符串，考虑用可变字符串StringBuilder，最后toString()转为String形式

*/
class Solution {
    public String countAndSay(int n) {
        //定义字符串初始值
        String s = "1";

        //当n=1时直接返回（即后续复杂操作从n>=2开始）
        if(n==1)
            return s;
        
        //注：题目要求“正整数 n（1 ≤ n ≤ 30）”，故不作其他判断

        //外循环：控制行数，第一行已知，从2遍历到n，包含等于n
        for(int i=2; i<=n; i++){
            //每行字符串不同，故每行每次开始首先新建可变字符串
            StringBuilder str = new StringBuilder();

            //新建计数器count，用以计算每次相同字符的个数，不同时更新为1
            int count = 1;

            //新建FLAG变量pre，作为被计数的字符；
            //出现不同字符时，停止计数，并更新pre为新的不同字符
            char pre = s.charAt(0);

            //内循环：按照字符串s的索引遍历，从1开始比较（0是pre）
            for(int j=1; j<s.length(); j++){
                //如果索引j对应的字符与pre相等，count自增
                if(s.charAt(j)==pre)
                    count++;

                //如果索引对应的字符与pre不等：
                //将已有count和pre添加到str，并更新pre为不同的字符，count更新为1
                else{
                    str.append(count).append(pre);//“几个某数”，count前，pre后
                    pre = s.charAt(j);//更新pre为不同的字符
                    count=1;//更新count为初始值1
                }
            }

            //内循环结束后，将最后一组count+pre添加到str，并将str转为String形式
            str.append(count).append(pre);
            s = str.toString();
        }

        //最终返回s
        return s;
    }
}