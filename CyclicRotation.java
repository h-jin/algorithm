package algorithm;

public class CyclicRotation {

	  public int[] solution(int[] A, int K) {
	        // write your code in Java SE 8
		  	int size  = A.length;
		  	int [] result = new int[size];
		  	int pos = 0;
		  	for(int i = 0; i<size; i++){
		  		pos = (i+K)%size;
		  		result[pos] = A[i];
		  	}
		  	return result;
	  }
}
