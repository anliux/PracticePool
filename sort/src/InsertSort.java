//插入排序

/*
两层循环

时间复杂度：O(n^2): O(n)--O(n^2)
空间复杂度：O(1)
稳定
内部排序
*/

public class InsertSort
{
	public static void insertSort(int[] arr)
	{
		int len = arr.length;
		
		//从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
		for (int i=1; i<len; i++)
		{
			//// 记录要插入的数据，即每次循环对比的基准
			int temp = arr[i];
			
			//从已经排序的序列最右边的开始比较，找到比其小的数
			int j=i;
			while(j>0 && arr[j-1]>temp)
			{
				arr[j]=arr[j-1];
				j--;
			}
			
			//存在比其小的数，插入
			if(j!=i)
				arr[j]=temp;
		}
	}
	
	public static void main(String[] args) 
	{
		int[] array = {12,34,32,56,18,42};
		insertSort(array);
		for(int i=0; i<array.length; i++)
     		System.out.println("array["+i+"]="+array[i]);
	}
}
