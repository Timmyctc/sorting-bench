package sorting;

import java.util.Arrays;

public class RadixSort extends Sorter {

	@Override
	int[] sort(int[] arr) {
		return arr = radixsort(arr, arr.length);
	}

	private static int[] radixsort(int arr[], int n) {
		// Find the maximum number to know number of digits
		int max = getmax(arr, n);

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; max / exp > 0; exp *= 10)
			countsort(arr, n, exp);
		return arr;
	}

	private static void countsort(int arr[], int n, int exp) {
		int output[] = new int[n]; // initialise output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0); // .fill fills a target array with value (0)

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++; // counting occurances of each bucket tier

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		} // rof
			// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}// end countsort

	private static int getmax(int arr[], int n) // get max val in array
	{
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			} // fi
		} // rof
		return max;
	}// end getmax

	@Override
	void typeString() {
		System.out.printf("Radix Sort: ");
	}

}
