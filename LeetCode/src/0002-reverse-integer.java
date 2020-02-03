//0002-整数反转
//思路：使用数学方法取单个位，并重新组合；注意题目的临界条件。
//数学方法：整除取余取出最低位，整除对原x进行剩余位的获取



class Solution {
    public int reverse(int x) {
        //定义保存反转后数字的变量: "32位的有符号整数" -- int是32位整数
		int rev = 0;
        
		//循环直到x为0：
		//先取最低位，后进行x的整除运算，因此当x变为个位数的时候，取出最低位再整除之后，x得0
        while(x != 0){
            int pop = x % 10;
            x = x/10;

			//运算符优先级: &&的优先级高于||的优先级，在if判断中可以省略小括号
            //保险起见，同时方便阅读，建议加上小括号进行区
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > (Integer.MAX_VALUE%10))){
                return 0;
            }

            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < (Integer.MIN_VALUE%10))){
                return 0;
            }
			/*
			对于正数部分：
			考虑常规：
				`rev>Integer.MAX_VALUE/10`时，`rev*10`必定大于Integer的Max值，不符合条件
			考虑临界：
				`rev==Integer.MAX_VALUE/10`时，整除会削去个位的值，因此，若再乘以10，个位是0。
				这时再加某值，这个值需要小于MAX值的个位，否则越界。
				因此：`pop>Integer.MAX_VALUE % 10`
			
			对于负数部分：同理
			*/
			
			//将临时变量乘以10以提升位数，并在此基础上加上新取出的最低位，循环这个过程
            rev = rev*10 + pop;
        }

        return rev;
    }
}