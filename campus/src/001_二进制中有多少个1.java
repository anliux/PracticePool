//1-二进制中有多少个1
//思路：根据10进制转2进制的手算方法除2取余得结果
//注意：只是求1的个数，不需要求转成二进制的更多繁琐的东西。

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n!=0)
        {
            count = count + n%2;
            n = n/2;
        }

		//注：题目要求输出为字符串，这里这样输出是可以的，因为输出语句默认toString
        System.out.println(count);
    }
}
