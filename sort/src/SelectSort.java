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
			for (int j=i+1; j<len; j++)
			{
				if(arr[j]<arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
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
