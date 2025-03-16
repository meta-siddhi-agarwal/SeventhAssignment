package packageAssignment7;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

final public class SparseMatrix {
 
private int row,column;	


private static List<List<Integer>> nonZeroElementsListFirst=new ArrayList<>();

private static List<List<Integer>> nonZeroElementsListSecond=new ArrayList<>();

private static List<List<Integer>> addedMatrix=new ArrayList<>();

private static List<List<Integer>> productMatrix=new ArrayList<>();


static List<List<Integer>> transposedZeroElementsList=new ArrayList<>();

private SparseMatrix(int rowofSparseMatrix,int columnOfSparseMatrix) {
	row=rowofSparseMatrix;
	column=columnOfSparseMatrix;

}


static Scanner scannerObject=new Scanner(System.in);

static int rowOfMatrixFirst,columnOfMatrixFirst,
rowOfMatrixSecond,columnOfMatrixSecond;

static SparseMatrix sparseMatrixObject=new SparseMatrix();
 SparseMatrix() {
	
}
static boolean isValid=true;

static int numberOfZeroValues=0;
	public static void main(String[] args) 
	{
		while(isValid) {
			try {
				System.out.println("Select which operation to perform\n"
				+"1.Transpose of matrix\n"+"2.Check whether matrix is symmetrical\n"
				+"3.Addition of 2 matrix\n"+"4.Multiplication of 2 matrix\n"
				+"5.Compute time complexity of all methods\n"+"6.Exit");
				int input=scannerObject.nextInt();
				switch(input){
				case 1:
					rowOfMatrixFirst=sparseMatrixObject.inputRowFromUser();
					columnOfMatrixFirst=sparseMatrixObject.inputColumnFromUser();
					nonZeroElementsListFirst=sparseMatrixObject.inputFromUser(rowOfMatrixFirst, columnOfMatrixFirst,"matrix first");
					numberOfZeroValues=(rowOfMatrixFirst * columnOfMatrixFirst)-nonZeroElementsListFirst.size();
					if(nonZeroElementsListFirst.size()<numberOfZeroValues) {
					transposedZeroElementsList=sparseMatrixObject.transposeMatrix(nonZeroElementsListFirst);
					System.out.println("Transposed matrix is "+transposedZeroElementsList);}
					else System.out.println("Matrix is not sparse");
					break;
				case 2:
					rowOfMatrixFirst=sparseMatrixObject.inputRowFromUser();
					columnOfMatrixFirst=sparseMatrixObject.inputColumnFromUser();
					nonZeroElementsListFirst=sparseMatrixObject.inputFromUser(rowOfMatrixFirst, columnOfMatrixFirst,"matrix first");
					numberOfZeroValues=(rowOfMatrixFirst * columnOfMatrixFirst)-nonZeroElementsListFirst.size();
					if(nonZeroElementsListFirst.size()<numberOfZeroValues) {
					boolean ifSymmetrical=sparseMatrixObject.isSymmetrical(nonZeroElementsListFirst);
					if(ifSymmetrical==true)System.out.println("Matrix is Symmetrical");
					else System.out.println("Matrix is not Symmetrical");}
					else System.out.println("Matrix is not sparse");
					break;
				case 3:
					rowOfMatrixFirst=sparseMatrixObject.inputRowFromUser();
					columnOfMatrixFirst=sparseMatrixObject.inputColumnFromUser();
					rowOfMatrixSecond=sparseMatrixObject.inputRowFromUser();
					columnOfMatrixSecond=sparseMatrixObject.inputColumnFromUser();
					if(rowOfMatrixFirst==rowOfMatrixSecond && columnOfMatrixFirst==columnOfMatrixSecond) {
						nonZeroElementsListFirst=sparseMatrixObject.inputFromUser(rowOfMatrixFirst, columnOfMatrixFirst,"matrix first");
						numberOfZeroValues=(rowOfMatrixFirst * columnOfMatrixFirst)-nonZeroElementsListFirst.size();
						if(nonZeroElementsListFirst.size()<numberOfZeroValues) {
						nonZeroElementsListSecond=sparseMatrixObject.inputFromUser(rowOfMatrixSecond, columnOfMatrixSecond,"matrix second");
						numberOfZeroValues=(rowOfMatrixSecond * columnOfMatrixSecond)-nonZeroElementsListSecond.size();
						if(nonZeroElementsListSecond.size()<numberOfZeroValues) {
						addedMatrix=sparseMatrixObject.addition(nonZeroElementsListFirst, nonZeroElementsListSecond);
						System.out.println("Addition of matrix is "+addedMatrix);
					}
						else System.out.println("It is not a sparse matrix");
						}
						else System.out.println("It is not a sparse matrix");
					}
						else System.out.println("Addition cannot be done");
						
					break;
				case 4:
					rowOfMatrixFirst=sparseMatrixObject.inputRowFromUser();
					columnOfMatrixFirst=sparseMatrixObject.inputColumnFromUser();
					rowOfMatrixSecond=sparseMatrixObject.inputRowFromUser();
					if(columnOfMatrixFirst==rowOfMatrixSecond ) {
					columnOfMatrixSecond=sparseMatrixObject.inputColumnFromUser();
				
						nonZeroElementsListFirst=sparseMatrixObject.inputFromUser(rowOfMatrixFirst, columnOfMatrixFirst,"matrix first");
						numberOfZeroValues=(rowOfMatrixFirst * columnOfMatrixFirst)-nonZeroElementsListFirst.size();
						if(nonZeroElementsListFirst.size()<numberOfZeroValues) {
						nonZeroElementsListSecond=sparseMatrixObject.inputFromUser(rowOfMatrixSecond, columnOfMatrixSecond,"matrix second");
						numberOfZeroValues=(rowOfMatrixSecond * columnOfMatrixSecond)-nonZeroElementsListSecond.size();
						if(nonZeroElementsListSecond.size()<numberOfZeroValues) {
						productMatrix=sparseMatrixObject.multiplication(nonZeroElementsListFirst, nonZeroElementsListSecond);
						System.out.println("Product of matrix is "+productMatrix);
					}
						else System.out.println("It is not a sparse matrix");
						}
						else System.out.println("It is not a sparse matrix");
					}
					else System.out.println("Multiplication cannot be done");
					break;
				case 5:
					System.out.println("Time complexity of transpose of a matrix is O(n)\n"
				    +"Time complexity of computing if matrix is symmetrical is O(n)\n"
					+"Time complexity of adding two matrixes O(n+m) where n and m are sizes of two matrixes\n"
					+"Time complexity of multiplying two matrixes is O(n^3)");
					break;
				case 6:
					System.out.println("Program terminated successfully");

					isValid=false;
					break;
				default:
					System.out.println("Please choose valid option");
					
				}
			}
			catch(Exception e) {
				System.out.println(e);
				scannerObject.nextLine();
			}
		}
		
	
		
		
	}
	
