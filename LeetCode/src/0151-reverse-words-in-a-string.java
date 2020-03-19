//0151-翻转字符串里的单词
//思路：一次翻转；两次翻转



//两次翻转：13ms，击败20%的用户
/*
- 算法1：两次翻转
    - 定义翻转指定索引值的字符串的函数并定义为私有；
    - 首先处理空格：剪去所有空格后，将字符串数组重新用一个空格连起来；
    - 将字符串转为字符数组；
    - 定义双指针：大指针遍历并找空格，小指针为要翻转单词的首个索引；
    - 遍历：翻转每个单词；
    - 翻转整个字符串；
    - 返回：新建字符串，并将字符数组传入。
*/
class Solution {
    public String reverseWords(String s) {
        //首先处理空格，然后再用一个空格将字符串拼起来
        //注意：split(" +")可以剪去多个空格
        String [] words = s.trim().split(" +");
        String str = String.join(" ", words);

        //将str字符串转为字符数组，然后遍历字符串，翻转每个单词
        char[] chars = str.toCharArray();
        int n = chars.length;

        //定义两个指针来控制翻转范围
        int i = 0, j = 0; //i和j为每个单词的起止索引，j遍历至n
        while(j <= n){
            //判断大指针j是否遇到空格或者遍历完成：如果是则翻转，并更新小指针
            //注：j要检测空格，指向的是要翻转的范围的前一个索引值
            if(j == n || chars[j] == ' '){
                reverse(chars, i, j-1);
                i = j + 1;
            }

            //大指针j每次循环都要向后移动
            j++;

        }

        //翻转整个字符串
        reverse(chars, 0, n-1);

        //将字符数组转为字符串并返回
        //注：用toString不好使，会返回哈希码
        return new String(chars);
    }

    //定义翻转指定索引的字符数组的函数reverse: 引用型变量，返回值为void即可
    private void reverse(char[] chs, int i, int j){
        while(i<j){
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }
}



//可变字符串+一次翻转：6ms，击败42.5%的用户
/*
- 算法2：一次翻转
    - 首先处理空格：剪去所有空格后，将字符串数组重新用一个空格连起来；
    - 定义可变字符串StringBuilder；
    - 从后遍历字符串数组：如果不是第一个元素，则额外添加空格，否则，只添加元素本身；
    - 将可变字符串转为String类型，并返回。
    - 注：简单多了，但是用了很多库函数吧。
*/
class Solution {
    public String reverseWords(String s) {
        //首先处理空格，然后再用一个空格将字符串拼起来
        //注意：split(" +")可以剪去多个空格
        String [] words = s.trim().split(" +");

        //定义可变字符串：
        StringBuilder sb = new StringBuilder();

        //遍历字符串，并添加空格
        for(int i = words.length - 1; i >= 0; i--){
            if(i == 0)
                sb.append(words[i]);
            else
                sb.append(words[i]).append(" ");
        }
        
        return sb.toString();
    }
}



//直接一次翻转：感觉没啥问题但是超出时间限制。
class Solution {
    public String reverseWords(String s) {
        //首先处理空格，然后再用一个空格将字符串拼起来
        //注意：split(" +")可以剪去多个空格
        String [] words = s.trim().split(" +");

        //定义双指针：
        int left = 0, right = words.length-1;
        
        //遍历字符串，翻转每个单词
        while(left < right){
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
        }
        
        return String.join(" ", words);
    }
}
