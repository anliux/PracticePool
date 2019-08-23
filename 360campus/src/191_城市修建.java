/*
191-城市修建

注意：Arrays最后有s别忘了，调用时也有s；边界值设置要特别注意，防止角标越界
*/
import java.util.Scanner;
import java.util.Arrays;

public class Main   
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); // 输入
		int n = sc.nextInt();
		//定义存储坐标的数组
		long X[] = new long[n];
		long Y[] = new long[n];
		//循环n次将坐标值存入对应数组中
		for (int i=0; i<n; i++)
		{
			X[i] = sc.nextLong();
			Y[i] = sc.nextLong();
		}
		long res = Way(X,Y); //调用求最值函数
		System.out.println(res*res); // 正方形故最值平方
	}

	private static long Way(long x[], long y[])
	{
		//先对x，y数组进行排序
		Arrays.sort(x);
		Arrays.sort(y);
		//排除异常：当数组中只有一个元素时，返回0
		if(x.length<2 || y.length<2)
			return 0;
		//求x，y数组中元素的最大差值：求端点值差后取绝对值
		long x_length = Math.abs(x[x.length-1]-x[0]);
		long y_length = Math.abs(y[y.length-1]-y[0]);
		//取以上两值的最大值
		return Math.max(x_length, y_length);
	}
}
