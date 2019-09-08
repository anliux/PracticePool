//6-访友
//思路：注意与找零中对每个值进行整除取余相区分，这里整除5后的余数必是1234其一，故直接加1即可。

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = 0;
        if(n%5 != 0)
            count = n/5 + 1;
        else
            count = n/5;
        System.out.println(count);
    }
}