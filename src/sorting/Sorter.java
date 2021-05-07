package sorting;

	//An Abstract Class to Wrap our Sorting classes as one type (For benching later) 
 abstract class Sorter {
	 abstract int[] sort(int[]arr);	//every class will provide body for a sort method
	 
	 //Abstract method to display the name of the Sorting class (For use during console output later) 
	 abstract void typeString();
	 
	 //All sorting classes Extend this abstract class and can make use of its protected swap method
	  protected void swap(int[]arr ,int index1, int index2) {
		  int temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
	}//End Swap
	  
	  //Overloaded Swap
	  protected void swap(int num1, int num2) {
		  int temp = num1;
			num1 = num2;
			num2 = temp;
	}//End Swap
}//end Abstract Class
