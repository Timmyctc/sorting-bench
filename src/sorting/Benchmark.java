package sorting;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Benchmark {

	// Creating a RandomArrayGenerator to create arrays for benching
	private static final RandomArrayGenerator RAG = new RandomArrayGenerator();
	// TEST_CASES Contains a list of all the array sizes to be tested
	private final static int[] TEST_CASES = new int[] { 100, 250, 500, 1000, 2000, 3500, 4750, 7500, 8250, 10000 };

	protected void benchmark(Sorter sort) {
		double[] results = new double[10];
		sort.typeString(); // calling sorter type's typeString() method to display name of current sorter
		// System.out.print(name);
		for (int i = 0; i < TEST_CASES.length; i++) { // Iterate through the TEST_CASES array
			double total = 0d;

			for (int aveCount = 0; aveCount < 10; aveCount++) { // Run this 10 times to get average ms to sort each
																// array

				int[] test = RAG.createArrays(TEST_CASES[i]); // Current array to test is taken from the TEST_CASES
																// array
				double startTime = System.nanoTime(); // starttime
				sort.sort(test); // Sort
				double endTime = System.nanoTime(); // endtime
				double timeElapsed = (endTime - startTime); // totaltime elapsed in nanosecs
				double elapsedMillis = timeElapsed / 1000000; // total time elapsed in ms
				total += elapsedMillis; // total time to sort array 10 times

			}
			System.out.printf("\t\t%.3f", total / 10); // displays average sort time rounded to 3dec places
			results[i] = total / 10;
		}
		graphResults(results);
		System.out.println();
	}// End Benchmark Method

	protected void displaySize() {
		System.out.printf("Size" + "\t");
		for (int i = 0; i < TEST_CASES.length; i++) {
			System.out.printf(("\t\t") + TEST_CASES[i]);
		}
		System.out.println();
	}// End displaySize

	private void graphResults(double[] results) {

		double[] sizes = new double[TEST_CASES.length];
		for (int i = 0; i < TEST_CASES.length; i++) {
			sizes[i] = TEST_CASES[i];
		}

		XYChart chart = QuickChart.getChart("Sample Chart", "Array Sizes", "ms To Sort", "y(x)", sizes, results);
		chart.getStyler().setXAxisMax((double) TEST_CASES[TEST_CASES.length - 1]);
		chart.getStyler().setXAxisMin((double) TEST_CASES[0]);
		chart.getStyler().setYAxisMax(120.0);
		chart.getStyler().setYAxisMin(0.00);
		new SwingWrapper<XYChart>(chart).displayChart();
	}
}// end Class
