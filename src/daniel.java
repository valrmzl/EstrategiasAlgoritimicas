import java.util.Arrays;

public class daniel {
	public static void moveElementsToRight(int[] A, int start, int
			lastIndexWithValue) {
			 for(int it = lastIndexWithValue; it >= start; it --) {
			 A[it + 1] = A[it];
			 }
			 }
	
	public static void merge(int[] A, int[] B, int N) {
		 int bPointer = 0, lastIndexWithValue;
		 int movementsTodo = A.length - N;
		 for(int it = 0; it < A.length && bPointer < N - 1; it++) {
		 lastIndexWithValue = A.length - movementsTodo + bPointer - 1;
		 if(B[bPointer] < A[it]) {
		 moveElementsToRight(A,it + 1, lastIndexWithValue);
		 A[it + 1] = A[it];
		 A[it] = B[bPointer];
		 bPointer++;
		 } else {
		 moveElementsToRight(A,it + 1, lastIndexWithValue);
		 A[it + 1] = B[bPointer];
		 bPointer++;
		 it++;
		 }
		 }
		 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] B = {3,8,22,26,38,40};
		 int[] A = {4,9,11,12,0,0,0,0,0,0};
		 merge(A,B, 6);
		 System.out.println("\nArray after merge:\n" + Arrays.toString(A));

	}

}
