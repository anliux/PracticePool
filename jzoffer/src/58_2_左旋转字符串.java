//58.2 - 左旋转字符串
//思路：库函数；列表遍历；三次翻转


//库函数：0 ms/100.00%; 41.4 MB/48.88%
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}



//列表遍历：3 ms/44.07%; 41.6 MB/23.47%
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        for(int i = 0; i < n; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}



//三次翻转：2ms/52.22%; 41.5 MB/32.04%
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
