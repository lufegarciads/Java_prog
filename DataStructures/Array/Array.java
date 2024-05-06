// Luis Felipe Garcia de Souza (Leader), Diana Afanasyev, Jessie Moszkowicz, Barry Penner
// COMP 5511 - Principles of Data Structures
// Fall 2023
// Assignment 1 Question 6

public class Array {

	public static void main(String[] args) {
		
		// Defining array parameters used for testing
		int n = 15;     // size of arrays to be tested. Grader - feel free to modify for testing purposes
		int max = (int)(n*1.5);   // maximum value of array elements defined to optimize probability of duplicates for testing purposes
		
		System.out.println("------------------------------------------------------------- "
		          	 +  "\n|   SORTING-BY-COUNTING OF ARRAY OF NON-REPEATING INTEGERS   |"
			         +  "\n -------------------------------------------------------------");
		
		
		// Creating and initializing 3 arrays
		int[] A = noRepArray(n,max);   // Array size 'n' of random non-repeating integers the value of which does not exceed 'max'
		int[] B = new int[n];
		int[] C = new int[n];

		
		// Printing arrays pre-sorting
		System.out.println("\nPRE-SORTING:");
		printArrays(A,B,C);

		// Sorting-by-count A[] into B[], using C[] to map A[] values to B[] indices
		SortByCountNoRep(A,B,C);

		// Printing arrays post-sorting
		System.out.println("\nPOST-SORTING:");
		printArrays(A,B,C);

		
		System.out.println("\n\n------------------------------------------------------------- "
						+  "\n|   SORT-BY-COUNTING OF INTEGERS ACCOUNTING FOR REPETITION   |"
						+  "\n -------------------------------------------------------------");
			
		// Reset A to random possibly repeating integers, reinitializing B and C to 0
		A = repArray(n,max);
		zeroArray(B);
		zeroArray(C);
		
		// Printing arrays
		System.out.println("\nPRE-SORTING:");
		printArrays(A,B,C);
		
		// Sorting A[] of possibly repeating integers into B[], using C[] to map A[] values to B[] indices
		SortByCountWithRep(A,B,C);

		// Printing arrays post-sorting
		System.out.println("\nPOST-SORTING:");
		printArrays(A,B,C);
	}
	
	//---------------------------------------------//
	//          ARRAY GENERATORS / SETTERS         //
	//---------------------------------------------//
	
	// Generating an array of non-repeating random integers of size n between 0 and max
	public static int[] noRepArray (int n, int max) {
		int[] arr = new int[n];
		for (int i=0;i<n;i++) {
			int a=(int)(Math.random()*max);
			for (int j = 0; j<i;j++) {
				while (a==arr[j]) {
					a=(int)(Math.random()*max);
					j=0;
				}
			}
			arr[i] = a;
		}
		return arr;
	}
	
	// Generating an array of possibly repeating random integers of size n between 0 and max
	public static int[] repArray (int n, int max) {
		int[] arr = new int[n];
		for (int i=0;i<n;i++) {
			arr[i]=(int)(Math.random()*max);
		}
		return arr;
	}
	
	
	// Setting all array elements to 0
	public static void zeroArray (int[] arr){
		for (int i = 0; i<arr.length;i++) {
			arr[i]=0;
		}
	}
	
	//----------------------//
	//     SORTING AIDS     //
	//----------------------//
	
	// Incrementing elements of C[] to reflect the order of values of A[], then stores A[] elements into B[] using C[] as guiding indices 
	public static void SortByCountNoRep(int[] A, int[] B,int[] C) {
		// Counting number of elements larger than each A[] entry and incrementing C[] accordingly
		for (int a=0;a<A.length;a++) {
			for (int j = 0; j<A.length; j++) {
				if (A[a]>(A[j])) {                          
					C[a] = C[a] + 1;
				}
			}
		}
		// Assigning A[] elements into B[] using mapping provided by C[]
		for (int i=0;i<A.length;i++) {
			B[C[i]] = A[i];
		}
	}
	
	// Same as above with the addition of a correction for repeated values 
	public static void SortByCountWithRep(int[] A, int[] B,int[] C) {
		for (int a=0;a<A.length;a++) {
			for (int j = 0; j<A.length; j++) {
				if (A[a]>(A[j])) {                          
					C[a] = C[a] + 1;
				}
			}
		}
		
		// Incrementing C[] for each repeated value
		for (int i = 0; i<A.length ;i++) {
			for (int j = i+1; j<A.length; j++) {
				if (A[i]==A[j]) {
					C[j]++;
				}
			}
		}
		for (int i=0;i<A.length;i++) {
			B[C[i]] = A[i];
		}
	}
	
	
	//---------------------//
	//    PRINTING AIDS    //
	//---------------------//
	
	
	// Prints out a table with indices, arrays A, B, and C as per format on assignment instructions
	public static void printArrays(int[] A, int[] B, int[] C) {
		System.out.println("---------------------------------");
		System.out.println("| Index |   A   |   C   |   B   |");
		System.out.println("---------------------------------");
		
		for (int i=0;i<A.length;i++) {
			formatter(i);
			formatter(A[i]);
			formatter(C[i]);
			formatter(B[i]);
			System.out.println("|");
		}
		System.out.println("---------------------------------");
	}
	
	// Formats spacing for tabulation by taking a value and printing it out with appropriate spacing 
	// *NOTE: Assumes integers are at most 6 digits long (judged to be sufficient for the purpose of this assignment)
	public static void formatter(int i) {
		if (i<10) {
			System.out.print("|   "+i+"   ");
		}
		else if (i<100) {
			System.out.print("|   "+i+"  ");
		}
		else if (i<1000) {
			System.out.print("|  "+i+"  ");
		}
		else if (i<10000) {
			System.out.print("|  "+i+" ");
		}
		else if (i<100000){
			System.out.print("| "+i+" ");
		}	
		else {
			System.out.print("| "+i);
		}
	}
}
