//58.1 - 翻转单词顺序列
//思路：两次翻转，分别翻转整个str，以及翻转每个单词，以空格为分隔

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
            j++;//当不符合末尾或找到空格时，j继续自增
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