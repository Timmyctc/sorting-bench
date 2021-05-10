package sorting;

public class SelectionSort extends Sorter {
	
	@Override
	int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)// outer loop
		{
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++)// inner loop
			{
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				} // end if
			} // endfor
			
			//swap logic
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		} // endfor(outer
		return arr;
	}// end SelectSort

	@Override
	String getType() {
		return "Selection Sort:";
	}
}
