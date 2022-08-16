//46. 把数字翻译成字符串


//递归：0ms/100%; 38.4 MB/30.44%
class Solution {
    public int translateNum(int num) {
        //递归：后两位可翻译：f(i) = f(i-1) + f(i-2); 否则 f(i) = f(i-1)

        //个位：
        if(num<=9)
            return 1;

        //取后两位判断：
        int tens = num % 100;
        
        //递归：后两位不可翻译 vs 可翻译
        if(tens >= 26 || tens <= 9)//超出范围，不可翻译
            return translateNum(num/10);
        else//在[10,25]范围内
            return translateNum(num/10) + translateNum(num/100);
    }
}



//dp-dp数组+String：0ms/100%; 38.1 MB/79.19%
class Solution {
    public int translateNum(int num) {
        //dp: n展开为每一位时，转为字符串更好求解

        //int数字转为字符串
        String str = String.valueOf(num);

        //初始化dp数组: 注意长度需要 +1
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;

        //遍历：
        for(int i = 2; i <= str.length(); i++){
            String temp = str.substring(i-2, i);//左闭右开
            if(temp.compareTo("10")<0 || temp.compareTo("25")>0)//前两位不可翻译
                dp[i] = dp[i-1];
            else 
                dp[i] = dp[i-1] + dp[i-2];
        }

        //返回结果：返回dp的最后一个元素
        return dp[dp.length-1];
    }
}


//dp优化不用dp数组：0ms/100%; 38.4 MB/29.30%
class Solution {
    public int translateNum(int num) {
        //dp优化：
        String str = String.valueOf(num);
        int a = 1, b = 1;
        int c;
        for(int i = 2; i <= str.length(); i++){
            String temp = str.substring(i-2,i);
            if(temp.compareTo("10")>=0 && temp.compareTo("25")<=0)//后两位可翻译
                c = a + b;
            else
                c = b;
            a = b; 
            b = c;
        }
        return b;
    }
}


//dp优化：取余
class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
/*
作者：jyd
链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
*/
