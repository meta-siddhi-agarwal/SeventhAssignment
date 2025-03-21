package packageAssignment7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestClassForSparseMatrix {
	
	//object for calling sparse matrix functions
	SparseMatrix sparseMatrixObject=new SparseMatrix();


	/**
	 * will test transpose matrix function for different test cases
	 */
	@Test
	public void testCaseForTransposeMatrix() {
		List<List<Integer>> sparseMatrix=new ArrayList<List<Integer>>();
		List<Integer> subSparseMatrix=new ArrayList<>();
		subSparseMatrix.add(3);
		subSparseMatrix.add(2);
		subSparseMatrix.add(20);
		sparseMatrix.add(subSparseMatrix);
		
		List<List<Integer>> expectedSparseMatrix=new ArrayList<List<Integer>>();
		List<Integer> expecteSubSparseMatrix=new ArrayList<>();
		expecteSubSparseMatrix.add(2);
		expecteSubSparseMatrix.add(3);
		expecteSubSparseMatrix.add(20);
		expectedSparseMatrix.add(expecteSubSparseMatrix);
		
		assertEquals(expectedSparseMatrix, sparseMatrixObject.transposeMatrix(sparseMatrix));
		
	}
	
	//test case for is symmetrical function
	@Test
	public void testCaseForIsSymmetrical() {
		List<List<Integer>> sparseMatrix=new ArrayList<List<Integer>>();
		List<Integer> subSparseMatrix=new ArrayList<>();
		subSparseMatrix.add(2);
		subSparseMatrix.add(2);
		subSparseMatrix.add(20);
		sparseMatrix.add(subSparseMatrix);
		
		boolean expectedResult=true;
		assertEquals(expectedResult, sparseMatrixObject.isSymmetrical(sparseMatrix));
		
	}
	
	//test cases for addition of two matrix function
	@Test
	public void testCaseForAdditionOfTwoMatrix() {
		List<List<Integer>> sparseMatrix1=new ArrayList<List<Integer>>();
		List<Integer> subSparseMatrix1=new ArrayList<>();
		subSparseMatrix1.add(0);
		subSparseMatrix1.add(0);
		subSparseMatrix1.add(20);
		sparseMatrix1.add(subSparseMatrix1);
		
		List<List<Integer>> sparseMatrix2=new ArrayList<List<Integer>>();
		List<Integer> subSparseMatrix2=new ArrayList<>();
		subSparseMatrix2.add(0);
		subSparseMatrix2.add(0);
		subSparseMatrix2.add(20);
		sparseMatrix2.add(subSparseMatrix2);
		
		List<List<Integer>> expectedSparseMatrix=new ArrayList<List<Integer>>();
		List<Integer> expecteSubSparseMatrix=new ArrayList<>();
		expecteSubSparseMatrix.add(0);
		expecteSubSparseMatrix.add(0);
		expecteSubSparseMatrix.add(40);
		expectedSparseMatrix.add(expecteSubSparseMatrix);
		assertEquals(expectedSparseMatrix, sparseMatrixObject.additionOfTwoMatrix(sparseMatrix1,sparseMatrix2));
		
	}
	
	//test cases for multiplication of two matrix function
	@Test
	public void testCaseForMultiplicationOfTwoMatrix() {
		List<List<Integer>> sparseMatrix1=new ArrayList<List<Integer>>();
		List<Integer> subSparseMatrix1=new ArrayList<>();
		subSparseMatrix1.add(0);
		subSparseMatrix1.add(0);
		subSparseMatrix1.add(10);
		sparseMatrix1.add(subSparseMatrix1);
		
		List<List<Integer>> sparseMatrix2=new ArrayList<List<Integer>>();
		List<Integer> subSparseMatrix2=new ArrayList<>();
		subSparseMatrix2.add(0);
		subSparseMatrix2.add(0);
		subSparseMatrix2.add(7);
		sparseMatrix2.add(subSparseMatrix2);
		
		List<List<Integer>> expectedSparseMatrix=new ArrayList<List<Integer>>();
		List<Integer> expecteSubSparseMatrix=new ArrayList<>();
		expecteSubSparseMatrix.add(0);
		expecteSubSparseMatrix.add(0);
		expecteSubSparseMatrix.add(70);
		expectedSparseMatrix.add(expecteSubSparseMatrix);
		assertEquals(expectedSparseMatrix, sparseMatrixObject.multiplicationOfTwoMatrix(sparseMatrix1,sparseMatrix2));
		
	}
	
}

