package practice.myProjects.hourglass;

import java.util.Scanner;

/*this is the practice problem from hacker rank. 
 * I did this problem from the editorial section. 
 * I kept this similar solution for my private reference. 
 * If you find the same content there its not coincidence*/

public class HourGlass2DArray {
	private static final int _MAXI = 6; // size of matrix
	private static final int _OFFSET = 2; // hourglass width
	private static int matrix[][] = new int[_MAXI][_MAXI];
	private static int maxHourglass = -63; // lets initialize to lowest possible
											// sum (-9 x 7)

	public static void main(String[] args) {
		// read inputs
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < _MAXI; i++) {
			for (int j = 0; j < _MAXI; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		scan.close();

		// find maximum hourglass
		for (int i = 0; i < _MAXI - _OFFSET; i++) {
			for (int j = 0; j < _MAXI - _OFFSET; j++) {
				hourglass(i, j);
			}
		}

		// print maximum hourglass
		System.out.println(maxHourglass);
	}

	/**
	 * Given a starting index for an hourglass, sets maxHourglass
	 * 
	 * @param i row
	 * @param j column
	 **/
	private static void hourglass(int i, int j) {
		int tmpSum = 0; // current hourglass sum

		// sum top 3 and bottom 3 elements
		for (int k = j; k <= j + _OFFSET; k++) {
			tmpSum += matrix[i][k];
			tmpSum += matrix[i + _OFFSET][k];
		}
		// sum middle element
		tmpSum += matrix[i + 1][j + 1];

		if (maxHourglass < tmpSum) {
			maxHourglass = tmpSum;
		}
	}

}
