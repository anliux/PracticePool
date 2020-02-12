//0067-二进制求和
//思路：逐位计算，注意进位



//逐位计算：3ms，击败56.7%的用户
/*
  - 思路：逐位计算（位运算的方法要考虑过多的细枝末节，这里不详述）
  - 补0使两字符串长度相等，然后从末尾开始遍历，并不断添加结果，最后对结果进行反转
    - 补0：在遍历过程中判断，长度小于0时直接返回0
    - 添加：需要在字符串上添加，因此使用可变字符串StrinBuilder
    - 反转：添加顺序是每次在右侧添加，即不断将较高位添加到右侧，因此最后需要反转
    - 注：本代码好几处把几句代码合并到一句的
*/
class Solution {
    public String addBinary(String a, String b) {
        //定义可变字符串res，进位标志flag
        StringBuilder res = new StringBuilder();
        int flag = 0;

        //从末尾开始，同时遍历两个字符串，并在两字符串均遍历至第一个元素时终止循环
        for(int i=a.length()-1, j=b.length()-1 ; i>=0 || j>=0; i--,j--){
            //赋值sum，并分别取a和b两字符串的最右位累加到sum
            int sum = flag; //循环中，若前一次循环有进位，则在此处加上
            sum += i>=0? a.charAt(i) - '0' : 0;
            sum += j>=0? b.charAt(j) - '0' : 0;

            //对sum值进行判断：取余得到应添加到结果，整除得到flag的值
            //sum有几种情况：0，1，2，3。其中0和1正常操作，2需要进位1留下0，3需要进位1留下1
            res.append(sum % 2);
            flag = sum / 2;
        }

        //返回时需要对最后一次循环后flag的值进行判断，之后反转，并转为String型
        res.append(flag==0 ? "" : flag); //注意：判断写在append里，写在外面有点傻
        return res.reverse().toString();
    }
}
