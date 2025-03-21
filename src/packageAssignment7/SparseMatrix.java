package packageAssignment7;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

final public class SparseMatrix {
	// indicates row and column of sparse matrix
	private int row, column;

	//will store non-zero elements of a matrix
	private List<List<Integer>> nonZeroElementsList = new ArrayList<>();

	//will store sum of two matrices(non-zero elements only)
	private static List<List<Integer>> addedMatrix = new ArrayList<>();

	//will store product of two matrices(non-zero elements only)
	private static List<List<Integer>> productMatrix = new ArrayList<>();

	//will store non-zero and zero elements
	private static int sparseMatrix[][];

	//will store transpose of matrix(non-zero elements only)
	private List<List<Integer>> transposedZeroElementsList = new ArrayList<>();

	//for taking user input
	static Scanner scannerObject = new Scanner(System.in);
	
	//for controliing loop
	static boolean isValid = true;

	//will determine whether a matrix is sparse or not
	static int numberOfZeroValues = 0;

	public static void main(String[] args) {
		while (isValid) {
			try {
				System.out.println("Select which operation to perform\n" + "1.Transpose of matrix\n"
						+ "2.Check whether matrix is symmetrical\n" + "3.Addition of 2 matrix\n"
						+ "4.Multiplication of 2 matrix\n" + "5.Compute time complexity of all methods\n" + "6.Exit");
				int input = scannerObject.nextInt();
				switch (input) {

				// case 1 for transposing matrix
				case 1:
					// sparse matrix obj. for initializing private variables
					SparseMatrix sparseMatrixForCase1 = new SparseMatrix();

					// getting row and column of matrix from user
					sparseMatrixForCase1.row = sparseMatrixForCase1.inputRowFromUser();
					sparseMatrixForCase1.column = sparseMatrixForCase1.inputColumnFromUser();

					// adding only non zero elements to list
					sparseMatrixForCase1.nonZeroElementsList = sparseMatrixForCase1.getInputMatrixFromUser(
							sparseMatrixForCase1.row, sparseMatrixForCase1.column, "matrix first");

					// if non-zero elements>zero elements, it means matrix is not sparse
					numberOfZeroValues = (sparseMatrixForCase1.row * sparseMatrixForCase1.column)
							- sparseMatrixForCase1.nonZeroElementsList.size();

					if (sparseMatrixForCase1.nonZeroElementsList.size() < numberOfZeroValues) {

						// retrieving transpose matrix
						sparseMatrixForCase1.transposedZeroElementsList = sparseMatrixForCase1
								.transposeMatrix(sparseMatrixForCase1.nonZeroElementsList);
						System.out.println("Transposed matrix is ");

						// print result, which is in matrix format
						printMatrix(sparseMatrixForCase1.column, sparseMatrixForCase1.row,
								sparseMatrixForCase1.transposedZeroElementsList);
					} else
						System.out.println("Matrix is not sparse");
					break;

				// case 2 will check whether a matrix is sparse or not
				case 2:

					// sparse matrix obj. for initializing private variables
					SparseMatrix sparseMatrixForCase2 = new SparseMatrix();

					// getting row and column of matrix from user
					sparseMatrixForCase2.row = sparseMatrixForCase2.inputRowFromUser();
					sparseMatrixForCase2.column = sparseMatrixForCase2.inputColumnFromUser();

					if (sparseMatrixForCase2.row != sparseMatrixForCase2.column) {
						System.out.println("Matrix is not symmetrical");
						break;
					}
					// adding only non zero elements to list
					sparseMatrixForCase2.nonZeroElementsList = sparseMatrixForCase2.getInputMatrixFromUser(
						sparseMatrixForCase2.row, sparseMatrixForCase2.column, "matrix first");

					// if non-zero elements>zero elements, it means matrix is not sparse
					numberOfZeroValues = (sparseMatrixForCase2.row * sparseMatrixForCase2.column)
						- sparseMatrixForCase2.nonZeroElementsList.size();
					if (sparseMatrixForCase2.nonZeroElementsList.size() < numberOfZeroValues) {

						// check whether matrix is symmetrical or not
						boolean ifSymmetrical = sparseMatrixForCase2
								.isSymmetrical(sparseMatrixForCase2.nonZeroElementsList);
						if (ifSymmetrical == true)
							System.out.println("Matrix is Symmetrical");
						else
							System.out.println("Matrix is not Symmetrical");
					} else
						System.out.println("Matrix is not sparse");
					break;

				// case3 will add 2 matrix
				case 3:

					// sparse matrix obj. for initializing private variables
					SparseMatrix sparseMatrixForFirstMatrix = new SparseMatrix();
					SparseMatrix sparseMatrixForSecondMatrix = new SparseMatrix();

					// getting row and column of matrix from user
					sparseMatrixForFirstMatrix.row = sparseMatrixForFirstMatrix.inputRowFromUser();
					sparseMatrixForFirstMatrix.column = sparseMatrixForSecondMatrix.inputColumnFromUser();

					sparseMatrixForSecondMatrix.row = sparseMatrixForFirstMatrix.inputRowFromUser();
					sparseMatrixForSecondMatrix.column = sparseMatrixForSecondMatrix.inputColumnFromUser();

					// if row=column, only then addition is possible
					if (sparseMatrixForFirstMatrix.row == sparseMatrixForSecondMatrix.row
							&& sparseMatrixForFirstMatrix.column == sparseMatrixForSecondMatrix.column) {

						sparseMatrixForFirstMatrix.nonZeroElementsList = sparseMatrixForFirstMatrix
								.getInputMatrixFromUser(sparseMatrixForFirstMatrix.row,
										sparseMatrixForFirstMatrix.column, "matrix first");
						numberOfZeroValues = (sparseMatrixForFirstMatrix.row * sparseMatrixForFirstMatrix.column)
								- sparseMatrixForFirstMatrix.nonZeroElementsList.size();

						// if non-zero elements>zero elements, it means matrix is not sparse
						if (sparseMatrixForFirstMatrix.nonZeroElementsList.size() < numberOfZeroValues) {

							// if non-zero elements>zero elements, it means matrix is not sparse
							sparseMatrixForSecondMatrix.nonZeroElementsList = sparseMatrixForSecondMatrix
									.getInputMatrixFromUser(sparseMatrixForSecondMatrix.row,
											sparseMatrixForSecondMatrix.column, "matrix second");

							// if non-zero elements>zero elements, it means matrix is not sparse
							numberOfZeroValues = (sparseMatrixForSecondMatrix.row * sparseMatrixForSecondMatrix.column)
									- sparseMatrixForSecondMatrix.nonZeroElementsList.size();

							if (sparseMatrixForSecondMatrix.nonZeroElementsList.size() < numberOfZeroValues) {
								addedMatrix = sparseMatrixForSecondMatrix.additionOfTwoMatrix(
										sparseMatrixForFirstMatrix.nonZeroElementsList,
										sparseMatrixForFirstMatrix.nonZeroElementsList);
								System.out.println("Addition of matrix is ");
								printMatrix(sparseMatrixForSecondMatrix.row, sparseMatrixForSecondMatrix.column,
										addedMatrix);
							} else
								System.out.println("It is not a sparse matrix");
						} else
							System.out.println("It is not a sparse matrix");
					} else
						System.out.println("Addition cannot be done");

					break;

				// case4 will multiply 2 matrix
				case 4:

					// sparse matrix obj. for initializing private variables
					SparseMatrix sparseObjectForFirstMatrix = new SparseMatrix();
					SparseMatrix sparseObjectForSecondMatrix = new SparseMatrix();

					// getting row and column of matrix from user
					sparseObjectForFirstMatrix.row = sparseObjectForFirstMatrix.inputRowFromUser();
					sparseObjectForFirstMatrix.column = sparseObjectForFirstMatrix.inputColumnFromUser();
					sparseObjectForSecondMatrix.row = sparseObjectForSecondMatrix.inputRowFromUser();

					// mandatory condition for performing multiplication in a matrix
					if (sparseObjectForFirstMatrix.column == sparseObjectForSecondMatrix.row) {

						// if true, proceed to taking column of 2nd matrix
						sparseObjectForSecondMatrix.column = sparseObjectForSecondMatrix.inputColumnFromUser();

						// take 1st matrix values
						sparseObjectForFirstMatrix.nonZeroElementsList = sparseObjectForFirstMatrix
								.getInputMatrixFromUser(sparseObjectForFirstMatrix.row,
										sparseObjectForFirstMatrix.column, "matrix first");

						numberOfZeroValues = (sparseObjectForFirstMatrix.row * sparseObjectForFirstMatrix.column)
								- sparseObjectForFirstMatrix.nonZeroElementsList.size();

						if (sparseObjectForFirstMatrix.nonZeroElementsList.size() < numberOfZeroValues) {

							// take 2nd matrix values
							sparseObjectForSecondMatrix.nonZeroElementsList = sparseObjectForSecondMatrix
									.getInputMatrixFromUser(sparseObjectForSecondMatrix.row,
											sparseObjectForSecondMatrix.column, "matrix second");

							numberOfZeroValues = (sparseObjectForSecondMatrix.row * sparseObjectForSecondMatrix.column)
									- sparseObjectForSecondMatrix.nonZeroElementsList.size();

							if (sparseObjectForSecondMatrix.nonZeroElementsList.size() < numberOfZeroValues) {

								productMatrix = sparseObjectForFirstMatrix.multiplicationOfTwoMatrix(
										sparseObjectForFirstMatrix.nonZeroElementsList,
										sparseObjectForSecondMatrix.nonZeroElementsList);
								System.out.println("Product of matrix is ");
								printMatrix(sparseObjectForFirstMatrix.row, sparseObjectForSecondMatrix.column,
										productMatrix);
							} else
								System.out.println("It is not a sparse matrix");
						} else
							System.out.println("It is not a sparse matrix");
					} else
						System.out.println("Multiplication cannot be done");
					break;

				// case 5 will display complexity for all the operations
				case 5:
					System.out.println("Time complexity of transpose of a matrix is O(n)\n"
							+ "Time complexity of computing if matrix is symmetrical is O(n)\n"
							+ "Time complexity of adding two matrixes O(n+m) where n and m are sizes of two matrixes\n"
							+ "Time complexity of multiplying two matrixes is O(n^3)");
					break;

				// case 6 will terminate the program
				case 6:
					System.out.println("Program terminated successfully");

					isValid = false;
					break;

				// default test case for handling invalid input
				default:
					System.out.println("Please choose valid option");

				}
			} catch (Exception e) {
				System.out.println("Enter valid input");
				scannerObject.nextLine();
			}
		}
	}

