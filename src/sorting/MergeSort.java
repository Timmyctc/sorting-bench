package sorting;

public class MergeSort extends Sorter{

	@Override
	int[] sort(int[] arr) {
		return arr = mergeSort(arr,0,arr.length-1);
	}
	private static int[] mergeSort(int[] array, int low, int high) {
	    if (high <= low) return array;

	    int mid = (low+high)/2;	//get midpoint
	    
	    //recursive algorithm calls
	    //Call mergeSort on the lower half of the array
	    mergeSort(array, low, mid);
	    
	    //Call mergeSort on the upper half of the array
	    mergeSort(array, mid+1, high);
	    
	    //merging the halves
	    merge(array, low, mid, high);

	    return array;
	}//end MergeSort method
	
	private static void merge(int[] array, int low, int mid, int high) {
	    // Creating temporary subarrays
	    int lArray[] = new int[mid - low + 1];
	    int rArray[] = new int[high - mid];

	    // Copying our data into temporary arrays
	    for (int i = 0; i < lArray.length; i++) lArray[i] = array[low + i];
	    for (int i = 0; i < rArray.length; i++) rArray[i] = array[mid + i + 1];
	        

	    //use these indexes to iterate through each of the sub arrays (lower and higher)
	    int leftIndex = 0;
	    int rightIndex = 0;

	    // Copying from leftArray and rightArray back into array
	    for (int i = low; i < high + 1; i++) {
	        if (leftIndex < lArray.length && rightIndex < rArray.length) {
	            if (lArray[leftIndex] < rArray[rightIndex]) {
	               array[i] = lArray[leftIndex];
	               leftIndex++;
	            } else {
	                array[i] = rArray[rightIndex];
	                rightIndex++;
	            }
	            
	        } else if (leftIndex < lArray.length) {
	            
	            array[i] = lArray[leftIndex];
	            leftIndex++;
	            
	        } else if (rightIndex < rArray.length) {
	            
	            array[i] = rArray[rightIndex];
	            rightIndex++;
	        }
	    }//end for
	}//End method merge

	@Override
	String getType() {
		return "Merge Sort: ";
	}//end getType
}//end Clas MergeSort