	private int inputRowFromUser() throws Exception {
		System.out.println("Enter no. of rows");
		int rowOfMatrix=scannerObject.nextInt();
		if(rowOfMatrix>0)return rowOfMatrix;
		else throw new Exception();
	}
	
	private int inputColumnFromUser() throws Exception {
		System.out.println("Enter no. of columns");
		int columnOfMatrix=scannerObject.nextInt();
		if(columnOfMatrix>0)return columnOfMatrix;
		else throw new Exception();
		
	}
	
	List<List<Integer>> inputFromUser(int numberOfRows,int numberOfColumns,String message)
	{

		List<List<Integer>> nonZeroMatrix=new ArrayList<>();
		for(int rowIndex=0;rowIndex<numberOfRows;rowIndex++) {
			for(int columnIndex=0;columnIndex<numberOfColumns;columnIndex++) {
				System.out.println("Enter value of cell of "+message);
				int valueOfMatrix=scannerObject.nextInt();
				if(valueOfMatrix>0 || valueOfMatrix<0) {
					List<Integer> subList=new ArrayList();
					subList.add(rowIndex);
					subList.add(columnIndex);
					subList.add(valueOfMatrix);
					nonZeroMatrix.add(subList);

				}
			}
		}

		return nonZeroMatrix;
		
	}
	
