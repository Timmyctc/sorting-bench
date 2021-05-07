package sorting;

import java.util.Random;

public class QuickSort extends Sorter {

	@Override
	int[] sort(int[] arr) {
		return arr = quicksort(arr, 0, arr.length-1);
	}

	private int[] quicksort(int[] arr, int low, int high) {
		if (low < high+1) {
			int p = partition(arr, low , high);
			quicksort(arr, low, p-1);//left partition
			quicksort(arr, p+1, high);//right partition
		}
		return arr;
		
	}

	private int partition(int[] arr, int low, int high) {
		swap(arr, low, getpivot(low, high));
		int border = low + 1;
		for(int i = border; i<=high; i++) {
			if(arr[i] < arr[low])
			{
				swap(arr, i, border++);
			}//End If
		}//End For
		swap(arr, low, border-1);
		return border-1;
	}

	private int getpivot(int low, int high) {
		Random r = new Random();
		return r.nextInt((high-low) + 1) + low;
	}
	
	@Override
	void typeString() {
			System.out.printf("Quick Sort");
	}

}
