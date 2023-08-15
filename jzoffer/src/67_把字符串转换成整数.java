//67 - 构建乘积数组
//注意多种特殊值的处理：正负数、0、边界值、空格、非数字字符等



//分四部分处理字符串: 1ms/100%; 39.24mb/78.77%
class Solution {
    public int strToInt(String str) {
        //空格处理并转为字符数组
        char[] c = str.trim().toCharArray();

        //判空
        if(c.length==0)
            return 0;

        //初始化辅助参数
        int res = 0; //结果参数
        int sign = 1; //符号位参数，默认为正数1
        int bndry = Integer.MAX_VALUE/10; //边界值参数
        int i = 1; //遍历起始位索引值参数，默认0为符号位，从1开始遍历数字字符

        //符号位判断
        if(c[0] == '-')
            sign = -1;
        else if(c[0] != '+')
            i = 0;

        //循环：拼接，越界+非数字字符判断
        for(int j = i; j < c.length ; j++){
            //非数字字符判断: 直接跳出循环
            if(c[j]>'9' || c[j]<'0')
                break;

            //越界判断
            if(res>bndry || res==bndry && c[j]>'7'){
                if(sign==1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
                //return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            //拼接
            res = res*10 + (c[j]-'0');
        }

        //返回结果
        return sign * res;
    }
}
