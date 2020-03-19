//58.2 - 左旋转字符串
//思路：三次翻转



//三次翻转：2ms，击败29%的用户
/*
 - 算法：
    - 定义翻转函数；
    - 边界值判断；（如果题目规定边界值，可简化或省略）
    - 将字符串转为字符数组；
    - 整体翻转以及分别翻转两段字符串；
    - 重新构建字符串并返回。
*/
//注意：仍然是先转成字符数组进行操作，最后再转成String返回
class Solution {
    public String reverseLeftWords(String s, int n) {
        //边界值判断：如果n大于字符串长度则直接返回原字符串。不过此处题目规定了取值范围。

        //将字符串转为字符数组
        char[] chs = s.toCharArray();

        //三次翻转：
        reverse(chs, 0, n-1);
        reverse(chs, n, chs.length-1);
        reverse(chs, 0, chs.length-1);

        //将字符数组转为字符串，并返回
        //return Arrays.toString(chs); //返回值："[f, g, a, b, c, d, e]"
        return new String(chs);
    }

    //定义翻转函数
    private void reverse(char[] chs, int left, int right){
        while(left < right){
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
    }
}



//用substring偷懒: 0ms，击败100%的用户
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
