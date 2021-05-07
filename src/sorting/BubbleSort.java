package sorting;

public class BubbleSort extends Sorter {
	int[] sort(int[] arr) {
		int outer, inner;
		boolean isSorted = true;
		// loop through the array to the arrays final index (length -1)
		for (outer = arr.length - 1; outer > 0; outer--) {
			for (inner = 0; inner < outer; inner++) {
				if (arr[inner] > arr[inner + 1])
					swap(arr, inner, inner + 1);
				isSorted = false;
			}
			if(isSorted) return arr;
		}
		return arr;

	}

	@Override
	void typeString() {
		System.out.printf("Bubble Sort: ");
	}// End TypeString
}// End Class



