//8-数字序列第n位的值
//思路：等差数列求和 n(n+1)/2，相当于计算和在第几项以内
//注意：边界值比如6，对应的是3，while判断没有等号，要不然边界值不对。

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(n>(i*(i+1))/2)
        {
            i++;
        }
        System.out.println(i);
    }
}