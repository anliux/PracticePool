/*
192-圈地运动

注意：本代码其实写得像坨屎。不过先ac了再说吧，后期需要继续优化。
*/

import java.util.Scanner;

public class Main  
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		//至少需要三条边，否则无法构成多边形
		if(n<3)
			System.out.println(-1);

		int sum, temp; //sum为所有数的和，temp存储每个数并遍历与max的比较
		int max = sum = sc.nextInt(); //使用第一个数初始化max和sum
		for (int i=1; i<n; i++)
		{
			//每输入一个数均与max进行比较
			max = (temp=sc.nextInt())>max ? temp : max;

			//求所有数的和，则sum-max为除了最大值外所有数的和
			sum += temp;
			int sumSub = sum - max;

			//至少需要三条边，即循环至少进行两轮，满足再进一步判断
			if(i>1)
			{
				if(sumSub>max)
				{
					System.out.println(i+1);//注意边界值，循环外已经赋值一次了
					break;
				}
				if(i == n-1) //注意：循环外已经有一次取值了，故只剩n-1个数，注意边界别越界了
					System.out.println(-1);
			}
		}
	}
}
