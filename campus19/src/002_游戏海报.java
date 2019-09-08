//2-游戏海报
//思路：插空问题，找数学规律

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        if(n>20 || n<1)
            return;
        System.out.println(26*(n+1)-n);
    }
}