	List<List<Integer>> transposeMatrix(List<List<Integer>> sparseMatrixList) 
	{
		List<List<Integer>> transposedMatrix=new ArrayList<>();
		
		for(int sparseMatrixIndex=0;sparseMatrixIndex<sparseMatrixList.size();sparseMatrixIndex++) {
			List<Integer> subList=new ArrayList<>();
			subList=sparseMatrixList.get(sparseMatrixIndex);
			int rowOfSubList=subList.get(0);
			int columnOfSubList=subList.get(1);
			int valueOfSubList=subList.get(2);
			List<Integer> subListOfTransposedMatrix=new ArrayList<>();
			subListOfTransposedMatrix.add(columnOfSubList);
			subListOfTransposedMatrix.add(rowOfSubList);
			subListOfTransposedMatrix.add(valueOfSubList);
			transposedMatrix.add(subListOfTransposedMatrix);
		}
		
		
		return transposedMatrix;
		

	}
	
	
	boolean isSymmetrical(List<List<Integer>> sparseMatrixList)
	{
		List<List<Integer>> transposedMatrix=transposeMatrix(sparseMatrixList);
		
		if(transposedMatrix.size()!=sparseMatrixList.size())return false;
	 else {
		 for(int transposedMatrixIndex=0;transposedMatrixIndex<transposedMatrix.size();transposedMatrixIndex++) 
		 {
			 List<Integer> subList=new ArrayList<>();
			 subList=transposedMatrix.get(transposedMatrixIndex);
			 int rowOfSubList=subList.get(0);
			 int columnOfSubLIst=subList.get(1);
			 int valueOfSubList=subList.get(2);
			 List<Integer> reversedSubList=new ArrayList<>();
			 reversedSubList=sparseMatrixList.get(0);
			 int rowOfReversedSubList=reversedSubList.get(0);
			 int columnOfReversedSubList=reversedSubList.get(1);
			 int valueOfReversedSubList=reversedSubList.get(2);
			 if(rowOfSubList==rowOfReversedSubList && columnOfSubLIst==columnOfReversedSubList
		      && valueOfSubList==valueOfReversedSubList) {}
			 else return false;
		 }
		 
		 
		 

	 }
	
		return true;
	}
	
