package sorting;

public class SortingRunner {
	public static void main(String[] args) {

		//Create Sorter Objects to pass to Benchmark Method
		Sorter bubble = new BubbleSort();
		Sorter quick = new QuickSort();
		Sorter merge = new MergeSort();
		Sorter radix = new RadixSort();
		Sorter select = new SelectionSort();
		Benchmark bench = new Benchmark();

		//Method to display input Sizes
		bench.displaySize();
		//pass sorter objects and our list of arrays to the benchmark method
		bench.benchmark(bubble);
		bench.benchmark(quick);
		bench.benchmark(merge);
		bench.benchmark(radix);
		bench.benchmark(select);

	}//End Main
}//End Class
