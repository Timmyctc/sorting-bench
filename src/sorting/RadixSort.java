package sorting;

import java.util.Arrays;

public class RadixSort extends Sorter {

	@Override
	int[] sort(int[] arr) {
		return arr = radixsort(arr, arr.length);
	}//end sort method

	private static int[] radixsort(int arr[], int n) {
		// Method to find max value in array
		int max = getmax(arr, n);

		// Do counting sort for every digit.
		for (int exp = 1; max / exp > 0; exp *= 10)
			countsort(arr, n, exp);
		return arr;
	}

	//Counting sort method to count arr[] relative to exp
	private static void countsort(int arr[], int n, int exp) {
		int output[] = new int[n];		// initialise output array
		int count[] = new int[10]; 		//initialise count array (will store occurances of numbers in each band) 
		int i;
		Arrays.fill(count, 0); // .fill fills a target array with value (0)

		
		for (i = 0; i < n; i++) count[(arr[i] / exp) % 10]++; // counting occurances of each bucket tier

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		} // rof
		
			// Building output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}//rof

		// Copy the output array to arr[]
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}// end countsort

	private static int getmax(int arr[], int n) // get max val in array
	{
		int max = arr[0];		//assign max as first element by default
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {		//loop through and assign max to value larger than oldmax
				max = arr[i];
			} // fi
		} // rof
		return max;
	}// end getmax

	@Override
	String getType() {
		return "Radix Sort: ";
	}//end getType
}//end class