	List<List<Integer>> addition(List<List<Integer>> firstMatrix,List<List<Integer>> secondMatrix)
	{

		List<List<Integer>> addedList=new ArrayList<>();
		if(firstMatrix.size()>secondMatrix.size()) {

			for(int secondMatrixIndex=0;secondMatrixIndex<secondMatrix.size();secondMatrixIndex++) {
				List<Integer> subListOfFirstMatrix=new ArrayList<>();
				subListOfFirstMatrix=firstMatrix.get(secondMatrixIndex);
				int rowOfSubList=subListOfFirstMatrix.get(0);
				int columnOfSubList=subListOfFirstMatrix.get(1);
				int valueOfSubList=subListOfFirstMatrix.get(2);
				
				List<Integer> subListOfSecondMatrix=new ArrayList<>();
				subListOfSecondMatrix=secondMatrix.get(secondMatrixIndex);
				int rowOfSecondMatrix=subListOfSecondMatrix.get(0);
				int columnOfSecondMatrix=subListOfSecondMatrix.get(1);
				int valueOfSeconMatrix=subListOfSecondMatrix.get(2);
				List<Integer> subListOfAddedMatrix=new ArrayList<>();

				if(rowOfSecondMatrix==rowOfSubList && columnOfSecondMatrix==columnOfSubList) {
					System.out.println("hello");
					int addedValue=valueOfSeconMatrix+valueOfSubList;

					subListOfFirstMatrix.remove(2);
					if(addedValue!=0)
					subListOfFirstMatrix.add(addedValue);
					else firstMatrix.remove(subListOfFirstMatrix);
					
				}
				else {
					System.out.println(rowOfSecondMatrix+" "+rowOfSubList+" "+columnOfSecondMatrix);
					List<Integer> subListOfFirstList=new ArrayList<>();
					subListOfFirstList.add(rowOfSecondMatrix);
					subListOfFirstList.add(columnOfSecondMatrix);
					subListOfFirstList.add(valueOfSeconMatrix);
					firstMatrix.add(subListOfFirstList);
				
				}
		
			
			}
			return firstMatrix;

			
		}
		else {
			
			for(int firstMatrixIndex=0;firstMatrixIndex<firstMatrix.size();firstMatrixIndex++) {
				List<Integer> subListOfSecondMatrix=new ArrayList<>();
				subListOfSecondMatrix=secondMatrix.get(firstMatrixIndex);
				int rowOfSecondMatrix=subListOfSecondMatrix.get(0);
				int columnOfSecondMatrix=subListOfSecondMatrix.get(1);
				int valueOfSecondMatrix=subListOfSecondMatrix.get(2);
				
				List<Integer> subListOfFirstMatrix=new ArrayList<>();
				subListOfFirstMatrix=firstMatrix.get(firstMatrixIndex);
				int rowOfFirstMatrix=subListOfFirstMatrix.get(0);
				int columnOfFirstMatrix=subListOfFirstMatrix.get(1);
				int valueOfFirstMatrix=subListOfFirstMatrix.get(2);
				List<Integer> subListOfAddedMatrix=new ArrayList<>();

				if(rowOfFirstMatrix==rowOfSecondMatrix && columnOfFirstMatrix==columnOfSecondMatrix) {
					int addedValue=valueOfFirstMatrix+valueOfSecondMatrix;

					subListOfSecondMatrix.remove(2);
					if(addedValue!=0)
						subListOfSecondMatrix.add(addedValue);
						else secondMatrix.remove(subListOfSecondMatrix);

					
				}
				else {
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


	
	
	
	List<List<Integer>> multiplication(List<List<Integer>> firstMatrix,
			List<List<Integer>> secondMatrix){
		
		List<List<Integer>> productMatrix=new ArrayList<>();
		for(int firstMatrixIndex=0;firstMatrixIndex<firstMatrix.size();firstMatrixIndex++) {
			List<Integer> firstSubMatrix=firstMatrix.get(firstMatrixIndex);
			int columnOfFirstMatrix=firstSubMatrix.get(1);
			int valueOfFirstMatrix=firstSubMatrix.get(2);
			for(int secondMatrixIndex=0;secondMatrixIndex<secondMatrix.size();secondMatrixIndex++) {
				List<Integer> secondSubMatrix=secondMatrix.get(secondMatrixIndex);
				int rowOfSecondMatrix=secondSubMatrix.get(0);
				if(columnOfFirstMatrix==rowOfSecondMatrix) {
					int valueOfSecondMatrix=secondSubMatrix.get(2);
					int resultantProduct=valueOfFirstMatrix*valueOfSecondMatrix;
					int rowOfFirstMatrix=firstSubMatrix.get(0);
					int columnOfSecondMatrix=secondSubMatrix.get(1);
					List<Integer> productSubMatrix=new ArrayList<>();
					if(productMatrix.size()>0) {
						
						for(int productMatrixIndex=0;productMatrixIndex<productMatrix.size();productMatrixIndex++) {
							productSubMatrix=productMatrix.get(productMatrixIndex);
							if(productSubMatrix.get(0)==rowOfFirstMatrix 
							&& productSubMatrix.get(1)==columnOfSecondMatrix) {
								resultantProduct+=productSubMatrix.get(2);

								productSubMatrix.remove(2);
								productSubMatrix.add(resultantProduct);
								break;
							}
							else {
								List<Integer> subMatrixForProduct=new ArrayList<Integer>();
								subMatrixForProduct.add(rowOfFirstMatrix);
								subMatrixForProduct.add(columnOfSecondMatrix);
								subMatrixForProduct.add(resultantProduct);
								
								productMatrix.add(subMatrixForProduct);
								break;
							}
						}
						
					}
					else {
					
						productSubMatrix.add(rowOfFirstMatrix);
						productSubMatrix.add(columnOfSecondMatrix);
						productSubMatrix.add(resultantProduct);
						productMatrix.add(productSubMatrix);
						
					}
				}
				
				}
			}
		return productMatrix;
	}
}


