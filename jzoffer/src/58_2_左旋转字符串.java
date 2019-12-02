//58.2 - 左旋转字符串
//思路：同上一题思路，关键是进行三次翻转，即整体翻转以及分别翻转两段字符串
//注意：仍然是先转成字符数组进行操作，最后再转成String返回


public class Solution {
    public String LeftRotateString(String str,int n) {
        if(n>=str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }
    
    private void reverse(char[] chars, int i, int j){
        while(i<j){
            swap(chars,i++,j--);
        }
    }
    
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}