	/**
	 * function prints matrix in 2-D format
	 * 
	 * @param rowOfMatrix         represents row of matrix
	 * @param columnOfMatrix      represents column of matrix
	 * @param nonZeroElementsList contains non-zero elements only
	 */
	static public void printMatrix(int rowOfMatrix, int columnOfMatrix, List<List<Integer>> nonZeroElementsList) {
		sparseMatrix = new int[rowOfMatrix][columnOfMatrix];

		for (int nonZeroListIndex = 0; nonZeroListIndex < nonZeroElementsList.size(); nonZeroListIndex++) {
			int rowOfList = nonZeroElementsList.get(nonZeroListIndex).get(0);
			int columnOfList = nonZeroElementsList.get(nonZeroListIndex).get(1);

			// setting sparsematrix's value when there is a non-zero value present in a cell
			sparseMatrix[rowOfList][columnOfList] = nonZeroElementsList.get(nonZeroListIndex).get(2);
		}

		// printing entire matrix
		for (int rowIndex = 0; rowIndex < sparseMatrix.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < sparseMatrix[rowIndex].length; columnIndex++) {
				System.out.print(sparseMatrix[rowIndex][columnIndex] + "  ");
			}
			System.out.println();
		}

	}

	/**
	 * will give no. of rows user wants in a matrix
	 * 
	 * @return no. of rows in matrix
	 * @throws Exception in case row<=0
	 */
	private int inputRowFromUser() throws Exception {
		System.out.println("Enter no. of rows");
		int rowOfMatrix = scannerObject.nextInt();
		if (rowOfMatrix > 0)
			return rowOfMatrix;
		else
			throw new Exception();
	}

	/**
	 * will give no. of column user wants in a matrix
	 * 
	 * @return no. of rows in matrix
	 * @throws Exception in case column<=0
	 */
	private int inputColumnFromUser() throws Exception {
		System.out.println("Enter no. of columns");
		int columnOfMatrix = scannerObject.nextInt();
		if (columnOfMatrix > 0)
			return columnOfMatrix;
		else
			throw new Exception();

	}

	/**
	 * will take input of matrix from user
	 * 
	 * @param numberOfRows    in a 2-D matrix
	 * @param numberOfColumns in a 2-D matrix
	 * @param message         whether we want input for first matrix or second
	 * @return
	 */
	public List<List<Integer>> getInputMatrixFromUser(int numberOfRows, int numberOfColumns, String message) {

		List<List<Integer>> nonZeroMatrix = new ArrayList<>();
		for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
			System.out.println("Enter the values of row " + rowIndex);
			for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
				System.out.println("Value at " + rowIndex + "," + columnIndex);
				int valueOfMatrix = scannerObject.nextInt();
				// if value is non-zero, then add
				if (valueOfMatrix != 0) {
					List<Integer> subList = new ArrayList<>();
					subList.add(rowIndex);
					subList.add(columnIndex);
					subList.add(valueOfMatrix);

					// add sub list to main list
					nonZeroMatrix.add(subList);

				}
			}
		}

		return nonZeroMatrix;

	}

	/**
	 * will compute transpose of a matrix
	 * 
	 * @param sparseMatrixList initial matrix which needs to be transposed
	 * @return transposed matrix
	 */
	public List<List<Integer>> transposeMatrix(List<List<Integer>> sparseMatrixList) {
		List<List<Integer>> transposedMatrix = new ArrayList<>();

		for (int sparseMatrixIndex = 0; sparseMatrixIndex < sparseMatrixList.size(); sparseMatrixIndex++) {
			List<Integer> subList = new ArrayList<>();
			subList = sparseMatrixList.get(sparseMatrixIndex);
			int rowOfSubList = subList.get(0);
			int columnOfSubList = subList.get(1);
			int valueOfSubList = subList.get(2);

			// changing row to column and vice versa and adding it to another sub list
			List<Integer> subListOfTransposedMatrix = new ArrayList<>();
			subListOfTransposedMatrix.add(columnOfSubList);
			subListOfTransposedMatrix.add(rowOfSubList);
			subListOfTransposedMatrix.add(valueOfSubList);

			// then adding it to main list
			transposedMatrix.add(subListOfTransposedMatrix);
		}
		return transposedMatrix;
	}

	/**
	 * will give boolean ans. whether matrix is symmetrical or not
	 * 
	 * @param sparseMatrixList initial matrix which was entered be the user
	 * @return whether matrix is symmetrical or not
	 */
	public boolean isSymmetrical(List<List<Integer>> sparseMatrixList) {
		// for storing transpose elements, we will be calling transpose function
		List<List<Integer>> transposedMatrix = transposeMatrix(sparseMatrixList);

		// if both matrix's size are not equal, matrix is not symmetrical
		if (transposedMatrix.size() != sparseMatrixList.size())
			return false;
		else {
			for (int transposedMatrixIndex = 0; transposedMatrixIndex < transposedMatrix
					.size(); transposedMatrixIndex++) {
				// getting row, column and value from transposed sub list
				List<Integer> subList = new ArrayList<>();
				subList = transposedMatrix.get(transposedMatrixIndex);
				int rowOfSubList = subList.get(0);
				int columnOfSubLIst = subList.get(1);
				int valueOfSubList = subList.get(2);

				// getting row, column and value from original sub list
				List<Integer> reversedSubList = new ArrayList<>();
				reversedSubList = sparseMatrixList.get(0);
				int rowOfReversedSubList = reversedSubList.get(0);
				int columnOfReversedSubList = reversedSubList.get(1);
				int valueOfReversedSubList = reversedSubList.get(2);

				// condition for symmetrical
				if (rowOfSubList == rowOfReversedSubList && columnOfSubLIst == columnOfReversedSubList
						&& valueOfSubList == valueOfReversedSubList) {
				} else
					return false;
			}

		}

		return true;
	}

	/**
	 * will compute addition of 2 matrices
	 * 
	 * @param firstMatrix  entered by the user
	 * @param secondMatrix entered by the user
	 * @return sum of the both matrices
	 */
	public List<List<Integer>> additionOfTwoMatrix(List<List<Integer>> firstMatrix, List<List<Integer>> secondMatrix) {

		/*
		 * to prevent out of bound exception also we will be saving space by only adding
		 * values in first matrix or second matrix and returning it
		 */
		if (firstMatrix.size() > secondMatrix.size()) {

			for (int secondMatrixIndex = 0; secondMatrixIndex < secondMatrix.size(); secondMatrixIndex++) {
				List<Integer> subListOfFirstMatrix = new ArrayList<>();
				// getting row , column and value from first submatrix
				subListOfFirstMatrix = firstMatrix.get(secondMatrixIndex);
				int rowOfSubList = subListOfFirstMatrix.get(0);
				int columnOfSubList = subListOfFirstMatrix.get(1);
				int valueOfSubList = subListOfFirstMatrix.get(2);

				// getting row , column and value from first submatrix
				List<Integer> subListOfSecondMatrix = new ArrayList<>();
				subListOfSecondMatrix = secondMatrix.get(secondMatrixIndex);
				int rowOfSecondMatrix = subListOfSecondMatrix.get(0);
				int columnOfSecondMatrix = subListOfSecondMatrix.get(1);
				int valueOfSeconMatrix = subListOfSecondMatrix.get(2);

				// if there is a non-zero value in both the matrices at a particular position

				if (rowOfSecondMatrix == rowOfSubList && columnOfSecondMatrix == columnOfSubList) {

					int addedValue = valueOfSeconMatrix + valueOfSubList;

					subListOfFirstMatrix.remove(2);
					if (addedValue != 0)
						subListOfFirstMatrix.add(addedValue);
					else
						firstMatrix.remove(subListOfFirstMatrix);

				} else {

					List<Integer> subListOfFirstList = new ArrayList<>();
					subListOfFirstList.add(rowOfSecondMatrix);
					subListOfFirstList.add(columnOfSecondMatrix);
					subListOfFirstList.add(valueOfSeconMatrix);
					firstMatrix.add(subListOfFirstList);

				}

			}
			return firstMatrix;

		} else {

			// same we will repeating for another matrix if second matrix>first one
			for (int firstMatrixIndex = 0; firstMatrixIndex < firstMatrix.size(); firstMatrixIndex++) {
				List<Integer> subListOfSecondMatrix = new ArrayList<>();
				subListOfSecondMatrix = secondMatrix.get(firstMatrixIndex);
				int rowOfSecondMatrix = subListOfSecondMatrix.get(0);
				int columnOfSecondMatrix = subListOfSecondMatrix.get(1);
				int valueOfSecondMatrix = subListOfSecondMatrix.get(2);

				List<Integer> subListOfFirstMatrix = new ArrayList<>();
				subListOfFirstMatrix = firstMatrix.get(firstMatrixIndex);
				int rowOfFirstMatrix = subListOfFirstMatrix.get(0);
				int columnOfFirstMatrix = subListOfFirstMatrix.get(1);
				int valueOfFirstMatrix = subListOfFirstMatrix.get(2);

				List<Integer> subListOfAddedMatrix = new ArrayList<>();

				if (rowOfFirstMatrix == rowOfSecondMatrix && columnOfFirstMatrix == columnOfSecondMatrix) {
					int addedValue = valueOfFirstMatrix + valueOfSecondMatrix;

					subListOfSecondMatrix.remove(2);
					if (addedValue != 0)
						subListOfSecondMatrix.add(addedValue);
					else
						secondMatrix.remove(subListOfSecondMatrix);
				} else {
					subListOfAddedMatrix.add(valueOfSecondMatrix);
					subListOfAddedMatrix.add(rowOfFirstMatrix);
					subListOfAddedMatrix.add(columnOfFirstMatrix);
					subListOfAddedMatrix.add(valueOfFirstMatrix);
					secondMatrix.add(subListOfAddedMatrix);

				}

			}
			return secondMatrix;
		}

	}

	/**
	 * will compute multiplication of 2 matrices
	 * 
	 * @param firstMatrix  entered by the user
	 * @param secondMatrix entered by the user
	 * @return product matrix
	 */
	public List<List<Integer>> multiplicationOfTwoMatrix(List<List<Integer>> firstMatrix,
			List<List<Integer>> secondMatrix) {

		List<List<Integer>> productMatrix = new ArrayList<>();

		// we will calculate product of both matrix using O(n^3) complexity
		for (int firstMatrixIndex = 0; firstMatrixIndex < firstMatrix.size(); firstMatrixIndex++) {
			List<Integer> firstSubMatrix = firstMatrix.get(firstMatrixIndex);
			int columnOfFirstMatrix = firstSubMatrix.get(1);
			int valueOfFirstMatrix = firstSubMatrix.get(2);

			// traversing first matrix item with every item of 2nd matrix
			for (int secondMatrixIndex = 0; secondMatrixIndex < secondMatrix.size(); secondMatrixIndex++) {
				List<Integer> secondSubMatrix = secondMatrix.get(secondMatrixIndex);
				int rowOfSecondMatrix = secondSubMatrix.get(0);

				// mandatory condition for multiplication in a matrix
				if (columnOfFirstMatrix == rowOfSecondMatrix) {
					int valueOfSecondMatrix = secondSubMatrix.get(2);

					// generating output of both cell
					int resultantProduct = valueOfFirstMatrix * valueOfSecondMatrix;
					int rowOfFirstMatrix = firstSubMatrix.get(0);
					int columnOfSecondMatrix = secondSubMatrix.get(1);
					List<Integer> productSubMatrix = new ArrayList<>();

					/*
					 * there might be a situation where particular cell already consist a value
					 * therefore traversing entirely throughout the product matrix
					 */
					if (productMatrix.size() > 0) {

						for (int productMatrixIndex = 0; productMatrixIndex < productMatrix
								.size(); productMatrixIndex++) {
							productSubMatrix = productMatrix.get(productMatrixIndex);

							// here we mention the condition
							if (productSubMatrix.get(0) == rowOfFirstMatrix
									&& productSubMatrix.get(1) == columnOfSecondMatrix) {
								resultantProduct += productSubMatrix.get(2);
								// updating values
								productSubMatrix.remove(2);
								productSubMatrix.add(resultantProduct);
								break;
							} else {
								// if the condition does not satisfy, just add
								List<Integer> subMatrixForProduct = new ArrayList<Integer>();
								subMatrixForProduct.add(rowOfFirstMatrix);
								subMatrixForProduct.add(columnOfSecondMatrix);
								subMatrixForProduct.add(resultantProduct);

								productMatrix.add(subMatrixForProduct);
								break;
							}
						}

					}

					// if product matrix is empty, just add
					else {

						productSubMatrix.add(rowOfFirstMatrix);
						productSubMatrix.add(columnOfSecondMatrix);
						productSubMatrix.add(resultantProduct);// prodRes
						productMatrix.add(productSubMatrix);// secondMatCol

					}
				}

			}
		}
		return productMatrix;
	}
}
