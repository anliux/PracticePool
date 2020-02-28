//希尔排序

/*
  - 三层循环
  - 时间复杂度：O(nlogn)
  - 空间复杂度：O(1)
  - 不稳定
  - 内部排序
  - 首次突破O(n^2)的时间复杂度
*/

public class ShellSort  
{
	public static void shellSort(int[] arr)
	{
		int len = arr.length;
		int h; //增量
		int temp; //存储每次对比时后一个值（也可以看做是基准值）

		for (h=len/2; h>0; h=h/2) //最外层循环：控制遍历的轮数，以递减的增量作为循环条件
		{
			for (int i=h; i<len; i++) //中间层循环：控制每轮遍历时后一个值的递增
			{
				//同插入排序，要有一个变量来存储基准值：后一个元素
				temp = arr[i];

			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[] array = {12,34,32,56,18,42};
		shellSort(array);
		for(int i=0; i<array.length; i++)
     		System.out.println("array["+i+"]="+array[i]);
	}
}
