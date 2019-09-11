//选择排序

/*
两层循环

时间复杂度：O(n^2): O(n^2)--O(n^2)
空间复杂度：O(1)
不稳定
内部排序
*/

public class SelectSort
{
	public static void selectSort(int[] arr)
	{
		int len = arr.length;
		for (int i=0; i<len-1; i++)
		{
			//注意：选择排序每一趟只有一次交换，而比较过程中只是角标在变化。
			int min = i;
			for (int j=i+1; j<len; j++)
			{
				if(arr[j]<arr[min])
				{
					min = j;
				}
			}
			if(min!=i)
			{
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[] array = {12,34,32,56,18,42};
		selectSort(array);
		for(int i=0; i<array.length; i++)
     		System.out.println("array["+i+"]="+array[i]);
	}
}
