package net.davekirkwood.codility.lessons.arrays;

public class CyclicRotation {

   public int[] solution(int[] A, int K) {
   	
   	if(A.length == 0 || A.length == K) {
   		return A;
   	}
   	
   	for(int i=0;i<K; i++) {
   		int lastValue = A[A.length-1];
   		
   		for(int j=A.length-2; j>=0; j--) {
   			A[j+1] = A[j];
   		}
   		A[0] = lastValue;
   	}
   	return A;
   	
   }
	
	public static void main(String[] args) {
		CyclicRotation cr = new CyclicRotation();
		int[] result = cr.solution(new int[] { 1,2,3,4 }, 4);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	
}
