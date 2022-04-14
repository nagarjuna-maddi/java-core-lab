package com.javacorelabs;

import java.util.Arrays;

/**
 * @author Nagarjuna
 * 
 * Program prints the 2D-array to create the board for Snakes and Ladders game
 *
 */
public class SnLBoard {

	public static void main(String[] args) {

		// Input the board dimensions of your choice
		int noOfRows = 10;
		int noOfCols = 10;

		int[][] snlBoard = createBoard(noOfRows, noOfCols);

		printBoard(snlBoard);
	}

	private static int[][] createBoard(int noOfRows, int noOfCols) {

		if (noOfRows < 1 || noOfCols < 2) {
			throw new RuntimeException("Invalid dimensions, Cannot create the Board!");
		}
		
		System.out.printf("Printing %dX%d Snakes & Ladders Board.. \n\n", noOfRows, noOfCols);

		int[][] snlBoard = new int[noOfRows][noOfCols];

		int cellNumber = noOfRows * noOfCols;

		int rowIndex = 0;
		int colIndex = 0;
		int multiple = 1;

		// Set initial storing colIndex value 
		// Following condition is required to make sure the value 1 will always starts from extreme left in the bottom row
		if (noOfRows % 2 != 0) {
			colIndex = noOfCols - 1;
			multiple = -1;
		}

		while (cellNumber >= 1) {

			snlBoard[rowIndex][colIndex] = cellNumber;

			//System.out.println("[" + rowIndex + "," + colIndex + "] --> " + cellNumber);

			colIndex += multiple;

			// update variables to store values from LEFT to RIGHT
			if (colIndex == -1) {
				rowIndex += 1;
				colIndex = 0;
				multiple = 1;
			}

			// update variables to store values from RIGHT to LEFT
			if (colIndex == noOfCols) {
				rowIndex += 1;
				colIndex = noOfCols - 1;
				multiple = -1;
			}

			cellNumber -= 1;
		}

		return snlBoard;

	}

	public static void printBoard(int snlBoard[][]) {
		for (int[] eachRow : snlBoard) {
			System.out.println(Arrays.toString(eachRow));
		}
	}

}
