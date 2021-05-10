package sorting;

public class BubbleSort extends Sorter {
	 int[] sort(int[] arr) {
		int outer, inner;
		boolean isSorted = true;
		// loop through the array to the arrays final index (length -1)
		for (outer = arr.length - 1; outer > 0; outer--) {
			for (inner = 0; inner < outer; inner++) {
				if (arr[inner] > arr[inner + 1])		//Comparison
					swap(arr, inner, inner + 1);		//Swap method
				isSorted = false;
			}
			if(isSorted) return arr;	//if no swaps occur return 
		}
		return arr;	
	}//End Method

	@Override
	String getType() {
		return "BubbleSort: ";
	}//End Sort Method
}// End Class



