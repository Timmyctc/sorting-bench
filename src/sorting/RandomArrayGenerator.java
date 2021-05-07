package sorting;

import java.util.Random;

public class RandomArrayGenerator {
	final Random rand = new Random();
	//final int[] TEST_CASES = new int[] { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };

	public int[] createArrays(int n) {
		//ArrayList<int[]> listofArrays = new ArrayList<int[]>();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = rand.nextInt(101);
			}
		return arr;
	}

}
