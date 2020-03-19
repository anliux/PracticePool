//58.1 - 翻转单词顺序列
//思路：两次翻转，分别翻转整个str，以及翻转每个单词，以空格为分隔



//单一空格处理：
public class Solution {
    public String ReverseSentence(String str) {
        int n = str.length();

        //首先将str转为char数值，方便后续操作
        char[] chars = str.toCharArray();
        
        //定义指针，方便遍历以及寻找空格
        int i = 0, j = 0;
        
        //注：先翻转单词，后翻转整个str。都一样。
        
        //循环，直到尾指针j遍历到末尾
        while(j<=n){//为了与j-1统一，循环条件设为包含=
            //注意：char型，故空格需要用单引号而不是双引号
            if(j==n || chars[j]==' '){//当j遍历到末尾或者遇到空格时，翻转i到j-1的内容
                reverse(chars, i, j-1);
                i = j+1;
            }
            j++;//j继续自增
        }
        
        //翻转整个str
        reverse(chars, 0, n-1);
        
        //将char数组转为String并返回
        //构造函数 String(char[] value): 分配一个新的String，使其表示字符数组参数中当前包含的字符序列。
        return new String(chars);
    }
    
    private void reverse(char[] c, int i, int j){
        while(i<j)
            swap(c, i++, j--);
    }
    
    private void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}



//多空格处理：13ms，击败20%的用户
//注：总体差不多，只是开始增加了对于多空格的处理。
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
